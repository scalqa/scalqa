package scalqa; package lang; package any; package self; package `given`; import language.implicitConversions

trait VoidTag[A]:
  def isVoid(v: A): Boolean

object VoidTag:

  trait Booleans[A<:Any.Raw.Boolean] extends VoidTag[A]{ override def isVoid(v: A): Boolean }
  trait Bytes   [A<:Any.Raw.Byte]    extends VoidTag[A]{ override def isVoid(v: A): Boolean }
  trait Chars   [A<:Any.Raw.Char]    extends VoidTag[A]{ override def isVoid(v: A): Boolean }
  trait Shorts  [A<:Any.Raw.Short]   extends VoidTag[A]{ override def isVoid(v: A): Boolean }
  trait Ints    [A<:Any.Raw.Int]     extends VoidTag[A]{ override def isVoid(v: A): Boolean }
  trait Longs   [A<:Any.Raw.Long]    extends VoidTag[A]{ override def isVoid(v: A): Boolean }
  trait Floats  [A<:Any.Raw.Float]   extends VoidTag[A]{ override def isVoid(v: A): Boolean }
  trait Doubles [A<:Any.Raw.Double]  extends VoidTag[A]{ override def isVoid(v: A): Boolean }

  inline given givenBoolean    : Booleans[Boolean] with {  inline def isVoid(v: Boolean) = false }
  inline given givenByte       : Bytes   [Byte]    with {  inline def isVoid(v: Byte)    = false }
  inline given givenChar       : Chars   [Char]    with {  inline def isVoid(v: Char)    = false }
  inline given givenShort      : Shorts  [Short]   with {  inline def isVoid(v: Short)   = v==0  }
  inline given givenInt        : Ints    [Int]     with {  inline def isVoid(v: Int)     = v==0  }
  inline given givenLong       : Longs   [Long]    with {  inline def isVoid(v: Long)    = v==0L }
  inline given givenFloat      : Floats  [Float]   with {  inline def isVoid(v: Float)   = v==0F }
  inline given givenDouble     : Doubles [Double]  with {  inline def isVoid(v: Double)  = v==0D }
  inline given givenString     : VoidTag    [String]  with {  inline def isVoid(v: String)  = v.length==0 }
  inline given givenDefault[A] : VoidTag    [A]       = ZZ.Tag.cast[VoidTag[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
