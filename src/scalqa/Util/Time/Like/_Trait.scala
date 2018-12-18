package scalqa; package Util; package Time; package Like

trait _Trait[TYPE] extends Any with Core {

  def round(l: Duration, m: Custom.Rounding = \/): TYPE

  def day: Day = toTime.day

  def dayTime: DayTime = toTime.dayTime

  def month = day.month

  def year = day.year

  def toBrief: String = {
    val t = toTime;
    if (t.isVoid) "Void"
    else { val v = t.round(1.Second, DOWN); if (v.day.isCurrent) v.dayTime.toString else v.toString }
  }

  def age: Duration = { val cur = Time.now.totalMillis; val tm = totalMillis; if (cur <= tm) \/ else cur - tm }

  def durationTo(that: Time): Duration = Duration.fromMillis(that.totalMillis.real - totalMillis.real abs)

  def isFuture = toTime > Time.now

  def isPast = !this.isVoid && toTime < Time.now

  def +(v: Duration): TYPE
  def +~(v: ~[Duration]): TYPE

  def -(v: Duration): TYPE
  def -~(v: ~[Duration]): TYPE

  protected def toTime: Time

  override def toString: String = if (this.isVoid) "Void" else {
    var s = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date(totalMillis.real))
    if (s endsWith ":00.000") s = s copyShort 7
    if (s endsWith ".000") s = s copyShort 4
    s
  }

  private[scalqa] def isDayStart = this == day.start
  private[scalqa] def isMonthStart = this == month.start
  private[scalqa] def isYearStart = this == year.start

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> `Custom Time Like`
 *
 *     It is a base for developing custom Time like types
 *
 * @def +( -> Plus Duration
 *
 *   Creates a new instance with specified value added
 *
 *   {{{ 2018.Year.start + 1.Day lp // Prints 2018-01-02 00:00 }}}
 *
 * @def +~ -> Plus all
 *
 *   Creates a new instance with added stream values
 *
 *   {{{ 2018.Year.start +~ (~[Duration] + 1.Day + 1.Hour + 1.Minute) lp // Prints 2018-01-02 01:01 }}}
 *
 * @def -( -> Subtract value
 *
 *   Creates a new instance with specified value subtracted
 *
 *   {{{ 2018.Year.start - 1.Day lp  // Prints 2017-12-31 00:00 }}}
 *
 * @def -~ -> Subtract all values
 *
 *   Creates a new instance with all stream values subtracted
 *
 *   {{{ 2018.Year.start -~ (~[Duration] + 1.Day + 1.Hour + 1.Minute) lp // Prints 2017-12-30 22:59 }}}
 *
 * @def toBrief -> Short String.
 *
 *     Time is rounded to 1.Second.
 *
 *     For current Day, day portion is ommited.
 *
 * @def toString -> String formated.
 *
 *     Format is "yyyy-MM-dd HH:mm:ss.SSS".
 *
 * @def durationTo -> Range duration
 *
 *     Returns [[Duration]] between `this` and `that`.
 *
 * @def toTime: -> Time conversion.
 *
 *     Converts `this` to [[Time]].
 *
 * @def year -> Year.
 *
 *     [[Year]], which includes `this` time instance.
 *
 * @def month -> Month.
 *
 *     [[Month]], which includes `this` time instance.
 *
 * @def day: -> Day.
 *
 *     [[Day]], which includes `this` time instance.
 *
 * @def dayTime: -> DayTime component.
 *
 *     [[DayTime]] component of `this` time instance.
 *
 * @def age -> [[Duration]] to current.
 *
 *     Returns [[Duration]] from `this` time to current time.
 *
 *     If `this` is in future, void [[Duration]] is returned.
 *
 * @def isFuture -> Check if in future.
 *
 *    Returns `true` if this time is greater than current.
 *
 * @def isPast -> Check if in past.
 *
 *    Returns `true` if this time is less or equal to current.
 *
 * @def round -> Round .
 *
 *     Rounding `this` up by [[Duration]] specified.
 *
 *      {{{
 *         // DayTime based generic example
 *         val dt: DayTime = DayTime.make(10, 15, 46, 990)
 *
 *         dt.lp                 // Prints: 10:15:46.990
 *         dt.pad(1.Second).lp   // Prints: 10:15:47
 *         dt.pad(10.Seconds).lp // Prints: 10:15:50
 *         dt.pad(1.Minute).lp   // Prints: 10:16
 *      }}}
 *
 */
