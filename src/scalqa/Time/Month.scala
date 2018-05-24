package scalqa; package Time

class Month protected[Month] (protected val real: Int) extends AnyVal with Any.Value.Int with Able.Sequence {
  protected type THIS = Month
  protected type TARGET = Month

  protected def companion = Month

  def index: Int = value

  def year: Year = Year.get(index / 12)

  def number: Int = index % 12 + 1

  def day(num: Int): Day = Day.get(year.number, number, num)

  def days: Index[Day] = new Index[Day] { def apply(i: Int) = day(i + 1); val size = number match { case 2 => if (year.isLeap) 29 else 28; case 4 | 6 | 9 | 11 => 30; case _ => 31 } }

  def start: Time = days(0).start

  def period = Time.Period.get(start, next.start)

  override def toString = year.toString + "-" + (if (number > 9) number else "0" + number)

  protected def _sequenceMove(i: Int) = new Month(value + i)
}

object Month extends Any.Value.Int.Companion[Month] {

  protected def get(v: Int) = new Month(v)

  def get: Month = Day.get.month

  def get(year: Int, month: Int) = new Month(year * 12 + month - 1)

  def getParse(s: String): Month = get(s.copyFirst(4).toInt, s.copy(5 <> 6).toInt)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @def get: -> Current month.
 *
 * @def get(year -> Month by year and month numbers.
 *
 *     Note, month number is within 1 <> 12.
 *
 * @def day( -> Day by number.
 *
 *    Returns [[Day]] within this [[Month]] by number.
 *
 *    @param num day number from 1 up to 31
 *
 *    {{{
 *      Month.get(2018,4).day(9).lp // Prints: 2018-04-09
 *    }}}
 *
 * @def days -> Index of days.
 *
 *   [[Index]] of all [[Day]]s for the month.
 *
 *   {{{
 *      Month.get(2018, 1).days.all.range.lp
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
 *    Index is calculated as: (year.number * 12 + month.number - 1)
 *
 *    {{{
 *       Month.get(2018, 1).index.lp // Prints: 24216
 *       Month.get(2018, 2).index.lp // Prints: 24217
 *       Month.get(2018, 3).index.lp // Prints: 24218
 *    }}}
 *
 * @def start -> Month start time
 *
 *   Returns [[Time]] for the first moment of the month
 *
 *   {{{
 *       Month.get(2018, 1).start.lp // prints: Time{day=2018-01-01,time=0:00}
 *   }}}
 *
 * @def period -> Year period
 *
 *   Returns [[Period]] from the first moment of the month and the first moment of the next month exclusive.
 *
 *   {{{
 *      Month.get(2018, 1).period.lp // prints: 2018-01-01 0:00:00 to 2018-02-01 0:00:00
 *   }}}
 *
 * @class Month -> '''Calendar Month'''
 */
