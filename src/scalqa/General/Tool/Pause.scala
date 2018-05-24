package scalqa; package General.Tool

object Pause {

  def apply(tl: Time.Length): Unit = if (tl.totalMillis > 0) { val o = new Object(); o.synchronized(o.wait(tl.totalMillis)) }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Pause ->  '''Thread Pausing Tool'''
 *
 * Globally available pause Tool.
 *
 * @def apply -> Pauses current execution thread
 *
 *  @example
 *   {{{
 *       Pause(10.Millis) // Pauses for 10 milliseconds
 *
 *       Pause(2.Seconds) // Pauses for 2 seconds
 *
 *       Pause(1.Minute)  // Pauses for 1 minute
 *   }}}
 */
