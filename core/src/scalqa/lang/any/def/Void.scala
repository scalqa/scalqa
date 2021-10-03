package scalqa; package lang; package any; package `def`; import language.implicitConversions

trait Void[A]:
  def value_isVoid(v: A): Boolean

object Void:

  trait Primitive[A <: Any.Primitive.Type] extends Void[A]

  object Primitive:
    object X:
      trait Boolean[A<:Any.Boolean] extends Primitive[A]{ override def value_isVoid(v: A): scala.Boolean }
      trait Byte   [A<:Any.Byte]    extends Primitive[A]{ override def value_isVoid(v: A): scala.Boolean }
      trait Char   [A<:Any.Char]    extends Primitive[A]{ override def value_isVoid(v: A): scala.Boolean }
      trait Short  [A<:Any.Short]   extends Primitive[A]{ override def value_isVoid(v: A): scala.Boolean }
      trait Int    [A<:Any.Int]     extends Primitive[A]{ override def value_isVoid(v: A): scala.Boolean }
      trait Long   [A<:Any.Long]    extends Primitive[A]{ override def value_isVoid(v: A): scala.Boolean }
      trait Float  [A<:Any.Float]   extends Primitive[A]{ override def value_isVoid(v: A): scala.Boolean }
      trait Double [A<:Any.Double]  extends Primitive[A]{ override def value_isVoid(v: A): scala.Boolean }

  inline given givenBoolean    : Primitive.X.Boolean[Boolean]   with {  inline def value_isVoid(v: Boolean)   = false }
  inline given givenByte       : Primitive.X.Byte   [Byte]      with {  inline def value_isVoid(v: Byte)      = false }
  inline given givenChar       : Primitive.X.Char   [Char]      with {  inline def value_isVoid(v: Char)      = false }
  inline given givenShort      : Primitive.X.Short  [Short]     with {  inline def value_isVoid(v: Short)     = v==0  }
  inline given givenInt        : Primitive.X.Int    [Int]       with {  inline def value_isVoid(v: Int)       = v==0  }
  inline given givenLong       : Primitive.X.Long   [Long]      with {  inline def value_isVoid(v: Long)      = v==0L }
  inline given givenFloat      : Primitive.X.Float  [Float]     with {  inline def value_isVoid(v: Float)     = v==0F }
  inline given givenDouble     : Primitive.X.Double [Double]    with {  inline def value_isVoid(v: Double)    = v==0D }
  inline given givenString     : Void               [String]    with {  inline def value_isVoid(v: String)    = v.length==0 }
  inline given givenList[A]    : Void               [List[A]]   with {  inline def value_isVoid(v: List[A])   = v eq Nil }
  inline given givenOption[A]  : Void               [Option[A]] with {  inline def value_isVoid(v: Option[A]) = v eq None }
  inline given givenDefault[A] : Void               [A]                                                       = ZZ.Any()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object X -> ### Implemented Type Extentions

@def value_isVoid -> Void check

      Returns true if provided value should be considered void



*/
