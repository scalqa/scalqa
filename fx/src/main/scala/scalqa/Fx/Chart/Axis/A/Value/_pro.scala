package scalqa; package Fx; package Chart; package Axis; package A; package Value

trait _pro[A] {

  def lowerBoundPro: Pro.OM[A] = Custom.ProWO(real.lowerBoundProperty).asBiMappedView(map.asReversedView); def lowerBound = map.undo(real.getLowerBound); def lowerBound_=(v: A) = real.setLowerBound(map(v))

  def upperBoundPro: Pro.OM[A] = Custom.ProWO(real.upperBoundProperty).asBiMappedView(map.asReversedView); def upperBound = map.undo(real.getUpperBound); def upperBound_=(v: A) = real.setUpperBound(map(v))

  def minorTickCountPro: Pro.OM[Int] = Custom.ProWO(real.minorTickCountProperty); def minorTickCount = real.getMinorTickCount; def minorTickCount_=(v: Int) = real.setMinorTickCount(v)

  def minorTickLengthPro: Pro.OM[Double] = Custom.ProWO(real.minorTickLengthProperty); def minorTickLength = real.getMinorTickLength; def minorTickLength_=(v: Double) = real.setMinorTickLength(v)

  def minorTickVisiblePro: Pro.OM[Boolean] = Custom.ProWO(real.minorTickVisibleProperty); def minorTickVisible = real.isMinorTickVisible; def minorTickVisible_=(v: scala.Boolean) = real.setMinorTickVisible(v)

  def scalePro: Pro.O[Double] = Custom.ProO(real.scaleProperty); def scale = real.getScale; protected def scale_=(v: Double) = real.setScaleX(v)

  // -------------------------------------------------------------------
  private[Value] def real: javafx.scene.chart.ValueAxis[JNumber]
  private[Value] def map: BiMap[A, Double]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
