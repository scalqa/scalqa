package scalqa; package fx; package scene; import language.implicitConversions

abstract class Shape extends Node:
  protected type REAL <: javafx.scene.shape.Shape

  @tn("fill_Pro")   def fill_*            : Pro.OM[Paint] = Fx.JavaFx.To.pro_OM(real.fillProperty)  .mutableMap_^[Paint]
  /**/              def fill              : Paint         = fill_*()
  /**/              def fill_=(p: Paint)  : Unit = fill_*() = p

  @tn("stroke_Pro") def stroke_*          : Pro.OM[Paint] = Fx.JavaFx.To.pro_OM(real.strokeProperty).mutableMap_^[Paint]
  /**/              def stroke            : Paint         = stroke_*()
  /**/              def stroke_=(p: Paint): Unit          = stroke_*() = p

object Shape:
  type Path   = shape.Path;    val Path   = shape.Path
  type Circle = shape.Circle;  val Circle = shape.Circle
  type Line   = shape.Line;    val Line   = shape.Line

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
