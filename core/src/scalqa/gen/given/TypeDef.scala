package scalqa; package gen; package `given`; import language.implicitConversions

abstract class TypeDef[A] private[scalqa]():
  /**/                  def typeName: String
  private[scalqa] final def isRef   : Boolean = this.isInstanceOf[z.ReferenceTypeDef[_]]

object TypeDef extends zTypeDefDefault:
  def apply[A <: Any.Opaque](name: String): TypeDef[A] = new zOpaqueTag(name);  private class zOpaqueTag[A](val typeName: String) extends TypeDef[A]

  inline given givenBoolean : TypeDef[Boolean] = ZZ.BooleanDef.cast[TypeDef[Boolean]]
  inline given givenByte    : TypeDef[Byte]    = ZZ.ByteDef   .cast[TypeDef[Byte]]
  inline given givenChar    : TypeDef[Char]    = ZZ.CharDef   .cast[TypeDef[Char]]
  inline given givenShort   : TypeDef[Short]   = ZZ.ShortDef  .cast[TypeDef[Short]]
  inline given givenInt     : TypeDef[Int]     = ZZ.IntDef    .cast[TypeDef[Int]]
  inline given givenLong    : TypeDef[Long]    = ZZ.LongDef   .cast[TypeDef[Long]]
  inline given givenFloat   : TypeDef[Float]   = ZZ.FloatDef  .cast[TypeDef[Float]]
  inline given givenDouble  : TypeDef[Double]  = ZZ.DoubleDef .cast[TypeDef[Double]]

private[`given`] abstract class zTypeDefDefault:
  inline given givenAny[A]  : TypeDef[A]       = ZZ.RefTypeDef.cast[TypeDef[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
  @def typeName -> Type name
*/