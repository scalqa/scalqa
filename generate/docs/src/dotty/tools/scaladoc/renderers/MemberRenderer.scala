package dotty.tools.scaladoc
package renderers

import scalqa.{*,given}

import scala.collection.immutable.SortedMap
import util.HTML._
import collection.JavaConverters._
import dotty.tools.scaladoc.translators.FilterAttributes
import dotty.tools.scaladoc.tasty.comments.markdown.DocFlexmarkRenderer
import com.vladsch.flexmark.util.ast.{Node => MdNode}
import dotty.tools.scaladoc.tasty.comments.wiki.WikiDocElement
import translators._

class MemberRenderer(signatureRenderer: SignatureRenderer)(using DocContext) extends DocRender(signatureRenderer):
  import signatureRenderer._

  def doc(m: Member): Seq[AppliedTag] =  m.docs.fold(Nil)(d => Seq(renderDocPart(d.body)))

  def tableRow(name: String, content: AppliedTag) = Seq(dt(name), dd(content))

  def defintionClasses(m: Member) = m.origin match
    case Origin.Overrides(defs) =>
      def renderDef(d: Overriden): Seq[TagArg] =
        Seq(" -> ", signatureRenderer.renderLink(d.name, d.dri))
      val headNode = m.inheritedFrom.map(form => signatureRenderer.renderLink(form.name, form.dri))
      val tailNodes = defs.flatMap(renderDef)
      val nodes = headNode.fold(tailNodes.drop(1))(_ +: tailNodes)
      tableRow("Definition Classes", div(nodes:_*))

    case _ => Nil

  def inheritedFrom(m: Member) = m.inheritedFrom match
    case Some(InheritedFrom(name, dri)) => tableRow("Inherited from", signatureRenderer.renderLink(name, dri))
    case _ => Nil

  def docAttributes(m: Member): Seq[AppliedTag] =

    def nested(name: String, on: SortedMap[String, DocPart]): Seq[AppliedTag] =
      if on.isEmpty then Nil else
        tableRow(name, dl(cls := "attributes")(
          on.map { case (name, value) => tableRow(name, renderDocPart(value))}.toList:_*
        ))

    def list(name: String, on: List[DocPart]): Seq[AppliedTag] =
      if on.isEmpty then Nil else tableRow(name, div(on.map(e => div(renderDocPart(e)))))

    def opt(name: String, on: Option[DocPart]): Seq[AppliedTag] =
      if on.isEmpty then Nil else tableRow(name, renderDocPart(on.get))

    m.docs.fold(Nil)(d =>
      nested("Type Params", d.typeParams) ++
      nested("Value Params", d.valueParams) ++
      opt("Returns", d.result) ++
      nested("Throws", d.throws) ++
      opt("Constructor", d.constructor) ++
      list("Authors", d.authors) ++
      list("See also", d.see) ++
      opt("Version", d.version) ++
      opt("Since", d.since) ++
      list("Todo", d.todo) ++
      list("Note", d.note) ++
      list("Example", d.example)
    )

  def companion(m: Member): Seq[AppliedTag] = Nil /* scalqa  m.companion.fold(Nil){dri =>
    val kindName = if m.kind == Kind.Object then "class" else "object"
    tableRow("Companion", signatureRenderer.renderLink(kindName, dri))
  }*/

  def source(m: Member): Seq[AppliedTag] =
    summon[DocContext].sourceLinks.pathTo(m).fold(Nil){ link =>
      tableRow("Source", a(href := scalqa.docs.Path(link))(m.sources.fold("(source)")(_.path.getFileName().toString())))
    }

  def deprecation(m: Member): Seq[AppliedTag] = m.deprecated.fold(Nil){ a =>
    def stripQuotes(s: String) = s.stripPrefix("\"").stripSuffix("\"")
    def parameter(p: Annotation.AnnotationParameter): TagArg = p match
      case Annotation.PrimitiveParameter(_, value) => stripQuotes(value)
      case Annotation.LinkParameter(_, dri, text) =>
        signatureRenderer.renderLink(stripQuotes(text), dri)
      case Annotation.UnresolvedParameter(_, value) => stripQuotes(value)

    val (named, unnamed) = a.params.partition(_.name.nonEmpty)
    val message = named.find(_.name.get == "message")
    val since = named.find(_.name.get == "since")

    val content = (
      Seq(
        since.map(s => code("[Since version ", parameter(s), "] ")),
        message.map(m => parameter(m)))
      ++ m.docs.map(_.deprecated.toSeq.map(renderDocPart))
    ).flatten
    Seq(dt("Deprecated"), dd(content:_*))
  }

  def memberInfo(m: Member): Seq[AppliedTag] =
    val comment = m.docs
    val bodyContents = m.docs.fold(Nil)(e => renderDocPart(e.body) :: Nil)

    Seq(
      div(cls := "documentableBrief doc")(comment.filterNot(_ => m.kind.isClassLike).flatMap(_.short).fold("")(renderDocPart)),
      div(cls := "cover")(
        div(cls := "doc")(bodyContents),
        dl(cls := "attributes")(
          docAttributes(m),
          companion(m),
          deprecation(m),
          defintionClasses(m),
          inheritedFrom(m),
          source(m),
        )
      )
    )

  private def originInfo(m: Member): Seq[TagArg] = m.origin match {
    case Origin.ImplicitlyAddedBy(name, dri) =>
      Seq("Implicitly added by ", renderLink(name, dri))
    case Origin.ExtensionFrom(name, dri) =>
      Seq("Extension method from ", renderLink(name, dri))
    case Origin.ExportedFrom(name, dri) =>
      val signatureName: TagArg = dri match
        case Some(dri: DRI) => renderLink(name, dri)
        case None => name
      Seq("Exported from ", signatureName)
    case _ => Nil
  }

  def memberSignature(member: Member) =
    val depStyle = if member.deprecated.isEmpty then "" else "deprecated"
    val nameClasses = cls := s"documentableName $depStyle"

    val rawBuilder = ScalaSignatureProvider.rawSignature(member, InlineSignatureBuilder())
    val inlineBuilder = rawBuilder.asInstanceOf[InlineSignatureBuilder]
    if inlineBuilder.preName.isEmpty then println(member)
    val kind :: modifiersRevered = inlineBuilder.preName
    val signature = inlineBuilder.names.reverse
    Seq(
      span(cls := "modifiers")(
        span(cls := "other-modifiers")(modifiersRevered.reverse.map(renderElement)),
        span(cls := "kind")(renderElement(kind)),
      ),
      renderLink(member.name, member.dri, nameClasses),
      span(cls := "signature")(signature.map(renderElement)),
    )

  def memberIcon(member: Member) = member.kind match {
    case Kind.Package => Nil
    case _ =>
      val co = member.companion_? // scalqa
      val withCompanion = co.foldAs("")(_ => "-wc")
      val iconSpan = span(cls := s"micon ${member.kind.name.head}$withCompanion")()
      //Seq(member.companion.flatMap(link(_)).fold(iconSpan)(link => a(href := link)(iconSpan)))
      Seq(co.map(dri => a(href := dri.normalizedTag.takeAfterLast(".") + ".html" )(iconSpan)) or iconSpan)
  }

  def annotations(member: Member) =
   val rawBuilder = InlineSignatureBuilder().annotationsBlock(member)
   val signatures = rawBuilder.asInstanceOf[InlineSignatureBuilder].names.reverse
   span(cls := "annotations monospace")(signatures.map(renderElement))

  def member(member: Member) =
    val filterAttributes = FilterAttributes.attributesFor(member)
    val anchor = if member.dri.anchor.isEmpty then Nil else Seq(id := member.dri.anchor)
    def topLevelAttr = Seq(cls := "documentableElement")
      ++ anchor
      ++ filterAttributes.map{ case (n, v) => Attr(s"data-f-$n") := v }

    div(topLevelAttr:_*)(
      a(href := (if member.needsOwnPage then link(member.dri).getOrElse("#") else s"#${member.dri.anchor}"), cls := "documentableAnchor"),
      div(annotations(member)),
      div(cls := "header monospace")(memberSignature(member)),
      div(cls := "docs")(
        span(cls := "modifiers"), // just to have padding on left
        div(
          div(cls := "originInfo")(originInfo(member):_*),
          div(cls := "memberDocumentation")(memberInfo(member)),
        )
      )
    )

  private case class MGroup(header: AppliedTag, members: Seq[Member], groupName: String)

  private def actualGroup(name: String, members: Seq[Member | MGroup]): Seq[AppliedTag] =
    if members.isEmpty then Nil else
    div(cls := "documentableList")(
      h3(cls:="groupHeader")(name),
      members.sortBy {
        case m: Member => m.name
        case MGroup(_, _, name) => name
      }.map {
        case element: Member =>
          member(element)
        case MGroup(header, members, _) =>
          div(
            header,
            members.map(member)
          )
      }
    ) :: Nil

  private def isDeprecated(m: Member | MGroup): Boolean = m match
    case m: Member => m.deprecated.nonEmpty
    case g: MGroup => g.members.exists(isDeprecated)

  private def isInherited(m: Member | MGroup): Boolean = m match
    case m: Member => m.inheritedFrom.nonEmpty
    case g: MGroup => g.members.exists(isInherited)

  private def isAbstract(m: Member | MGroup): Boolean = m match
    case m: Member => m.modifiers.exists(Set(Modifier.Abstract, Modifier.Deferred).contains)
    case g: MGroup => g.members.exists(isAbstract)

  private type SubGroup = (String, Seq[Member | MGroup])
  private def buildGroup(name: String, subgroups: Seq[SubGroup]): Tab =
    val all = subgroups.map { case (name, members) =>
      val (allInherited, allDefined) = members.partition(isInherited)
      val (depDefined, defined) = allDefined.partition(isDeprecated)
      val (depInherited, inherited) = allInherited.partition(isDeprecated)
      val normalizedName = name.toLowerCase
      val definedWithGroup = if Set("methods", "fields").contains(normalizedName) then
          val (abstr, concr) = defined.partition(isAbstract)
          Seq(
            actualGroup(s"Abstract ${normalizedName}", abstr),
            actualGroup(s"Concrete ${normalizedName}", concr)
          )
        else
          Seq(actualGroup(name, defined))

      definedWithGroup ++ List(
        actualGroup(s"Deprecated ${normalizedName}", depDefined),
        actualGroup(s"Inherited ${normalizedName}", inherited),
        actualGroup(s"Deprecated and Inherited ${normalizedName}", depInherited)
      )
    }

    val children = all.flatten.flatten
    if children.isEmpty then emptyTab
    else Tab(name, name, h2(tabAttr(name))(name) +: children, if name=="Member" then "" else "selected") // scalqa

  case class ExpandedGroup(name: AppliedTag, description: AppliedTag, prio: Int)

  val emptyTab = Tab("", "", Nil)

  def grouppedMember(m: Member, membersInGroups: Seq[Member]): Tab =
    if membersInGroups.isEmpty then emptyTab else
      val descriptions = m.docs.map(_.groupDesc).getOrElse(Map.empty)
      val names = m.docs.map(_.groupNames).getOrElse(Map.empty)
      val prios = m.docs.map(_.groupPrio).getOrElse(Map.empty)

      val rawGroups = membersInGroups.groupBy(_.docs.flatMap(_.group)).collect {
          case (Some(groupName), members) =>
            ExpandedGroup(
              names.get(groupName).fold(raw(groupName))(renderDocPart),
              descriptions.get(groupName).fold(raw(""))(renderDocPart),
              prios.getOrElse(groupName, 1000)
            ) -> members
        }
      val content = rawGroups.toSeq.sortBy(_._1.prio).flatMap {
        case (group, members) =>
          Seq(div(cls := "documentableList")(
            h3(group.name),
            group.description,
            members.map(member)
          ))
      }
      Tab("Grouped members", "custom_groups", content, "selected")

  def buildMembers(s: Member): AppliedTag =
    val (membersInGroups, rest) = s.members.partition(_.docs.exists(_.group.nonEmpty))

    val extensions =
      rest.groupBy{ _.kind match
        case Kind.Extension(on, _) => Some(on)
        case _ => None
      }.collect {
        case (Some(on), members) =>
          val sig = Signature(s"extension (${on.name}: ") ++ on.signature ++ Signature(")")
          MGroup(span(sig.map(renderElement)), members.sortBy(_.name).toSeq, on.name)
      }.toSeq

    // scalqa start
    val GET = s.children
    div(cls := "membersList")(renderTabs(
      singleSelection = false,
      buildGroup("Packages", Seq(
        ("", rest.filter(m => m.kind == Kind.Package)),
      )),
      grouppedMember(s, membersInGroups),
      buildGroup("Member", Seq(
        ("", GET.members)
      )),
      buildGroup("Alias", Seq(
        ("", GET.aliases)
      )),
      buildGroup("Type", Seq(
        ("", GET.types)
      )),
      buildGroup("Def", Seq(
          ("Constructor", GET.constructors),
          (if(GET.constructors.isEmpty) "" else "Body", if(GET.localDefs.nonEmpty || GET.inheritedDefs.nonEmpty) Nil else GET.defs),
          ("Local", GET.localDefs),
          ("Inherited", GET.inheritedDefs)
      )),
      buildGroup("To", Seq(
        ("", GET.makers),
      )),
      buildGroup("Extension", Seq(
          ("", GET.extended),
      )),
//      buildGroup("Implied", Seq[SubGroup](
//          ("Implicit", rest.filter(_.kind.isInstanceOf[Kind.Implicit])),
//          ("Given",    rest.filter(_.kind.isInstanceOf[Kind.Given])),
//        ) ++ GET.extensions.map((t,s) => (t,s)).map[SubGroup]((on:ExtensionTarget,m:Seq[Member]) => {
//            val sig = Signature(s"extension (${on.name}: ") ++ on.signature ++ Signature(")")
//            val mg  = MGroup(span(sig.map(renderElement)),m)
//            val sg : SubGroup = ("",Seq(mg))
//            sg
//          })
//      ),
      buildGroup("Export", Seq(
        ("Defined exports", GET.exports),
      ))
    ))
    // scalqa end

  case class Tab(name: String, id: String, content: Seq[AppliedTag], cls: String = "")

  def tabAttr(id: String) = Attr("data-togglable") := id

  private def renderTabs(singleSelection: Boolean, allTabs: Tab*): Seq[AppliedTag] =
    val tabs = allTabs.filter(_.content.nonEmpty)
      if tabs.isEmpty then Nil else
        Seq(div(cls := (if singleSelection then "tabs single" else "tabs"))(
            div(cls := "names")(tabs.map(t =>
              button(tabAttr(t.id), cls := s"tab ${t.cls}")(t.name)
            )),
            div(cls := "contents")(tabs.map(t =>
              div(tabAttr(t.id), cls := s"tab ${t.cls}")(t.content)
            ))
        ))

  def classLikeParts(m: Member): Seq[AppliedTag] =
    if !m.kind.isInstanceOf[Classlike] then Nil else
      val graphHtml = m.graph match
        case graph if graph.edges.nonEmpty =>
          Seq(div( id := "inheritance-diagram", cls := "diagram-class showGraph")(
            input(value := "Reset zoom", `type` := "button", cls := "btn", onclick := "zoomOut()"),
            svg(id := "graph"),
            script(`type` := "text/dot", id := "dot")(
              raw(DotDiagramBuilder.build(graph, signatureRenderer))
            ),
          ))
        case _ => Nil

      def signatureList(list: Seq[LinkToType]): Seq[AppliedTag] =
        if list.isEmpty then Nil
        else Seq(div(cls := "symbol monospace")(list.map(link =>
          div(link.kind.name," ", link.signature.map(renderElement))
        )))

      val supertypes = signatureList(m.parents)
      val subtypes = signatureList(m.knownChildren)

      renderTabs(
        singleSelection = true,
        Tab("Graph", "graph", graphHtml, "showGraph"),
        Tab("Supertypes", "supertypes", supertypes),
        Tab("Known subtypes", "subtypes", subtypes),
      )

  private def buildDocumentableFilter = div(cls := "documentableFilter")(
    div(cls := "filterUpperContainer")(
      button(cls := "filterToggleButton", testId := "filterToggleButton")(
        raw("""
          <svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 0 24 24" width="24">
            <path d="M0 0h24v24H0z" fill="none"/>
            <path d="M10 6L8.59 7.41 13.17 12l-4.58 4.59L10 18l6-6z"/>
          </svg>
        """)
      ),
      input(cls := "filterableInput", placeholder := "Filter all members", testId := "filterBarInput")
    ),
    div(cls := "filterLowerContainer")()
  )

  def fullMember(m: Member): AppliedTag =
    val intro = m.kind match
      case Kind.RootPackage =>Seq(h1(summon[DocContext].args.name))
      case _ =>
        Seq(
          div(cls := "cover-header")(
            memberIcon(m),
            h1(m.scalqaName)
          ),
          div(cls := "signature monospace")(
            annotations(m),
            memberSignature(m)
          )
        )

    div(
      intro,
      memberInfo(m),
      classLikeParts(m),
      buildDocumentableFilter, // TODO Need to make it work in JS :(
      buildMembers(m))
