package scalqa; package Stream; package Flow; package _consume

trait _foreach[A] { self: Flow[A] =>

  def foreach(f: Consumer[A]): Unit

  def foreachSynchronized(c: Consumer[A]): Unit = foreach(v => synchronized { c.accept(v) })

  def drain: Unit = foreach(\/)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _foreach -> `Foreach Interface`
 *
 *   These methods always pump all elements through the pipeline
 *
 * @def foreach( -> For each
 *
 *   Applies given function for each element
 *
 *   {{{
 *     (1 <> 3).all.foreach("Element: " + _ lp)
 *
 *     // Output
 *     Element: 1
 *     Element: 2
 *     Element: 3
 *   }}}
 *
 * @def foreachSynchronized( -> Synchronized foreach
 *
 *   Calls foreach within synchronized context
 *
 * @def drain -> Discharge everything
 *
 *   Calls foreach discarding all elements
 *
 *   Even though nothing is done at this point, this method can be run for the benefit of other functions in the pipeline
 *
 *   {{{
 *     ('A' <> 'C').all.peek("Process " + _ lp).drain
 *
 *     // Output
 *     Process A
 *     Process B
 *     Process C
 *   }}}
 */
