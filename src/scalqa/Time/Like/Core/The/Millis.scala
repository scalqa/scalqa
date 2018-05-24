package scalqa; package Time; package Like; package Core; package The

trait Millis extends Any with Core with Able.Plus[Length._Class] with Able.Minus[Length._Class] {
  protected type TARGET <: Millis

  def totalHours: Length.Hours = (_totalMillis / Length.MillisOfHour).toInt
  def totalMinutes: Length.Minutes = (_totalMillis / Length.MillisOfMinute).toInt.Minutes
  def totalSeconds: Length.Seconds = (_totalMillis / Length.MillisOfSecond).toInt
  def totalMillis: Length.Millis = _totalMillis

  def subHours: Length.Hours = totalHours % 24
  def subMinutes: Length.Minutes = totalMinutes % 60
  def subSeconds: Length.Seconds = totalSeconds % 60
  def subMillis: Length.Millis = (_totalMillis % Length.MillisOfSecond)

  // ------------------------------------------------------------------------------------------

  def roundUp(l: Length): TARGET = roundDown(l) ? (_._totalMillis < _totalMillis, _._plus(l).cast[TARGET])

  def roundDown(l: Length): TARGET = (_totalMillis % l.totalMillis) ? (_ == 0, _ => _target, m => _minus(m.Millis))

  // ------------------------------------------------------------------------------------------
  protected def _totalMillis: Long
  protected def _get(millis: Long): TARGET
  protected def _plus(l: Length): TARGET = _get(_totalMillis + l.totalMillis)
  protected def _plusAll(a: ~[Length], s: Int): TARGET = a.foldAs[TARGET](_target, _ + _ cast)
  protected def _minus(l: Length): TARGET = _get(_totalMillis - l.totalMillis)
  protected def _minusAll(a: ~[Length]): TARGET = a.foldAs[TARGET](_target, _ - _ cast)
  protected def _target: TARGET = this.cast

  private[Time] def subMicros: Length.Micros = 0
  private[Time] def subNanos: Length.Nanos = 0
  private[Time] def totalMicros: Length.Micros = totalMillis * 1000
  private[Time] def totalNanos: Length.Nanos = totalMicros * 1000
  private[Time] def preciseMicros: Length.Micros = subMillis * 1000
  private[Time] def preciseNanos: Length.Nanos = preciseMicros * 100
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
