package scalqa; package gen; import language.implicitConversions

import java.lang.{ Math => Java}

object Math:
  inline def floor(inline v: Double)                 : Double = Java.floor(v)
  inline def ceil (inline v: Double)                 : Double = Java.ceil(v)
  inline def log10(inline v: Double)                 : Double = Java.log10(v)
  inline def pow(inline a: Double, inline b: Double) : Double = Java.pow(a,b)

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  inline def Numeric    = math.Numeric
  inline def Ordering   = math.Ordering;    type Ordering[A]  = math.Ordering[A]
  inline def Format     = math.Format;      type Format       = math.Format.opaque.`type`
  inline def Rounding   = math.Rounding;    type Rounding     = math.Rounding
  inline def BigDecimal = math.BigDecimal;  type BigDecimal   = math.BigDecimal.opaque.`type`
  inline def BigInteger = math.BigInteger;  type BigInteger   = math.BigInteger.opaque.`type`

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Math -> ### Math Utilities

*/
