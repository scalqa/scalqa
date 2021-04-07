package scalqa; package docs

import dotty.tools.scaladoc.renderers.{ Locations, Page }
import dotty.tools.scaladoc.util.HTML.{ AppliedTag, a, href, div, span , cls }

object Menu:

  def build(l: Locations, topPage: Page, link: Link): AppliedTag =
    val moduleId = link.dri.moduleId
    val memberId = link.dri.memberId

    def renderNested(page: Page): (Boolean, AppliedTag) =
      val isSelected = page.link.dri == link.dri
      def linkHtml(expanded: Boolean = false) =
        val attrs = if (isSelected) Seq(cls := "selected expanded") else Nil
        Seq(a(href := l.pathToPage(link.dri, page.link.dri), attrs)(Nil, page.link.name))

      page.children.filter(_.link.name!="Dotty") match
        case Nil => isSelected -> div(linkHtml())
        case children =>
          val nested = children.map(p =>if(p.link.name=="API") renderApi(Docs.rootModule) else renderNested(p))
          val expanded = nested.exists(_._1) || page.link == link
          val attr = if expanded || isSelected then Seq(cls := "expanded") else Nil
          (isSelected || expanded) -> div(attr)(
            linkHtml(expanded),
            span(cls := "ar"),
            nested.map(_._2)
          )

    def renderApi(module: Module): (Boolean, AppliedTag) =
      val isSelected = module.id == moduleId
      def linkHtml(expanded: Boolean = false) =
        val attrs = if (isSelected) Seq(cls := "selected expanded") else Nil
        var dri = if(isSelected && memberId==module.main.id) module.dri2 else module.dri
        var str : String = l.pathToPage(link.dri, dri)
        if(dri.isOpaque) str = l.pathToPage(link.dri, dri.restoreOpaqueBase).replace("$$opaque$","")
        Seq(a(href := str, attrs)(module.name.^.reviseIf(_ == "scalqa", _ => "API")))

      module.children.^.convert(l =>
        if(l.isEmpty) (isSelected -> div(linkHtml()))
        else
          val nested   = l.~.map(renderApi).toList
          val expanded = nested.exists(_._1) || module.dri == link.dri
          val attr = if expanded || isSelected then Seq(cls := "expanded") else Nil
          (isSelected || expanded) -> div(attr)( linkHtml(expanded), span(cls := "ar"), nested.map(_._2) )
      )

    div(Seq(cls := "expanded"))(
      renderNested(topPage.children.find(_.link.name=="Guide").get)._2, // Static pages
      renderApi(Docs.rootModule.children.head)._2                       // Generated API
    )