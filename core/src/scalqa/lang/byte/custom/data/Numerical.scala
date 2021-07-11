package scalqa; package lang; package byte; package custom; package data; import language.implicitConversions

abstract class Numerical[A<:Opaque.Byte](typeName:String) extends Ordered[A](typeName) with Numerical._methods[A]:

  @fast given math: G.Math[A] = Lang.Byte.math.cast[G.Math[A]]

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
      @tn("multiply")       inline def * (inline v: A|Byte)                               : A           = (x.real * v.cast[Byte]).cast[A]
      @tn("divide")         inline def / (inline v: A|Byte)                               : A           = (x.real / v.cast[Byte]).cast[A]
      @tn("plus")           inline def + (inline v: A|Byte)                               : A           = (x.real + v.cast[Byte]).cast[A]
      @tn("minus")          inline def - (inline v: A|Byte)                               : A           = (x.real - v.cast[Byte]).cast[A]
      @tn("remainder")      inline def % (inline v: A|Byte)                               : A           = (x.real % v.cast[Byte]).cast[A]
      @tn("greater")        inline def > (inline v: A|Byte|Short|Int|Long|Float|Double)   : Boolean     = inline v match{ case _ :Double => x.real >  v.cast[Double]; case _ :Float => x.real >  v.cast[Float]; case _ :Long => x.real >  v.cast[Long]; case _ :Int => x.real >  v.cast[Int]; case _ :Short => x.real >  v.cast[Short]; case _ => x.real >  v.cast[Byte] }
      @tn("greaterOrEqual") inline def >=(inline v: A|Byte|Short|Int|Long|Float|Double)   : Boolean     = inline v match{ case _ :Double => x.real >= v.cast[Double]; case _ :Float => x.real >= v.cast[Float]; case _ :Long => x.real >= v.cast[Long]; case _ :Int => x.real >= v.cast[Int]; case _ :Short => x.real >= v.cast[Short]; case _ => x.real >= v.cast[Byte] }
      @tn("less")           inline def < (inline v: A|Byte|Short|Int|Long|Float|Double)   : Boolean     = inline v match{ case _ :Double => x.real <  v.cast[Double]; case _ :Float => x.real <  v.cast[Float]; case _ :Long => x.real <  v.cast[Long]; case _ :Int => x.real <  v.cast[Int]; case _ :Short => x.real <  v.cast[Short]; case _ => x.real <  v.cast[Byte] }
      @tn("lessOrEqual")    inline def <=(inline v: A|Byte|Short|Int|Long|Float|Double)   : Boolean     = inline v match{ case _ :Double => x.real <= v.cast[Double]; case _ :Float => x.real <= v.cast[Float]; case _ :Long => x.real <= v.cast[Long]; case _ :Int => x.real <= v.cast[Int]; case _ :Short => x.real <= v.cast[Short]; case _ => x.real <= v.cast[Byte] }
      /**/                  inline def sign                                               : Int         = { val v=x.real; if(v>0) 1 else if(v<0) -1 else 0 }
      /**/                  inline def roundTo(inline size:A)    (using inline r:Rounding): A           = r(x.real,size.real).cast[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Numerical -> ### Byte Custom Numerical Data Setup

  Custom Numerical Data  element is provided with similar operations, which are available on base primitive without any loss of performance.

  See [more in guide](../../../../../guide/features/Data.html).

@trait _methods -> ### Custom Numerical Data Default Methods

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
