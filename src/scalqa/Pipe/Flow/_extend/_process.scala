package scalqa; package Pipe; package Flow; package _extend

trait _process[A] extends __[A] {

  def peek(f: A => Any): Flow[A]

  def peekIdx(f: (Int, A) => Any, start: Int = 0): Flow[A] = { var i = start; peek(f(synchronized { i += 1; i }, _)) }

  def synchronize: Flow[A] = Z.flow.synchronize(This)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _process -> '''Process Interface'''.
 *
 *    Process methods do not change [[Flow]] type or composition.
 *
 * @def peek( -> Element access.
 *
 *    Provides access to a passing pipeline element
 *
 *    This method does not change pipeline type or composition in any way
 *
 *    {{{
 *      ('A' <> 'C').all.peek(_.lp("Passing: ")).count().lp
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
 *    Provides access to a passing pipeline elements with their index in sequence
 *
 *    @param start starting value for element indexing.
 *
 *    {{{
 *      ('A' <> 'C').all.peekIdx(Print.ls("Peek", _, "=", _)).count().lp
 *
 *      // Output
 *      Peek 0 = A
 *      Peek 1 = B
 *      Peek 2 = C
 *      3
 *    }}}
 *
 * @def synchronize -> Synchronization
 *
 *     Adds synchronized processing to the [[Flow]] elements
 *
 *     Note, ''synchronize'' is ignored for [[Pipe]], because it is sequential itself
 *
 *     If ''synchronized'', all the further parallel processing functions will compete to obtain a single lock, which could cause slowdown
 *
 *     @example
 *     {{{
 *       var counter = 0L
 *
 *       (1 <> 1000).all.parallel.synchronize.apply(counter += _)
 *
 *       counter.lp  // Prints: 500500
 *
 *       // Without synchronization 'counter' could be updated concurrently with unpredictable results
 *     }}}
 */
