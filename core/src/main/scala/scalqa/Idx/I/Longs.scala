package scalqa; package Idx.I

import Custom.Array.{ Z => AZ }

class Longs private[I] (protected val base: Array[Long]) extends AnyVal with Idx.I[Long] {
  protected type TYPE = Longs
  def make = new Longs(_)

  def apply(i: Int) = base(i)
  def size: Int = base.length
  override def all: ~[Long] = Custom.Array.Z.stream(base)

  override def copy(r: Idx.Range) = new Longs(AZ.copy.range(base, r))
  override def copyDrop(r: Idx.Range) = new Longs(AZ.copy.dropRange(base, r))

  override def +(v: Long) = new Longs(AZ.plus(base, v))
  override def +~(v: ~[Long]) = new Longs(AZ.plus.stream(base, v))
  override def +@(i: Int, v: Long) = new Longs(AZ.plus.at(base, i, v))
  override def +~@(i: Int, v: ~[Long]) = new Longs(AZ.plus.pipeAt(base, i, v))

  override def -(v: Long) = new Longs(AZ.minus(base, v))
  override def -~(v: ~[Long]) = new Longs(AZ.minus.stream(base, v))

  override def toArray(implicit t: ClassTag[Long]) = base.copyFull
}

object Longs extends Z.Primitive.Setup[Long, Longs](new Longs(_), Array.emptyLongArray)

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Longs -> `Immutable Long Array Wrap`
 *
 * There is [[Longs]] alias at Scalqa root, so this class can be universally used without prefix
 *
 * @object Longs ->
 *
 *   [[Longs]] is often created from a [[Stream]]:
 *
 *   {{{
 *       (1L ~+ 2 + 3).toRaw[Longs]
 *   }}}
 */
