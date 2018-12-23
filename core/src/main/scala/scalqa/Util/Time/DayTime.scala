package scalqa; package Util; package Time

class DayTime private[scalqa] (val real: Int) extends AnyVal with Time.Like.Core.A.Millis with Any.Datum.Int.Computable[DayTime] {
  protected def setup = DayTime

  @inline final def hours = super.totalHours

  @inline final def duration = Duration.fromMillis(real)

  @inline final def totalMillis = real Millis

  def round(l: Duration, r: Custom.Rounding = \/) = make(r.remainder(real, l.real).toInt)

  def +(l: Duration) = DayTime.fromMillis(real + l.totalMillis.real)
  def +~(v: ~[Duration]) = DayTime.fromMillis(v.foldAs(real.toLong)(_ + _.totalMillis.real))
  def -(l: Duration) = DayTime.fromMillis(real - l.totalMillis.real)
  def -~(v: ~[Duration]) = DayTime.fromMillis(v.foldAs(real.toLong)(_ - _.totalMillis.real))

  def toBrief = Z.DayTimeFormat(this, false)
  override def toString = Z.DayTimeFormat(this, true)
}

object DayTime extends Any.Datum.Int.Computable.Setup[DayTime] {
  val Min = make(0)
  val Max = make(23.Hours, 59.Minutes, 59.Seconds, 999.Millis)

  def now: DayTime = Time.now.dayTime

  protected def make(v: Int) = new DayTime(v)

  def make(s: String): DayTime = Z.DayTimeFormat.parse(s)

  def make(unit: Duration, more: Duration*): DayTime = fromMillis(more.all.map(_.real).fold(unit.real)(_ + _))

  def fromMillis(m: Long): DayTime = { val v = m % Z.MillisInOneDay; val ms = if (v >= 0) v else Z.MillisInOneDay + v; make(ms.toInt) }

  def currentPro(changeEvery: Duration): Pro.O[DayTime] = Time.currentPro(changeEvery).asMappedView(_.dayTime)

  implicit def zzDayTime(v: NOW.type): DayTime = DayTime.now

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *  @class DayTime -> `Time within Day`
 *
 *      [[DayTime]] can be better understood as [[Duration]] passed from midnight.
 *
 * @val Min -> Minimal value.
 *   {{{ DayTime.Min.lp // Prints: 0:00 }}}
 *
 * @val Max -> Maximum value.
 *   {{{ DayTime.Max.lp // Prints: 23:59:59.999 }}}
 *
 *
 * @def now: -> Current DayTime.
 *
 * @def make(unit: -> By generic units.
 *
 *   Creates [[DayTime]] specified by one or more [Duration]s in any order.
 *
 *   {{{
 *       DayTime.make(10.Hours, 15.Seconds).lp             // Prints: 10:00:15
 *       DayTime.make(10.Hours, 15.Seconds, 45.Minutes).lp // Prints: 10:45:15
 *   }}}
 *
 * @def fromMillis -> By milliseconds.
 *
 *     Creates a [[DayTime]] by total milliseconds.
 *
 *     If `value` exceeds the whole day, the day divided remainder will be used.
 *
 *     If `value` is negative, [[DayTime]] down from Max value is taken.
 *
 *   {{{
 *       DayTime.fromMillis(10001).lp  // Prints: 0:00:10.001
 *       DayTime.fromMillis(-10001).lp // Prints: 23:59:49.999
 *   }}}
 *
 *  @def hours -> Number of hours.
 *
 *      Same as totalHours
 *
 *      Number of hours since midnight.
 *
 *      Value range is 0 to 23
 *
 *  @def duration -> [[Duration]] from midnight.
 *
 *      Natural conversion since [[DayTime]] is essentially [[Duration]] passed from midnight.
 */
