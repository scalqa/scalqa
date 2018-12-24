package scalqa; package Idx.I

import Custom.Array.{ Z => AZ }

class Chars private[I] (protected val base: Array[Char]) extends AnyVal with Idx.I[Char] {
  protected type TYPE = Chars
  def make = new Chars(_)

  def apply(i: Int) = base(i)
  def size: Int = base.length
  override def all: ~[Char] = Custom.Array.Z.stream(base)

  override def copy(r: Idx.Range) = new Chars(AZ.copy.range(base, r))
  override def copyDrop(r: Idx.Range) = new Chars(AZ.copy.dropRange(base, r))

  override def +(v: Char) = new Chars(AZ.plus(base, v))
  override def +~(v: ~[Char]) = new Chars(AZ.plus.stream(base, v))
  override def +@(i: Int, v: Char) = new Chars(AZ.plus.at(base, i, v))
  override def +~@(i: Int, v: ~[Char]) = new Chars(AZ.plus.pipeAt(base, i, v))

  override def -(v: Char) = new Chars(AZ.minus(base, v))
  override def -~(v: ~[Char]) = new Chars(AZ.minus.stream(base, v))

  override def toArray(implicit t: ClassTag[Char]) = base.copyFull
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
