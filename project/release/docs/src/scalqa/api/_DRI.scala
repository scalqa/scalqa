package scalqa; package api

trait _DRI:

  extension (x: DRI)
    def id                : Id          = Id(x)
    def memberOpt         : Opt[Member] = Registry.memberOpt(x.id)
    def moduleOpt         : Opt[Module] = Registry.moduleOpt(x.id.moduleId)
    def isTypeDef         : Boolean     = x.location.endsWith("$$TYPE$")
    def isLangAny         : Boolean     = x.location=="scalqa.lang.Any$"
    def isPrivate         : Boolean     = (x.location+"."+x.anchor).replace("$",".").replace("..",".").replace("..",".").self.map(s => s.contains(".z.") || s.contains(".Z.") || s.contains(".z_"))
    def tag               : String      = x.location
                                           .replace("$$TYPE$","").replace("$$",".")
                                           .self.map(l => x.anchor.??.map(_.takeBefore("-")).map(a => l.self.mapIf(_.endsWith("$"),_.dropLast(1)) + "." + a) or l)

    def label(brief: Boolean = true): String =
      var tg = x.tag
      if(!x.location.startsWith("scalqa.")) return tg.simpleName(brief)
      var v = if(tg.startsWith("scalqa.")) tg.dropFirst(7) else tg

      v = v.splitStream('.','$').dropVoid.map(_.docLabel).makeString(".")

      if(!x.anchor.isEmpty)
        var a = x.anchor.takeBefore("-")
        if(!v.endsWith("."+a)) v = v + "." + a
      else
        v = v.lastIndexOfOpt("._").map(i => v.dropFirst(i + 1)) or v

      v.simpleName(brief)

    def scalqaLabel(brief: Boolean = true): String = label(brief)



