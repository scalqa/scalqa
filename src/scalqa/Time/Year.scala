package scalqa; package Time

class Year private (protected val real: Int) extends AnyVal with Any.Value.Int with Able.Sequence {
  protected type THIS = Year
  protected type TARGET = Year

  def number: Int = value

  def isLeap = java.time.Year.isLeap(number)

  def days: Index[Day] = new Index[Day] { def size = if (isLeap) 366 else 365; def apply(i: Int) = start.day + i }

  def months: Index[Month] = new Index[Month] { def size = 12; def apply(i: Int) = Month.get(number, i + 1) }

  def start: Time = months(0).start

  def period = Time.Period.get(start, next.start)

  protected def companion = Year
  protected def _sequenceMove(i: Int) = new Year(value + i)
}

object Year extends Any.Value.Int.Companion[Year] {

  def get: Year = Day.get.year

  def get(i: Int) = new Year(i)

  import scala.language.implicitConversions

  implicit def zzGet(i: Int): Year = new Year(i)

  implicit def zzInt(y: Year): Int = y.value

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @def get: -> Current year.
 *
 * @def get( -> Year by Int.
 *
 * @def number -> Year number.
 *
 *   {{{
 *      2018.Year.number.lp // Prints: 2018
 *   }}}
 *
 * @def isLeap -> Leap year indicator.
 *
 *   Leap years have an extra day - Feb 29th.
 *
 *   Leap years usually happen every 4 years. But, let's check:
 *
 *   {{{
 *       // Find every 4th year, which is not leap
 *       (0 <> 2050).all.map(_.Year).let(_.number % 4 == 0).drop(_.isLeap).lp
 *       // Output
 *       ~(100, 200, 300, 500, 600, 700, 900, 1000, 1100, 1300, 1400, 1500, 1700, 1800, 1900)
 *   }}}
 *
 * @def days -> Index of days.
 *
 *   [[Index]] of all [[Day]]s for the year.
 *
 *   Size is 366 for leap and 365 for regular years.
 *
 *   {{{
 *      2018.Year.days.all.range.lp
 *      // Output
 *       2018-01-01 <> 2018-12-31
 *   }}}
 *
 * @def months -> Index of months.
 *
 *   [[Index]] of all [[Month]]s for the year.
 *
 *   Size is always 12.
 *   {{{
 *       2018.Year.months.all.lp
 *       // Output
 *       ~(2018-01, 2018-02, 2018-03, 2018-04, 2018-05, 2018-06, 2018-07, 2018-08, 2018-09, 2018-10, 2018-11, 2018-12)
 *   }}}
 *
 * @def start -> Year start time
 *
 *   Returns [[Time]] for the first moment of the year
 *
 *   {{{
 *       2018.Year.start.lp // prints: Time{day=2018-01-01,time=0:00}
 *   }}}
 *
 * @def period -> Year period
 *
 *   Returns [[Period]] from the first moment of the year and the first moment of the next year exclusive.
 *
 *   {{{
 *      2018.Year.period.lp // prints: 2018-01-01 0:00:00 to 2019-01-01 0:00:00
 *   }}}
 *
 * @class Year -> '''Calendar Year'''
 *
 */
