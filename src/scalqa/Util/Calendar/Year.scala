package scalqa; package Util; package Calendar

class Year private[scalqa] (protected val real: Int) extends AnyVal with Any.Datum.Int.Sequential[Year] {
  protected def setup = Year

  def number: Int = real

  def start: Time = Month.make(real, 1).start

  def period = Time.Period.make(start, next.start)

  def isLeap = java.time.Year.isLeap(real)

  def months: Idx[Month] = new Idx[Month] { def size = 12; def apply(i: Int) = Month.make(number, i + 1) }

  def days: Idx[Day] = new Idx[Day] { val from = Day.make(number, 1, 1); val size = if (isLeap) 366 else 365; def apply(i: Int) = from + i }

  override def toString = real.toString
}

object Year extends Any.Datum.Int.Sequential.Setup[Year] {
  def now: Year = Time.now.year

  @inline def make(v: Int): Year = new Year(v)

  implicit def zzYear(v: NOW.type): Year = Year.now

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Year -> `Calendar Year`
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
 * @def days -> Idx of days.
 *
 *   [[Idx]] of all [[Day]]s for the year.
 *
 *   Size is 366 for leap and 365 for regular years.
 *
 *   {{{
 *      2018.Year.days.all.range.lp
 *      // Output
 *       2018-01-01 <> 2018-12-31
 *   }}}
 *
 * @def months -> Idx of months.
 *
 *   [[Idx]] of all [[Month]]s for the year.
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
 */
