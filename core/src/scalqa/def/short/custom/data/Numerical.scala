package scalqa; package `def`; package short; package custom; package data; import language.implicitConversions

import scala.{ Short as REAL }

abstract class Numerical[A<:Opaque.Short](typeName:String) extends Ordered[A](typeName):

  @fast given math: G.Math[A] = Short.math.cast[G.Math[A]]

  extension[A<:RAW](inline x: A)
    /**/            inline def abs        : A  = {val v=x; if(v.real >= 0) v else (-v.real).cast[A]}
    @tn("plus")     inline def +(v: A)    : A  = (x.real + v.real).cast[A]
    @tn("minus")    inline def -(v: A)    : A  = (x.real - v.real).cast[A]
    @tn("multiply") inline def *(v: REAL) : A  = (x.real * v).cast[A]
    @tn("divide")   inline def /(v: REAL) : A  = (x.real / v).cast[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Numerical -> ###

@def abs         -> Absolute value   \n\n  Returns non negative value
@def *           -> Multiply         \n\n  Returns the product of this and given value
@def /           -> Divide           \n\n  Returns the quotient of this and given value
@def +           -> Plus             \n\n  Returns the sum of this and given value
@def -           -> Minus            \n\n  Returns difference of this and given value

*/