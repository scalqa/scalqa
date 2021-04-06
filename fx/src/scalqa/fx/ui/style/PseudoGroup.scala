package scalqa; package fx; package ui; package style; import language.implicitConversions

class PseudoGroup protected[style] (val classes: ><[PseudoClass]):
  private def grp(sq: Seq[Boolean])               : Int   = sq.~.findPosition_?(b => b) or sq.size

  /**/    def apply(n: Node, activeIndex: Int)  : Unit  = classes.~.foreachIndexed((i, c) => n.real.pseudoClassStateChanged(c.real, i == activeIndex))
  /**/    def apply(n: Node, ba: Boolean*)      : Unit  = apply(n, grp(ba))
  /**/    def apply(nodes: Node*)(ba: Boolean*) : Unit  = { val i = grp(ba); nodes.~.foreach(n => apply(n, i)) }

object PseudoGroup:
  val PositiveNegative         : PseudoGroup = PseudoGroup("positive", "negative")
  val SmallMediumLarge         : PseudoGroup = PseudoGroup("small", "medium", "large")

  def apply(p: ~[PseudoClass]) : PseudoGroup = new PseudoGroup(p.><)
  def apply(p: PseudoClass*)   : PseudoGroup = apply(p)


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
