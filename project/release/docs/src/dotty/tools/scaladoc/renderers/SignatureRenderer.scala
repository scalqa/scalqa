package dotty.tools.scaladoc
package renderers

import util.HTML._
import collection.JavaConverters._
import java.net.URI
import java.net.URL
import java.util.{List => JList, Set => JSet}
import scala.util.Try
import org.jsoup.Jsoup
import java.nio.file.Paths

import scalqa.{*,given}


// TODO merge it with new renderer
trait SignatureRenderer:
  def currentDri: DRI
  def link(dri: DRI): Option[String]

  def renderElement(e: String | (String, DRI) | Link) = renderElementWith(e)

  def renderLink(name: String, dri: DRI, modifiers: AppliedAttr*) =
    renderLinkContent(name, dri, modifiers:_*)

  def unresolvedLink(content: TagArg, modifiers: AppliedAttr*) =
    span(Attr("data-unresolved-link") := "", modifiers)(content)

  def renderLinkContent(content: TagArg, dri: DRI, modifiers: AppliedAttr*) =
    link(dri) match
      case Some(link) => a(href := link.replace("$$TYPE$",""), modifiers)(content)
      case _ => unresolvedLink(content, modifiers:_*)


  def renderElementWith(e: String | (String, DRI) | Link, modifiers: AppliedAttr*) = e match
    case (name, dri) => J.unsupportedOperation() //renderLink("!!"+dri.scalqaLabel(), dri, modifiers *)
    case name: String => raw(name)
    case l: Link =>
      renderLink(l.label, l.dri, modifiers *)
