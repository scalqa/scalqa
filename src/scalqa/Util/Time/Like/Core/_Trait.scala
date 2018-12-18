package scalqa; package Util; package Time; package Like; package Core

trait _Trait extends Any {

  def totalDays: Days
  def totalHours: Hours
  def totalMinutes: Minutes
  def totalSeconds: Seconds
  def totalMillis: Millis
  private[Time] def totalMicros: Micros
  private[Time] def totalNanos: Nanos

  // ---------------------------------
  def subHours = totalHours % 24
  def subMinutes = totalMinutes % 60
  def subSeconds = totalSeconds % 60
  def subMillis = totalMillis % 1000
  private[Time] def subMicros = totalMicros % 1000
  private[Time] def subNanos = totalNanos % 1000

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def totalDays -> Day count.
 *
 *     Total days (24.Hours) which fit in `this` time unit.
 *
 * @def totalMillis -> Milliseconds count.
 *
 *     Total milliseconds which fit in `this` time unit.
 *
 * @def subMillis -> Milliseconds remainder.
 *
 *     Milliseconds remainder when rounded by whole second.
 *
 *     Value range is from 0 to 999
 *
 * @def totalSeconds -> Seconds count.
 *
 *     Total seconds which fit in `this` time unit.
 *
 * @def subSeconds -> Seconds remainder.
 *
 *     Seconds remainder when rounded by whole minute.
 *
 *     Value range is from 0 to 59
 *
 * @def totalMinutes -> Minutes count.
 *
 *     Total minutes which fit in `this` time unit.
 *
 * @def subMinutes -> Minutes remainder.
 *
 *     Minutes remainder when rounded by whole hour.
 *
 *     Value range is from 0 to 59
 *
 * @def totalHours -> Hours count.
 *
 *     Total hours which fit in `this` time unit.
 *
 * @def subHours -> Hours remainder.
 *
 *     Hours remainder when rounded by whole day (24 hours).
 *
 *     Value range is from 0 to 23
 *
 * @def totalMicros -> Microseconds count.
 *
 *     Total microseconds which fit in `this` time unit.
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
 *     Total nanoseconds which fit in `this` time unit.
 *
 *     Note: Maximum duration expressed in nanoseconds is "7331 days, 10 hours, 50 mins, 44.854775807 secs". Unboxed over will cause problems.
 *
 */
