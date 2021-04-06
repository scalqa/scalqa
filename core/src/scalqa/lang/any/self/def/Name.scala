package scalqa; package lang; package any; package self; package `def`; import language.implicitConversions

abstract class Name[A] private[lang]():
  private[scalqa] final def isRef : Boolean = this.isInstanceOf[z.ReferenceType[_]]
  /**/                  def name  : String

object Name extends zTypeDefault:
  def apply[A <: Opaque](name: String): Name[A] = new zOpaqueDef(name);  private class zOpaqueDef[A<:Opaque](val name: String) extends Name[A]

  inline given xxBoolean : Name[Boolean] = ZZ.BooleanDef.cast[Name[Boolean]]
  inline given xxByte    : Name[Byte]    = ZZ.ByteDef   .cast[Name[Byte]]
  inline given xxChar    : Name[Char]    = ZZ.CharDef   .cast[Name[Char]]
  inline given xxShort   : Name[Short]   = ZZ.ShortDef  .cast[Name[Short]]
  inline given xxInt     : Name[Int]     = ZZ.IntDef    .cast[Name[Int]]
  inline given xxLong    : Name[Long]    = ZZ.LongDef   .cast[Name[Long]]
  inline given xxFloat   : Name[Float]   = ZZ.FloatDef  .cast[Name[Float]]
  inline given xxDouble  : Name[Double]  = ZZ.DoubleDef .cast[Name[Double]]
private[`def`] abstract class zTypeDefault:
  inline given xxAny[A]  : Name[A]       = ZZ.RefType.cast[Name[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
  @def name -> Name

      Returns type name

*/