package scalqa; package lang; package int; package custom; package data; import language.implicitConversions

abstract class Numerical[A<:Opaque.Int](typeName:String) extends Ordered[A](typeName):

  @fast given math: G.Math[A] = Int.math.cast[G.Math[A]]

  extension[A<:RAW](inline x: A)
    @tn("plus")     inline def +(inline v: A)              : A  = (x.real + v.real).cast[A]
    @tn("minus")    inline def -(inline v: A)              : A  = (x.real - v.real).cast[A]
    @tn("multiply") inline def *(inline v: Byte|Short|Int) : A  = (x.real * v.cast[Int]).cast[A]
    @tn("divide")   inline def /(inline v: Byte|Short|Int) : A  = (x.real / v.cast[Int]).cast[A]

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