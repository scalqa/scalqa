package scalqa; package api

import _signature.*

trait _Signature:

  extension (x: Member)
    private def isStreamExt: Boolean = {val l=x.dri.location;  !l.endsWith("$") && l.startsWith("scalqa.val.stream") && (l.startsWith("scalqa.val.stream._build") | l.startsWith("scalqa.val.stream._Build") | l.startsWith("scalqa.val.stream._use") | l.startsWith("scalqa.val.stream._Use"))}
    private def thisOpaque : String | Link = x.parent.?.drop(_.name=="_methods").map(v => Link(v.label,v.dri)) or "THIS_OPAQUE"
    private def thisReal   : String        = Registry.member_?(Id(x.dri.copy(anchor=""))).drop(_.name=="_methods").map_?(_.extendsSignature.~.map(_.label).dropWhile(!_.contains("AnyRef.Opaque")).dropFirst(4).read_?) or "THIS_REAL"

  extension (x: Signature)
    def tag : String = x.~.map(_.label).makeString("")

    def dropGenericDef(v: String): Signature =
      if(x.size<3 || x.head.toString.trim != "[" || x.tail.head.toString.trim != v && x.tail.tail.head.toString.trim != v) x
      else x.drop(x.~.findPosition_?(_.toString.trim == "]").map(_ + 1) or 0)

    def improveSignature(m: Member): Signature =
      var s = dropPrivate(x)
      if(m.kind.isType && s.nonEmpty)
        s = m.name match
               case "Ordering" => Seq("[A] = scala.math.Ordering[A]")
               case _ if m.signature.head.isInstanceOf[String] => s ++ m.signature
               case _                                          => s ++ m.signature.prepended(" = ")
      else if(m.kind.isTrait && m.isStreamExt)
        s = if(s.size<=1) Seq("[A]") else s.~.flatMap[String | Link]{ case v: String => v.^.~; case v: Link => (v,"[A]")}.toSeq.prepended("[A]")
      else
        s = s.filterNot(v => v.isInstanceOf[String] && v.toString.contains("inline"))
        s = s.dropGenericDef("THIS_OPAQUE")
        s = specialized(m,s)
        if(m.kind.isExtension && ( m.isStreamExt || m.dri.location.endsWith(".Opt$") || m.dri.location.endsWith(".array._methods"))) s = StandardExtensions(m,s)

//        if(m.name == "real" && m.dri.tag.contains("File"))
//          ">>>****************************************************************** " + m.dri.tag tp()
//          m.dri.tp
//          s.~.print

      s.map{
        case v: String if v=="THIS_OPAQUE"       => m.thisOpaque
        case v: String if v=="THIS_REAL"         => m.thisReal
        case v: String                           => v
        case l: Link  =>
          if(!l.dri.location.startsWith("scalqa")) l.dri.tag.simpleName().^.mapIf(v => m.name.startsWith(v), _ => l.dri.tag)
          else l.name match
            case "THIS_OPAQUE"                            => m.thisOpaque
            case "Ordering"                               => l.copy(dri=Registry.member_?(Id("scalqa.gen.math.ordering")).get.dri)
            case n if n.length==1 && n.notIn("J","O","M") => n
            case _                                        =>
              l.copy(
                name= l.dri.label()
                      .^.mapIf(v => m.name.withOp.startsWith(v), _ => l.dri.label(false))
                      .^.mapIf(_ => m.name.notIn("M","O","OM") && !l.dri.location.contains("Event"),_.replace("Observable","O").replace("Mutable","M"))
              ).^.map(l => l.lookupAnchor_? or l)
      }