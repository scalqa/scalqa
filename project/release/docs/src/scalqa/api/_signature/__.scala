package scalqa; package api

import _signature.*

trait _Signature:

  extension (x: Member)
    private def isStreamExt: Boolean = {val l=x.dri.location;  l.startsWith("scalqa.val.stream") && !l.endsWith("$") && (l.startsWith("scalqa.val.stream._build") | l.startsWith("scalqa.val.stream._Build") | l.startsWith("scalqa.val.stream._use") | l.startsWith("scalqa.val.stream._Use"))}
    private def thisOpaque : String | Link = x.parent.?.drop(_.name.startsWith("_")).map(v => Link(v.label,v.dri)) or "THIS_OPAQUE"
    private def thisReal   : String        = Registry.memberOpt(Id(x.dri.copy(anchor=""))).drop(_.name=="_methods").mapOpt(_.extendsSignature.stream.map(_.label).dropWhile(!_.contains("AnyRef.Opaque")).dropFirst(4).readOpt) or "THIS_REAL"

  extension (x: Signature)
    def tag : String = x.stream.map(_.label).makeString("")

    def dropGenericDef(v: String): Signature =
      if(x.size<3 || x.head.toString.trim != "[" || x.tail.head.toString.trim != v && x.tail.tail.head.toString.trim != v) x
      else x.drop(x.stream.findPositionOpt(_.toString.trim == "]").map(_ + 1) or 0)

    def scalqaSignature(m: Member): Signature =
      var s = dropPrivate(x)
      if(m.kind.isType && m.name == "Ordering")
        s = Seq("[A] = scala.math.Ordering[A]")
      else if(m.kind.isTrait && m.isStreamExt)
        s = if(s.size<=1) Seq("[A]") else s.stream.flatMap[String | Link]{ case v: String => v.self.stream; case v: Link => (v,"[A]")}.toSeq.prepended("[A]")
      else
        s = s.filterNot(v => v.isInstanceOf[String] && v.toString.contains("inline"))
        s = s.dropGenericDef("THIS_OPAQUE")
        s = specialized(m,s)
        if(m.kind.isExtension && ( m.isStreamExt || m.dri.location.self.map(l=> l.endsWith(".Opt$") || l.endsWith(".Result$") || l.endsWith(".array._methods")))) s = StandardExtensions(m,s)

//        if(m.name == "real" && m.dri.tag.contains("File"))
//          ">>>****************************************************************** " + m.dri.tag tp()
//          m.dri.tp
//          s.stream.print

      s.map{
        case v: String if v=="THIS_OPAQUE"       => m.thisOpaque
        case v: String if v=="THIS_REAL"         => m.thisReal
        case v: String                           => v
        case l: Link  =>
          if(!l.dri.location.startsWith("scalqa")) l.dri.tag.simpleName().self.mapIf(v => m.name.startsWith(v), _ => l.dri.tag)
          else l.name match
            case "THIS_OPAQUE"                                => m.thisOpaque
            case "Ordering"                                   => l.copy(dri=Registry.memberOpt(Id("scalqa.gen.math.ordering")).get.dri)
            case n if n.length==1 && n.notIn("J","O","M","~") => n
            case _                                            =>
              l.copy(
                name= l.dri.label()
                      .self.mapIf(v => m.name.withOp.startsWith(v), _ => l.dri.label(false))
                      .self.mapIf(_ => m.name.notIn("M","O","OM") && !l.dri.location.contains("Event"),_.replace("Observable","O").replace("Mutable","M"))
              ).self.map(l => l.lookupAnchorOpt or l)
      }