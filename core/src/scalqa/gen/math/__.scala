package scalqa; package gen; import language.implicitConversions

import java.lang.{ Math => Java}

object Math:
  inline def floor(inline v: Double)                 : Double = Java.floor(v)
  inline def ceil (inline v: Double)                 : Double = Java.ceil(v)
  inline def log10(inline v: Double)                 : Double = Java.log10(v)
  inline def pow(inline a: Double, inline b: Double) : Double = Java.pow(a,b)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def Ordering   = math.Ordering;    type Ordering[A]  = math.Ordering[A]
  transparent inline def Format     = math.Format;      type Format       = math.Format.opaque.`type`
  transparent inline def Rounding   = math.Rounding;    type Rounding     = math.Rounding
  transparent inline def BigDecimal = math.BigDecimal;  type BigDecimal   = math.BigDecimal.opaque.`type`
  transparent inline def BigInteger = math.BigInteger;  type BigInteger   = math.BigInteger.opaque.`type`

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Math -> ### General Math

   Math type in Scalqa is an alias to scala.math.Numeric. Generally "Math" is a better name for what Numeric stands for.

   Math object contains few shortcuts to java.lang.Math static methods.

*/
