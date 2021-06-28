package scalqa; package lang; package double; package custom; package data; import language.implicitConversions

import java.lang.{ Double => NUMBER }

abstract class Number[A<:Opaque.Double](typeName:String) extends Ordered[A](typeName):

  @fast given math: G.Math[A] = Lang.Double.math.cast[G.Math[A]]

  extension[A<:RAW](inline x: A)
    /**/                        inline def abs                                                : A           = {val v=x; if(v.real >= 0) v else (-v.real).cast[A]}
    /**/                        inline def unary_-                                            : A           = (- x.real).cast[A]
    @tn("numberMultiply")       inline def * (inline v: A|Byte|Short|Int|Long|Float|Double)   : A           = (x.real * v.cast[Double]).cast[A]
    @tn("numberDivide")         inline def / (inline v: A|Byte|Short|Int|Long|Float|Double)   : A           = (x.real / v.cast[Double]).cast[A]
    @tn("numberPlus")           inline def + (inline v: A|Byte|Short|Int|Long|Float|Double)   : A           = (x.real + v.cast[Double]).cast[A]
    @tn("numberMinus")          inline def - (inline v: A|Byte|Short|Int|Long|Float|Double)   : A           = (x.real - v.cast[Double]).cast[A]
    @tn("numberRemainder")      inline def % (inline v: A|Byte|Short|Int|Long|Float|Double)   : A           = (x.real % v.cast[Double]).cast[A]
    @tn("numberGreater")        inline def > (inline v: A|Byte|Short|Int|Long|Float|Double)   : Boolean     = x.real >  v.cast[Double]
    @tn("numberGreaterOrEqual") inline def >=(inline v: A|Byte|Short|Int|Long|Float|Double)   : Boolean     = x.real >= v.cast[Double]
    @tn("numberLess")           inline def < (inline v: A|Byte|Short|Int|Long|Float|Double)   : Boolean     = x.real <  v.cast[Double]
    @tn("numberLessOrEqual")    inline def <=(inline v: A|Byte|Short|Int|Long|Float|Double)   : Boolean     = x.real <= v.cast[Double]
    /**/                        inline def Byte                                               : Byte        = x.cast[Byte]
    /**/                        inline def Short                                              : Short       = x.cast[Short]
    /**/                        inline def Int                                                : Int         = x.cast[Int]
    /**/                        inline def Long                                               : Long        = x.cast[Long]
    /**/                        inline def Float                                              : Float       = x.cast[Float]
    /**/                        inline def Double                                             : Double      = x.cast[Double]
    /**/                        inline def Number                                             : NUMBER      = NUMBER.valueOf(x.real)
    /**/                        inline def sign                                               : Int         = { val v=x.real; if(v>0) 1 else if(v<0) -1 else 0 }
    /**/                        inline def roundTo(inline size:A)    (using inline r:Rounding): A           = r(x.real,size.real).cast[A]
    /**/                        inline def roundDecimal(inline d:Int)(using inline r:Rounding): A           = r.decimal(x.real,d).cast[A]

  given givenCanEqualByte  : CanEqual[A,Byte]   = CanEqual.derived
  given givenCanEqualShort : CanEqual[A,Short]  = CanEqual.derived
  given givenCanEqualInt   : CanEqual[A,Int]    = CanEqual.derived
  given givenCanEqualLong  : CanEqual[A,Long]   = CanEqual.derived
  given givenCanEqualFloat : CanEqual[A,Float]  = CanEqual.derived
  given givenCanEqualDouble: CanEqual[A,Double] = CanEqual.derived

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Number -> ###

  Custom Data Number element is provided with similar operations, which are available on base primitive without any loss of performance.

  See [more in guide](../../../../../guide/features/Data.html).

@def unary_-     -> Negate           \n\n  Returns negation of this value
@def *           -> Multiply         \n\n  Returns the product of this and given value
@def /           -> Divide           \n\n  Returns the quotient of this and given value
@def +           -> Plus             \n\n  Returns the sum of this and given value
@def -           -> Minus            \n\n  Returns difference of this and given value
@def %           -> Remainder        \n\n  Returns the remainder of the division of this by given value
@def <           -> Less             \n\n  Returns `true` if current value is less than given, `false` - otherwise
@def <=          -> Less or equal    \n\n  Returns `true` if current value is less or equal to given, `false` - otherwise
@def >           -> Greater          \n\n  Returns `true` if current value is greater than given, `false` - otherwise
@def >=          -> Greater or equal \n\n  Returns `true` if current value is greater or equal to given, `false` - otherwise
@def Byte        -> Make Byte        \n\n  Byte constructor as a conversion from this value
@def Short       -> Make Short       \n\n  Short constructor as a conversion from this value
@def Int         -> Make Int         \n\n  Int constructor as a conversion from this value
@def Long        -> Make Long        \n\n  Long constructor as a conversion from this value
@def Float       -> Make Float       \n\n  Float constructor as a conversion from this value
@def Double      -> Make Double      \n\n  Double constructor as a conversion from this value
@def Number      -> Make Number      \n\n  Number constructor as a conversion from this value
@def sign        -> Sign             \n\n  Returns -1 if this is negative, 0 - if this value equals to 0, and 1 otherwise
@def roundTo     -> Round to size    \n\n  Rounds current value to specified size
*/