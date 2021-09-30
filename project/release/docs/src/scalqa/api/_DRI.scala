package scalqa; package api

trait _DRI:

  extension (x: DRI)
    def id                : Id          = Id(x)
    def member_?          : Opt[Member] = Registry.member_?(x.id)
    def module_?          : Opt[Module] = Registry.module_?(x.id.moduleId)
    def isTypeDef         : Boolean     = x.location.endsWith("$$TYPE$")
    def isLangAny         : Boolean     = x.location=="scalqa.lang.Any$"
    def tag               : String      = x.location
                                           .replace("$$TYPE$","").replace("$$",".")
                                           .^.map(l => x.anchor.^.?.map(_.takeBefore("-")).map(a => l.^.mapIf(_.endsWith("$"),_.dropLast(1)) + "." + a) or l)

    def label(shrt: Boolean = true): String =
      val short = shrt && !x.isLangAny
      var tg = x.tag
      if(!x.location.startsWith("scalqa.")) return tg.simpleName(short)
      var v = if(tg.startsWith("scalqa.")) tg.dropFirst(7) else tg

      v = v.split_~('.','$').dropVoid.map(_.docLabel.nameToOp).makeString(".")

      if(!x.anchor.isEmpty)
        var a = x.anchor.takeBefore("-")
        //if(a.length == 1) return a
        if(!v.endsWith("."+a)) v = v + "." + a
        if(v=="~" && x.tag == "scalqa.val.Stream$") v = "~~"
      else
        v = v.lastIndexOf_?("._").map(i => v.dropFirst(i + 1)) or v

      v.simpleName(short)

    def scalqaLabel(short: Boolean = true): String = label(short)

    def isPrivate: Boolean =
      val s=(x.location+".").replace("$",".").replace("..",".").replace("..",".")
      val v = s.contains(".z.") || s.contains(".Z.") || s.indexOf_~(".z").map_?(i => s.charAt_?(i+2).take(_.isUpper)).read_?
      v


