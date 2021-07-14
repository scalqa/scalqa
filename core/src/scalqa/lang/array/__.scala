package scalqa; package lang; import language.implicitConversions

import any.Raw

object Array:
  //  type AnyType[A] = Array[A] | Array[A & Raw.Boolean] | Array[A & Raw.Byte] | Array[A & Raw.Char]  | Array[A & Raw.Short]   // Aparently this is harder for compiler
  //                             | Array[A & Raw.Int]     | Array[A & Raw.Long] | Array[A & Raw.Float] | Array[A & Raw.Double]  // version 3.0.2.RC1 failed to process
  type AnyType[A] = Array[A]
                  | Array[A & Boolean] | Array[A & Opaque.Boolean]
                  | Array[A & Byte]    | Array[A & Opaque.Byte]
                  | Array[A & Char]    | Array[A & Opaque.Char]
                  | Array[A & Short]   | Array[A & Opaque.Short]
                  | Array[A & Int]     | Array[A & Opaque.Int]
                  | Array[A & Long]    | Array[A & Opaque.Long]
                  | Array[A & Float]   | Array[A & Opaque.Float]
                  | Array[A & Double]  | Array[A & Opaque.Double]

  inline def apply(inline x: Boolean, inline xs: Boolean*)        : Array[Boolean] = scala.Array(x,xs *)
  inline def apply(inline x: Byte,    inline xs: Byte*)           : Array[Byte]    = scala.Array(x,xs *)
  inline def apply(inline x: Char,    inline xs: Char*)           : Array[Char]    = scala.Array(x,xs *)
  inline def apply(inline x: Short,   inline xs: Short*)          : Array[Short]   = scala.Array(x,xs *)
  inline def apply(inline x: Int,     inline xs: Int*)            : Array[Int]     = scala.Array(x,xs *)
  inline def apply(inline x: Long,    inline xs: Long*)           : Array[Long]    = scala.Array(x,xs *)
  inline def apply(inline x: Float,   inline xs: Float*)          : Array[Float]   = scala.Array(x,xs *)
  inline def apply(inline x: Double,  inline xs: Double*)         : Array[Double]  = scala.Array(x,xs *)
  inline def apply[A](inline xs: A*)(using inline t: ClassTag[A]) : Array[A]       = scala.Array(xs *)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type _methods = array._methods

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Array -> ### Companion Object for scala.Array


*/