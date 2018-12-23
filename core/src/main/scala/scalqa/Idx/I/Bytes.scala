package scalqa; package Idx.I

import Custom.Array.{ Z => AZ }

class Bytes private[I] (protected val base: Array[Byte]) extends AnyVal with Idx.I[Byte] {
  protected type TYPE = Bytes
  @inline protected def make = new Bytes(_)

  @inline final def apply(i: Int) = base(i)
  @inline final def size: Int = base.length
  @inline final override def all: ~[Byte] = Custom.Array.Z.stream(base)

  @inline final override def copy(r: Idx.Range) = new Bytes(AZ.copy.range(base, r))
  @inline final override def copyDrop(r: Idx.Range) = new Bytes(AZ.copy.dropRange(base, r))

  @inline final override def +(v: Byte) = new Bytes(AZ.plus(base, v))
  @inline final override def +~(v: ~[Byte]) = new Bytes(AZ.plus.stream(base, v))
  @inline final override def +@(i: Int, v: Byte) = new Bytes(AZ.plus.at(base, i, v))
  @inline final override def +~@(i: Int, v: ~[Byte]) = new Bytes(AZ.plus.pipeAt(base, i, v))

  @inline final override def -(v: Byte) = new Bytes(AZ.minus(base, v))
  @inline final override def -~(v: ~[Byte]) = new Bytes(AZ.minus.stream(base, v))

  @inline final override def toArray(implicit t: ClassTag[Byte]) = base.copyFull
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
