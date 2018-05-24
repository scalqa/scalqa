package scalqa; package Time; package Like; package Core

trait _Trait extends Any {
  protected type TARGET <: Core

  def roundUp(l: Length): TARGET

  def roundDown(l: Length): TARGET

  // ---------------------------------
  def totalHours: Length.Hours

  def totalMinutes: Length.Minutes

  def totalSeconds: Length.Seconds

  def totalMillis: Length.Millis

  private[Time] def totalMicros: Length.Micros

  private[Time] def totalNanos: Length.Nanos

  // ---------------------------------
  def subHours: Length.Hours

  def subMinutes: Length.Minutes

  def subSeconds: Length.Seconds

  def subMillis: Length.Millis

  private[Time] def subMicros: Length.Micros

  private[Time] def subNanos: Length.Nanos

  // ---------------------------------
  private[Time] def preciseMicros: Length.Micros

  private[Time] def preciseNanos: Length.Nanos

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def totalMillis -> Milliseconds count.
 *
 *     Total milliseconds which fit in ''this'' time unit.
 *
 * @def subMillis -> Milliseconds remainder.
 *
 *     Milliseconds remainder when rounded by whole second.
 *
 *     Value range is from 0 to 999
 *
 * @def totalSeconds -> Seconds count.
 *
 *     Total seconds which fit in ''this'' time unit.
 *
 * @def subSeconds -> Seconds remainder.
 *
 *     Seconds remainder when rounded by whole minute.
 *
 *     Value range is from 0 to 59
 *
 * @def totalMinutes -> Minutes count.
 *
 *     Total minutes which fit in ''this'' time unit.
 *
 * @def subMinutes -> Minutes remainder.
 *
 *     Minutes remainder when rounded by whole hour.
 *
 *     Value range is from 0 to 59
 *
 * @def totalHours -> Hours count.
 *
 *     Total hours which fit in ''this'' time unit.
 *
 * @def subHours -> Hours remainder.
 *
 *     Hours remainder when rounded by whole day (24 hours).
 *
 *     Value range is from 0 to 23
 *
 * @def totalMicros -> Microseconds count.
 *
 *     Total microseconds which fit in ''this'' time unit.
 *
 * @def preciseMicros -> Total microseconds within last second.
 *
 *     Value range is from 0 to 999,999
 *
 * @def subMicros -> Microseconds remainder.
 *
 *     Microseconds remainder when rounded by whole millisecond.
 *
 *     Value range is from 0 to 999
 *
 * @def subNanos -> Nanoseconds remainder.
 *
 *     Nanoseconds remainder when rounded by whole microsecond.
 *
 *     Value range is from 0 to 999
 *
 * @def totalNanos -> Nanoseconds count.
 *
 *     Total nanoseconds which fit in ''this'' time unit.
 *
 *     Note: Maximum length expressed in nanoseconds is "7331 days, 10 hours, 50 mins, 44.854775807 secs". Values over will cause problems.
 *
 * @def preciseNanos -> Total nanoseconds within last second.
 *
 *     Value range is from 0 to 999,999,999
 *
 * @def roundUp -> Round up.
 *
 *     Rounding ''this'' up by [[Time.Length]] specified.
 *
 *      {{{
 *         // DayTime based generic example
 *         val dt: DayTime = DayTime.get(10, 15, 46, 990)
 *
 *         dt.lp                 // Prints: 10:15:46.990
 *         dt.pad(1.Second).lp   // Prints: 10:15:47
 *         dt.pad(10.Seconds).lp // Prints: 10:15:50
 *         dt.pad(1.Minute).lp   // Prints: 10:16
 *      }}}
 *
 * @def roundDown -> Round down.
 *
 *     Rounding ''this'' down by [[Time.Length]] specified.
 *
 *      {{{
 *         // DayTime based generic example
 *         val dt: DayTime = DayTime.get(10, 15, 46, 990)
 *
 *         dt.lp                   // Prints: 10:15:46.990
 *         dt.trim(1.Second).lp    // Prints: 10:15:46
 *         dt.trim(10.Seconds).lp  // Prints: 10:15:40
 *         dt.trim(1.Minute).lp    // Prints: 10:15
 *      }}}
 */
