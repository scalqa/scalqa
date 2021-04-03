package scalqa; package `def`; package any; package self; package info; package tag; import language.implicitConversions

trait Void[A]:
  def isVoid(v: A): Boolean

object Void:

  trait Booleans[A<:Any.Raw.Boolean] extends Void[A]{ override def isVoid(v: A): Boolean }
  trait Bytes   [A<:Any.Raw.Byte]    extends Void[A]{ override def isVoid(v: A): Boolean }
  trait Chars   [A<:Any.Raw.Char]    extends Void[A]{ override def isVoid(v: A): Boolean }
  trait Shorts  [A<:Any.Raw.Short]   extends Void[A]{ override def isVoid(v: A): Boolean }
  trait Ints    [A<:Any.Raw.Int]     extends Void[A]{ override def isVoid(v: A): Boolean }
  trait Longs   [A<:Any.Raw.Long]    extends Void[A]{ override def isVoid(v: A): Boolean }
  trait Floats  [A<:Any.Raw.Float]   extends Void[A]{ override def isVoid(v: A): Boolean }
  trait Doubles [A<:Any.Raw.Double]  extends Void[A]{ override def isVoid(v: A): Boolean }

  inline given xxBoolean    : Booleans[Boolean] with {  inline def isVoid(v: Boolean) = false }
  inline given xxByte       : Bytes   [Byte]    with {  inline def isVoid(v: Byte)    = false }
  inline given xxChar       : Chars   [Char]    with {  inline def isVoid(v: Char)    = false }
  inline given xxShort      : Shorts  [Short]   with {  inline def isVoid(v: Short)   = v==0  }
  inline given xxInt        : Ints    [Int]     with {  inline def isVoid(v: Int)     = v==0  }
  inline given xxLong       : Longs   [Long]    with {  inline def isVoid(v: Long)    = v==0L }
  inline given xxFloat      : Floats  [Float]   with {  inline def isVoid(v: Float)   = v==0F }
  inline given xxDouble     : Doubles [Double]  with {  inline def isVoid(v: Double)  = v==0D }
  inline given xxString     : Void    [String]  with {  inline def isVoid(v: String)  = v.length==0 }
  inline given xxDefault[A] : Void    [A]       = ZZ.Tag.cast[Void[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
