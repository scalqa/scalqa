package scalqa; package docs

import dotty.tools.scaladoc.renderers.{ Locations, Page }
import dotty.tools.scaladoc.util.HTML.{ AppliedTag, a, href, div, span , cls }

object Menu:

  def build(l: Locations, topPage: Page, link: Link): AppliedTag =
    val id = link.dri.id

    def renderNested(page: Page): (Boolean, AppliedTag) =
      val isSelected = page.link.dri == link.dri
      def linkHtml(expanded: Boolean = false) =
        val attrs = if (isSelected) Seq(cls := "selected expanded") else Nil
        Seq(a(href := l.pathToPage(link.dri, page.link.dri), attrs)(Nil, page.link.name))

      page.children.filter(_.link.name!="Dotty") match
        case Nil => isSelected -> div(linkHtml())
        case children =>
          val nested = children.map(p =>if(p.link.name=="API") renderApi(scalqa.Registry.rootModule) else renderNested(p))
          val expanded = nested.exists(_._1) || page.link == link
          val attr = if expanded || isSelected then Seq(cls := "expanded") else Nil
          (isSelected || expanded) -> div(attr)(
            linkHtml(expanded),
            span(cls := "ar"),
            nested.map(_._2)
          )

    def renderApi(module: Module): (Boolean, AppliedTag) =
      val isSelected = module.main.id.moduleId == id.moduleId
      def linkHtml(expanded: Boolean = false) =
        val attrs = if (isSelected) Seq(cls := "selected expanded") else Nil
        var dri = if(isSelected && id==module.main.id) module.dri2 else module.dri
        var str : String = l.pathToPage(link.dri, dri).replace("$$TYPE$","")
        Seq(a(href := str, attrs)(module.name.^.mapIf(_ == "scalqa", _ => "API").^.mapIf(_.startsWith("_"), v => v.takeFirst(2).lower + v.dropFirst(2))))

      module.children.^.map(l =>
        if(l.isEmpty) (isSelected -> div(linkHtml()))
        else
          val nested   = l.~.map(renderApi).toList
          val expanded = nested.exists(_._1) || module.dri == link.dri
          val attr = if expanded || isSelected then Seq(cls := "expanded") else Nil
          (isSelected || expanded) -> div(attr)( linkHtml(expanded), span(cls := "ar"), nested.map(_._2) )
      )

    div(Seq(cls := "expanded"))(
      renderNested(topPage.children.find(_.link.name=="Guide").get)._2, // Static pages
      renderApi(scalqa.Registry.rootModule.children.head)._2            // Generated API
    )
