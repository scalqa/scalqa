package scalqa; package api

trait _DRI:

  extension (x: DRI)
    def memberId          : Member.Id   = Member.Id(x)
    def moduleId          : Module.Id   = x.memberId.moduleId
    def member_?          : Opt[Member] = Doc.member_?(x.memberId)
    def module_?          : Opt[Module] = Doc.module_?(x.moduleId)
    def isOpaque          : Boolean     = x.anchor=="opaque"
    def isOpaqueBase      : Boolean     = x.location.endsWith("$$opaque$")
    def trimOpaqueBase    : DRI         = if(x.isOpaqueBase) x.copy(location=x.location.dropLast(9), anchor="opaque").^(_DRI.lookup.put(_,x)) else x
    def restoreOpaqueBase : DRI         = _DRI.lookup.get_?(x).get
    def isPrivate         : Boolean     =
        //val s=x.location.dropFirst(7) // "scalqa."
        //if('.' in s)  .contains("."))
        val p=x.location+".";  p.contains(".z") || p.contains(".Z.") || p.contains(".Z$.")
        //|| s in ("def","gen","j")

//        var s=x.location
//        if(s.length<7) return false
//        s=s.dropFirst(7) // "scalqa."
//        val p=s+".";
//        p.contains(".z") || p.contains(".Z.") || p.contains(".Z$.") || s.in("def","gen","j")


    def lastName          : String      = x.location.split_~(Array('$','.')).takeLast(1).read

    def scalqaName        : String      = name

    def scalqaName(base: String): String =


      if(!x.location.startsWith("scalqa.") || x.anchor.isEmpty.not && base != "`type`") base
      else if(x.anchor.isEmpty) x.name.^.convert(v => v.lastIndexOf_?("._").map(i => v.dropFirst(i + 1)) or v)
      else
        var v = x.anchor.takeBefore("-").replace("THIS_TYPE","this.type")
        if(v.length > 1) v = (x.name + "." + v).simpleName
        v

    def name          : String      =
      //if(base!=null && (base.length==1 && base!="G" && base!="X" || base.indexOf('.') >= 0)) return base
      var v = x.location
      if(v.startsWith("scalqa.")) v = v.dropFirst(7) //else return base
      if(v.endsWith("$$opaque$")) v = v.dropLast(9)
      v = v.split_~(Array('.','$')).dropVoid.map(_.docLabel.nameToOp).makeString(".")
      if(v.endsWith(".opaque"))   v = v.dropLast(7)
      v.simpleName


private object _DRI:
  private val lookup = Lookup.M.concurrent[DRI,DRI]()
