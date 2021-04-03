package scalqa; package fx; package util; package style; import language.implicitConversions

object Class extends String.Custom.Data[style.Class]("Fx.Style.Class"):
  /**/     inline def apply   (inline v: String): Class   = v.asOpaque[Class]
  implicit inline def xxString(inline v: String): Class   = apply(v)

  given FxConverter: TwoWayFun[String,Class] = \/

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
