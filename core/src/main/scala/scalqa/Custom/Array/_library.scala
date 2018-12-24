package scalqa; package Custom; package Array

class _library[A] private[scalqa] (protected val base: Array[A]) extends AnyVal with Like[A] {
  protected type TYPE = Array[A]
  def make = AS_IS

  def apply(i: Int): A = base(i)
  def size = base.length

  def Idx: scalqa.Idx.Array[A] = new scalqa.Idx.Array(base)

  override def copy(r: scalqa.Idx.Range) = Z.copy.range(base, r)
  override def copyDrop(r: scalqa.Idx.Range) = Z.copy.dropRange(base, r)

  override def +(v: A) = Z.plus(base, v)
  override def +~(v: ~[A]) = Z.plus.stream(base, v)
  override def +@(i: Int, v: A) = Z.plus.at(base, i, v)
  override def +~@(i: Int, v: ~[A]) = Z.plus.pipeAt(base, i, v)
  override def -(v: A) = Z.minus(base, v)
  override def -~(v: ~[A]) = Z.minus.stream(base, v)

  override def copyResize(newSize: Int) = Z.copy.resize(base, newSize)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
