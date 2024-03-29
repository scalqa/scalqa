package scalqa; package fx; package base; package style; import language.implicitConversions

import Style.PseudoClass

class PseudoGroup protected[style] (val classes: Pack[PseudoClass]):
  private def grp(sq: Seq[Boolean])               : Int   = sq.stream.findPositionOpt(b => b) or sq.size

  /**/    def apply(n: Fx.Node, activeIndex: Int) : Unit  = classes.stream.foreachIndexed((i, c) => n.real.pseudoClassStateChanged(c.real, i == activeIndex))
  /**/    def apply(n: Fx.Node, ba: Boolean*)     : Unit  = apply(n, grp(ba))
  /**/    def apply(nodes: Fx.Node*)(ba: Boolean*): Unit  = { val i = grp(ba); nodes.stream.foreach(n => apply(n, i)) }

object PseudoGroup:
  val PositiveNegative             : PseudoGroup = PseudoGroup("positive", "negative")
  val SmallMediumLarge             : PseudoGroup = PseudoGroup("small", "medium", "large")

  def apply(p: Stream[PseudoClass]): PseudoGroup = new PseudoGroup(p.pack)
  def apply(p: PseudoClass*)       : PseudoGroup = apply(p)


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
