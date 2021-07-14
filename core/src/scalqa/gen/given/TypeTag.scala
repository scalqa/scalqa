package scalqa; package gen; package `given`; import language.implicitConversions

abstract class TypeTag[A] private[scalqa]():
  private[scalqa] final def isRef   : Boolean = this.isInstanceOf[z.ReferenceTypeTag[_]]
  /**/                  def typeName: String

object TypeTag extends zTypeDefault:
  def apply[A <: Opaque](name: String): TypeTag[A] = new zOpaqueTag(name);  private class zOpaqueTag[A<:Opaque](val typeName: String) extends TypeTag[A]

  inline given givenBoolean : TypeTag[Boolean] = ZZ.BooleanTag.cast[TypeTag[Boolean]]
  inline given givenByte    : TypeTag[Byte]    = ZZ.ByteTag   .cast[TypeTag[Byte]]
  inline given givenChar    : TypeTag[Char]    = ZZ.CharTag   .cast[TypeTag[Char]]
  inline given givenShort   : TypeTag[Short]   = ZZ.ShortTag  .cast[TypeTag[Short]]
  inline given givenInt     : TypeTag[Int]     = ZZ.IntTag    .cast[TypeTag[Int]]
  inline given givenLong    : TypeTag[Long]    = ZZ.LongTag   .cast[TypeTag[Long]]
  inline given givenFloat   : TypeTag[Float]   = ZZ.FloatTag  .cast[TypeTag[Float]]
  inline given givenDouble  : TypeTag[Double]  = ZZ.DoubleTag .cast[TypeTag[Double]]
private[`given`] abstract class zTypeDefault:
  inline given givenAny[A]  : TypeTag[A]       = ZZ.RefTypeTag.cast[TypeTag[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
  @def typeName -> Type name
*/