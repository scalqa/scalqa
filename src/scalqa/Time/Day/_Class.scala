package scalqa; package Time; package Day

class _Class private[Day] (protected val real: Int) extends AnyVal with Any.Value.Int with Able.Sequence {
  protected type THIS = _Class
  protected type TARGET = _Class

  def index: Int = value

  def year: Year = Z.Access.day(value).year

  def month = Z.Access.day(value).month

  def number = Z.Access.day(value).number

  def +(dt: DayTime): Time = Time.get(this, dt)

  def weekDay: WeekDay = WeekDay.getByOrdinal(((Int.Max + value.toLong - 4) % 7).toByte)

  def isCurrent = this == Day.get

  def start: Time = Z.Access.day(value).start

  def period: Period = Time.Period.get(start, next.start)

  override def toString = month.toString + "-" + number.toString ? (_.length < 2, "0" + _)

  protected def companion = _Class
  protected def _sequenceMove(i: Int) = new Day(value + i)
}

object _Class extends Any.Value.Int.Companion[Day] {

  protected def get(v: Int) = new Day(v)

  import scala.language.implicitConversions
  implicit def zzGet(c: CURRENT.type) = Day.get
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class -> '''Calendar Date'''
 *
 *     [[Day]] along with [[Month]] and [[Year]] brings the functionality of real world calendar
 *
 *     @contentDiagram
 *
 *     @example
 *     {{{
 *        // Find all Fridays the 13th for this century
 *       (2000 <<> 2100).all.map(_.Year).flatMap(_.days).let(_.number == 13).
 *         let(_.weekDay.isFri).peek(Print.ln(_)).count() lp "Total Count: "
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
 *     Creates [[Time]] with ''this'' day and provided [[DayTime]].
 *
 *    {{{
 *       (Day.get(2000, 1, 1) + DayTime.get(23,59,59)).lp // Prints: Time{day=2000-01-01,time=23:59:59}
 *    }}}
 *
 * @def isCurrent -> Checks if ''today''.
 *
 *   Returns ''true'' if ''this'' day is ''today''.
 *
 *    {{{
 *       Day.get.isCurrent.lp // Prints: true
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
 *      Day.get(1900, 1, 31).index.lp // Prints: -25537
 *      Day.get(1970, 1, 31).index.lp // Prints: 30
 *      Day.get(2018, 1, 31).index.lp // Prints: 17562
 *    }}}
 *
 * @def start -> Day start time.
 *
 *   Returns [[Time]] for the first moment of the day.
 *
 *   {{{
 *       Day.get(2018, 1, 1).start.lp // prints: Time{day=2018-01-01,time=0:00}
 *   }}}
 *
 * @def period -> Day period
 *
 *   Returns [[Period]] from the first moment of the day and the first moment of the next day exclusive.
 *
 *   {{{
 *      Day.get(2018, 1, 1).period.lp // prints: 2018-01-01 0:00:00 to 2018-01-02 0:00:00
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
