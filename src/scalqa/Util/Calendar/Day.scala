package scalqa; package Util; package Calendar

class Day private[scalqa] (protected val real: Int) extends AnyVal with Any.Datum.Int.Sequential[Day] {
  protected def setup = Day

  def index: Int = real

  def year: Year = Z.DaySetup(index).year

  def month = Z.DaySetup(index).month

  def number = Z.DaySetup(index).number

  def +(dt: DayTime, V: \/ = \/) = Time.make(this, dt)

  def weekDay: WeekDay = WeekDay.items(((Int.MaxValue + real.toLong - 4) % 7).toByte)

  def isCurrent = Day.now == this

  def start: Time = Z.DaySetup(index).start

  def period: Period = Time.Period.make(start, next.start)

  override def toString = month.I.toString + "-" + { val v = number.toString; if (v.length < 2) "0" + v else v }

}

object Day extends Any.Datum.Int.Sequential.Setup[Day] {
  protected def make(v: Int) = new Day(v)
  private var _day: Day = Time.now.day
  private var nextDayStart: Time = _day.next.start

  val length = Duration.fromMillis(Time.Z.MillisInOneDay)

  def now: Day = {
    val t = Time.now;
    if (t >= nextDayStart) { _day = t.day; nextDayStart = _day.next.start }
    _day
  }

  def fromIndex(epochDay: Int): Day = new Day(epochDay)

  def make(year: Int, month: Int, day: Int): Day = fromIndex(java.time.LocalDate.of(year, month, day).toEpochDay.toInt)

  def make(m: Month, day: Int): Day = make(m.year.number, m.number, day)

  def make(day: String): Day = make(
    day.copy(4.Range).toInt,
    if (day.length < 7) 1 else day.copy(5 <> 6).toInt, if (day.length < 10) 1 else day.copy(8 <> 9).toInt)

  def make(string: String, format: String): Day = Time.fromMillis(new java.text.SimpleDateFormat(format).parse(string).getTime).day

  implicit def zzDay(v: NOW.type): Day = Day.now

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Day -> `Calendar Date`
 *
 *     {{{
 *        // Find all Fridays the 13th for this century
 *       (2000 <<> 2100).all.map(_.Year).flatMap(_.days).let(_.number == 13).
 *         let(_.weekDay.isFri).peek(_.lp).count lp "Total Count: "
 *
 *       // Output
 *       2001-04-13
 *       2001-07-13
 *       . . . . .
 *       2099-11-13
 *       2100-08-13
 *       Total Count: 172
 *     }}}
 *
 * @def + -> Creates [[Time]]
 *
 *     Creates [[Time]] with `this` day and provided [[DayTime]].
 *
 *    {{{
 *       (Day.make(2000, 1, 1) + DayTime.make(23,59,59)).lp // Prints: Time{day=2000-01-01,time=23:59:59}
 *    }}}
 *
 * @def isCurrent -> Checks if `today`.
 *
 *   Returns `true` if `this` day is `today`.
 *
 *    {{{
 *       Day.now.isCurrent.lp // Prints: true
 *    }}}
 *
 * @def weekDay -> Sunday to Saturday enumeration value.
 *
 *   Returns [[WeekDay]] value corresponding to this day.
 *
 *    {{{
 *       // Calculate number of each WeakDay in the year 2000
 *       2000.Year.days.all.map(_.weekDay)
 *           .countFew(_.isSun, _.isMon, _.isTue, _.isWed, _.isThu, _.isFri, _.isSat).all.lp
 *       // Output
 *       ~(53, 52, 52, 52, 52, 52, 53)
 *    }}}
 *
 * @def index -> Unique sequential index.
 *
 *    Day 1970-01-01 has index 0
 *
 *    {{{
 *      Day.make(1900, 1, 31).index.lp // Prints: -25537
 *      Day.make(1970, 1, 31).index.lp // Prints: 30
 *      Day.make(2018, 1, 31).index.lp // Prints: 17562
 *    }}}
 *
 * @def start -> Day start time.
 *
 *   Returns [[Time]] for the first moment of the day.
 *
 *   {{{
 *       Day.make(2018, 1, 1).start.lp // prints: Time{day=2018-01-01,time=0:00}
 *   }}}
 *
 * @def period -> Day period
 *
 *   Returns [[Period]] from the first moment of the day and the first moment of the next day exclusive.
 *
 *   {{{
 *      Day.make(2018, 1, 1).period.lp // prints: 2018-01-01 0:00:00 to 2018-01-02 0:00:00
 *   }}}
 * @def number -> Day number within the month.
 *
 *    Number is from 1 and up to 31
 *
 * @def year -> Day's year.
 *
 *    Returns [[Year]] which contains this [[Day]].
 *
 * @def month -> Day's month.
 *
 *    Returns [[Month]] which contains this [[Day]].
 */
