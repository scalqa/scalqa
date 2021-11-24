package scalqa; package lang; package any; package `def`; import language.implicitConversions

abstract class TypeName[A] private[scalqa]():
  def typeName: String

object TypeName extends z_TypeNameDefault:
  def apply[A <: Any.Opaque](name: String): TypeName[A] = new z_OpaqueTag(name);  private class z_OpaqueTag[A](val typeName: String) extends TypeName[A]

  inline given givenBoolean : TypeName[Boolean] = ZZ.BooleanName.cast[TypeName[Boolean]]
  inline given givenByte    : TypeName[Byte]    = ZZ.ByteName   .cast[TypeName[Byte]]
  inline given givenChar    : TypeName[Char]    = ZZ.CharName   .cast[TypeName[Char]]
  inline given givenShort   : TypeName[Short]   = ZZ.ShortName  .cast[TypeName[Short]]
  inline given givenInt     : TypeName[Int]     = ZZ.IntName    .cast[TypeName[Int]]
  inline given givenLong    : TypeName[Long]    = ZZ.LongName   .cast[TypeName[Long]]
  inline given givenFloat   : TypeName[Float]   = ZZ.FloatName  .cast[TypeName[Float]]
  inline given givenDouble  : TypeName[Double]  = ZZ.DoubleName .cast[TypeName[Double]]

private[any] abstract class z_TypeNameDefault:
  inline given givenAny[A]  : TypeName[A]       = ZZ.RefName.cast[TypeName[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
