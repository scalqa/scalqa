package dotty.tools.scaladoc
package tasty

import scala.quoted._
import dotty.tools.scaladoc.util.Escape._
import scala.collection.mutable.{ Map => MMap }
import dotty.tools.io.AbstractFile

class SymOps[Q <: Quotes](val q: Q) extends JavadocAnchorCreator with Scaladoc2AnchorCreator:
  import q.reflect._

  given Q = q

  private val externalLinkCache: scala.collection.mutable.Map[AbstractFile, Option[ExternalDocLink]] = MMap()

  extension (sym: Symbol)
    def packageName: String = (
      if (sym.isPackageDef) sym.fullName
      else sym.maybeOwner.packageName
    )

    def packageNameSplitted: Seq[String] =
      sym.packageName.split('.').toList

    def className: Option[String] =
      if (sym.isClassDef && !sym.flags.is(Flags.Package)) Some(
        Some(sym.maybeOwner).filter(s => s.exists).flatMap(_.className).fold("")(cn => cn + "$") + sym.name
      ).filterNot(_.contains("package$"))
      else if (sym.isPackageDef) None
      else sym.maybeOwner.className

    def anchor: Option[String] =
      if (!sym.isClassDef && !sym.isPackageDef) {
        val params = sym.signature.paramSigs.map {
          case s: String => s
          case i: Int => i.toString
        }
        val result = sym.signature.resultSig
        val hash = ((params.mkString + result).hashCode % 4096).toHexString
        Some(s"${sym.name}-$hash")
      }
      else None
    //TODO: Retrieve string that will match scaladoc anchors

    def getVisibility(): Visibility =
      import VisibilityScope._

      def explicitScope(ownerType: TypeRepr): VisibilityScope =
        val moduleSym = ownerType.typeSymbol.companionModule
        if moduleSym.isNoSymbol
          then ExplicitTypeScope(ownerType.typeSymbol.name)
          else ExplicitModuleScope(moduleSym.name)

      def implicitScope(ownerSym: Symbol): VisibilityScope =
        val moduleSym = ownerSym.companionModule
        if moduleSym.isNoSymbol
          then ImplicitTypeScope
          else ImplicitModuleScope

      val visibilityFlags = (sym.flags.is(Flags.Private), sym.flags.is(Flags.Protected), sym.flags.is(Flags.Local))
      (sym.privateWithin, sym.protectedWithin, visibilityFlags) match
        case (Some(owner), None, _) => Visibility.Private(explicitScope(owner))
        case (None, Some(owner), _) => Visibility.Protected(explicitScope(owner))
        case (None, None, (true, false, _)) => Visibility.Private(implicitScope(sym.owner))
        case (None, None, (false, true, true)) => Visibility.Protected(ThisScope)
        case (None, None, (false, true, false)) => Visibility.Protected(implicitScope(sym.owner))
        case (None, None, (false, false, false)) => Visibility.Unrestricted
        case _ => throw new Exception(s"Visibility for symbol $sym cannot be determined")


    // Order here determines order in documenation
    def getExtraModifiers(): Seq[Modifier] = Seq(
        Flags.Final -> Modifier.Final,
        Flags.Sealed -> Modifier.Sealed,
        Flags.Erased -> Modifier.Erased,
        Flags.Abstract -> Modifier.Abstract,
        Flags.Deferred -> Modifier.Deferred,
        Flags.Implicit -> Modifier.Implicit,
        Flags.Inline -> Modifier.Inline,
        Flags.Lazy -> Modifier.Lazy,
        Flags.Open -> Modifier.Open,
        Flags.Override -> Modifier.Override,
        Flags.Case -> Modifier.Case,
        ).collect { case (flag, mid) if sym.flags.is(flag) => mid }

    def isHiddenByVisibility: Boolean =
      import VisibilityScope._

      //import scalqa.{*,given}
      //if(sym.dri.isPrivate) return true

      getVisibility() match
        case Visibility.Private(_) => true
        case Visibility.Protected(ThisScope | ImplicitModuleScope | _: ExplicitModuleScope) => true
        case _ => false

    def shouldDocumentClasslike: Boolean = !isHiddenByVisibility
        && !sym.flags.is(Flags.Synthetic)
        && (!sym.flags.is(Flags.Case) || !sym.flags.is(Flags.Enum))
        && !(sym.companionModule.flags.is(Flags.Given))


    def getCompanionSymbol: Option[Symbol] = Some(sym.companionClass).filter(_.exists)

    def isCompanionObject: Boolean = sym.flags.is(Flags.Module) && sym.companionClass.exists

    def isGiven: Boolean = sym.flags.is(Flags.Given)

    def isExported: Boolean = sym.flags.is(Flags.Exported)

    def isOverriden: Boolean = sym.flags.is(Flags.Override)

    def isExtensionMethod: Boolean = sym.flags.is(Flags.ExtensionMethod)

    def isArtifact: Boolean = sym.flags.is(Flags.Artifact)

    def isLeftAssoc(d: Symbol): Boolean = !d.name.endsWith(":")

    def extendedSymbol: Option[ValDef] =
      Option.when(sym.isExtensionMethod){
        val termParamss = sym.tree.asInstanceOf[DefDef].termParamss
        if isLeftAssoc(sym) || termParamss.size == 1 then termParamss(0).params(0)
        else termParamss(1).params(0)
      }

    private def constructPath(location: Seq[String], anchor: Option[String], link: ExternalDocLink): String =
      val extension = ".html"
      val docURL = link.documentationUrl.toString
      def constructPathForJavadoc: String =
        val l = "\\$+".r.replaceAllIn(location.mkString("/"), _ => ".")
        val javadocAnchor = if anchor.isDefined then {
          val paramSigs = sym.paramSymss.flatten.map(_.tree).collect {
            case v: ValDef => v.tpt.tpe
          }.map(getJavadocType)
          "#" + sym.name + paramSigs.mkString("-","-","-")
        } else ""
        docURL + l + extension + javadocAnchor

      //TODO #263: Add anchor support
      def constructPathForScaladoc2: String =
        val l = escapeUrl(location.mkString("/"))
        val scaladoc2Anchor = if anchor.isDefined then {
          "#" + getScaladoc2Type(sym.tree)
        } else ""
        docURL + l + extension + scaladoc2Anchor

      // TODO Add tests for it!
      def constructPathForScaladoc3: String =
        val base = docURL + escapeUrl(location.mkString("/")) + extension
        anchor.fold(base)(a => base + "#" + a)

      link.kind match {
        case DocumentationKind.Javadoc => constructPathForJavadoc
        case DocumentationKind.Scaladoc2 => constructPathForScaladoc2
        case DocumentationKind.Scaladoc3 => constructPathForScaladoc3
      }

    // TODO #22 make sure that DRIs are unique plus probably reuse semantic db code?
    def dri(using dctx: DocContext): DRI =
      if sym == Symbol.noSymbol then topLevelDri
      else if sym.isValDef && sym.moduleClass.exists then sym.moduleClass.dri
      else
        val method =
          if (sym.isDefDef) Some(sym)
          else if (sym.maybeOwner.isDefDef) Some(sym.owner)
          else None

        val (className, anchor) = if sym.fullName == "scala.AnyRef" then // hacking relocation for synthetic `type AnyRef`
          (Some("AnyRef"), None)
        else
          (sym.className, sym.anchor)

        val location = sym.packageNameSplitted ++ className

        val externalLink = {
            import q.reflect._
            import dotty.tools.dotc
            given ctx: dotc.core.Contexts.Context = q.asInstanceOf[scala.quoted.runtime.impl.QuotesImpl].ctx
            val csym = sym.asInstanceOf[dotc.core.Symbols.Symbol]
            val extLink = if externalLinkCache.contains(csym.associatedFile) then externalLinkCache(csym.associatedFile)
            else {
              val calculatedLink = Option(csym.associatedFile).map(_.path).flatMap( path =>
               dctx.externalDocumentationLinks.find(_.originRegexes.exists(r => r.matches(path))))
              externalLinkCache += (csym.associatedFile -> calculatedLink)
              calculatedLink
            }
            extLink.map(link => constructPath(location, anchor, link))
        }

        DRI(
          location.mkString("."),
          anchor.getOrElse(""),
          externalLink = externalLink,
          // sym.show returns the same signature for def << = 1 and def >> = 2.
          // For some reason it contains `$$$` instrad of symbol name
          s"${sym.name}${sym.fullName}/${sym.signature.resultSig}/[${sym.signature.paramSigs.mkString("/")}]"
        )

    def driInContextOfInheritingParent(par: Symbol)(using dctx: DocContext): DRI = sym.dri.copy(
      location = par.dri.location,
      externalLink = None
    )
