package scalqa; package lang; package any; package z; package extension; import language.implicitConversions

transparent private[z] trait extra :
  self =>

  // ----------------------------------------------------------------------------------------------------------------
  // These `real` methods are primarily for primitive types, to make them same as opaque primitives, which support 'real'
  extension(inline x: Raw.Boolean) inline def real: Boolean = x.cast[Boolean]
  extension(inline x: Raw.Byte   ) inline def real: Byte    = x.cast[Byte]
  extension(inline x: Raw.Char   ) inline def real: Char    = x.cast[Char]
  extension(inline x: Raw.Short  ) inline def real: Short   = x.cast[Short]
  extension(inline x: Raw.Int    ) inline def real: Int     = x.cast[Int]
  extension(inline x: Raw.Long   ) inline def real: Long    = x.cast[Long]
  extension(inline x: Raw.Float  ) inline def real: Float   = x.cast[Float]
  extension(inline x: Raw.Double ) inline def real: Double  = x.cast[Double]
  extension(inline x: String | Opaque.String) inline def real: String  = x.cast[String]

  // ----------------------------------------------------------------------------------------------------------------
  // The `val` methods are inlined and must be public, here is the best place to put them
  extension[A             ](inline x:       Val.Opt[A]) inline def `val` : A                = {val v=x.cast[A]; v}
  extension[A<:Raw.Boolean](inline x: Boolean.G.Opt[A]) inline def `val` : A                = {val v=(x.real== Boolean.G.Opt.TRUE.real).cast[A]; v}
  extension[A<:Raw.Byte   ](inline x: Byte   .G.Opt[A]) inline def `val` : A                = {val v=x.cast[A]; v}
  extension[A<:Raw.Char   ](inline x: Char   .G.Opt[A]) inline def `val` : A                = {val v=x.cast[A]; v}
  extension[A<:Raw.Short  ](inline x: Short  .G.Opt[A]) inline def `val` : A                = {val v=x.cast[A]; v}
  extension[A<:Raw.Int    ](inline x: Int    .G.Opt[A]) inline def `val` : A                = {val v=x.cast[A]; v}
  extension[A<:Raw.Long   ](inline x: Long   .G.Opt[A]) inline def `val` : A                = {val v=x.cast[A]; v}
  extension[A<:Raw.Float  ](inline x: Float  .G.Opt[A]) inline def `val` : A                = {val v=x.cast[A]; v}
  extension[A<:Raw.Double ](inline x: Double .G.Opt[A]) inline def `val` : A                = {val v=x.cast[A]; v}

  // Problem ----------------------------------------------------------------------------------------------------------
  extension[A](inline x: Result.Problem)@tn("problemResult") inline def ?? : Result[A] = x.cast[Result[A]]

  // Opaque ----------------------------------------------------------------------------------------------------------
  extension[A](inline x: A) inline def asOpaque[B<:Opaque]: B = x.cast[B]


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/