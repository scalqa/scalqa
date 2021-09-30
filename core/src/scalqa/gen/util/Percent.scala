package scalqa; package gen; package util; import language.implicitConversions

import Gen.Percent

object Percent extends Double.Opaque.Data.Numerical[Percent]("Percent"):
  /**/     inline def apply(inline v: Double)           : Percent = v.toOpaque
  /**/     inline def apply(value: Double, base: Double): Percent = (if (base == 0.0) 0.0 else value * 100.0 / base).toOpaque
  /**/     inline def apply(value: Number, base: Number): Percent = apply(value.doubleValue, base.doubleValue)
  override        def value_isVoid(v: Percent)          : Boolean = v.real == 0.0
  override        def value_tag(v: Percent)             : String  = {val l = v.toLong; if(v.real==l) l.toString + "%" else v.toString + "%"}
  implicit inline def implicitRequest(v: \/)               : Percent = 0.0.toOpaque

  extension(inline x: Percent)
    /**/               inline def apply(inline nv: Int)                                            : Int    = (x.real * nv / 100.0).toInt
    /**/               inline def apply(inline nv: Long)                                           : Long   = (x.real * nv / 100.0).toLong
    /**/               inline def apply(inline nv: Float)                                          : Float  = (x.real * nv / 100.0).toFloat
    @tn("applyDouble") inline def apply(inline nv: Double)                                         : Double = (x.real * nv / 100.0)
    /**/               inline def apply[A<:Int.Opaque]   (inline nv: A)(using inline n:Math.Sum[A]): A      =  x(nv.cast[Int]).cast[A]
    /**/               inline def apply[A<:Long.Opaque]  (inline nv: A)(using inline n:Math.Sum[A]): A      =  x(nv.cast[Long]).cast[A]
    /**/               inline def apply[A<:Float.Opaque] (inline nv: A)(using inline n:Math.Sum[A]): A      =  x(nv.cast[Float]).cast[A]
    /**/               inline def apply[A<:Double.Opaque](inline nv: A)(using inline n:Math.Sum[A]): A      =  x(nv.cast[Double]).cast[A]

  object TYPE:
    opaque type DEF <: Double.Opaque = Double.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@type DEF  -> ###

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
