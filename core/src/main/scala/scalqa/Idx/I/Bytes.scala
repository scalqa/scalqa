package scalqa; package Idx.I

import Custom.Array.{ Z => AZ }

class Bytes private[I] (protected val base: Array[Byte]) extends AnyVal with Idx.I[Byte] {
  protected type TYPE = Bytes
  def make = new Bytes(_)

  def apply(i: Int) = base(i)
  def size: Int = base.length
  override def all: ~[Byte] = Custom.Array.Z.stream(base)

  override def copy(r: Idx.Range) = new Bytes(AZ.copy.range(base, r))
  override def copyDrop(r: Idx.Range) = new Bytes(AZ.copy.dropRange(base, r))

  override def +(v: Byte) = new Bytes(AZ.plus(base, v))
  override def +~(v: ~[Byte]) = new Bytes(AZ.plus.stream(base, v))
  override def +@(i: Int, v: Byte) = new Bytes(AZ.plus.at(base, i, v))
  override def +~@(i: Int, v: ~[Byte]) = new Bytes(AZ.plus.pipeAt(base, i, v))

  override def -(v: Byte) = new Bytes(AZ.minus(base, v))
  override def -~(v: ~[Byte]) = new Bytes(AZ.minus.stream(base, v))

  override def toArray(implicit t: ClassTag[Byte]) = base.copyFull
}

object Bytes extends Z.Primitive.Setup[Byte, Bytes](new Bytes(_), Array.emptyByteArray)

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Bytes -> `Immutable Byte Array Wrap`
 *
 * @object Bytes ->
 *
 *   [[Bytes]] is often created from a [[Stream]]:
 *
 *   {{{
 *       (0 <> 10).all.map(_.toByte).toRaw[Bytes]
 *   }}}
 */
