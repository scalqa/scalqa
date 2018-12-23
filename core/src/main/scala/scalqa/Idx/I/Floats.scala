package scalqa; package Idx.I

import Custom.Array.{ Z => AZ }

class Floats private[I] (protected val base: Array[Float]) extends AnyVal with Idx.I[Float] {
  protected type TYPE = Floats
  @inline protected def make = new Floats(_)

  @inline final def apply(i: Int) = base(i)
  @inline final def size: Int = base.length
  @inline final override def all: ~[Float] = Custom.Array.Z.stream(base)

  @inline final override def copy(r: Idx.Range) = new Floats(AZ.copy.range(base, r))
  @inline final override def copyDrop(r: Idx.Range) = new Floats(AZ.copy.dropRange(base, r))

  @inline final override def +(v: Float) = new Floats(AZ.plus(base, v))
  @inline final override def +~(v: ~[Float]) = new Floats(AZ.plus.stream(base, v))
  @inline final override def +@(i: Int, v: Float) = new Floats(AZ.plus.at(base, i, v))
  @inline final override def +~@(i: Int, v: ~[Float]) = new Floats(AZ.plus.pipeAt(base, i, v))

  @inline final override def -(v: Float) = new Floats(AZ.minus(base, v))
  @inline final override def -~(v: ~[Float]) = new Floats(AZ.minus.stream(base, v))

  @inline final override def toArray(implicit t: ClassTag[Float]) = base.copyFull
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
