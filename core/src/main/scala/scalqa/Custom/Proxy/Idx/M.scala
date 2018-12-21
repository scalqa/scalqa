package scalqa; package Custom; package Proxy; package Idx

class M[A](protected val real: scalqa.Idx.M[A]) extends M.Like[A]

object M {

  trait Like[A] extends Idx.Like[A] with scalqa.Idx.M[A] with Any.Wrap[scalqa.Idx.M[A]] {

    override def addAt(n: Int, e: A) = real.addAt(n, e)

    override def removeAt(i: scalqa.Idx.Range) = real.removeAt(i)

    override def update(n: Int, a: A) = real.update(n, a)

    override def order(o: math.Ordering[A]) = real.order(o)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
