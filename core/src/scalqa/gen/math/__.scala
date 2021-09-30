package scalqa; package gen; import language.implicitConversions

object Math:
  inline def floor(inline v: Double)                 : Double = java.lang.Math.floor(v)
  inline def ceil (inline v: Double)                 : Double = java.lang.Math.ceil(v)
  inline def log10(inline v: Double)                 : Double = java.lang.Math.log10(v)
  inline def pow(inline a: Double, inline b: Double) : Double = java.lang.Math.pow(a,b)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Average[A]   = math.Average[A];          transparent inline def Average    = math.Average
  type Sum[A]       = math.Sum[A]
  type Ordering[A]  = scala.Ordering[A];        transparent inline def Ordering   = math.Ordering
  type Format       = math.Format.TYPE.DEF;     transparent inline def Format     = math.Format
  type Rounding     = math.Rounding;            transparent inline def Rounding   = math.Rounding
  type BigDecimal   = math.BigDecimal.TYPE.DEF; transparent inline def BigDecimal = math.BigDecimal
  type BigInteger   = math.BigInteger.TYPE.DEF; transparent inline def BigInteger = math.BigInteger

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@type DEF  -> ### General Math

   Math type in Scalqa is an alias to scala.math.Numeric, with which they can be used interchangeably.

@object Math  ->

   Math object contains few shortcuts to java.lang.Math static methods.

*/
