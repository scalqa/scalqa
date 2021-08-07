package scalqa; package gen; package math; import language.implicitConversions

import Math.Format
import java.text.{ DecimalFormat as REAL }

object Format extends AnyRef.Opaque.Base[Format,REAL]("Format"):
  inline def apply(inline format: String) : Format = new REAL(format).opaque

  extension (inline x: Format)
    inline def apply(inline v: Double): String  = x.real.format(v)
    inline def apply(inline v: Long)  : String  = x.real.format(v)
    inline def apply(inline v: Number): String  = x.real.format(v)

  extension[A<:Int.Raw   ](inline x: Format) inline def apply(inline v: A) : String  = x.real.format(v.cast[Int])
  extension[A<:Long.Raw  ](inline x: Format) inline def apply(inline v: A) : String  = x.real.format(v.cast[Long])
  extension[A<:Float.Raw ](inline x: Format) inline def apply(inline v: A) : String  = x.real.format(v.cast[Float])
  extension[A<:Double.Raw](inline x: Format) inline def apply(inline v: A) : String  = x.real.format(v.cast[Double])

  object OPAQUE:
    opaque type TYPE <: AnyRef.Opaque = REAL & AnyRef.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
