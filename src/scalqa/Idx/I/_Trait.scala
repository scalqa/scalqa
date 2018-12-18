package scalqa; package Idx.I

trait _Trait[@specialized(DATA) A] extends Any with Custom.Array.View[A] with Idx[A] {
  protected type THIS <: _Trait[A]

  override def contains(v: A): Boolean = Custom.Array.Z.contains(base, v)

  def toArray(implicit t: ClassTag[A]) = { val a = new Array[A](size); System.arraycopy(base, 0, a, 0, size); a }

  def toPrimitive[TRGT](implicit c: Z.PrimitiveConverter[A, TRGT]): TRGT = c.make(this)
}

private object _Trait {

  implicit def zzVoid[A](v: \/)(implicit i: Ilk[A]): Idx.I[A] = i.mkValueVoid[A]

  implicit val Bytes = new Base(new Bytes(_))
  implicit val Chars = new Base(new Chars(_))
  implicit val Shorts = new Base(new Shorts(_))
  implicit val Ints = new Base(new Ints(_))
  implicit val Longs = new Base(new Longs(_))
  implicit val Floats = new Base(new Floats(_))
  implicit val Doubles = new Base(new Doubles(_))
  implicit val Booleans = new Base(new Booleans(_))
  // ***********************************************************************************************
  class Base[A, TRGT](create: Array[A] => TRGT)(implicit i: Ilk[A]) extends Z.PrimitiveConverter[A, TRGT] {

    @inline def make = v => create(if (v.base.getClass == i.ArrayClass) v.base else i.mkArray[A](v.size).I(_.updateAll(v.base)))
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> `Immutable Trait`
 *
 * @def toPrimitive -> To Primitive Immutable
 *
 *     Converts this Immutable to primitive Immutable
 *
 *     Supported primitive Values are:
 *
 *     -  [[Booleans]] for Boolean types
 *     -  [[Bytes]] for Byte types
 *     -  [[Chars]] for Char types
 *     -  [[Shorts]] for Short types
 *     -  [[Ints]] for Int types
 *     -  [[Longs]] for Long types
 *     -  [[Floats]] for Float types
 *     -  [[Doubles]] for Double types
 *
 *     {{{
 *         val r : Refs[Int] = (1 <> 10).all.to[Refs]
 *
 *         val i : Ints = r.toPrimitive[Ints]
 *     }}}
 */
