package scalqa; package fx; package scene; import language.implicitConversions

import javafx.scene.image.{ Image => JImage }
import Fx.Image

object Image extends Abstract.Delegate.Opaque[Image, JImage]("Fx.Image"):
  /**/     def apply(v: J.Url) : Image = new JImage(v.toString)
  implicit def implicitFromJava(v: JImage) : Image = this(v)
  override def doc(v: Image) = Doc(name) += ("width", v.width) += ("height", v.height)

  extension (x: Image)
    @tn("width_Pro")  def width_*  : Double.Pro.O  = Fx.JavaFx.To.pro_O(x.real.widthProperty)
    /**/              def width    : Double        = x.real.getWidth
    @tn("height_Pro") def height_* : Double.Pro.O  = Fx.JavaFx.To.pro_O(x.real.heightProperty)
    /**/              def height   : Double        = x.real.getHeight
    /**/              def isError  : Boolean       = x.real.isError

  object opaque:
    opaque type `type` <: Any.Opaque.Ref = JImage & Any.Opaque.Ref

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
