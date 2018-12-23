package scalqa; package Idx.I

import Custom.Array.{ Z => AZ }

class Ints private[I] (protected val base: Array[Int]) extends AnyVal with Idx.I[Int] {
  protected type TYPE = Ints
  @inline protected def make = new Ints(_)

  @inline final def apply(i: Int) = base(i)
  @inline final def size: Int = base.length
  @inline final override def all: ~[Int] = Custom.Array.Z.stream(base)

  @inline final override def copy(r: Idx.Range) = new Ints(AZ.copy.range(base, r))
  @inline final override def copyDrop(r: Idx.Range) = new Ints(AZ.copy.dropRange(base, r))

  @inline final override def +(v: Int) = new Ints(AZ.plus(base, v))
  @inline final override def +~(v: ~[Int]) = new Ints(AZ.plus.stream(base, v))
  @inline final override def +@(i: Int, v: Int) = new Ints(AZ.plus.at(base, i, v))
  @inline final override def +~@(i: Int, v: ~[Int]) = new Ints(AZ.plus.pipeAt(base, i, v))

  @inline final override def -(v: Int) = new Ints(AZ.minus(base, v))
  @inline final override def -~(v: ~[Int]) = new Ints(AZ.minus.stream(base, v))

  @inline final override def toArray(implicit t: ClassTag[Int]) = base.copyFull
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
 * @object Ints ->
 *
 *   [[Ints]] is often created from a [[Stream]]:
 *
 *   {{{
 *       (1 ~+ 2 + 3).toRaw[Ints]
 *   }}}
 */
