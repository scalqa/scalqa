package scalqa; package Fx; package Style; package Pseudo

class Group protected[Pseudo] (val classes: Refs[Pseudo.Class]) {

  def apply(n: A.Node, activeIndex: Int): Unit = classes.all.foreachIdx((i, c) => n.real.pseudoClassStateChanged(c.real, i == activeIndex))

  def apply(n: A.Node, ba: Boolean*): Unit = apply(n, idx(ba))

  def apply(nodes: A.Node*)(ba: Boolean*): Unit = { val i = idx(ba); nodes.all.foreach(n => apply(n, i)) }

  // -----------------------------------------------------------------------------------------------------
  private def idx(sq: Seq[Boolean]): Int = sq.all.findIdxOpt(b => b) or sq.size

}

object Group {

  def make(p: ~[Pseudo.Class]): Group = new Group(p.to[Refs])

  def make(p: Pseudo.Class*): Group = make(p)

  val PositiveNegative = Group.make("positive", "negative")

  val SmallMediumLarge = Group.make("small", "medium", "large")

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
