package scalqa; package Fx; package Chart; package XY; package A

class Lines[X, Y](xPar: Axis[X], yPar: Axis[Y]) extends XY[X, Y](xPar, yPar) {
  protected type REAL = javafx.scene.chart.LineChart[axisX.VALUE, axisY.VALUE]; override def _createGui = new REAL(axisX.real, axisY.real)
  type ITEM = Item
  type SERIES = Line

  // ***************************************************************************************************************
  class Line(nameOpt: Opt[String] = \/, override val items: Idx.OM[ITEM] = \/) extends super.Series(nameOpt, items) with Any.Able.Add[(X, Y)] {

    def this(name: String, all: ~[(X, Y)]) = {
      this(name.Opt, Idx.OM.makeSized[ITEM](100));
      items +~= all.map(new Item(_))
    }

    def add(t: (X, Y)) = items += new Item(t)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
