package scalqa; package fx; package scene; package shape; package path

import javafx.scene.shape.{ LineTo => JLineTo }

class LineTo(val real: JLineTo) extends AnyVal with Z.Base[LineTo,JLineTo]:
  protected def setup                 = LineTo
  def xPro           : Double.Pro.OM  = Fx.JavaFx.To.pro_OM(real.xProperty)
  def x              : Double         = real.getX
  def x_=(v: Double) : Unit           = real.setX(v)
  def yPro           : Double.Pro.OM  = Fx.JavaFx.To.pro_OM(real.yProperty)
  def y              : Double         = real.getY
  def y_=(v: Double) : Unit           = real.setY(v)

object LineTo extends Z.Setup[LineTo,JLineTo]:
  def apply(v: JLineTo)           : LineTo = new LineTo(v)
  def apply()                     : LineTo = apply(JLineTo())
  def apply(x: Double, y: Double) : LineTo = apply(JLineTo(x, y))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
