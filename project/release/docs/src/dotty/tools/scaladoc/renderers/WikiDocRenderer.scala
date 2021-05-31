package dotty.tools.scaladoc
package renderers

import dotty.tools.scaladoc.tasty.comments.wiki._
import util.HTML._
import com.vladsch.flexmark.util.ast.{Node => MdNode}
import dotty.tools.scaladoc.tasty.comments.wiki.WikiDocElement
import dotty.tools.scaladoc.tasty.comments.markdown.DocFlexmarkRenderer

class DocRender(signatureRenderer: SignatureRenderer)(using DocContext):

  def renderDocPart(doc: DocPart): AppliedTag = doc match
    case md: MdNode => renderMarkdown(md)
    case Nil => raw("")
    case Seq(elem: WikiDocElement) => renderElement(elem)
    case list: Seq[WikiDocElement @unchecked] => div(list.map(renderElement))

  private def renderMarkdown(el: MdNode): AppliedTag =
    raw(DocFlexmarkRenderer.render(el)( (link,name) =>
      renderLink(link, default => text(if name.isEmpty then default else name)).toString
    ))

  private def listItems(items: Seq[WikiDocElement]) =
    items.map(i => li(renderElement(i)))
  private def notSupported(name: String, content: AppliedTag): AppliedTag =
    report.warning(s"Wiki syntax does not support $name in ${signatureRenderer.currentDri.location}")
    content

  private def renderLink(target: DocLink, linkBody: String => TagArg): AppliedTag =
    target match
      case DocLink.ToDRI(dri: DRI, name: String) =>
        signatureRenderer.renderLinkContent(linkBody(name), dri)
      case DocLink.ToURL(url) => a(href := url)(linkBody(url))
      case DocLink.UnresolvedDRI(query, msg) =>
        val tooltip = s"Problem linking $query: $msg"
        signatureRenderer.unresolvedLink(linkBody(query), titleAttr :=  tooltip)

  private def renderElement(e: WikiDocElement): AppliedTag = e match
    case Title(text, level) =>
      val content = renderElement(text)
      level match
          case 1 => h1(content)
          case 2 => h2(content)
          case 3 => h3(content)
          case 4 => h4(content)
          case 5 => h5(content)
          case 6 => h6(content)
    case Paragraph(text) => p(renderElement(text))
    case Code(data: String) => pre(code(raw(data))) // TODO add classes
    case HorizontalRule => hr

    case UnorderedList(items) => ul(listItems(items))
    case OrderedList(items, style) => ol(listItems(items)) // TODO use style
    case Chain(items: Seq[Inline]) => span(items.map(renderElement))
    case Italic(text) => span(cls:="italic")(renderElement(text))
    case Underline(text) => span(cls:="underline")(renderElement(text))
    case Bold(text) => span(cls:="bold")(renderElement(text))
    case Monospace(text) => code(renderElement(text))
    case Superscript(text) => span(cls:="superscript")(renderElement(text))  // TODO implement style
    case Subscript(text) => span(cls:="subscript")(renderElement(text))  // TODO implement style
    case Link(target, body) =>
      renderLink(target, default => body.fold[TagArg](text(default))(renderElement))
    case Text(text) => raw(text)
    case Summary(text) => renderElement(text)
    case HtmlTag(content) => raw(content)

    case DefinitionList(items) => notSupported("DefinitionList", raw(""))

    case link: RepresentationLink =>
      notSupported("Subscript", renderElement(link.title))
