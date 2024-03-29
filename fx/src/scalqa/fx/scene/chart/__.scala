package scalqa; package fx; package scene

abstract class Chart extends Abstract.Region:
  protected type REAL <: javafx.scene.chart.Chart

  def animatedPro                 : Boolean.Pro.OM  = Fx.JavaFx.To.pro_OM(real.animatedProperty)
  def animated                    : Boolean         = real.getAnimated
  def animated_=(v: Boolean)      : Unit            = real.setAnimated(v)
  def legendVisiblePro            : Boolean.Pro.OM  = Fx.JavaFx.To.pro_OM(real.legendVisibleProperty)
  def legendVisible               : Boolean         = real.isLegendVisible
  def legendVisible_=(v: Boolean) : Unit            = real.setLegendVisible(v)
  def titlePro                    : Pro.OM[String]  = Fx.JavaFx.To.pro_OM(real.titleProperty)
  def title                       : String          = real.getTitle
  def title_=(v: String)          : Unit            = real.setTitle(v)

object Chart:
  type Axis[A]  = chart.Axis[A];   transparent inline def Axis = chart.Axis
  type XY[X, Z] = chart.XY[X, Z];  transparent inline def XY   = chart.XY

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
