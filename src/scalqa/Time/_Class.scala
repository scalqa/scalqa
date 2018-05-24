package scalqa; package Time

class _Class private[Time] (protected val real: Long) extends AnyVal with Any.Value.Long with Like with Like.Core.The.Millis {
  protected type THIS = _Class
  protected type TARGET = _Class

  def Gmt: Gmt = Time.Gmt.getByMillis(real)

  def Precise: Time.Precise = Time.Precise.get(this, 0, 0)

  def skipTo(dt: DayTime): Time = (dt.totalMillis - dayTime.totalMillis).I.to(l => _plus((l ? (_ < 0, _ + Length.MillisOfDay)).Millis))

  override def day: Day = Day.getByIndex(zoneDT.toLocalDate.toEpochDay.toInt)

  override def dayTime: DayTime = { val zt = zoneDT; DayTime.get(zt.getHour.Hours, zt.getMinute.Minutes, zt.getSecond.Seconds, (zt.getNano / 1000000).Millis) }

  override def toString: String = day + " " + dayTime

  def format(pattern: String): String = new java.text.SimpleDateFormat(pattern).format(new java.util.Date(totalMillis))

  protected def zoneDT = java.time.Instant.ofEpochMilli(_totalMillis).atZone(Zone.Id)
  protected def _get(millis: Long) = new Time(millis)
  protected def _totalMillis = value
  protected def companion = _Class
  protected def toTime = this
}

object _Class extends Any.Value.Long.Companion[Time] {

  protected def get(v: Long) = new Time(v)

  import scala.language.implicitConversions

  implicit def zzGet(c: CURRENT.type) = Time.get

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def format -> Format
 *
 *   Formats time with given ''pattern''
 *
 *   See [[https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html java.text.SimpleDateFormat]] for details
 *   {{{
 *     val t: Time = \/
 *
 *     t.format("hh 'o''clock' a, zzzz") lp        // Prints: 07 o'clock PM, Eastern Standard Time
 *
 *     t.format("yyyy.MM.dd G 'at' HH:mm:ss z") lp // Prints: 1969.12.31 AD at 19:00:00 EST
 *
 *     t.format("EEE, MMM d, ''yy") lp             // Prints: Wed, Dec 31, '69
 *
 *     t.format("h:mm a") lp                       // Prints: 7:00 PM
 *   }}}
 *
 * @def Gmt -> GMT Time
 *
 *     Built-in constructor to create [[Time.Gmt]]
 *
 * @def skipTo -> Skip to next
 *
 *     Finds next greater instance of time with given [[DayTime]]
 *
 *     Note: The result may skip to next day
 *
 *     {{{
 *       val time = 2018.Year.start
 *
 *       time lp                                   // Prints: 2018-01-01 0:00:00
 *
 *       time.skipTo(16.Hours) lp                  // Prints: 2018-01-01 16:00:00
 *
 *       time.skipTo(16.Hours).skipTo(10.Hours) lp // Prints: 2018-01-02 10:00:00
 *     }}}
 */
