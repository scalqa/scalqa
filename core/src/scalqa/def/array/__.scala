package scalqa; package `def`; import language.implicitConversions

object Array:
  inline def apply(inline x: Boolean, inline xs: Boolean*)        : Array[Boolean] = scala.Array(x,xs *)
  inline def apply(inline x: Byte,    inline xs: Byte*)           : Array[Byte]    = scala.Array(x,xs *)
  inline def apply(inline x: Char,    inline xs: Char*)           : Array[Char]    = scala.Array(x,xs *)
  inline def apply(inline x: Short,   inline xs: Short*)          : Array[Short]   = scala.Array(x,xs *)
  inline def apply(inline x: Int,     inline xs: Int*)            : Array[Int]     = scala.Array(x,xs *)
  inline def apply(inline x: Long,    inline xs: Long*)           : Array[Long]    = scala.Array(x,xs *)
  inline def apply(inline x: Float,   inline xs: Float*)          : Array[Float]   = scala.Array(x,xs *)
  inline def apply(inline x: Double,  inline xs: Double*)         : Array[Double]  = scala.Array(x,xs *)
  inline def apply[A](inline xs: A*)(using inline t: ClassTag[A]) : Array[A]       = scala.Array(xs *)

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type _extension = array._extension

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Array -> ### Companion for scala.Array


*/