package scalqa; package Fx; package Chart; package XY

trait _pro {

  def alternativeColumnFillVisiblePro: Pro.OM[Boolean] = Custom.ProWO(real.alternativeColumnFillVisibleProperty); def alternativeColumnFillVisible = real.isAlternativeColumnFillVisible; def alternativeColumnFillVisible_=(v: Boolean) = real.setAlternativeColumnFillVisible(v)

  def alternativeRowFillVisiblePro: Pro.OM[Boolean] = Custom.ProWO(real.alternativeRowFillVisibleProperty); def alternativeRowFillVisible = real.isAlternativeRowFillVisible; def alternativeRowFillVisible_=(v: Boolean) = real.setAlternativeRowFillVisible(v)

  def horizontalGridLinesVisiblePro: Pro.OM[Boolean] = Custom.ProWO(real.horizontalGridLinesVisibleProperty); def horizontalGridLinesVisible = real.isHorizontalGridLinesVisible; def horizontalGridLinesVisible_=(v: Boolean) = real.setHorizontalGridLinesVisible(v)

  def horizontalZeroLineVisiblePro: Pro.OM[Boolean] = Custom.ProWO(real.horizontalZeroLineVisibleProperty); def horizontalZeroLineVisible = real.isHorizontalZeroLineVisible; def horizontalZeroLineVisible_=(v: Boolean) = real.setHorizontalZeroLineVisible(v)

  def verticalGridLinesVisiblePro: Pro.OM[Boolean] = Custom.ProWO(real.verticalGridLinesVisibleProperty); def verticalGridLinesVisible = real.getVerticalGridLinesVisible; def verticalGridLinesVisible_=(v: Boolean) = real.setVerticalGridLinesVisible(v)

  def verticalZeroLineVisiblePro: Pro.OM[Boolean] = Custom.ProWO(real.verticalZeroLineVisibleProperty); def verticalZeroLineVisible = real.isVerticalZeroLineVisible; def verticalZeroLineVisible_=(v: Boolean) = real.setVerticalZeroLineVisible(v)

  // -----------------------------------------------------------
  private[XY] def real: javafx.scene.chart.XYChart[_, _]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
