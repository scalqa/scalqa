package scalqa; package Pipe; package Flow; package _extend

trait _trigger[A] extends __[A] {

  def trigger(f: => Any): Flow[A] = This.peek(_ => f)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _trigger -> '''Trigger Interface'''.
 *
 *
 * @def trigger -> Valueless element access
 *
 *   The given function is executed for each element passing the pipeline
 *
 *   The function itself does not take elements as parameters
 *
 *   ''trigger'' is a valueless ''peek''
 *
 *   {{{
 *     (1 <> 1000).all
 *        .trigger(Pause(1.Millis)) // Pauses 1000 times
 *        .countAndTime.lp
 *
 *     // Output
 *     (1000,1.002 sec)
 *   }}}
 */
