package scalqa; package Stream; package _extend

trait _trigger[A] { self: Stream[A] =>

  def triggerEmpty(f: => Unit): ~[A]= Z.extend.trigger.triggerEmpty(this, f)

  def triggerFirst(f: Time => Unit): ~[A] = Z.extend.trigger.triggerFirst(this, f)

  def triggerLast(f: (Int, Duration) => Unit): ~[A]= Z.extend.trigger.triggerLast(this, f)

  def triggerEvery(time: Duration, f: (Int, Duration) => Unit): ~[A] = Z.extend.trigger.triggerEvery[A](this, time, f)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _trigger -> `Trigger Interface`.
 *
 *     Allows to provide status of ongoing processing
 *
 *     {{{
 *       (1 <> 5000).all
 *         .peek(_ => {
 *           // Some expensive processing
 *           App.pause(1.Millis)
 *         })
 *         .triggerFirst(t => "Started at: " + t.dayTime lp)
 *         .triggerEvery(1.Second, (i, t) => "Processed " + i + " in " + t lp)
 *         .triggerLast((i, t) => "Grand Total " + i + " in " + t lp)
 *         .drain
 *
 *         // Output
 *         Started at: 7:23:56.095
 *         Processed 962 in 1 sec
 *         Processed 1959 in 2 sec
 *         Processed 2959 in 3 sec
 *         Processed 3959 in 4 sec
 *         Processed 4960 in 5 sec
 *         Grand Total 5000 in 5.045 sec
 *     }}}
 *
 * @def triggerEmpty -> Run for empty
 *
 *     Runs the given function if pipeline is empty
 *
 *     Note: This method might not execute for some pumping methods, if they determine that pipeline is empty from the [[Stream._info]], and would not even attempt to pump elements. Please, test
 *
 * @def triggerFirst -> Runs before first
 *
 *     Runs given function when the first element pumped, but before it is passed down the pipeline
 *
 *     This will not run for empty pipeline
 *
 *     @param f  Function with current time as argument
 *
 * @def triggerLast -> Runs after last
 *
 *     Runs given function when pumping for the next element brings nothing
 *
 *     This will not run for empty pipeline
 *
 *     @param f  Function with element count and the [[Duration]] it took to pump all elements
 *
 * @def triggerEvery -> Run on timer
 *
 *     Runs given function every `time` period, while elements are being pumped
 *
 *     Note, it will not run even once if all elements pumped in less than the given `time` length
 *
 *     @param time period to run
 *     @param f function with cumulative element count and time length as arguments
 */
