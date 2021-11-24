package scalqa; package fx; package scene; package shape; package path

import javafx.scene.shape.{ QuadCurveTo => JQuadCurveTo }

class QuadCurveTo(val real: JQuadCurveTo) extends AnyVal with Z.Base[QuadCurveTo,JQuadCurveTo]:
  protected def setup                                  = QuadCurveTo
  /**/      def xPro                  : Double.Pro.OM  = Fx.JavaFx.To.pro_OM(real.xProperty)
  /**/      def x                     : Double         = real.getX
  /**/      def x_=(v: Double)        : Unit           = real.setX(v)
  /**/      def yPro                  : Double.Pro.OM  = Fx.JavaFx.To.pro_OM(real.yProperty)
  /**/      def y                     : Double         = real.getY
  /**/      def y_=(v: Double)        : Unit           = real.setY(v)
  /**/      def controlXPro           : Double.Pro.OM  = Fx.JavaFx.To.pro_OM(real.controlXProperty)
  /**/      def controlX              : Double         = real.getControlX
  /**/      def controlX_=(v: Double) : Unit           = real.setControlX(v)
  /**/      def controlYPro           : Double.Pro.OM  = Fx.JavaFx.To.pro_OM(real.controlYProperty)
  /**/      def controlY              : Double         = real.getControlY
  /**/      def controlY_=(v: Double) : Unit           = real.setControlY(v)

object QuadCurveTo extends Z.Setup[QuadCurveTo,JQuadCurveTo]:
  def apply(v: JQuadCurveTo)                                          : QuadCurveTo = new QuadCurveTo(v)
  def apply()                                                         : QuadCurveTo = apply(JQuadCurveTo())
  def apply(controlX: Double, controlY: Double, x: Double, y: Double) : QuadCurveTo = apply(JQuadCurveTo(controlX, controlY, x, y))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
