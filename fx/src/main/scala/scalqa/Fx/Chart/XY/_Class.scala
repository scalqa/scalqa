package scalqa; package Fx; package Chart; package XY

abstract class _Class[X, Y] protected (val axisX: Axis[X], val axisY: Axis[Y]) extends Chart._Class with _pro with _Series[X, Y] with _Item[X, Y] {
  protected type REAL <: javafx.scene.chart.XYChart[axisX.VALUE, axisY.VALUE]
  type SERIES <: Series
  type ITEM <: Item

  private[XY]type J_SERIES = javafx.scene.chart.XYChart.Series[axisX.VALUE, axisY.VALUE]
  private[XY]type J_ITEM = javafx.scene.chart.XYChart.Data[axisX.VALUE, axisY.VALUE]

  val data: Idx.M[SERIES] = Idx.M.wrap(real.getData).asBiMappedView(Series.apply, _.real.asInstanceOf[J_SERIES])

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
