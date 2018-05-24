package scalqa; package Concurrent; package Scheduler

class _Class private[Scheduler] (val real: java.util.concurrent.ScheduledExecutorService) extends AnyVal {

  def submitIn(delay: Time.Precise.Length, r: () => Any): Control = new ControlBase(r) {
    val future = real.schedule(this, delay.totalNanos.toLong, java.util.concurrent.TimeUnit.NANOSECONDS)
  }

  def runEvery(period: Time.Precise.Length, r: () => Any): Control = runEveryIn(period, period, r)

  def runEveryIn(period: Time.Precise.Length, initialDelay: Time.Precise.Length, r: () => Any): Control = new ControlBase(r) {
    val future = real.scheduleAtFixedRate(this, initialDelay.totalNanos.toLong, period.totalNanos.toLong, java.util.concurrent.TimeUnit.NANOSECONDS)
  }

}

private object _Class {

  import scala.language.implicitConversions

  implicit def zzGet(e: java.util.concurrent.ScheduledExecutorService): Scheduler = get(e)

}

// *****************************************************************************
private abstract class ControlBase(f: () => Any) extends Control.The.Base with Runnable {

  protected val future: java.util.concurrent.Future[_]

  protected override def fireCancel: Unit = { if (!(future.isDone || future.isCancelled)) future.cancel(false); super.fireCancel }

  def run =
    if (_notCancelled) try f() catch {
      case t: Throwable =>
        if (t != Any.Event.CancelException) t.printStackTrace();
        cancel;
        throw Any.Event.CancelException
    }
    else throw Any.Event.CancelException
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class ->
 *
 *   The [[Concurrent.Scheduler]] is a wrapper around ''java.util.concurrent.ScheduledExecutorService''
 *
 *   @param real the wrapped Java peer
 *
 * @def submitIn -> Schedule one time job
 *
 *     Schedules a one time job with given delay
 *     {{{
 *        // Prints "Hello" in 3 seconds
 *         Schedule.onceIn(3.Seconds, Print("Hello"))
 *     }}}
 *
 * @def runEvery( -> Schedule job
 *
 *     Schedules a job to run every given ''period''
 *
 *     {{{
 *        // Prints time every 1 second for the rest of the day
 *
 *        val day = Day.get
 *
 *        Schedule.every(1.Seconds, Print.ln(Time.get)).cancelIf(day != Day.get)
 *     }}}
 *
 * @def runEveryIn -> Schedule job
 *
 *     Schedules a job with given ''initialDelay'', which will run every given ''period''
 *
 *     {{{
 *        // In 10 minutes, this will start printing time every 1 second for one hour
 *        Schedule.everyIn(1.Second, 10.Minutes, Time.get lp).expireIn(1.Hour)
 *     }}}
 */
