package scalqa; package Pipe; package Flow; package _pump

trait _foreach[A] extends __[A] {

  def apply(f: A => Any): Unit

  def applyIdx(f: (Int, A) => Any, start: Int = 0): Unit = Z.foreach.apply.idx(This, f, start)

  def foreach(f: A => Unit): Unit = Z.foreach.apply(This, f)

  def run(f: => Any): Unit = Z.foreach.apply(This, (a: A) => f)

  def drain: Unit = Z.foreach.drain(This)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _foreach -> '''Foreach Interface'''
 *
 *   These methods always pump all elements through the pipeline.
 *
 * @def apply( -> For each
 *
 *   Applies given function for each element
 *
 *   {{{
 *     def all = (1 <> 3).all
 *
 *     all.apply(Print.ls("Element:", _))
 *
 *     var sum = 0
 *     all(sum += _)   // apply is implied
 *     sum.lp("Sum=")
 *
 *     // Output
 *     Element: 1
 *     Element: 2
 *     Element: 3
 *     Sum=6
 *   }}}
 *
 * @def applyIdx -> For each indexed
 *
 *   Applies given function for each element and its sequential index
 *
 *   @param start starting value for the index in the `f` function
 *
 *   {{{
 *     ('A' <> 'C').all.applyIdx(Print.ls("Element", _, "=", _), 1)
 *
 *     // Output
 *     Element 1 = A
 *     Element 2 = B
 *     Element 3 = C
 *   }}}
 *
 * @def foreach ->  Same as ''apply''
 *
 *   Required by Scala `for` comprehensions.
 *
 * @def run ->  For each valueless
 *
 *   Applies given function for each element, even though the function itself does not take the element
 *
 *   {{{
 *     var count = 0
 *
 *     ('A' <> 'Z').all.run { count += 1 }
 *
 *     count.lp  // Prints: 26
 *   }}}
 *
 * @def drain -> Discharge everything
 *
 *   Pumps all elements through the pipeline and discards them
 *
 *   Even though nothing is done at this point, this method is run for the benefit of other functions in the pipeline
 *
 *   {{{
 *     ('A' <> 'C').all.peek(Print.ls("Process", _)).drain
 *
 *     // Output
 *     Process A
 *     Process B
 *     Process C
 *   }}}
 */
