package scalqa; package Stream; package Flow; package _extend

trait _flow[A] { self: Flow[A] =>

  def sequential: Stream[A] = Stream.Z.extend.flow.sequential(this)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _flow -> `Flow Control`
 *
 *
 * @def sequential -> Restore [[Flow]] to [[Stream]]
 *
 *     Restores potentially parallel [[Flow]] back to [[Stream]]
 *
 *     If this object is already a Stream, the operation is instant
 *
 *     Otherwise the operation is quite expensive
 *
 *     In many cases it is advisable to consume pipeline as [[Flow]] instead of converting to [[Stream]]
 *
 *     {{{
 *        (1 <> 1000).all
 *           .parallel                       // Switching to parallel Stream.Flow
 *           .peek(_ => App.pause(1.Millis)) // Expensive operation
 *           .sequential                     // Back to Stream
 *           .countAndTime("Count = " + _ + "\tDone in " + _ lp)
 *
 *        // Output
 *        Count = 1000   Done in 0.186 sec
 *     }}}
 */
