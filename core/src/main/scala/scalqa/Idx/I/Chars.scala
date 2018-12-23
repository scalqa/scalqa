package scalqa; package Idx.I

import Custom.Array.{ Z => AZ }

class Chars private[I] (protected val base: Array[Char]) extends AnyVal with Idx.I[Char] {
  protected type TYPE = Chars
  @inline protected def make = new Chars(_)

  @inline final def apply(i: Int) = base(i)
  @inline final def size: Int = base.length
  @inline final override def all: ~[Char] = Custom.Array.Z.stream(base)

  @inline final override def copy(r: Idx.Range) = new Chars(AZ.copy.range(base, r))
  @inline final override def copyDrop(r: Idx.Range) = new Chars(AZ.copy.dropRange(base, r))

  @inline final override def +(v: Char) = new Chars(AZ.plus(base, v))
  @inline final override def +~(v: ~[Char]) = new Chars(AZ.plus.stream(base, v))
  @inline final override def +@(i: Int, v: Char) = new Chars(AZ.plus.at(base, i, v))
  @inline final override def +~@(i: Int, v: ~[Char]) = new Chars(AZ.plus.pipeAt(base, i, v))

  @inline final override def -(v: Char) = new Chars(AZ.minus(base, v))
  @inline final override def -~(v: ~[Char]) = new Chars(AZ.minus.stream(base, v))

  @inline final override def toArray(implicit t: ClassTag[Char]) = base.copyFull
}

object Chars extends Z.Primitive.Setup[Char, Chars](new Chars(_), Array.emptyCharArray)

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Chars -> `Immutable Char Array Wrap`
 *
 * @object Chars ->
 *
 *   [[Chars]] is often created from a [[Stream]]:
 *
 *   {{{
 *       ('A' <> 'Z').all.toRaw[Chars]
 *   }}}
 */
