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

  // Problem ----------------------------------------------------------------------------------------------------------
  extension[A](inline x: Result.Problem)@tn("problemResult") inline def ?? : Result[A] = x.cast[Result[A]] // This has to be duplicated in global library, though publicaly defined in Problem

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/