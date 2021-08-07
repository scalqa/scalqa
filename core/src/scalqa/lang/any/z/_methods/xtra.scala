package scalqa; package lang; package any; package z; package _methods; import language.implicitConversions

transparent trait xtra:
  self =>

  extension(inline x: Boolean.Raw)   inline def real: Boolean          = x.cast[Boolean]
  extension(inline x: Byte.Raw)      inline def real: Byte             = x.cast[Byte]
  extension(inline x: Char.Raw)      inline def real: Char             = x.cast[Char]
  extension(inline x: Short.Raw)     inline def real: Short            = x.cast[Short]
  extension(inline x: Int.Raw)       inline def real: Int              = x.cast[Int]
  extension(inline x: Long.Raw)      inline def real: Long             = x.cast[Long]
  extension(inline x: Float.Raw)     inline def real: Float            = x.cast[Float]
  extension(inline x: Double.Raw)    inline def real: Double           = x.cast[Double]
  extension(inline x: String.Opaque) inline def real: java.lang.String = x.cast[java.lang.String]

  // ----------------------------------------------------------------------------------------------------------------
  // The `val` methods are not a public API, but they are inlined and must be public.  Here is the best place to put them
  extension[A             ](inline x:       Val.Opt[A]) inline def `val` : A  = {val v=x.cast[A]; v}
  extension[A<:Boolean.Raw](inline x: Boolean.G.Opt[A]) inline def `val` : A  = {val v=(x.real == Boolean.G.Opt.TRUE.real).cast[A]; v}
  extension[A<:Byte.Raw   ](inline x: Byte   .G.Opt[A]) inline def `val` : A  = {val v=x.cast[A]; v}
  extension[A<:Char.Raw   ](inline x: Char   .G.Opt[A]) inline def `val` : A  = {val v=x.cast[A]; v}
  extension[A<:Short.Raw  ](inline x: Short  .G.Opt[A]) inline def `val` : A  = {val v=x.cast[A]; v}
  extension[A<:Int.Raw    ](inline x: Int    .G.Opt[A]) inline def `val` : A  = {val v=x.cast[A]; v}
  extension[A<:Long.Raw   ](inline x: Long   .G.Opt[A]) inline def `val` : A  = {val v=x.cast[A]; v}
  extension[A<:Float.Raw  ](inline x: Float  .G.Opt[A]) inline def `val` : A  = {val v=x.cast[A]; v}
  extension[A<:Double.Raw ](inline x: Double .G.Opt[A]) inline def `val` : A  = {val v=x.cast[A]; v}

  // Problem ----------------------------------------------------------------------------------------------------------
  extension[A](inline x: Result.Problem)@tn("problemResult") inline def ?? : Result[A] = x.cast[Result[A]] // This has to be duplicated in global library, though publicaly defined in Problem

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/