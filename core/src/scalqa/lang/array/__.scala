package scalqa; package lang; import language.implicitConversions

object Array:
//  type AnyType[A] = Array[A] | Array[A & Boolean.Raw] | Array[A & Byte.Raw] | Array[A & Char.Raw]  | Array[A & Short.Raw]   // Aparently this is harder for compiler,
//                             | Array[A & Int.Raw]     | Array[A & Long.Raw] | Array[A & Float.Raw] | Array[A & Double.Raw]  // version 3.0.2.RC1 failed to process
  type AnyType[A] = Array[A]
                  | Array[A & Boolean] | Array[A & Boolean.Opaque]
                  | Array[A & Byte]    | Array[A & Byte.Opaque]
                  | Array[A & Char]    | Array[A & Char.Opaque]
                  | Array[A & Short]   | Array[A & Short.Opaque]
                  | Array[A & Int]     | Array[A & Int.Opaque]
                  | Array[A & Long]    | Array[A & Long.Opaque]
                  | Array[A & Float]   | Array[A & Float.Opaque]
                  | Array[A & Double]  | Array[A & Double.Opaque]

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