package scalqa; package Time; package Precise

class _Class private[Precise] (protected val _totalSeconds: Long, protected val _preciseNanos: Int) extends Like with Like.Core.The.Nanos {
  protected type TARGET = Precise

  def toTime = Time.getByMillis(_totalSeconds * 1000 + _preciseNanos / Long.OneMillion)

  override def toString: String = if (this.isVoid) "Void" else
    new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date(totalMillis.toLong)) + "." + subMicros.toPaddedString + "." + subNanos.toPaddedString

  protected def _get(seconds: Long, pNanos: Long): _Class = Precise.get(seconds.Seconds, pNanos.Nanos)

  protected override def _dataEqual(v: Like): Boolean = super._dataEqual(v) && v.I.letAs(classOf[Precise]).map(_.preciseNanos == preciseNanos).or(true)

}

object _Class extends Able.Void.Companion[_Class](new Precise(0, 0) with Void) {

  import scala.language.implicitConversions

  implicit def zzNow(c: CURRENT.type): Precise = get

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class ->
 *
 *     General timing in ''scalqa'' is done with millisecond precision and it is sufficient for most scenarios.
 *
 *     Moreover, most objects are value wraps of Long primitive, which makes the implementations extremely efficient.
 *
 *     Occasionally, however, nanosecond precision is required, and ''Precise'' package fills the gap:
 *
 *       - [[Time.Precise]] can be used instead of [[Time]]
 *       - [[Time.Precise.Length]] can be used instead of [[Time.Length]]
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
 */
