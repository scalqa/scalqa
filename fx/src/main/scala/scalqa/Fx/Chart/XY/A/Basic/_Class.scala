package scalqa; package Fx; package Chart; package XY; package A; package Basic

class _Class[X, Y, XA <: Axis[X], YA <: Axis[Y]](override val axisX: XA, override val axisY: YA) extends XY[X, Y](axisX, axisY) with _Setup[X, Y] with _Item[X, Y] {
  protected type REAL = Z.XYChart[X, Y, XA, YA, axisX.VALUE, axisY.VALUE]; override def _createGui = new REAL(this, axisX.real, axisY.real)
  type ITEM <: Item
  type SERIES <: Series

  def allItems: ~[ITEM] = data.all.flatMap(_.items).drop(_.isVoid)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
