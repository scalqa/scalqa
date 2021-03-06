package scalqa; package fx; package base; package `abstract`; package region; import language.implicitConversions

import javafx.scene.layout.{ Background => JBackground, BackgroundFill => JFill, BackgroundImage => JImage }
import Region.Background

object Background extends Delegate.Opaque[Background, JBackground]("Fx.Abstract.Region.Background"):
  implicit def implicitFromxxJava(v: JBackground) : Background  = apply(v)
  implicit def implicitToJava    (v: Background)  : JBackground = apply(v)

  extension(x: Background)
    def images : Idx[Fx.Image] = Val.Idx.wrap(x.getImages).map_^(bi => Fx.Image(bi.getImage))
    def fills  : Idx[Fill]     = Val.Idx.wrap(x.getFills).map_^(Fill(_))

  object opaque:
    opaque type `type` <: Any.Opaque.Ref = JBackground & Any.Opaque.Ref

  // *****************************************************************************************
  type   Fill = Fill.opaque.`type`
  object Fill extends Delegate.Opaque[Fill, JFill]("Fx.Abstract.Region.Background.Fill"):
    object opaque { opaque type `type` <: Any.Opaque.Ref = JFill & Any.Opaque.Ref}

  type   Image = Image.opaque.`type`
  object Image extends Delegate.Opaque[Fx.Image, JImage]("Fx.Abstract.Region.Background.Image"):
    object opaque { opaque type `type` <: Any.Opaque.Ref = JImage & Any.Opaque.Ref}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
