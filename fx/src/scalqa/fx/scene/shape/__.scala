package scalqa; package fx; package scene; import language.implicitConversions

abstract class Shape extends Fx.Node:
  protected type REAL <: javafx.scene.shape.Shape

  def fillPro           : Pro.OM[Paint] = Fx.JavaFx.To.pro_OM(real.fillProperty)  .mutableMapView[Paint]
  def fill              : Paint         = fillPro()
  def fill_=(p: Paint)  : Unit          = fillPro() = p

  def strokePro         : Pro.OM[Paint] = Fx.JavaFx.To.pro_OM(real.strokeProperty).mutableMapView[Paint]
  def stroke            : Paint         = strokePro()
  def stroke_=(p: Paint): Unit          = strokePro() = p

object Shape:
  type Path   = shape.Path;    transparent inline def Path   = shape.Path
  type Circle = shape.Circle;  transparent inline def Circle = shape.Circle
  type Line   = shape.Line;    transparent inline def Line   = shape.Line

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
