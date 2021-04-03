package dotty.tools.scaladoc
package renderers

import util.HTML._
import collection.JavaConverters._
import java.net.URI
import java.net.URL
import dotty.tools.scaladoc.site._
import scala.util.Try
import org.jsoup.Jsoup
import java.nio.file.Paths
import java.nio.file.Path
import java.nio.file.Files
import java.io.File
import dotty.tools.scaladoc.translators.FilterAttributes
import util._
import translators._

enum Resource(val path: String):
  case Text(override val path: String, content: String) extends Resource(path)
  case Classpath(override val path: String, name: String) extends Resource(path)
  case File(override val path: String, file: Path) extends Resource(path)
  case URL(url: String) extends Resource(url)

trait Resources(using ctx: DocContext) extends Locations, Writer:
  private def dynamicJsData =
    val str = jsonObject("filterDefaults" -> jsonObject(
      FilterAttributes.defaultValues.toSeq.map { case  (n, v) => n -> jsonString(v) }:_*
    ))
    Resource.Text("scripts/data.js", s"var scaladocData = $str")

  private def scaladocVersionFile = Resource.Text("scaladoc.version", "BuildInfo.version") // scalqa

  private def projectLogo = ctx.args.projectLogo.toSeq.map { p =>
      val path = Paths.get(p)
      Resource.File(s"project-logo/${path.getFileName()}", path)
  }

  private def dottyRes(path: String) = Resource.Classpath(path, s"dotty_res/$path")

  def linkResources(dri: DRI, resources: Iterable[String]): Iterable[AppliedTag] =
    def fileExtension(url: String): String =
      val param = url.indexOf('?')
      val end = if param < 0 then url.length else param
      val point = url.lastIndexOf('.', end)
      url.substring(point+1, end)

    for res <- resources yield
      fileExtension(res) match
        case "css" => link(rel := "stylesheet", href := resolveLink(dri, res))
        case "js" => script(`type` := "text/javascript", src := resolveLink(dri, res), defer := "true")
        case _ => raw("")

  val memberResources: Seq[Resource] =
    val fromResources = List(
      "styles/nord-light.css",
      "styles/scalastyle.css",
      "styles/dotty-icons.css",
      "styles/diagram.css",
      "styles/filter-bar.css",
      "styles/search-bar.css",
      "styles/scaladoc-searchbar.css",
      "hljs/highlight.pack.js",
      "hljs/LICENSE",
      "scripts/hljs-scala3.js",
      "scripts/ux.js",
      "scripts/common/component.js",
      "scripts/common/utils.js",
      "scripts/components/FilterBar.js",
      "scripts/components/DocumentableList.js",
      "scripts/components/Input.js",
      "scripts/components/FilterGroup.js",
      "scripts/components/Filter.js",
      "scripts/searchbar.js"
    ).map(dottyRes)

    val urls = List(
      "https://code.jquery.com/jquery-3.5.1.min.js",
      "https://d3js.org/d3.v6.min.js",
      "https://cdn.jsdelivr.net/npm/graphlib-dot@0.6.2/dist/graphlib-dot.min.js",
      "https://cdnjs.cloudflare.com/ajax/libs/dagre-d3/0.6.1/dagre-d3.min.js",
    ).map(Resource.URL.apply)

    fromResources ++ urls ++ projectLogo ++ Seq(scaladocVersionFile, dynamicJsData)

  val searchDataPath = "scripts/searchData.js"
  val memberResourcesPaths = Seq(searchDataPath) ++ memberResources.map(_.path)


  def searchData(pages: Seq[Page]) =
    def flattenToText(signature: Signature): String =
      signature.map {
        case Link(name, dri) => name
        case s: String => s
      }.mkString

    def mkEntry(dri: DRI, name: String, text: String, descr: String) = jsonObject(
        "l" -> jsonString(absolutePath(dri)),
        "n" -> jsonString(name),
        "t" -> jsonString(text),
        "d" -> jsonString(descr)
      )

    def processPage(page: Page): Seq[JSON] =
      val res =  page.content match
        case m: Member =>
          val descr = m.dri.asFileLocation
          def processMember(member: Member): Seq[JSON] =
            val signatureBuilder = ScalaSignatureProvider.rawSignature(member, InlineSignatureBuilder()).asInstanceOf[InlineSignatureBuilder]
            val sig = Signature(member.kind.name, " ") ++ Seq(Link(member.name, member.dri)) ++ signatureBuilder.names.reverse
            val entry = mkEntry(member.dri, member.name, flattenToText(sig), descr)
            val children = member
                .membersBy(m => m.kind != Kind.Package && !m.kind.isInstanceOf[Classlike])
                .filter(m => m.origin == Origin.RegularlyDefined && m.inheritedFrom.isEmpty)
            Seq(entry) ++ children.flatMap(processMember)

          processMember(m)
        case _ =>
          Seq(mkEntry(page.link.dri, page.link.name, page.link.name, ""))

      res ++ page.children.flatMap(processPage)

    val entries = pages.flatMap(processPage)
    Resource.Text(searchDataPath, s"pages = ${jsonList(entries)};")


  def allResources(pages: Seq[Page]): Seq[Resource] = memberResources ++ Seq(
    dottyRes("favicon.ico"),
    dottyRes("fonts/dotty-icons.woff"),
    dottyRes("fonts/dotty-icons.ttf"),
    dottyRes("images/scaladoc_logo.svg"),
    dottyRes("images/class.svg"),
    dottyRes("images/class_comp.svg"),
    dottyRes("images/object.svg"),
    dottyRes("images/object_comp.svg"),
    dottyRes("images/trait.svg"),
    dottyRes("images/trait_comp.svg"),
    dottyRes("images/enum.svg"),
    dottyRes("images/enum_comp.svg"),
    dottyRes("images/given.svg"),
    dottyRes("images/github-icon-black.png"),
    dottyRes("images/github-icon-white.png"),
    dottyRes("images/discord-icon-black.png"),
    dottyRes("images/discord-icon-white.png"),
    dottyRes("images/twitter-icon-black.png"),
    dottyRes("images/twitter-icon-white.png"),
    dottyRes("images/gitter-icon-black.png"),
    dottyRes("images/gitter-icon-white.png"),
    searchData(pages)
  )

  def renderResource(resource: Resource): Seq[String] =
    resource match
      case Resource.Text(path, content) =>
        Seq(write(path, content))
      case Resource.Classpath(path, name) =>
        getClass.getClassLoader.getResourceAsStream(name) match
          case null =>
            report.error(s"Unable to find $name on classpath")
            Nil
          case is =>
            try Seq(copy(is, path)) finally is.close()
      case Resource.File(path, file) =>
        Seq(copy(file, path))
      case Resource.URL(url) =>
        Nil
