package scalqa; package Stream; package _consume

trait _foreach[A] extends Flow._consume._foreach[A] { self: Stream[A] =>

  def foreachIdx(f: Consumer.Idx[A], start: Int = 0): Unit = Z.consume.foreach.Idx(this, f)

  override def foreachSynchronized(f: Consumer[A]): Unit = foreach(f)

  def apply(c: Consumer[A], forEmpty: => Any = \/): Unit = { if (prime) foreach(c) else forEmpty; () }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @def foreachSynchronized -> Calls foreach
 *
 *     `foreachSynchronized` is inherited from [[Stream.Flow]], which could be parallel
 *
 *     [[Stream]] is sequential by itself, so `foreachSynchronized` is same as regular `foreach`
 *
 * @def foreachIdx -> For each indexed
 *
 *   Calls foreach with counter
 *
 *   @param start starting value for the index in the `f` function
 *
 *   {{{
 *     ('A' <> 'C').all.foreachIdx("Element " + _ + " = " + _ lp, 1)
 *
 *     // Output
 *     Element 1 = A
 *     Element 2 = B
 *     Element 3 = C
 *   }}}
 *
 * @def apply( -> For each or for empty
 *
 *   Calls foreach if there are elements
 *
 *   Executes `forEmpty` otherwise
 *
 */
