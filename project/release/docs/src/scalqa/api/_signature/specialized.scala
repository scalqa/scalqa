package scalqa; package api; package _signature

object specialized:
  private val SPEC_OPT = Seq("o",":","Specialized.Opt","[","T",",","OPT","]",",")

  def apply(m:Member, x: Signature) : Signature = if(x.isEmpty) x else adjustType(m,dropOpt(m,x))

  def dropOpt(m:Member, x: Signature) : Signature = if(m.name.equalsIgnoreCase("map_?")) x.~.dropSequenceBy(_.toStr.trim,SPEC_OPT).toSeq else x

  def adjustType(m:Member, x: Signature) : Signature =
    def isSpec = x.~.takeType[Link].exists(_.name == "Specialized")
    def typ = if(x.~.takeType[String].exists(_.trim == "T")) "T" else "A"
    x.last match
      case v: Link if v.name=="~"   && isSpec => x.dropRight(1).appended(v.copy(dri=v.dri.copy(anchor=typ+".~")))
      case v: Link if v.name=="Opt" && isSpec => x.dropRight(1).appended(v.copy(dri=v.dri.copy(anchor=typ+".Opt")))
      case _                                  => x
