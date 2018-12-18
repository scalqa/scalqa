package scalqa

import Util.Time.PreciseDuration

package object App {
  type Event = Event._Trait

  def pause(tl: Duration): Unit = scala.concurrent.blocking { 
    if (tl.totalMillis > 0) { val o = new Object(); o.synchronized(o.wait(tl.totalMillis.toLong)) } }

  def runEvery(period: PreciseDuration, f: => Any): App.Event = runEveryIn(period, period, f)

  def runEveryIn(period: PreciseDuration, initDelay: PreciseDuration, f: => Any): App.Event = new Event.Z.Scheduled(() => f) {
    val future = Setup.SchedularPro().scheduleAtFixedRate(this, initDelay.totalNanos.toLong, period.totalNanos.toLong, java.util.concurrent.TimeUnit.NANOSECONDS)
  }

  def runIn(delay: PreciseDuration, job: => Any): App.Event = new Event.Z.Scheduled(() => job) {
    val future = Setup.SchedularPro().schedule(this, delay.totalNanos.toLong, java.util.concurrent.TimeUnit.NANOSECONDS)
  }

  def executionContext = Setup.ExecutionContextPro()

  def exit = { "App.exit requested".lp; System.exit(0) }

  def printStack(lines: Int = \/): Unit = new Exception {
    setStackTrace(getStackTrace.drop(1))
    if (lines > 0) setStackTrace(getStackTrace.take(lines))
  }.printStackTrace

  @inline private[scalqa] def initSize: Int = Setup.InitBufferSizePro()
  @inline private[scalqa] def initSize(v: Int): Int = if (v >= 0) v else initSize

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def pause -> Pauses current execution thread
 *
 *   {{{
 *       App.pause(10.Millis) // Pauses for 10 milliseconds
 *
 *       App.pause(2.Seconds) // Pauses for 2 seconds
 *
 *       App.pause(1.Minute)  // Pauses for 1 minute
 *   }}}
 *
 * @def runIn -> Schedule one time job
 *
 *     Schedules a one time job with given delay
 *     {{{
 *        // Prints "Hello" in 3 seconds
 *         App.runIn(3.Seconds, "Hello" lp)
 *     }}}
 *
 * @def runEvery( -> Schedule job
 *
 *     Schedules a job to run every given `period`
 *
 *     {{{
 *        // Prints time every 1 second for the rest of the day
 *
 *        val day = Day.get
 *
 *        App.runEvery(1.Seconds, Time.now lp).cancelIf(day != Day.make)
 *     }}}
 *
 * @def runEveryIn -> Schedule start of job
 *
 *     Schedules a job with given `initDelay`, which will run every given `period`
 *
 *     {{{
 *        // In 10 minutes, this will start printing time every 1 second for one hour
 *        Schedule.everyIn(1.Second, 10.Minutes, Time.now lp).expireIn(1.Hour)
 *     }}}
 */
