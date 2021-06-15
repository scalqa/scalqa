package scalqa; package gen; package `given`; import language.implicitConversions

abstract class NameTag[A] private[scalqa]():
  private[scalqa] final def isRef : Boolean = this.isInstanceOf[z.ReferenceNameTag[_]]
  /**/                  def name  : String

object NameTag extends zTypeDefault:
  def apply[A <: Opaque](name: String): NameTag[A] = new zOpaqueTag(name);  private class zOpaqueTag[A<:Opaque](val name: String) extends NameTag[A]

  inline given givenBoolean : NameTag[Boolean] = ZZ.BooleanTag.cast[NameTag[Boolean]]
  inline given givenByte    : NameTag[Byte]    = ZZ.ByteTag   .cast[NameTag[Byte]]
  inline given givenChar    : NameTag[Char]    = ZZ.CharTag   .cast[NameTag[Char]]
  inline given givenShort   : NameTag[Short]   = ZZ.ShortTag  .cast[NameTag[Short]]
  inline given givenInt     : NameTag[Int]     = ZZ.IntTag    .cast[NameTag[Int]]
  inline given givenLong    : NameTag[Long]    = ZZ.LongTag   .cast[NameTag[Long]]
  inline given givenFloat   : NameTag[Float]   = ZZ.FloatTag  .cast[NameTag[Float]]
  inline given givenDouble  : NameTag[Double]  = ZZ.DoubleTag .cast[NameTag[Double]]
private[`given`] abstract class zTypeDefault:
  inline given givenAny[A]  : NameTag[A]       = ZZ.RefNameTag.cast[NameTag[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
  @def name -> NameTag

      Returns type name

*/