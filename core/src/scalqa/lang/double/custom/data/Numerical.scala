package scalqa; package lang; package double; package custom; package data; import language.implicitConversions

abstract class Numerical[A<:Opaque.Double](typeName:String) extends Ordered[A](typeName) with Numerical._methods[A]:

  @fast given math: G.Math[A] = Lang.Double.math.cast[G.Math[A]]

  given givenCanEqualByte  : CanEqual[A,Byte]   = CanEqual.derived
  given givenCanEqualShort : CanEqual[A,Short]  = CanEqual.derived
  given givenCanEqualInt   : CanEqual[A,Int]    = CanEqual.derived
  given givenCanEqualLong  : CanEqual[A,Long]   = CanEqual.derived
  given givenCanEqualFloat : CanEqual[A,Float]  = CanEqual.derived
  given givenCanEqualDouble: CanEqual[A,Double] = CanEqual.derived

object Numerical:

  trait _methods[A<:RAW] extends Ordered.zMethodsBase[A] with z.toPrimitives[A]:
    extension(inline x: A)
      /**/                  inline def abs                                                : A           = {val v=x; if(v.real >= 0) v else (-v.real).cast[A]}
      /**/                  inline def unary_-                                            : A           = (- x.real).cast[A]
      @tn("multiply")       inline def * (inline v: A|Byte|Short|Int|Long|Float|Double)   : A           = (x.real * v.cast[Double]).cast[A]
      @tn("divide")         inline def / (inline v: A|Byte|Short|Int|Long|Float|Double)   : A           = (x.real / v.cast[Double]).cast[A]
      @tn("plus")           inline def + (inline v: A|Byte|Short|Int|Long|Float|Double)   : A           = (x.real + v.cast[Double]).cast[A]
      @tn("minus")          inline def - (inline v: A|Byte|Short|Int|Long|Float|Double)   : A           = (x.real - v.cast[Double]).cast[A]
      @tn("remainder")      inline def % (inline v: A|Byte|Short|Int|Long|Float|Double)   : A           = (x.real % v.cast[Double]).cast[A]
      @tn("greater")        inline def > (inline v: A|Byte|Short|Int|Long|Float|Double)   : Boolean     = x.real >  v.cast[Double]
      @tn("greaterOrEqual") inline def >=(inline v: A|Byte|Short|Int|Long|Float|Double)   : Boolean     = x.real >= v.cast[Double]
      @tn("less")           inline def < (inline v: A|Byte|Short|Int|Long|Float|Double)   : Boolean     = x.real <  v.cast[Double]
      @tn("lessOrEqual")    inline def <=(inline v: A|Byte|Short|Int|Long|Float|Double)   : Boolean     = x.real <= v.cast[Double]
      /**/                  inline def sign                                               : Int         = { val v=x.real; if(v>0) 1 else if(v<0) -1 else 0 }
      /**/                  inline def roundTo(inline size:A)    (using inline r:Rounding): A           = r(x.real,size.real).cast[A]
      /**/                  inline def roundDecimal(inline d:Int)(using inline r:Rounding): A           = r.decimal(x.real,d).cast[A]


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Numerical -> ###

  Custom Numerical Data  element is provided with similar operations, which are available on base primitive without any loss of performance.

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
@def sign        -> Sign             \n\n  Returns -1 if this is negative, 0 - if this value equals to 0, and 1 otherwise
@def roundTo     -> Round to size    \n\n  Rounds current value to specified size
*/