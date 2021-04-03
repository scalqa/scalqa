package scalqa; package gen; package math; import language.implicitConversions

import Math.Format

object Format extends Any.Ref.Custom.Type[Format,java.text.DecimalFormat]("Format"):
  inline def apply(inline format: String) : Format = new java.text.DecimalFormat(format).asOpaque[Format]

  extension (inline x: Format)
    inline def apply(inline v: Double): String  = x.real.format(v)
    inline def apply(inline v: Long)  : String  = x.real.format(v)
    inline def apply(inline v: Number): String  = x.real.format(v)

  extension[A<:Any.Raw.Int   ](inline x: Format) inline def apply(inline v: A) : String  = x.real.format(v.real)
  extension[A<:Any.Raw.Long  ](inline x: Format) inline def apply(inline v: A) : String  = x.real.format(v.real)
  extension[A<:Any.Raw.Float ](inline x: Format) inline def apply(inline v: A) : String  = x.real.format(v.real)
  extension[A<:Any.Raw.Double](inline x: Format) inline def apply(inline v: A) : String  = x.real.format(v.real)

  object opaque:
    opaque type `type` <: Opaque.Ref = java.text.DecimalFormat & Opaque.Ref

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
