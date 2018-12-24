package scalqa; package Idx.I

import Custom.Array.{ Z => AZ }

class Doubles private[I] (protected val base: Array[Double]) extends AnyVal with Idx.I[Double] {
  protected type TYPE = Doubles
  def make = new Doubles(_)

  def apply(i: Int) = base(i)
  def size: Int = base.length
  override def all: ~[Double] = Custom.Array.Z.stream(base)

  override def copy(r: Idx.Range) = new Doubles(AZ.copy.range(base, r))
  override def copyDrop(r: Idx.Range) = new Doubles(AZ.copy.dropRange(base, r))

  override def +(v: Double) = new Doubles(AZ.plus(base, v))
  override def +~(v: ~[Double]) = new Doubles(AZ.plus.stream(base, v))
  override def +@(i: Int, v: Double) = new Doubles(AZ.plus.at(base, i, v))
  override def +~@(i: Int, v: ~[Double]) = new Doubles(AZ.plus.pipeAt(base, i, v))

  override def -(v: Double) = new Doubles(AZ.minus(base, v))
  override def -~(v: ~[Double]) = new Doubles(AZ.minus.stream(base, v))

  override def toArray(implicit t: ClassTag[Double]) = base.copyFull
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
