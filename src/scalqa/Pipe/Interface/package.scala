package scalqa; package Pipe

import scala.language.higherKinds

package object Interface extends Z.Create {
  private[scalqa] val This = this

  def apply[A]: Pipe[A] = The.Void

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Interface ->
 *
 *    There are many ways to create [[Pipe.Interface]] besides ''get'' constructors
 *
 *     {{{
 *      val p: ~[Int] = 4 ~ 5 ~ 6 ~ 7 ~ 8   // Series of '~' operators, first on Any, then on resulting Pipe
 *      p lp                                // Prints: ~(4, 5, 6, 7, 8)
 *
 *      val d = ~[Double] ~ 12 ~ 10L ~ 1D   // Pipe with forced Double type
 *      d lp                                // Prints: ~(12.0, 10.0, 1.0)
 *
 *      val r: ~[Int] = 10 <> 12            // From Range, which can be implicitly converted to Pipe.Interface
 *      r lp                                // Prints: ~(10, 11, 12)
 *
 *      val v1 = ~[Int]                     // Create void pipe with explicit type
 *      v1 lp                               // Prints: void
 *
 *      val v2: ~[Int] = \/                 // Create void pipe with context type
 *      v2 lp                               // Prints: void
 *    }}}
 */
