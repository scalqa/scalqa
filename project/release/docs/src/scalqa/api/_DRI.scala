package scalqa; package api

trait _DRI:

  extension (x: DRI)
    def id                : Id          = Id(x)
    def member_?          : Opt[Member] = Registry.member_?(x.id)
    def module_?          : Opt[Module] = Registry.module_?(x.id.mid)
    def isOpaqueDef       : Boolean     = x.location.endsWith("$$opaque$")
    def isPrivate         : Boolean     = { val p=x.location+".";  p.contains(".z") || p.contains(".Z.") || p.contains(".Z$.") }
    def tag               : String      = x.location.replace("$$opaque$","").replace("$$",".").^.as(l => x.anchor.^.?.map(_.takeBefore("-")).map(a => l.^.reviseIf(_.endsWith("$"),_.dropLast(1)) + "." + a) or l)

    def label             : String      = label("")
    def label(base:String): String      =
      var tg = x.tag
      if(!x.location.startsWith("scalqa.")) return tg.^.reviseIf(base.nonEmpty && !_.endsWith(base),_ + "." + base).simpleName
      var v = if(tg.startsWith("scalqa.")) tg.dropFirst(7) else tg

      v = v.split_~(Array('.','$')).dropVoid.map(_.docLabel.nameToOp).makeString(".")

      if(x.anchor.isEmpty) return v.^.as(v => v.lastIndexOf_?("._").map(i => v.dropFirst(i + 1)) or v).simpleName

      var a = x.anchor.takeBefore("-")
      if(a.length == 1) return a
      if(!v.endsWith("."+a)) v = v + "." + a

      if(v=="~" && x.tag == "scalqa.val.Stream$") "~~" else v.simpleName


    def scalqaLabel(base: Opt[String] = \/): String = base.map(label) or label



