package scalqa; package `def`; package any; package self; package info; package tag; import language.implicitConversions

abstract class Type[A] private[`def`]():
  final def isRef : Boolean = this.isInstanceOf[z.ReferenceType[_]]
  /**/  def name  : String

object Type extends zTypeDefault:
  def apply[A <: Opaque](name: String): Type[A] = new zOpaqueTag(name);  private class  zOpaqueTag[A<:Opaque](val name: String) extends Type[A]

  inline given xxBoolean : Type[Boolean] = ZZ.BooleanTag.cast[Type[Boolean]]
  inline given xxByte    : Type[Byte]    = ZZ.ByteTag   .cast[Type[Byte]]
  inline given xxChar    : Type[Char]    = ZZ.CharTag   .cast[Type[Char]]
  inline given xxShort   : Type[Short]   = ZZ.ShortTag  .cast[Type[Short]]
  inline given xxInt     : Type[Int]     = ZZ.IntTag    .cast[Type[Int]]
  inline given xxLong    : Type[Long]    = ZZ.LongTag   .cast[Type[Long]]
  inline given xxFloat   : Type[Float]   = ZZ.FloatTag  .cast[Type[Float]]
  inline given xxDouble  : Type[Double]  = ZZ.DoubleTag .cast[Type[Double]]
private[tag] abstract class zTypeDefault:
  inline given xxAny[A]  : Type[A]       = ZZ.RefType.cast[Type[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
  @def name -> Type name

      Returns type name

*/