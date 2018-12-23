package scalqa; package Idx.I

import Custom.Array.{ Z => AZ }

class Doubles private[I] (protected val base: Array[Double]) extends AnyVal with Idx.I[Double] {
  protected type TYPE = Doubles
  @inline protected def make = new Doubles(_)

  @inline final def apply(i: Int) = base(i)
  @inline final def size: Int = base.length
  @inline final override def all: ~[Double] = Custom.Array.Z.stream(base)

  @inline final override def copy(r: Idx.Range) = new Doubles(AZ.copy.range(base, r))
  @inline final override def copyDrop(r: Idx.Range) = new Doubles(AZ.copy.dropRange(base, r))

  @inline final override def +(v: Double) = new Doubles(AZ.plus(base, v))
  @inline final override def +~(v: ~[Double]) = new Doubles(AZ.plus.stream(base, v))
  @inline final override def +@(i: Int, v: Double) = new Doubles(AZ.plus.at(base, i, v))
  @inline final override def +~@(i: Int, v: ~[Double]) = new Doubles(AZ.plus.pipeAt(base, i, v))

  @inline final override def -(v: Double) = new Doubles(AZ.minus(base, v))
  @inline final override def -~(v: ~[Double]) = new Doubles(AZ.minus.stream(base, v))

  @inline final override def toArray(implicit t: ClassTag[Double]) = base.copyFull
}

object Doubles extends Z.Primitive.Setup[Double, Doubles](new Doubles(_), Array.emptyDoubleArray)

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Doubles -> `Immutable Double Array Wrap`
 *
 * @object Doubles ->
 *
 *   [[Doubles]] is often created from a [[Stream]]:
 *
 *   {{{
 *       (1.0 ~+ 2 + 3).toRaw[Doubles]
 *   }}}
 */
