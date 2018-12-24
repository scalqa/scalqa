package scalqa; package Idx.I

import Custom.Array.{ Z => AZ }

class Ints private[I] (protected val base: Array[Int]) extends AnyVal with Idx.I[Int] {
  protected type TYPE = Ints
  def make = new Ints(_)

  def apply(i: Int) = base(i)
  def size: Int = base.length
  override def all: ~[Int] = Custom.Array.Z.stream(base)

  override def copy(r: Idx.Range) = new Ints(AZ.copy.range(base, r))
  override def copyDrop(r: Idx.Range) = new Ints(AZ.copy.dropRange(base, r))

  override def +(v: Int) = new Ints(AZ.plus(base, v))
  override def +~(v: ~[Int]) = new Ints(AZ.plus.stream(base, v))
  override def +@(i: Int, v: Int) = new Ints(AZ.plus.at(base, i, v))
  override def +~@(i: Int, v: ~[Int]) = new Ints(AZ.plus.pipeAt(base, i, v))

  override def -(v: Int) = new Ints(AZ.minus(base, v))
  override def -~(v: ~[Int]) = new Ints(AZ.minus.stream(base, v))

  override def toArray(implicit t: ClassTag[Int]) = base.copyFull
}

object Ints extends Z.Primitive.Setup[Int, Ints](new Ints(_), Array.emptyIntArray) {

  def make(r: Idx.Range): Ints = new Ints(r.toArray)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Ints -> `Immutable Int Array Wrap`
 *
 * There is [[Ints]] alias at Scalqa root, so this class can be universally used without prefix
 *
 * @object Ints ->
 *
 *   [[Ints]] is often created from a [[Stream]]:
 *
 *   {{{
 *       (1 ~+ 2 + 3).toRaw[Ints]
 *   }}}
 */
