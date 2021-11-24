package scalqa; package fx; package scene; import language.implicitConversions

import javafx.scene.image.{ Image => REAL }
import Fx.Image

object Image extends Abstract.Delegate.Opaque[Image, REAL]("Fx.Image"):
  /**/     def apply(v: J.Url)          : Image = new REAL(v.toString)
  implicit def implicitFromJava(v: REAL): Image = this(v)
  override def value_doc(v: Image)      : Doc   = Doc(typeName) += ("width", v.width) += ("height", v.height)

  extension (x: Image)
    def widthPro : Double.Pro.O  = Fx.JavaFx.To.pro_O(x.real.widthProperty)
    def width    : Double        = x.real.getWidth
    def heightPro: Double.Pro.O  = Fx.JavaFx.To.pro_O(x.real.heightProperty)
    def height   : Double        = x.real.getHeight
    def isError  : Boolean       = x.real.isError

  object TYPE:
    opaque type DEF <: AnyRef.Opaque = REAL & AnyRef.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
