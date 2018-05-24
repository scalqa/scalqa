package scalqa; package Time; package Like; package Core; package The

trait Nanos extends Any with Core with Able.Plus[Precise.Length] with Able.Minus[Precise.Length] {
  protected type TARGET <: Nanos

  def totalHours: Length.Hours = _totalSeconds / 60 / 60
  def totalMinutes: Length.Minutes = _totalSeconds / 60
  def totalSeconds: Length.Seconds = _totalSeconds
  def totalMillis: Length.Millis = _totalSeconds * Long.OneThousand + subMillis
  def totalMicros: Length.Micros = _totalSeconds * Long.OneMillion + preciseMicros
  def totalNanos: Length.Nanos = _totalSeconds * Long.OneBillion + preciseNanos

  // ----------------------------------------
  def preciseNanos: Length.Nanos = _preciseNanos
  def preciseMicros: Length.Micros = _preciseNanos / 1000

  // ----------------------------------------
  def subHours: Length.Hours = totalHours % 24
  def subMinutes: Length.Minutes = totalMinutes % 60
  def subSeconds: Length.Seconds = totalSeconds % 60
  def subMillis: Length.Millis = _preciseNanos / Long.OneMillion
  def subMicros: Length.Micros = (_preciseNanos / 1000) % 1000
  def subNanos: Length.Nanos = _preciseNanos % 1000

  def roundUp(l: Length): TARGET = roundDown(l) ? (v => v._totalSeconds != _totalSeconds || v.preciseNanos != preciseNanos, _plus(l) cast)

  def roundDown(l: Length): TARGET = _minus(Precise.Length.get(totalSeconds % l.totalSeconds, preciseNanos % l.subMillis * Long.OneMillion))

  // ------------------------------------------------------------------------------------------
  protected def _totalSeconds: Long
  protected def _preciseNanos: Int

  protected def _get(seconds: Long, pNanos: Long): TARGET
  protected def _plus(l: Precise.Length): TARGET = _get(_totalSeconds + l.totalSeconds, _preciseNanos.toLong + l.preciseNanos)
  protected def _minus(l: Precise.Length): TARGET = _get(_totalSeconds - l.totalSeconds, _preciseNanos.toLong - l.preciseNanos)
  protected def _plusAll(a: ~[Precise.Length], s: Int): TARGET = a.foldAs[TARGET](_target, _ + _ cast)
  protected def _minusAll(a: ~[Precise.Length]): TARGET = a.foldAs[TARGET](_target, _ - _ cast)
  protected def _target: TARGET = this.cast
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
