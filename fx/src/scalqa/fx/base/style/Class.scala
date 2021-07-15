package scalqa; package fx; package base; package style; import language.implicitConversions

import Style.Class

object Class extends String.Custom.Data[Class]("Fx.Style.Class"):
  /**/     inline def apply(inline v: String)             : Class   = v.asOpaque[Class]
  implicit inline def implicitFromString(inline v: String): Class   = apply(v)

  given FxConverter: ReversibleFunction[String,Class] = \/

  extension (x: Class)
    override def join(v: Class|String) : Class = apply(if(x.isVoid) v.real else if(v.real.isVoid) x.real else x.real + ';' + v.real)

  object opaque:
    opaque type `type` <: Any.Opaque.String = Any.Opaque.String

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
