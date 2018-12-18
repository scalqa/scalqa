package scalqa; package Util

package object Time {
  private[scalqa] def This = this
  type Like[TYPE] = Like._Trait[TYPE]

  val Ordering = _Class.Ordering

  def now: Time = fromMillis(System.currentTimeMillis)

  def fromMillis(m: Long): Time = new Time(m)

  def make(i: java.time.Instant): Time = fromMillis(i.getEpochSecond * 1000 + i.getNano / Util.OneMillion)

  def make(d: Day, dt: DayTime): Time = d.start + dt.totalMillis

  def make(day: Day, plus: Duration*): Time = fromMillis(Duration.sum(day.start.totalMillis, plus: _*).real)

  def make(time: String): Time = time.indexOfOpt(" ").map(i => make(Day.make(time.copyFirst(i)), DayTime.make(time.copyFrom(i + 1)))) or Day.make(time).start

  def make(string: String, pattern: String): Time = new Time(new java.text.SimpleDateFormat(pattern).parse(string).getTime)

  def currentPro(changeEvery: Duration): scalqa.Pro.O[Time] = Z.CurrentPro(changeEvery)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def make(time -> Parse default
 *
 *   Parses String formatted by default with [[_Class.toString Time.toString]] method
 *
 * @def make(string -> Parse
 *
 *   Parses String by given pattern
 *
 *   See [[https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html java.text.SimpleDateFormat]] for pattern details
 *
 * @def make(day -> By Day and DayTime.
 *
 *     {{{
 *         val d  = Day.make(2018,4,6)
 *         val dt =  DayTime.make(16.Hours, 30.Minutes)
 *         Time.make(d,dt).lp // Prints: Time{day=2018-04-06,time=16:30}
 *     }}}
 *
 * @def make(day -> By Day and generic extension.
 *
 *     @param day base [[Day]]
 *     @param plus a set of time units in any order.
 *
 *     {{{
 *         Time.make(2018.Year.start.day, 12.Hours, 44.Seconds).lp  // Prints: Time{day=2018-01-01,time=12:00:44}
 *         Time.make(2018.Year.start.day, 44.Seconds, 12.Hours).lp  // Prints: Time{day=2018-01-01,time=12:00:44}
 *
 *         Time.make(2018.Year.start.day, 2.Days, 12.Hours).lp       // Prints: Time{day=2018-01-03,time=12:00}
 *         Time.make(2018.Year.start.day, 3.Weeks).lp               // Prints: Time{day=2018-01-22,time=0:00}
 *     }}}
 */
