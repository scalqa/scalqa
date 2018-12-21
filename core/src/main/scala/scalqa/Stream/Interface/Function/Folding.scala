package scalqa; package Stream; package Interface; package Function

trait Folding[@specialized(DATA) A] extends Folding.As[A, A] {

  def apply(a: A, b: A): A

}

object Folding {

  trait As[@specialized(DATA) A, @specialized(DATA) B] extends Z.RefPrim[A, B] with Z.PrimRef[A, B] {

    def apply(a: A, b: B): A

  }

  // *********************************************************************
  private[scalqa] object Z {

    trait PrimRef[@specialized(DATA) A, B] { def apply(x: A, y: B): A }

    trait RefPrim[A, @specialized(DATA) B] { def apply(x: A, y: B): A }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Folding -> `Folding[A]` &nbsp; is a specialized equivalent of &nbsp; `(A, A) => A` &nbsp; function and can be used in similar manner including syntactic sugar
 *
 * {{{
 *     def fold(f : Folding[Int,Int]): Int
 *
 *     foo(_ + _)
 * }}}
 *
 * @trait As -> `Folding.As[A,B]` &nbsp; is a specialized equivalent of &nbsp; `(A, B) => A` &nbsp; function and can be used in similar manner including syntactic sugar
 *
 * {{{
 *     def foldAs(start: Long)(f : Folding.As[Long,Int]): Long
 *
 *     foldAs(0L)(_ + _)
 * }}}
 */
