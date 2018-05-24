package scalqa; package Time; package Precise

class Length private (protected val _totalSeconds: Long, protected val _preciseNanos: Int) extends Like.Core.The.Nanos with Time.Length.Z.Base {
  protected type TARGET = Length

  protected def _get(seconds: Long, pNanos: Long): Length = Length.get(seconds, pNanos)

  def *(number: Int) = _get(_totalSeconds * number, _preciseNanos * number)

  def /(number: Int) = _get(_totalSeconds / number, _preciseNanos / number)

  def toLength = Time.Length.getByMillis(totalMillis)

}

object Length extends Able.Void.Companion[Length](new Length(0, 0) with Void) {

  def get(seconds: Long, nanos: Long): Length = {
    if (nanos < 0) get(seconds + (nanos / Long.OneBillion) - (nanos % Long.OneBillion).signum, -(nanos % Long.OneBillion))
    else if (nanos >= Long.OneBillion) new Length(seconds + (nanos / Long.OneBillion).toInt, (nanos % Long.OneBillion).toInt)
    else new Length(seconds, nanos.toInt)
  }

  def getByMillis(n: Long) = new Length(n / 1000, ((n % 1000) * Long.OneMillion).toInt)

  def getByNanos(n: Long) = new Length(n / Long.OneBillion, (n % Long.OneBillion).toInt)

  def get(units: Length*): Length = {
    var sec, nan = 0L
    units.all.apply(l => { sec += l._totalSeconds; nan += l._preciseNanos })
    get(sec, nan)
  }

  import scala.language.implicitConversions

  implicit def zzGet(v: Time.Length): Precise.Length = v.toPrecise

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Length -> [[Precise.Length]] can be created with the following custom length units:
 *     [[Length.Weeks Weeks]], [[Length.Days Days]], [[Length.Hours Hours]], [[Length.Minutes Minutes]],
 *      [[Length.Seconds Seconds]], [[Length.Millis Millis]], [[Length.Micros Micros]], [[Length.Nanos Nanos]]
 *
 *     {{{
 *       1.Day.preciseLength.lp       // Prints: 1 day
 *       33.Millis.preciseLength.lp   // Prints: 0.033 sec
 *       10.Hours.preciseLength.lp    // Prints: 10 hours
 *       99999.Nanos.preciseLength.lp // Prints: 0.000099999 sec
 *     }}}
 *
 *
 * @def toLength -> Regular Length.
 *
 *     Converts ''this'' [[Precise.Length]] to regular [[Length]].
 *
 *
 * @def get(seconds -> By seconds and nanoseconds.
 *
 *   @param nanos   nanoseconds. If ''nanos'' reach billion, the spill over will be added to the seconds.
 *
 *   {{{
 *      Time.Precise.Length.get(100, 999).lp              // Prints: 1 min, 40.000000999 secs
 *      Time.Precise.Length.get(100, Long.OneTrillion).lp // Prints: 18 mins, 20 secs
 *   }}}
 *
 * @def getByNanos -> By nanoseconds.
 *
 *   Creates [[Length]] by total nanoseconds.
 *
 *   {{{
 *       Time.Precise.Length.getByNanos(Long.OneTrillion + 999).lp
 *       // Output
 *       16 mins, 40.000000999 secs
 *   }}}
 *
 * @def getByMillis -> By milliseconds.
 *
 *   Creates [[Length]] by total milliseconds.
 *
 *   {{{
 *       Time.Precise.Length.getByMillis(Long.OneTrillion + 999).lp
 *       // Output
 *       11574 days, 1 hour, 46 mins, 40.999 secs
 *   }}}
 *
 * @def get(units -> By generic units.
 *
 *   Creates [[Length]] specified by one or more length units in any order.
 *
 *   {{{
 *        Time.Precise.Length.get(12.Hours, 45.Minutes, 999.Nanos, 5.Millis).lp
 *        // Output
 *        12 hours, 45 mins, 0.005000999 sec
 *   }}}
 *
 */
