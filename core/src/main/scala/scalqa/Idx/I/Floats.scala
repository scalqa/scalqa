package scalqa; package Idx.I

import Custom.Array.{ Z => AZ }

class Floats private[I] (protected val base: Array[Float]) extends AnyVal with Idx.I[Float] {
  protected type TYPE = Floats
  def make = new Floats(_)

  def apply(i: Int) = base(i)
  def size: Int = base.length
  override def all: ~[Float] = Custom.Array.Z.stream(base)

  override def copy(r: Idx.Range) = new Floats(AZ.copy.range(base, r))
  override def copyDrop(r: Idx.Range) = new Floats(AZ.copy.dropRange(base, r))

  override def +(v: Float) = new Floats(AZ.plus(base, v))
  override def +~(v: ~[Float]) = new Floats(AZ.plus.stream(base, v))
  override def +@(i: Int, v: Float) = new Floats(AZ.plus.at(base, i, v))
  override def +~@(i: Int, v: ~[Float]) = new Floats(AZ.plus.pipeAt(base, i, v))

  override def -(v: Float) = new Floats(AZ.minus(base, v))
  override def -~(v: ~[Float]) = new Floats(AZ.minus.stream(base, v))

  override def toArray(implicit t: ClassTag[Float]) = base.copyFull
}

object Floats extends Z.Primitive.Setup[Float, Floats](new Floats(_), Array.emptyFloatArray)

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Floats -> `Immutable Float Array Wrap`
 *
 * @object Floats ->
 *
 *   [[Floats]] is often created from a [[Stream]]:
 *
 *   {{{
 *       (1.0F ~+ 2 + 3).toRaw[Floats]
 *   }}}
 */
