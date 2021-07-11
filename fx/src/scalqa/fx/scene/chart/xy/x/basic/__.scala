package scalqa; package fx; package scene; package chart; package xy; package x; import language.implicitConversions

class Basic[X, Y, XA <: Chart.Axis[X], YA <: Chart.Axis[Y]](override val axisX: XA, override val axisY: YA) extends Chart.XY[X, Y](axisX, axisY):
  protected type REAL = basic.z.Real[X, Y, XA, YA, axisX.VALUE, axisY.VALUE]; override def _createReal = new REAL(this, axisX.real, axisY.real)
  type ITEM <: Item
  type SERIES <: Series

  def item_~ : ~[ITEM] = data.~.flatMap(_.items).dropVoid

  protected[x] object Setup:
    var updateLegendJobs: ><[() => Unit] = \/
    var calcXRange_:? : () => Opt[<>[X]] = () => item_~.map(_.x).range_?(using axisX.ordering)
    var calcYRange_:? : () => Opt[<>[Y]] = () => item_~.map(_.y).range_?(using axisY.ordering)

  class Item(xPar: X, yPar: Y) extends ItemBase:
    def this(p: (X, Y)) = { this(p._1, p._2) }
    x = xPar
    y = yPar
    lazy  val node: Fx.Node = null
    def isVisible = true
    protected[x] var layoutJob: () => Unit = \/

  class Series(name: String, l:  Idx.O[ITEM]) extends SeriesBase(name, l):
    def this() = this("", \/)
    lazy  val node: Fx.Node = null
    protected[x] var layoutJob: () => Unit = \/

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
