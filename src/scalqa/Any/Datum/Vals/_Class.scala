package scalqa; package Any; package Datum.Vals

final class _Class[A] private[Vals] (a: Array[_], val setup: Any.Datum.Setup[A]) extends scalqa.Idx[A] with Custom.Array.View[A] with Like[A] {
  protected type TYPE = Vals[A]
  protected def make = new Vals(_, setup)

  protected val real = a.asInstanceOf[Array[setup.VALUE]]

  protected def base = real.asInstanceOf[Array[A]]

  @inline def apply(i: Int) = setup.Map(real(i))
  @inline def size: Int = real.length
  @inline def length: Int = real.length

  def allReal = real.all

  override def copy(r: scalqa.Idx.Range) = new Vals[A](Custom.Array.Z.copy.range(real, r), setup)
  override def copyDrop(r: scalqa.Idx.Range) = new Vals[A](Custom.Array.Z.copy.dropRange(real, r), setup)

  override def +(v: A) = new Vals[A](Custom.Array.Z.plus(real, setup.Map.undo(v)), setup)
  override def +~(v: ~[A]) = new Vals[A](Custom.Array.Z.plus.stream(real, v.map(setup.Map.undo)), setup)
  override def +@(i: Int, v: A) = new Vals[A](Custom.Array.Z.plus.at(real, i, setup.Map.undo(v)), setup)
  override def +~@(i: Int, v: ~[A]) = new Vals[A](Custom.Array.Z.plus.pipeAt(real, i, v.map(setup.Map.undo)), setup)
  override def -(v: A) = new Vals[A](Custom.Array.Z.minus(real, setup.Map.undo(v)), setup)
  override def -~(v: ~[A]) = new Vals[A](Custom.Array.Z.minus.stream(real, v.map(setup.Map.undo)), setup)
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class -> `Vals` is an immutable array backed collection of [[Any.Datum]]
 *
 *    Any defined [[Datum]] elements, when put into a generic collection, are wrapped as Objects and take significant resources
 *
 *    [[Vals]] strips Object boxing and only stores values
 *
 *   {{{
 *     val vector: Vector[Percent] = (1 <> 1000000).all.map(_.Percent).all.to[Vector]
 *
 *     // vector stores 1,000,000 objects Percent
 *
 *
 *     val values: Vals[Percent] = (1 <> 1000000).all.map(_.Percent).toVals
 *
 *     // values stores a single Array[Double] object, holding 1,000,000 primitive values
 *   }}}
 */
