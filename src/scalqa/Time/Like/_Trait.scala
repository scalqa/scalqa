package scalqa; package Time; package Like

trait _Trait extends Any with Core with Able.DataEqual[_Trait] {
  protected type TARGET <: _Trait

  def day: Day = toTime.day

  def dayTime: DayTime = toTime.dayTime

  def month = day.month

  def year = day.year

  def toBrief: String = toTime.I.to(t => t.isVoid ? ("Void", t.roundDown(1.Second) ? (_.day.isCurrent, _.dayTime.toString, _.toString)))

  def age: Length = currentMillis.I.to(cm => if (cm <= totalMillis) \/ else new Length(cm - totalMillis))

  def lengthTo(that: Time): Length = new Length((that.totalMillis - totalMillis).abs)

  def isFuture = toTime > Time.get

  def isPast = this.isVoid.not && toTime < Time.get

  protected def toTime: Time

  protected def offset: Length.Millis = totalMillis % Length.MillisOfDay - dayTime.totalMillis

  override def toString: String = if (this.isVoid) "Void" else
    new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date(totalMillis.toLong)) ? (_ endsWith ":00.000", _ copyShort 7) ? (_ endsWith ".000", _ copyShort 4)

  private[scalqa] def isDayStart = this == day.start
  private[scalqa] def isMonthStart = this == month.start
  private[scalqa] def isYearStart = this == year.start

  protected def _dataEqual(v: Like): Boolean = totalMillis === v.totalMillis

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> '''Custom Time Base'''
 *
 *     This entire package can be skipped by regular developers.
 *
 *     It is a base for developing custom Time like types.
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
 * @def lengthTo -> Range length.
 *
 *     Returns [[Length]] between ''this'' and ''that''.
 *
 * @def toTime: -> Time conversion.
 *
 *     Converts ''this'' to [[Time]].
 *
 * @def year -> Year.
 *
 *     [[Year]], which includes ''this'' time instance.
 *
 * @def month -> Month.
 *
 *     [[Month]], which includes ''this'' time instance.
 *
 * @def day: -> Day.
 *
 *     [[Day]], which includes ''this'' time instance.
 *
 * @def dayTime: -> DayTime component.
 *
 *     [[DayTime]] component of ''this'' time instance.
 *
 * @def age -> [[Length]] to current.
 *
 *     Returns [[Length]] from ''this'' time to current time.
 *
 *     If ''this'' is in future, void [[Length]] is returned.
 *
 * @def isFuture -> Check if in future.
 *
 *    Returns ''true'' if this time is greater than current.
 *
 * @def isPast -> Check if in past.
 *
 *    Returns ''true'' if this time is less or equal to current.
 *
 */
