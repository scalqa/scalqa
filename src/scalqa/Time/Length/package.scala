package scalqa.Time

package object Length {

  def getByMillis(m: Long) = new Length(m)

  def get(more: Length*): Length = getByMillis(more.all.map(_.totalMillis.toLong).fold(0L, _ + _))

  val MillisOfSecond = 1000L
  val MillisOfMinute = 60 * MillisOfSecond
  val MillisOfHour = 60 * MillisOfMinute
  val MillisOfDay = 24 * MillisOfHour
  val MillisOfWeek = 7 * MillisOfDay

  val NanosOfMicros = 1000L
  val NanosOfMillis = NanosOfMicros * 1000L
  val NanosOfSecond = NanosOfMillis * 1000L
  val NanosOfMinute = 60 * NanosOfSecond
  val NanosOfHour = 60 * NanosOfMinute
  val NanosOfDay = 24 * NanosOfHour
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @object Length -> [[Length]] can be created with the following custom length units:
 *     [[Weeks]], [[Days]], [[Hours]], [[Minutes]], [[Seconds]], [[Millis]], [[Micros]], [[Nanos]]
 *
 *     {{{
 *       1.Day.length.lp     // Prints: 1 day
 *       33.Millis.length.lp // Prints: 0.033 sec
 *       10.Hours.length.lp  // Prints: 10 hours
 *     }}}
 *
 * @def getByMillis -> By milliseconds.
 *
 *     Creates [[Length]] by total milliseconds.
 *
 *   {{{
 *       Time.Length.getByMillis(Long.OneBillion).lp  // Prints: 11 days, 13 hours, 46 mins, 40 sec
 *   }}}
 *
 * @def get( -> By generic units.
 *
 *   Creates [[Length]] specified by one or more simple [[Time.Length]]s in any order.
 *
 *   {{{
 *       Time.Length.get(10.Hours, 15.Seconds).lp             // Prints: 10 hours, 15 sec
 *       Time.Length.get(10.Hours, 15.Seconds, 45.Minutes).lp // Prints: 10 hours, 45 mins, 15 sec
 *   }}}
 *
 */
