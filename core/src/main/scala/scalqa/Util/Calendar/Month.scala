package scalqa; package Util; package Calendar

class Month private[scalqa] (protected val real: Int) extends AnyVal with Any.Datum.Int.Sequential[Month] {
  protected def setup = Month

  def index: Int = real

  def year: Year = Year.make(index / 12)

  def number: Int = index % 12 + 1

  def day(num: Int): Day = Day.make(year.number, number, num)

  def days: Idx[Day] = new Idx[Day] { def apply(i: Int) = day(i + 1); val size = number match { case 2 => if (year.isLeap) 29 else 28; case 4 | 6 | 9 | 11 => 30; case _ => 31 } }

  def start: Time = days(0).start

  def period = Period.make(start, next.start)

  override def toString = year.toString + "-" + (if (number > 9) number else "0" + number)

}

object Month extends Any.Datum.Int.Sequential.Setup[Month] {

  @inline protected[Month] def make(v: Int) = new Month(v)

  @inline def now: Month = Day.now.month

  @inline def make(year: Int, month: Int): Month = make(year * 12 + month - 1)

  def make(s: String): Month = make(s.copyFirst(4).toInt, s.copy(5 <> 6).toInt)

  implicit def zzMonth(v: NOW.type): Month = Month.now

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Month -> `Calendar Month`
 *
 * @def day( -> Day by number.
 *
 *    Returns [[Day]] within this [[Month]] by number.
 *
 *    @param num day number from 1 up to 31
 *
 *    {{{
 *      Month.make(2018,4).day(9).lp // Prints: 2018-04-09
 *    }}}
 *
 * @def now: -> Current month.
 *
 * @def make(year -> Month by year and month numbers.
 *
 *     Note, month number is within 1 <> 12.
 *
 * @def days -> Idx of days.
 *
 *   [[Idx]] of all [[Day]]s for the month.
 *
 *   {{{
 *      Month.make(2018, 1).days.all.range.lp
 *      // Output
 *      2018-01-01 <> 2018-01-31
 *   }}}
 *
 * @def year -> Month's year.
 *
 *    Returns [[Year]] which contains this [[Month]].
 *
 * @def number -> Month number within the year.
 *
 *    Number is within 1 <> 12
 *
 * @def index -> Unique sequential index.
 *
 *    Idx is calculated as: (year.number * 12 + month.number - 1)
 *
 *    {{{
 *       Month.make(2018, 1).index.lp // Prints: 24216
 *       Month.make(2018, 2).index.lp // Prints: 24217
 *       Month.make(2018, 3).index.lp // Prints: 24218
 *    }}}
 *
 * @def start -> Month start time
 *
 *   Returns [[Time]] for the first moment of the month
 *
 *   {{{
 *       Month.make(2018, 1).start.lp // prints: Time{day=2018-01-01,time=0:00}
 *   }}}
 *
 * @def period -> Year period
 *
 *   Returns [[Period]] from the first moment of the month and the first moment of the next month exclusive.
 *
 *   {{{
 *      Month.make(2018, 1).period.lp // prints: 2018-01-01 0:00:00 to 2018-02-01 0:00:00
 *   }}}
 */
