package scalqa; package Pipe; package _extend

trait _trigger[A] extends Flow._extend._trigger[A] with __[A] {

  override def trigger(f: => Any): Pipe[A] = new Z.process.trigger[A](This, f)

  def triggerEmpty(f: => Any): Pipe[A] = new Z.process.on.empty(This, f)

  def triggerFirst(f: Time => Any): Pipe[A] = new Z.process.on.beforeFirst(This, f)

  def triggerLast(f: (Int, Time.Length) => Any): Pipe[A] = new Z.process.on.afterLast(This, f)

  def triggerEvery(time: Time.Length, f: (Int, Time.Length) => Any): Pipe[A] = new Z.process.on.every[A](This, time, f)

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
 *     Allows to provide status of ongoing processing
 *
 *     @example
 *     {{{
 *       (1 <> 5000).all
 *         .peek(element => {
 *           Pause(1.Millis) // Some expensive processing
 *         })
 *         .triggerFirst(t => Print.ls("Started at:", t.dayTime))
 *         .triggerEvery(1.Second, (i, t) => Print.ls("Processed", i, "in", t))
 *         .triggerLast((i, t) => Print.ls("Grand Total", i, "in", t))
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
 *     Note: This method might not execute for some pumping methods, if they determine that pipeline is empty from the [[Metadata]], and would not even attempt to pump elements. Please, test
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
 *     @param f  Function with element count and the [[Time.Length]] it took to pump all elements
 *
 * @def triggerEvery -> Run on timer
 *
 *     Runs given function every ''time'' period, while elements are being pumped
 *
 *     Note, it will not run even once if all elements pumped in less than the given ''time'' length
 *
 *     @param time period to run
 *     @param f function with cumulative element count and time length as arguments
 */
