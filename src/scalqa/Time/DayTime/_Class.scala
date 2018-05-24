package scalqa; package Time; package DayTime

class _Class private[DayTime] (protected val real: Int) extends AnyVal with Like.Core.The.Millis with Any.Value.Int {
  protected override type THIS = DayTime
  protected override type TARGET = DayTime

  def hours = super.totalHours

  def length = Length.getByMillis(_totalMillis)

  def toBrief = format(false)

  override def toString: String = format(true)

  def format(full: Boolean) = Z.format(this, full)

  protected def companion = _Class

  protected def _totalMillis = value: @inline

  private[scalqa] def isSecondStart = _totalMillis % Length.MillisOfSecond == 0
  private[scalqa] def isMinuteStart = _totalMillis % Length.MillisOfMinute == 0
  private[scalqa] def isHourStart = _totalMillis % Length.MillisOfHour == 0
  protected def _get(millis: Long) = DayTime.getByMillis(millis)
}

object _Class extends Any.Value.Int.Companion[DayTime] {

  protected def get(v: Int) = new DayTime(v)

  import scala.language.implicitConversions

  implicit def zzGet(c: CURRENT.type) = DayTime.get

  implicit def zzGet(l: Length) = DayTime.get(l)

  implicit def zzGetByHours(l: Length.Hours) = DayTime.get(l.toLength)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *  @def hours -> Number of hours.
 *
 *      Same as totalHours
 *
 *      Number of hours since midnight.
 *
 *      Value range is 0 to 23
 *
 *  @def length -> [[Length]]from midnight.
 *
 *      Natural conversion since [[DayTime]] is essentially [[Time.Length]] passed from midnight.
 *
 *
 *  @class _Class -> '''Time within Day'''
 *
 *      [[DayTime]] can be better understood as [[Time.Length]] passed from midnight.
 *
 */
