package scalqa; package Time

package object Day {
  private[scalqa] def This = this
  private var _day: Day = Time.get.day
  private var nextDayStart: Time = _day.next.start

  val length = scalqa.Time.Length.getByMillis(Length.MillisOfDay)

  def get: Day = Time.get.I.to(t => { if (t >= nextDayStart) { _day = t.day; nextDayStart = _day.next.start }; _day })

  protected def get(v: Int) = new Day(v)

  def getByIndex(epochDay: Int) = new Day(epochDay)

  def get(year: Int, month: Int, day: Int): Day = getByIndex(java.time.LocalDate.of(year, month, day).toEpochDay.toInt)

  def get(m: Month, day: Int): Day = get(m.year.toInt, m.number, day)

  def getParse(day: String): Day = Day.get(day.copy(4.Range).toInt, (day.length < 7) ? (1, day.copy(5 <> 6).toInt), (day.length < 10) ? (1, day.copy(8 <> 9).toInt))

  def getParse(string: String, format: String): Day = new java.text.SimpleDateFormat(format).parse(string).I.to(d => scalqa.Time.getByMillis(d.getTime).day)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def getParse(day -> Parse default
 *
 *   Parses String formatted by default with [[_Class.toString Day.toString]] method
 *
 * @def getParse(string -> Parse
 *
 *   Parses String by given pattern
 *
 *   See [[https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html java.text.SimpleDateFormat]] for pattern details
 *
 * @val length -> Length of one day
 *
 *    {{{
 *       Day.length == 24.Hours.length // Evaluates true
 *    }}}
 *
 * @def get: -> Current day
 *
 *    {{{
 *       Day.get.isCurrent // Evaluates true
 *    }}}
 *
 * @def get(year -> By numbers
 *
 *     @param year number
 *     @param month number from 1 to 12
 *     @param day number from 1 up to 31
 *
 *    {{{
 *       Day.get(2017,12,31).lp // Prints: 2017-12-31
 *    }}}
 *
 * @def get(m -> By [[Month]] and day number
 *
 *     @param m month instance
 *     @param day number from 1 up to 31
 *
 *    {{{
 *      val m = Month.get(2017,12)
 *      Day.get(m,31).lp // Prints: 2017-12-31
 *    }}}
 *
 *
 * @def getByIndex -> By sequential index
 *
 *    Day 1970-01-01 has index 0
 *
 *    {{{
 *      Day.get(1900, 1, 31).index.lp // Prints: -25537
 *      Day.get(1970, 1, 31).index.lp // Prints: 30
 *      Day.get(2018, 1, 31).index.lp // Prints: 17562
 *    }}}
 */
