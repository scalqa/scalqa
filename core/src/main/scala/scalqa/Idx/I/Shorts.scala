package scalqa; package Idx.I

import Custom.Array.{ Z => AZ }

class Shorts private[I] (protected val base: Array[Short]) extends AnyVal with Idx.I[Short] {
  protected type TYPE = Shorts
  def make = new Shorts(_)

  def apply(i: Int) = base(i)
  def size: Int = base.length
  override def all: ~[Short] = Custom.Array.Z.stream(base)

  override def copy(r: Idx.Range) = new Shorts(AZ.copy.range(base, r))
  override def copyDrop(r: Idx.Range) = new Shorts(AZ.copy.dropRange(base, r))

  override def +(v: Short) = new Shorts(AZ.plus(base, v))
  override def +~(v: ~[Short]) = new Shorts(AZ.plus.stream(base, v))
  override def +@(i: Int, v: Short) = new Shorts(AZ.plus.at(base, i, v))
  override def +~@(i: Int, v: ~[Short]) = new Shorts(AZ.plus.pipeAt(base, i, v))

  override def -(v: Short) = new Shorts(AZ.minus(base, v))
  override def -~(v: ~[Short]) = new Shorts(AZ.minus.stream(base, v))

  override def toArray(implicit t: ClassTag[Short]) = base.copyFull
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
 * There is [[Shorts]] alias at Scalqa root, so this class can be universally used without prefix
 *
 * @object Shorts ->
 *
 *   [[Shorts]] is often created from a [[Stream]]:
 *
 *   {{{
 *       (1.toShort ~+ 2.toShort + 3.toShort).toRaw[Shorts]
 *   }}}
 */
