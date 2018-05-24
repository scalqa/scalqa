package scalqa; package Pipe; package Flow; package _extend

trait _flow[A] extends __[A] {

  def sequential: Pipe[A] = Z.flow.sequential(This)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _flow -> '''Flow Control'''
 *
 *
 * @def sequential -> Restore [[Flow]] to [[Pipe]]
 *
 *     Restores potentially parallel [[Flow]] back to [[Pipe]]
 *
 *     If this object is already a Pipe, the operation is instant
 *
 *     Otherwise the operation is quite expensive
 *
 *     In many cases it is advisable to try to utilize the pipeline through the [[Flow]] pumping methods instead of converting to [[Pipe]]
 *
 *     {{{
 *        (1 <> 1000).all
 *           .parallel                 // Switching to parallel Pipe.Flow
 *           .trigger(Pause(1.Millis)) // Expensive operation
 *           .sequential               // Back to Pipe
 *           .countAndTime
 *           .I(t => Print.ls("Count =", t._1, "\tDone in", t._2))
 *
 *        // Output
 *        Count = 1000   Done in 0.186 sec
 *     }}}
 *
 */
