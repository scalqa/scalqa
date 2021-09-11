package scalqa; package lang; package any; package z; package _methods; import language.implicitConversions

transparent trait xtra:
  self =>

  extension(inline x: Any.Boolean)   inline def real: Boolean          = x.cast[Boolean]
  extension(inline x: Any.Byte)      inline def real: Byte             = x.cast[Byte]
  extension(inline x: Any.Char)      inline def real: Char             = x.cast[Char]
  extension(inline x: Any.Short)     inline def real: Short            = x.cast[Short]
  extension(inline x: Any.Int)       inline def real: Int              = x.cast[Int]
  extension(inline x: Any.Long)      inline def real: Long             = x.cast[Long]
  extension(inline x: Any.Float)     inline def real: Float            = x.cast[Float]
  extension(inline x: Any.Double)    inline def real: Double           = x.cast[Double]
  extension(inline x: String.Opaque) inline def real: java.lang.String = x.cast[java.lang.String]

  // ----------------------------------------------------------------------------------------------------------------
  // The `val` methods are not a public API, but they are inlined and must be public.  Here is the best place to put them
  extension[A             ](inline x:       Val.Opt[A]) inline def `val` : A  = {val v=x.cast[A]; v}
  extension[A<:AnyRef     ](inline x:       Val.Opt[A]) @tn("refVal") inline def `val` : A  = {val v=x.cast[A]; v}
  extension[A<:Any.Boolean](inline x: Boolean.G.Opt[A]) inline def `val` : A  = {val v=(x.real == Boolean.G.Opt.TRUE.real).cast[A]; v}
  extension[A<:Any.Byte   ](inline x: Byte   .G.Opt[A]) inline def `val` : A  = {val v=x.cast[A]; v}
  extension[A<:Any.Char   ](inline x: Char   .G.Opt[A]) inline def `val` : A  = {val v=x.cast[A]; v}
  extension[A<:Any.Short  ](inline x: Short  .G.Opt[A]) inline def `val` : A  = {val v=x.cast[A]; v}
  extension[A<:Any.Int    ](inline x: Int    .G.Opt[A]) inline def `val` : A  = {val v=x.cast[A]; v}
  extension[A<:Any.Long   ](inline x: Long   .G.Opt[A]) inline def `val` : A  = {val v=x.cast[A]; v}
  extension[A<:Any.Float  ](inline x: Float  .G.Opt[A]) inline def `val` : A  = {val v=x.cast[A]; v}
  extension[A<:Any.Double ](inline x: Double .G.Opt[A]) inline def `val` : A  = {val v=x.cast[A]; v}

  // Problem ----------------------------------------------------------------------------------------------------------
  extension[A](inline x: Result.Problem)@tn("problemResult") inline def ?? : Result[A] = x.cast[Result[A]] // This has to be duplicated in global library, though publicaly defined in Problem

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/