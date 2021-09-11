package scalqa; package fx; package base; package `abstract`; package region; import language.implicitConversions

import javafx.scene.layout.{ Background => JBackground, BackgroundFill => JFill, BackgroundImage => JImage }
import Region.Background

object Background extends Delegate.Opaque[Background, JBackground]("Fx.Abstract.Region.Background"):
  implicit def implicitFrom(v: JBackground): Background  = apply(v)
  implicit def implicitTo  (v: Background) : JBackground = apply(v)

  extension(x: Background)
    def images : Idx[Fx.Image] = Val.Idx.wrap(x.getImages).map_^(bi => Fx.Image(bi.getImage))
    def fills  : Idx[Fill]     = Val.Idx.wrap(x.getFills).map_^(Fill(_))

  object TYPE:
    opaque type DEF <: AnyRef.Opaque = JBackground & AnyRef.Opaque

  // *****************************************************************************************
  type   Fill = Fill.TYPE.DEF
  object Fill extends Delegate.Opaque[Fill, JFill]("Fx.Abstract.Region.Background.Fill"):
    object TYPE  { opaque type DEF <: AnyRef.Opaque = JFill & AnyRef.Opaque}

  type   Image = Image.TYPE.DEF
  object Image extends Delegate.Opaque[Fx.Image, JImage]("Fx.Abstract.Region.Background.Image"):
    object TYPE  { opaque type DEF <: AnyRef.Opaque = JImage & AnyRef.Opaque}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
