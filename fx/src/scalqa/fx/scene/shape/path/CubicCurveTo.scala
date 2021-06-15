package scalqa; package fx; package scene; package shape; package path

import javafx.scene.shape.{ CubicCurveTo => JCubicCurveTo }

class CubicCurveTo(val real: JCubicCurveTo) extends AnyVal with Z.Base[CubicCurveTo,JCubicCurveTo]:
  protected            def setup                                   = CubicCurveTo
  @tn("x_Pro")         def x_*                    : Double.Pro.OM  = Fx.JavaFx.To.pro_OM(real.xProperty)
  /**/                 def x                      : Double         = real.getX
  /**/                 def x_=(v: Double)         : Unit           = real.setX(v)
  @tn("y_Pro")         def y_*                    : Double.Pro.OM  = Fx.JavaFx.To.pro_OM(real.yProperty)
  /**/                 def y                      : Double         = real.getY
  /**/                 def y_=(v: Double)         : Unit           = real.setY(v)
  @tn("controlX1_Pro") def controlX1_*            : Double.Pro.OM  = Fx.JavaFx.To.pro_OM(real.controlX1Property)
  /**/                 def controlX1              : Double         = real.getControlX1
  /**/                 def controlX1_=(v: Double) : Unit           = real.setControlX1(v)
  @tn("controlX2_Pro") def controlX2_*            : Double.Pro.OM  = Fx.JavaFx.To.pro_OM(real.controlX2Property)
  /**/                 def controlX2              : Double         = real.getControlX2
  /**/                 def controlX2_=(v: Double) : Unit           = real.setControlX2(v)
  @tn("controlY1_Pro") def controlY1_*            : Double.Pro.OM  = Fx.JavaFx.To.pro_OM(real.controlY1Property)
  /**/                 def controlY1              : Double         = real.getControlY1
  /**/                 def controlY1_=(v: Double) : Unit           = real.setControlY1(v)
  @tn("controlY2_Pro") def controlY2_*            : Double.Pro.OM  = Fx.JavaFx.To.pro_OM(real.controlY2Property)
  /**/                 def controlY2              : Double         = real.getControlY2
  /**/                 def controlY2_=(v: Double) : Unit           = real.setControlY2(v)

object CubicCurveTo extends Z.Setup[CubicCurveTo,JCubicCurveTo]:
  def apply(v: JCubicCurveTo)                                           : CubicCurveTo = new CubicCurveTo(v)
  def apply()                                                           : CubicCurveTo = apply(JCubicCurveTo())
  def apply(controlX1: Double, controlY1: Double, controlX2: Double,
              controlY2: Double, x: Double, y: Double)                  : CubicCurveTo = apply(JCubicCurveTo(controlX1, controlY1, controlX2, controlY2, x, y))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
