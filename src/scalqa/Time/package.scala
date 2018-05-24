package scalqa

package object Time {
  type Day = Day._Class
  type DayTime = DayTime._Class
  type Period = Period._Class
  type Precise = Precise._Class
  type Length = Length._Class
  type Like = Like._Trait

  def get() = getByMillis(currentMillis)

  def getByMillis(m: Long) = new Time(m)

  def get(i: java.time.Instant) = getByMillis(i.getEpochSecond * 1000 + i.getNano / Long.OneMillion)

  def get(d: Day, dt: DayTime): Time = d.start + dt.totalMillis

  def get(day: Day, plus: Length*): Time = day.start + Length.get(plus: _*)

  def getParse(time: String): Time = time.indexOfOpt(" ").map(i => get(Day.getParse(time.copyFirst(i)), DayTime.getParse(time.copyFrom(i + 1)))) or Day.getParse(time).start

  def getParse(string: String, pattern: String): Time = new Time(new java.text.SimpleDateFormat(pattern).parse(string).getTime)

  def currentMillis = System.currentTimeMillis

  def currentPro(changeEvery: Time.Length): scalqa.Pro.O[Time] = Z.CurrentPro(changeEvery)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def getParse(time -> Parse default
 *
 *   Parses String formatted by default with [[_Class.toString Time.toString]] method
 *
 * @def getParse(string -> Parse
 *
 *   Parses String by given pattern
 *
 *   See [[https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html java.text.SimpleDateFormat]] for pattern details
 *
 * @def get(day -> By Day and DayTime.
 *
 *     {{{
 *         val d  = Day.get(2018,4,6)
 *         val dt =  DayTime.get(16.Hours, 30.Minutes)
 *         Time.get(d,dt).lp // Prints: Time{day=2018-04-06,time=16:30}
 *     }}}
 *
 * @def get(day -> By Day and generic extension.
 *
 *     @param day base [[Day]]
 *     @param plus a set of time units in any order.
 *
 *     {{{
 *         Time.get(2018.Year.start.day, 12.Hours, 44.Seconds).lp  // Prints: Time{day=2018-01-01,time=12:00:44}
 *         Time.get(2018.Year.start.day, 44.Seconds, 12.Hours).lp  // Prints: Time{day=2018-01-01,time=12:00:44}
 *
 *         Time.get(2018.Year.start.day, 2.Days, 12.Hours).lp       // Prints: Time{day=2018-01-03,time=12:00}
 *         Time.get(2018.Year.start.day, 3.Weeks).lp               // Prints: Time{day=2018-01-22,time=0:00}
 *     }}}
 */
