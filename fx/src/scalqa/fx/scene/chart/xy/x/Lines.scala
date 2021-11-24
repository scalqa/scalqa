package scalqa; package fx; package scene; package chart; package xy; package x; import language.implicitConversions

class Lines[X, Y](xParam: Chart.Axis[X], yParam: Chart.Axis[Y]) extends Chart.XY[X, Y](xParam, yParam):
  protected type REAL = javafx.scene.chart.LineChart[axisX.VALUE, axisY.VALUE]; override def _createReal = new REAL(axisX.real, axisY.real)
  type ITEM = ItemBase
  type SERIES = Line

  class Line(nameO: Opt[String]= \/, override val items:  Idx.OM[ITEM] = Idx.OM.void) extends SeriesBase(nameO, items) with Able.Add[(X, Y)]:
    def this(name: String, s: Stream[(X, Y)]) = { this(name.?,  Idx.OM[ITEM](100)); items ++= s.map(new ItemBase(_)) }

    def add(t: (X, Y)) = items += new ItemBase(t)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
