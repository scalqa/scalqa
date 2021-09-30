package scalqa; package lang; import language.implicitConversions

object Array:

  inline def apply[A<:Any.Primitive.Type](inline v: A, inline vs: A*)(using inline A:Specialized.Primitive[A]): A.Array =
    inline A match
      case _ : Specialized.Primitive[A&Any.Boolean] => scala.Array(v.cast[Boolean],vs.cast[Seq[Boolean]]: _*).cast[A.Array]
      case _ : Specialized.Primitive[A&Any.Byte   ] => scala.Array(v.cast[Byte],   vs.cast[Seq[Byte]]   : _*).cast[A.Array]
      case _ : Specialized.Primitive[A&Any.Char   ] => scala.Array(v.cast[Char],   vs.cast[Seq[Char]]   : _*).cast[A.Array]
      case _ : Specialized.Primitive[A&Any.Short  ] => scala.Array(v.cast[Short],  vs.cast[Seq[Short]]  : _*).cast[A.Array]
      case _ : Specialized.Primitive[A&Any.Int    ] => scala.Array(v.cast[Int],    vs.cast[Seq[Int]]    : _*).cast[A.Array]
      case _ : Specialized.Primitive[A&Any.Long   ] => scala.Array(v.cast[Long],   vs.cast[Seq[Long]]   : _*).cast[A.Array]
      case _ : Specialized.Primitive[A&Any.Float  ] => scala.Array(v.cast[Float],  vs.cast[Seq[Float]]  : _*).cast[A.Array]
      case _ : Specialized.Primitive[A&Any.Double ] => scala.Array(v.cast[Double], vs.cast[Seq[Double]] : _*).cast[A.Array]
      case _                                        => J.illegalState()

  inline def apply[A](inline xs: A*)(using inline t: ClassTag[A]) : Array[A] = scala.Array(xs *)

  inline def emptyBoolean: Array[Boolean] = ZZ.emptyBooleanArray
  inline def emptyByte   : Array[Byte]    = ZZ.emptyByteArray
  inline def emptyChar   : Array[Char]    = ZZ.emptyCharArray
  inline def emptyShort  : Array[Short]   = ZZ.emptyShortArray
  inline def emptyInt    : Array[Int]     = ZZ.emptyIntArray
  inline def emptyLong   : Array[Long]    = ZZ.emptyLongArray
  inline def emptyFloat  : Array[Float]   = ZZ.emptyFloatArray
  inline def emptyDouble : Array[Double]  = ZZ.emptyDoubleArray
  inline def emptyAnyRef : Array[AnyRef]  = ZZ.emptyObjectArray

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

@def emptyBoolean -> Empty Boolean array \n\n Returns singleton scala.Array.emptyBooleanArray
@def emptyByte    -> Empty Byte array    \n\n Returns singleton scala.Array.emptyByteArray
@def emptyChar    -> Empty Char array    \n\n Returns singleton scala.Array.emptyCharArray
@def emptyShort   -> Empty Short array   \n\n Returns singleton scala.Array.emptyShortArray
@def emptyInt     -> Empty Int array     \n\n Returns singleton scala.Array.emptyIntArray
@def emptyLong    -> Empty Long array    \n\n Returns singleton scala.Array.emptyLongArray
@def emptyFloat   -> Empty Float array   \n\n Returns singleton scala.Array.emptyFloatArray
@def emptyDouble  -> Empty Double array  \n\n Returns singleton scala.Array.emptyDoubleArray
@def emptyAnyRef  -> Empty Object array  \n\n Returns singleton scala.Array.emptyObjectArray

*/