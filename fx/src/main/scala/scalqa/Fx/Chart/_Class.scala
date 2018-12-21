package scalqa; package Fx; package Chart

abstract class _Class extends A.Region {
  protected type REAL <: javafx.scene.chart.Chart

  def animatedPro: Pro.OM[Boolean] = Custom.ProWO(real.animatedProperty); def animated = real.getAnimated; def animated_=(v: Boolean) = real.setAnimated(v)

  def legendVisiblePro: Pro.OM[Boolean] = Custom.ProWO(real.legendVisibleProperty); def legendVisible = real.isLegendVisible; def legendVisible_=(v: Boolean) = real.setLegendVisible(v)

  def titlePro: Pro.OM[String] = Custom.ProWO(real.titleProperty); def title = real.getTitle; def title_=(v: String) = real.setTitle(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
