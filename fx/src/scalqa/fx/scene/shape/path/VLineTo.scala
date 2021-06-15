package scalqa; package fx; package scene; package shape; package path

import javafx.scene.shape.{ VLineTo => JVLineTo }

class VLineTo(val real: JVLineTo) extends AnyVal with Z.Base[VLineTo,JVLineTo]:
  protected    def setup                             = VLineTo
  @tn("y_Pro") def y_*            : Double.Pro.OM    = Fx.JavaFx.To.pro_OM(real.yProperty)
  /**/         def y              : Double           = real.getY
  /**/         def y_=(v: Double) : Unit             = real.setY(v)

object VLineTo extends Z.Setup[VLineTo,JVLineTo]:
  def apply(v: JVLineTo) : VLineTo = new VLineTo(v)
  def apply()            : VLineTo = apply(JVLineTo())
  def apply(x: Double)   : VLineTo = apply(JVLineTo(x))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
