package scalqa; package api; package _signature

object specialized:
  private val NAMES = Pack("Stream","Range","Pack","Opt","Array","Idx","Buffer","Pro","Set","Collection")
  private val OPT   = Seq("o",":","Specialized.Opt","[","B",",","OPT","]",",")

  def apply(m:Member, x: Signature) : Signature = if(x.isEmpty) x else

    def posOpt : Int.Opt = x.stream.findPositionOpt(v => v.isInstanceOf[Link] && (v.cast[Link].name in ("Specialized","Primitive")))

    var s = x.last.?
      .takeType[Link]
      .take(_.name in NAMES)
      .take(_ => posOpt)
      .map(l =>  x.dropRight(1).appended( x.stream.dropFirst(posOpt.get).map(_.toString.trim).take(_ in ("A","B","C")).readOpt.or("A") + "." + l.name)) or x

    if  (m.name.equalsIgnoreCase("mapOpt")) s = s.stream.dropSequenceBy(_.label.trim,OPT).toSeq
    else if(m.name.startsWith("toLookup")) s = s.stream.replaceSequenceBy(v => v.?.takeType[Link].map(_.name) or v.toString, "Lookup".self.pack, Pack("KEY.Lookup")).toSeq

    s
