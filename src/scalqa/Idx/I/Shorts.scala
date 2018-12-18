package scalqa; package Idx.I

import Custom.Array.{ Z => AZ }

class Shorts private[I] (protected val base: Array[Short]) extends AnyVal with Idx.I[Short] {
  protected type TYPE = Shorts
  @inline protected def make = new Shorts(_)

  @inline def apply(i: Int) = base(i)
  @inline def size: Int = base.length
  @inline def length: Int = base.length
  @inline override def all: ~[Short] = Custom.Array.Z.stream(base)

  @inline override def copy(r: Idx.Range) = new Shorts(AZ.copy.range(base, r))
  @inline override def copyDrop(r: Idx.Range) = new Shorts(AZ.copy.dropRange(base, r))

  @inline override def +(v: Short) = new Shorts(AZ.plus(base, v))
  @inline override def +~(v: ~[Short]) = new Shorts(AZ.plus.stream(base, v))
  @inline override def +@(i: Int, v: Short) = new Shorts(AZ.plus.at(base, i, v))
  @inline override def +~@(i: Int, v: ~[Short]) = new Shorts(AZ.plus.pipeAt(base, i, v))

  @inline override def -(v: Short) = new Shorts(AZ.minus(base, v))
  @inline override def -~(v: ~[Short]) = new Shorts(AZ.minus.stream(base, v))

  @inline override def toArray(implicit t: ClassTag[Short]) = base.copyFull
}

object Shorts extends Z.Primitive.Setup[Short, Shorts](new Shorts(_), Array.emptyShortArray)

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Shorts -> `Immutable Short Array Wrap`
 *
 * @object Shorts ->
 *
 *   [[Shorts]] is often created from a [[Stream]]:
 *
 *   {{{
 *       (1.toShort ~+ 2.toShort + 3.toShort).toPrimitive[Shorts]
 *   }}}
 */
