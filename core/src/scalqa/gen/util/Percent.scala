package scalqa; package gen; package util; import language.implicitConversions

import Gen.Percent

object Percent extends Double.Custom.Data.Number[Percent]("Percent"):
  /**/     inline def apply(inline v: Double)           : Percent = v.asOpaque[Percent]
  /**/     inline def apply(value: Double, base: Double): Percent = (if (base == 0) 0D else value * 100 / base).asOpaque[Percent]
  /**/     inline def apply(value: Number, base: Number): Percent = apply(value.doubleValue, base.doubleValue)
  override        def isVoid(v: Percent)                : Boolean = v.real == 0D
  override        def tag(v: Percent)                   : String  = {val l = v.Long; if(v.real==l) l.toString + "%" else v.toString + "%"}
  implicit inline def xxRequest(inline v: \/)           : Percent = apply(0D)

  extension(inline x: Percent)
    inline def apply(inline nv: Int)                                         : Int    = (x.real * nv / 100.0).toInt
    inline def apply(inline nv: Long)                                        : Long   = (x.real * nv / 100.0).toLong
    inline def apply(inline nv: Float)                                       : Float  = (x.real * nv / 100.0).toFloat
    inline def apply(inline nv: Double)                 (using inline v: \/) : Double = (x.real * nv / 100.0)
    inline def apply[A<:Opaque.Int]   (inline nv: A)(using inline n:Math[A]) : A      =  x(nv.cast[Int]).cast[A]
    inline def apply[A<:Opaque.Long]  (inline nv: A)(using inline n:Math[A]) : A      =  x(nv.cast[Long]).cast[A]
    inline def apply[A<:Opaque.Float] (inline nv: A)(using inline n:Math[A]) : A      =  x(nv.cast[Float]).cast[A]
    inline def apply[A<:Opaque.Double](inline nv: A)(using inline n:Math[A]) : A      =  x(nv.cast[Double]).cast[A]

  object opaque:
    opaque type `type` <: Opaque.Double = Opaque.Double

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object opaque -> ###

   [[Percent]] is an opaque Double value

   [[Percent]] can be created with method constructors on primitives

   ```
     3.Percent.TP     // Prints: 3.0%
     3.14.Percent.TP  // Prints: 3.14%
   ```

@def apply -> Create from Double

       Easier way is to use built-in constructor:
       ```
         3.14.Percent.TP  // Prints: 3.14%
       ```
@def apply -> Create from value and base \n\n Returns percent of given value relative to given base
@def apply -> Create from value and base \n\n Returns percent of given value relative to given base

@def apply -> Take percent \n\n Applies this percent to given value.
@def apply -> Take percent \n\n Applies this percent to given value.
@def apply -> Take percent \n\n Applies this percent to given value.
@def apply -> Take percent \n\n Applies this percent to given value.
@def apply -> Take percent \n\n Applies this percent to given value.
@def apply -> Take percent \n\n Applies this percent to given value.
@def apply -> Take percent \n\n Applies this percent to given value.
@def apply -> Take percent \n\n Applies this percent to given value.

*/
