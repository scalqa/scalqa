package scalqa; package gen; package time; package x; import language.implicitConversions

import Time.Length

object Millis:
  inline val InOneSecond = 1000L
  inline val InOneMinute = InOneSecond * 60
  inline val InOneHour   = InOneMinute * 60
  inline val InOneDay    = InOneHour   * 24
  inline val InOneWeek   = InOneDay    * 7

  transparent trait Base:

    extension[OPAQUE <: Long.Opaque](inline x: OPAQUE)
      /**/            inline def nanos                   : Long      = 0L
      /**/            inline def micros                  : Long      = 0L
      /**/            inline def millis                  : Long      = x.real                      % 1000
      /**/            inline def seconds                 : Long      = x.real / Millis.InOneSecond % 60
      /**/            inline def minutes                 : Long      = x.real / Millis.InOneMinute % 60
      /**/            inline def hours                   : Long      = x.real / Millis.InOneHour   % 24
      /**/            inline def roundTo(l:Length)
                                       (using r:Rounding): OPAQUE    = (r(x.real, l.millisTotal)).cast[OPAQUE]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@def millis -> Milliseconds remainder

       Milliseconds remainder when rounded by whole second

       Value range is from 0 to 999


@def seconds -> Seconds remainder

       Seconds remainder when rounded by whole minute

       Value range is from 0 to 59


@def minutes -> Minutes remainder

       Minutes remainder when rounded by whole hour

       Value range is from 0 to 59

@def hours -> Hours remainder

       Hours remainder when rounded by whole day (24 hours)

       Value range is from 0 to 23

@def micros -> Microseconds remainder

       Microseconds remainder when rounded by whole millisecond

       Value range is from 0 to 999


@def nanos -> Nanoseconds remainder

       Nanoseconds remainder when rounded by whole microsecond

       Value range is from 0 to 999
*/
