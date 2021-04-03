package scalqa; package fx; package scene; package shape; package path

import javafx.scene.shape.{ HLineTo => JHLineTo }

class HLineTo(val real: JHLineTo) extends AnyVal with Z.Base[HLineTo,JHLineTo]:
  protected    def setup                             = HLineTo
  @tn("x_Pro") def x_*            : Double.Pro.OM    = Fx.JavaFx.As.pro_OM(real.xProperty)
  /**/         def x              : Double           = real.getX
  /**/         def x_=(v: Double) : Unit             = real.setX(v)

object HLineTo extends Z.Setup[HLineTo,JHLineTo]:
  def apply(v: JHLineTo) : HLineTo = new HLineTo(v)
  def apply()            : HLineTo = apply(JHLineTo())
  def apply(x: Double)   : HLineTo = apply(JHLineTo(x))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
