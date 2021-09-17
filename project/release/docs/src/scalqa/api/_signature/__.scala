package scalqa; package api

import _signature.*

trait _Signature:

  extension (x: String | Link)  def toStr      : String  = x match{ case s: String => s; case l: Link => l.dri.label("") }
  extension (x: Member) private def isStreamExt: Boolean = {val l=x.dri.location;  !l.endsWith("$") & (l.startsWith("scalqa.val.stream._build") | l.startsWith("scalqa.val.stream._Build") | l.startsWith("scalqa.val.stream._use") | l.startsWith("scalqa.val.stream._Use"))}

  extension (x: Signature)
    def tag : String = x.~.map(_.toStr).makeString()

    def dropGenericDef(v: String): Signature =
      if(x.size<3 || x.head.toString.trim != "[" || x.tail.head.toString.trim != v && x.tail.tail.head.toString.trim != v) x
      else x.drop(x.~.findPosition_?(_.toString.trim == "]").map(_ + 1) or 0)

    def scalqaImprove(m: Member, heading:Boolean): Signature =
      var s = dropPrivate(x)
      if(heading)
        if(m.kind.isType)
          s = m.name match
                 case "Ordering" => Seq("[A] = scala.math.Ordering[A]")
                 case "Math"     => Seq("[A] = scala.math.Numeric[A]")
                 case _ if m.signature.head.isInstanceOf[String] => s ++ m.signature
                 case _                                          => s ++ m.signature.prepended(" = ")
        else if(m.isStreamExt)
          s = if(s.size<=1) Seq("[A]") else s.~.flatMap[String | Link]{ case v: String => ~~(v); case v: Link => ~~(v,"[A]")}.toSeq.prepended("[A]")

      else
        s = s.filterNot(v => v.isInstanceOf[String] && v.toString.contains("inline"))
        s = s.dropGenericDef("THIS_OPAQUE")
        s = specialized(m,s)
        if(m.kind.isExtension && ( m.isStreamExt || m.dri.location.endsWith(".Opt$") || m.dri.location.endsWith(".array._methods"))) s = StandardExtensions(m,s)

        if(m.name == "width_*" && m.dri.tag.contains("Label"))
          ">>>****************************************************************** " + m.dri.tag tp()
          s.~.print

          s.map {
            case v: String => v
            case v: Link   => v.improve(m, heading)
          }.~.print

      s.map {
        case v: String => v
        case v: Link   => v.improve(m,heading)
      }

