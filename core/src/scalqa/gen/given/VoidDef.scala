package scalqa; package gen; package `given`; import language.implicitConversions

trait VoidDef[A]:
  def value_isVoid(v: A): Boolean

object VoidDef:

  trait BooleanRaw[A<:Boolean.Raw] extends VoidDef[A]{ override def value_isVoid(v: A): Boolean }
  trait ByteRaw   [A<:Byte.Raw]    extends VoidDef[A]{ override def value_isVoid(v: A): Boolean }
  trait CharRaw   [A<:Char.Raw]    extends VoidDef[A]{ override def value_isVoid(v: A): Boolean }
  trait ShortRaw  [A<:Short.Raw]   extends VoidDef[A]{ override def value_isVoid(v: A): Boolean }
  trait IntRaw    [A<:Int.Raw]     extends VoidDef[A]{ override def value_isVoid(v: A): Boolean }
  trait LongRaw   [A<:Long.Raw]    extends VoidDef[A]{ override def value_isVoid(v: A): Boolean }
  trait FloatRaw  [A<:Float.Raw]   extends VoidDef[A]{ override def value_isVoid(v: A): Boolean }
  trait DoubleRaw [A<:Double.Raw]  extends VoidDef[A]{ override def value_isVoid(v: A): Boolean }

  inline given givenBoolean    : BooleanRaw[Boolean] with {  inline def value_isVoid(v: Boolean) = false }
  inline given givenByte       : ByteRaw   [Byte]    with {  inline def value_isVoid(v: Byte)    = false }
  inline given givenChar       : CharRaw   [Char]    with {  inline def value_isVoid(v: Char)    = false }
  inline given givenShort      : ShortRaw  [Short]   with {  inline def value_isVoid(v: Short)   = v==0  }
  inline given givenInt        : IntRaw    [Int]     with {  inline def value_isVoid(v: Int)     = v==0  }
  inline given givenLong       : LongRaw   [Long]    with {  inline def value_isVoid(v: Long)    = v==0L }
  inline given givenFloat      : FloatRaw  [Float]   with {  inline def value_isVoid(v: Float)   = v==0F }
  inline given givenDouble     : DoubleRaw [Double]  with {  inline def value_isVoid(v: Double)  = v==0D }
  inline given givenString     : VoidDef   [String]  with {  inline def value_isVoid(v: String)  = v.length==0 }
  inline given givenDefault[A] : VoidDef   [A]                                                   = ZZ.Def.cast[VoidDef[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def value_isVoid -> Void check

      Returns true if provided value should be considered void

*/
