package scalqa; package Util; package Time

class PreciseTime private[scalqa] (protected val real: Long) extends AnyVal with Like[PreciseTime] with Like.Core.A.Nanos with Any.Datum.Long.Computable[PreciseTime] {
  protected def setup = PreciseTime

  def totalNanos = real Nanos

  def round(l: Duration, r: Custom.Rounding = \/) = PreciseTime.make(r.remainder(totalNanos.real, l.totalNanos.real))

  def +(l: Duration) = PreciseTime.make(totalNanos.real + l.totalNanos.real)
  def +~(v: ~[Duration]) = PreciseTime.make(v.foldAs(totalNanos.real)(_ + _.totalNanos.real))

  def -(l: Duration) = PreciseTime.make(totalNanos - l.totalNanos real)
  def -~(v: ~[Duration]) = PreciseTime.make(v.foldAs(totalNanos.real)(_ - _.totalNanos.real))

  def toTime = Time.fromMillis(totalMillis.real)

  override def toString = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date(real / Util.OneMillion)) + "." + subMicros.padded + "." + subNanos.padded

}

object PreciseTime extends Any.Datum.Long.Computable.Setup[PreciseTime] {

  def now: PreciseTime = make(clock.instant)

  def fromNanos(v: Long): PreciseTime = new PreciseTime(v)

  def make(i: java.time.Instant): PreciseTime = fromNanos(i.getEpochSecond * Util.OneBillion + i.getNano)

  private lazy val clock = java.time.Clock.systemUTC

  protected def make(v: Long) = new PreciseTime(v)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class PreciseTime ->
 *
 *     General timing in `scalqa` is done with millisecond precision and it is sufficient for most scenarios.
 *
 *     Moreover, most objects are value wraps of Long primitive, which makes the implementations extremely efficient.
 *
 *     Occasionally, however, nanosecond precision is required, and `Precise` package fills the gap:
 *
 *       - [[PreciseTime]] can be used instead of [[Time]]
 *       - [[PreciseDuration]] can be used instead of [[Duration]]
 *
 *     {{{
 *         val time = Time.get
 *         val precise = time.Precise
 *
 *         time lp                 // Prints: 2018-05-01 13:37:25.699
 *
 *         precise lp              // Prints: 2018-05-01 13:37:25.699.000.000
 *
 *         (time === precise) lp   // Prints: true
 *     }}}
 *
 * @def now: -> Current precise time.
 *
 *   Getting instant from java.time.Clock.systemUTC.instant
 *
 *   {{{
 *       // Tried
 *       PreciseTime.get.lp
 *       // Printed no micros or nanos
 *       2018-04-09 16:45:11.468.000.000
 *       // Apparently not every JVM supports precise clock.
 *  }}}
 *
 * @def make(i -> By instant
 *
 *   Time by java.time.Instant
 */
