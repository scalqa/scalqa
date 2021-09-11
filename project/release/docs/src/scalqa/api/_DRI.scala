package scalqa; package api

trait _DRI:

  extension (x: DRI)
    def id                : Id          = Id(x)
    def member_?          : Opt[Member] = Registry.member_?(x.id)
    def module_?          : Opt[Module] = Registry.module_?(x.id.mid)
    def isTypeDef         : Boolean     = x.location.endsWith("$$TYPE$")
    def tag               : String      = x.location.replace("$$TYPE$","").replace("$$",".").^.to(l => x.anchor.^.?.map(_.takeBefore("-")).map(a => l.^.reviseIf(_.endsWith("$"),_.dropLast(1)) + "." + a) or l)
    def label             : String      = label("")

    def label(base:String, om: Opt[Member] = \/, heading: Boolean = false): String      =
      var tg = x.tag
      if(!x.location.startsWith("scalqa.")) return tg.^.reviseIf(base.nonEmpty && !_.endsWith(base),_ + "." + base).simpleName(om,heading)
      var v = if(tg.startsWith("scalqa.")) tg.dropFirst(7) else tg

      v = v.split_~('.','$').dropVoid.map(_.docLabel.nameToOp).makeString(".")

      if(x.anchor.isEmpty) return v.^.to(v => v.lastIndexOf_?("._").map(i => v.dropFirst(i + 1)) or v).simpleName(om,heading)

      var a = x.anchor.takeBefore("-")
      if(a.length == 1) return a
      if(!v.endsWith("."+a)) v = v + "." + a

      if(v=="~" && x.tag == "scalqa.val.Stream$") "~~" else v.simpleName(om,heading)

    def scalqaLabel(base: Val.Opt[String] = \/, mo: Opt[Member] = \/, heading: Boolean = false): String = base.map(v => label(v,mo,heading)) or label

    def isPrivate: Boolean =
      val s=(x.location+".").replace("$",".").replace("..",".").replace("..",".")
      val v = s.contains(".z.") || s.contains(".Z.") || s.indexOf_~(".z").map_?(i => s.charAt_?(i+2).take(_.isUpper)).read_?
      v


