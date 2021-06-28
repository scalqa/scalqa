package scalqa; package lang; package short; package custom; package data; import language.implicitConversions

abstract class Numerical[A<:Opaque.Short](typeName:String) extends Ordered[A](typeName):

  @fast given math: G.Math[A] = Short.math.cast[G.Math[A]]

  extension[A<:RAW](inline x: A)
    @tn("plus")     inline def +(inline v: A)          : A  = (x.real + v.real).cast[A]
    @tn("minus")    inline def -(inline v: A)          : A  = (x.real - v.real).cast[A]
    @tn("multiply") inline def *(inline v: Byte|Short) : A  = (x.real * v.cast[Short]).cast[A]
    @tn("divide")   inline def /(inline v: Byte|Short) : A  = (x.real / v.cast[Short]).cast[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Numerical -> ###

  Custom Data Numerical elements cannot be treated as numbers, but they support addition, subtraction with its own kind, and multiplication and division by primitives.

  The best example of Data.Numerical type is [[scalqa.gen.time.Length Time.Length]]:

  ```
  var tl : Time.Length = 1.Hour - 10.Minutes + 20.Seconds

  tl.tp          // Prints: 50 mins 20 secs

  (tl / 5).tp    // Prints: 10 mins 4 secs

  (tl * 5).tp    // Prints: 4 hours 11 mins 40 secs

  ```
  Stream operation "sum" is also valid for Data.Numerical

@def abs         -> Absolute value   \n\n  Returns non negative value
@def *           -> Multiply         \n\n  Returns the product of this and given value
@def /           -> Divide           \n\n  Returns the quotient of this and given value
@def +           -> Plus             \n\n  Returns the sum of this and given value
@def -           -> Minus            \n\n  Returns difference of this and given value

*/