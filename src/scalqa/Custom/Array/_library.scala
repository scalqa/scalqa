package scalqa; package Custom; package Array

class _library[A] private[scalqa] (protected val base: Array[A]) extends AnyVal with Like[A] {
  protected type TYPE = Array[A]
  @inline protected def make = AS_IS

  @inline def apply(i: Int): A = base(i)
  @inline def size = base.length
  @inline def length = base.length

  @inline def Idx: Idx[A] = new scalqa.Idx.Array(base)

  @inline override def copy(r: scalqa.Idx.Range) = Z.copy.range(base, r)
  @inline override def copyDrop(r: scalqa.Idx.Range) = Z.copy.dropRange(base, r)

  @inline override def +(v: A) = Z.plus(base, v)
  @inline override def +~(v: ~[A]) = Z.plus.stream(base, v)
  @inline override def +@(i: Int, v: A) = Z.plus.at(base, i, v)
  @inline override def +~@(i: Int, v: ~[A]) = Z.plus.pipeAt(base, i, v)
  @inline override def -(v: A) = Z.minus(base, v)
  @inline override def -~(v: ~[A]) = Z.minus.stream(base, v)

  @inline override def copyResize(newSize: Int) = Z.copy.resize(base, newSize)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
