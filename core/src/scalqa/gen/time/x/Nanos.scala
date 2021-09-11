package scalqa; package gen; package time; package x; import language.implicitConversions

import Time.Length

object Nanos:
  inline val InOneMicros  = 1000L
  inline val InOneMillis  = InOneMicros  * 1000
  inline val InOneSecond  = InOneMillis  * 1000
  inline val InOneMinute  = InOneSecond  * 60
  inline val InOneHour    = InOneMinute  * 60
  inline val InOneDay     = InOneHour    * 24
  inline val InOneWeek    = InOneDay     * 7

  // ***********************************************************************************************
  transparent trait Base:

    extension[THIS_OPAQUE <: Long.Opaque](inline x: THIS_OPAQUE)
      inline def nanos             : Long        = x.real                      % 1000
      inline def micros            : Long        = x.real / Nanos.InOneMicros  % 1000
      inline def millis            : Long        = x.real / Nanos.InOneMillis  % 1000
      inline def seconds           : Long        = x.real / Nanos.InOneSecond  % 60
      inline def minutes           : Long        = x.real / Nanos.InOneMinute  % 60
      inline def hours             : Long        = x.real / Nanos.InOneHour    % 24
      inline def roundTo(l:Length)
                 (using r:Rounding): THIS_OPAQUE = (r(x.real, l.nanosTotal)).cast[THIS_OPAQUE]

  object Base:

    transparent trait Length extends Base:

      extension[THIS_OPAQUE <: Long.Opaque](inline x: THIS_OPAQUE)
        inline def nanosTotal        : Long      = x.real
        inline def microsTotal       : Long      = x.real / Nanos.InOneMicros
        inline def millisTotal       : Long      = x.real / Nanos.InOneMillis
        inline def secondsTotal      : Long      = x.real / Nanos.InOneSecond
        inline def minutesTotal      : Long      = x.real / Nanos.InOneMinute
        inline def hoursTotal        : Long      = x.real / Nanos.InOneHour
        inline def daysTotal         : Long      = x.real / Nanos.InOneDay
        inline def weeksTotal        : Long      = x.real / Nanos.InOneWeek


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@def daysTotal -> Day count

       Total days (24.Hours) which fit in `this` time unit


@def millisTotal -> Milliseconds count

       Total milliseconds which fit in `this` time unit


@def millis -> Milliseconds remainder

       Milliseconds remainder when rounded by whole second

       Value range is from 0 to 999


@def secondsTotal -> Seconds count

       Total seconds which fit in `this` time unit


@def seconds -> Seconds remainder

       Seconds remainder when rounded by whole minute

       Value range is from 0 to 59


@def minutesTotal -> Minutes count

       Total minutes which fit in `this` time unit


@def minutes -> Minutes remainder

       Minutes remainder when rounded by whole hour

       Value range is from 0 to 59


@def hoursTotal -> Hours count

       Total hours which fit in `this` time unit


@def hours -> Hours remainder

       Hours remainder when rounded by whole day (24 hours)

       Value range is from 0 to 23


@def microsTotal -> Microseconds count

       Total microseconds which fit in `this` time unit


@def micros -> Microseconds remainder

       Microseconds remainder when rounded by whole millisecond

       Value range is from 0 to 999


@def nanos -> Nanoseconds remainder

       Nanoseconds remainder when rounded by whole microsecond

       Value range is from 0 to 999


@def nanosTotal -> Nanoseconds count

       Total nanoseconds which fit in `this` time unit

       Note: Maximum duration expressed in nanoseconds is "7331 days, 10 hours, 50 mins, 44.854775807 secs". Unboxed over will cause problems

*/
