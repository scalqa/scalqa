package scalqa; package General.Tool

object Schedule {

  def every(period: Time.Precise.Length, f: => Any): Concurrent.Control = everyIn(period, period, f)

  def everyIn(period: Time.Precise.Length, initDelay: Time.Precise.Length, f: => Any): Concurrent.Control = App.Pro.DefaultScheduler().runEveryIn(period, initDelay, () => f)

  def onceIn(delay: Time.Precise.Length, job: => Any): Concurrent.Control = App.Pro.DefaultScheduler().submitIn(delay, () => job)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Schedule -> '''Default Scheduler'''
 *
 *   Globally available job scheduling tool
 *
 *   The scheduler used is [[App.Pro.DefaultScheduler]]
 *
 * @def onceIn -> Schedule one time job
 *
 *     Schedules a one time job with given delay
 *     {{{
 *        // Prints "Hello" in 3 seconds
 *         Schedule.onceIn(3.Seconds, Print("Hello"))
 *     }}}
 *
 * @def every( -> Schedule job
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
 * @def everyIn -> Schedule start of job
 *
 *     Schedules a job with given ''initDelay'', which will run every given ''period''
 *
 *     {{{
 *        // In 10 minutes, this will start printing time every 1 second for one hour
 *        Schedule.everyIn(1.Second, 10.Minutes, Time.get lp).expireIn(1.Hour)
 *     }}}
 */
