package scalqa; package Stream; package Flow; package _extend

trait _peek[A] { self: Flow[A] =>

  def peek(c: Consumer[A]): Flow[A]

  def peekIdx(c: Consumer.Idx[A], start: Int = 0): Flow[A] = { var i = start; peek(v => synchronized { c.accept(i, v); i += 1 }) }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _peek -> `Inspection Interface`.
 *
 *    'peek' methods do not change [[Flow]] type or composition.
 *
 * @def peek( -> Element access
 *
 *    Provides access to passing pipeline elements
 *
 *    This method does not change pipeline type or composition in any way
 *
 *    {{{
 *      ('A' <> 'C').all.peek("Passing: " + _ lp).count.lp
 *
 *      // Output
 *      Passing: A
 *      Passing: B
 *      Passing: C
 *      3
 *    }}}
 *
 * @def peekIdx -> Indexed element access
 *
 *    Provides access to passing pipeline elements with their index in sequence
 *
 *    @param start starting value for element indexing
 *
 *    {{{
 *      ('A' <> 'C').all.peekIdx("Peek" + _ + " = " + _ lp).count.lp
 *
 *      // Output
 *      Peek 0 = A
 *      Peek 1 = B
 *      Peek 2 = C
 *      3
 *    }}}
 *
 */
