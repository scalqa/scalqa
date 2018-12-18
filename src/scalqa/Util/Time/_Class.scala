package scalqa; package Util; package Time

class _Class private[scalqa] (val real: Long) extends AnyVal with Like[_Class] with Like.Core.A.Millis with Any.Datum.Long.Ordered[_Class] {
  protected def setup = _Class

  def totalMillis = real.Millis

  def Gmt: Gmt = Time.Gmt.fromMillis(real)

  def Precise: PreciseTime = PreciseTime.fromNanos(real * Util.OneMillion)

  def skipTo(dt: DayTime): Time = this + { val v = dt.totalMillis - dayTime.totalMillis; if (v >= 0) v else v + Z.MillisInOneDay }

  override def day: Day = Calendar.Day.fromIndex(zoneDT.toLocalDate.toEpochDay.toInt)

  override def dayTime: DayTime = { val zt = zoneDT; DayTime.make(zt.getHour.Hours, zt.getMinute.Minutes, zt.getSecond.Seconds, (zt.getNano / 1000000).Millis) }

  def format(pattern: String): String = new java.text.SimpleDateFormat(pattern).format(new java.util.Date(totalMillis.real))

  def round(l: Duration, r: Custom.Rounding = \/): Time = make(r.remainder(totalMillis.real, l.totalMillis.real))

  def +(l: Duration) = make(totalMillis + l.totalMillis real)
  def +~(v: ~[Duration]) = make(v.fold(totalMillis)(_ + _.totalMillis) real)

  def -(l: Duration) = make(totalMillis.real - l.totalMillis.real)
  def -~(v: ~[Duration]) = make(v.map(_.totalMillis.real).fold(totalMillis.real)(_ - _))

  protected def zoneDT = java.time.Instant.ofEpochMilli(totalMillis.real).atZone(Zone.Id)
  protected def toTime = this

  override def toString = day +- dayTime

}

object _Class extends Any.Datum.Long.Ordered.Setup[_Class] {

  protected def make(v: Long) = new _Class(v)

  implicit def zzTime(v: NOW.type): Time = Time.now

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
 *   Formats time with given `pattern`
 *
 *   See [[https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html java.text.SimpleDateFormat]] for details
 *   {{{
 *     val t: Time = \/
 *
 *     t.format("hh 'o`clock' a, zzzz") lp        // Prints: 07 o'clock PM, Eastern Standard Time
 *
 *     t.format("yyyy.MM.dd G 'at' HH:mm:ss z") lp // Prints: 1969.12.31 AD at 19:00:00 EST
 *
 *     t.format("EEE, MMM d, `yy") lp             // Prints: Wed, Dec 31, '69
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
