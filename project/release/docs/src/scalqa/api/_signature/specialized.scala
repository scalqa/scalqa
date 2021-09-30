package scalqa; package api; package _signature

object specialized:
  private val NAMES = ><("~","><","<>","Opt","Array","Idx","Buffer","Pro","Set","Collection")
  private val OPT   = Seq("o",":","Specialized.Opt","[","B",",","OPT","]",",")

  def apply(m:Member, x: Signature) : Signature = if(x.isEmpty) x else

    def pos_? : Int.Opt = x.~.findPosition_?(v => v.isInstanceOf[Link] && (v.cast[Link].name in ("Specialized","Primitive")))

    var s = x.last.?
      .takeType[Link]
      .take(_.name in NAMES)
      .take(_ => pos_?)
      .map(l =>  x.dropRight(1).appended( x.~.dropFirst(pos_?.get).map(_.toString.trim).take(_ in ("A","B","C")).read_?.or("A") + "." + l.name)) or x

    if  (m.name.equalsIgnoreCase("map_?")) s = s.~.dropSequenceBy(_.toStr.trim,OPT).toSeq
    else if(m.name.startsWith("toLookup")) s = s.~.replaceSequenceBy(v => v.?.takeType[Link].map(_.name) or v.toString, ><("Lookup"), ><("KEY.Lookup")).toSeq

    s
