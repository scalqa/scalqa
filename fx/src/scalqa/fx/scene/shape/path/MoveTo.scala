package scalqa; package fx; package scene; package shape; package path

import javafx.scene.shape.{ MoveTo => JMoveTo }

class MoveTo(val real: JMoveTo) extends AnyVal with Z.Base[MoveTo,JMoveTo]:
  protected    def setup                           = MoveTo
  @tn("x_Pro") def x_*            : Double.Pro.OM  = Fx.JavaFx.As.pro_OM(real.xProperty)
  /**/         def x              : Double         = real.getX
  /**/         def x_=(v: Double) : Unit           = real.setX(v)
  @tn("y_Pro") def y_*            : Double.Pro.OM  = Fx.JavaFx.As.pro_OM(real.yProperty)
  /**/         def y              : Double         = real.getY
  /**/         def y_=(v: Double) : Unit           = real.setY(v)

object MoveTo extends Z.Setup[MoveTo,JMoveTo]:
  def apply(v: JMoveTo)           : MoveTo = new MoveTo(v)
  def apply()                     : MoveTo = apply(JMoveTo())
  def apply(x: Double, y: Double) : MoveTo = apply(JMoveTo(x, y))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
