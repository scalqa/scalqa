package scalqa; package Fx; package Chart; package XY

trait _Item[X, Y] { self: XY[X, Y] =>
  type ITEM <: Item

  class Item protected extends Any.Able.ToInfo {
    def this(xPar: X, yPar: Y) = { this(); x = xPar; y = yPar }
    def this(p: (X, Y)) = { this(p._1, p._2) }

    val chart: XY[X, Y] = self

    def x: X = chart.axisX.valueMap.undo(real.getXValue); def x_=(v: X) = real.setXValue(chart.axisX.valueMap(v))

    def y: Y = chart.axisY.valueMap.undo(real.getYValue); def y_=(v: Y) = real.setYValue(chart.axisY.valueMap(v))

    def xPos: Double = axisX(x)

    def yPos: Double = axisY(y)

    def toInfo = new Pro.Info(this) += (("x", x)) += (("y", y))

    protected[Chart] lazy val real = new chart.J_ITEM().I(_.setExtraValue(this))

  }

  object Item {

    def make(d: javafx.scene.chart.XYChart.Data[_, _]): ITEM = d.getExtraValue.asInstanceOf[ITEM]

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
