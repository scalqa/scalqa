package scalqa; package Idx.I

import Custom.Array.{ Z => AZ }

class Longs private[I] (protected val base: Array[Long]) extends AnyVal with Idx.I[Long] {
  protected type TYPE = Longs
  @inline protected def make = new Longs(_)

  @inline def apply(i: Int) = base(i)
  @inline def size: Int = base.length
  @inline override def all: ~[Long] = Custom.Array.Z.stream(base)

  @inline override def copy(r: Idx.Range) = new Longs(AZ.copy.range(base, r))
  @inline override def copyDrop(r: Idx.Range) = new Longs(AZ.copy.dropRange(base, r))

  @inline override def +(v: Long) = new Longs(AZ.plus(base, v))
  @inline override def +~(v: ~[Long]) = new Longs(AZ.plus.stream(base, v))
  @inline override def +@(i: Int, v: Long) = new Longs(AZ.plus.at(base, i, v))
  @inline override def +~@(i: Int, v: ~[Long]) = new Longs(AZ.plus.pipeAt(base, i, v))

  @inline override def -(v: Long) = new Longs(AZ.minus(base, v))
  @inline override def -~(v: ~[Long]) = new Longs(AZ.minus.stream(base, v))

  @inline override def toArray(implicit t: ClassTag[Long]) = base.copyFull
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
 * @object Longs ->
 *
 *   [[Longs]] is often created from a [[Stream]]:
 *
 *   {{{
 *       (1L ~+ 2 + 3).toRaw[Longs]
 *   }}}
 */
