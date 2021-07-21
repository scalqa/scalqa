package scalqa; package gen; package `given`; import language.implicitConversions

trait VoidTag[A]:
  def isVoid(v: A): Boolean

object VoidTag:

  trait RawBoolean[A<:Any.Raw.Boolean] extends VoidTag[A]{ override def isVoid(v: A): Boolean }
  trait RawByte   [A<:Any.Raw.Byte]    extends VoidTag[A]{ override def isVoid(v: A): Boolean }
  trait RawChar   [A<:Any.Raw.Char]    extends VoidTag[A]{ override def isVoid(v: A): Boolean }
  trait RawShort  [A<:Any.Raw.Short]   extends VoidTag[A]{ override def isVoid(v: A): Boolean }
  trait RawInt    [A<:Any.Raw.Int]     extends VoidTag[A]{ override def isVoid(v: A): Boolean }
  trait RawLong   [A<:Any.Raw.Long]    extends VoidTag[A]{ override def isVoid(v: A): Boolean }
  trait RawFloat  [A<:Any.Raw.Float]   extends VoidTag[A]{ override def isVoid(v: A): Boolean }
  trait RawDouble [A<:Any.Raw.Double]  extends VoidTag[A]{ override def isVoid(v: A): Boolean }

  inline given givenBoolean    : RawBoolean[Boolean] with {  inline def isVoid(v: Boolean) = false }
  inline given givenByte       : RawByte   [Byte]    with {  inline def isVoid(v: Byte)    = false }
  inline given givenChar       : RawChar   [Char]    with {  inline def isVoid(v: Char)    = false }
  inline given givenShort      : RawShort  [Short]   with {  inline def isVoid(v: Short)   = v==0  }
  inline given givenInt        : RawInt    [Int]     with {  inline def isVoid(v: Int)     = v==0  }
  inline given givenLong       : RawLong   [Long]    with {  inline def isVoid(v: Long)    = v==0L }
  inline given givenFloat      : RawFloat  [Float]   with {  inline def isVoid(v: Float)   = v==0F }
  inline given givenDouble     : RawDouble [Double]  with {  inline def isVoid(v: Double)  = v==0D }
  inline given givenString     : VoidTag   [String]  with {  inline def isVoid(v: String)  = v.length==0 }
  inline given givenDefault[A] : VoidTag   [A]                                             = ZZ.Tag.cast[VoidTag[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
