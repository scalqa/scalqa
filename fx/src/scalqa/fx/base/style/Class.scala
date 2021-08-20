package scalqa; package fx; package base; package style; import language.implicitConversions

import Style.Class

object Class extends String.Opaque.Data[Class]("Fx.Style.Class"):
  /**/     inline def apply(inline v: String)       : Class   = v.opaque
  implicit inline def implicitFrom(inline v: String): Class   = apply(v)

  given FxConverter: ReversibleFunction[String,Class] = \/

  extension (x: Class)
    @tn("join") def +(v: Style|String): Class =  {val s=v.cast[String]; if(x.isVoid) s:Class else if(s.isVoid) x else x.real + ';' + s }

  object OPAQUE:
    opaque type TYPE <: String.Opaque = String.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
