package scalqa; package gen; package time; package x; import language.implicitConversions

import Time.Length

trait Nanos[A<:Any.Raw.Long]:
  extension(x:A)
    @tn("millisTotal")     def millisTotal                        : Long = x.nanosTotal / 1_000_000L
    @tn("nanosTotal")      def nanosTotal                         : Long
    @tn("roundTo")         def roundTo(l:Length)(using r:Rounding): A    = (r(x.nanosTotal, l.nanosTotal)).cast[A]
  extension(inline x:A)
    /**/            inline def weeksTotal                         : Long = x.nanosTotal / Nanos.InOneWeek
    /**/            inline def daysTotal                          : Long = x.nanosTotal / Nanos.InOneDay
    /**/            inline def hoursTotal                         : Long = x.nanosTotal / Nanos.InOneHour
    /**/            inline def minutesTotal                       : Long = x.nanosTotal / Nanos.InOneMinute
    /**/            inline def secondsTotal                       : Long = x.nanosTotal / Nanos.InOneSecond
    /**/            inline def microsTotal                        : Long = x.nanosTotal / 1000L

    /**/            inline def hours                              : Long = x.hoursTotal   % 24
    /**/            inline def minutes                            : Long = x.minutesTotal % 60
    /**/            inline def seconds                            : Long = x.secondsTotal % 60
    /**/            inline def millis                             : Long = x.millisTotal  % 1000
    /**/            inline def micros                             : Long = x.microsTotal  % 1000
    /**/            inline def nanos                              : Long = x.nanosTotal   % 1000

    @tn("plus")     inline def  +(inline l: Length)               : A    = (x.nanosTotal + l.nanosTotal).cast[A]
    @tn("minus")    inline def  -(inline l: Length)               : A    = (x.nanosTotal + l.nanosTotal).cast[A]
    @tn("plusAll")  inline def ++(inline s: ~[Length])            : A    = (s.foldAs(x.nanosTotal)(_ + _.nanosTotal)).cast[A]
    @tn("minusAll") inline def --(inline s: ~[Length])            : A    = (s.foldAs(x.nanosTotal)(_ - _.nanosTotal)).cast[A]


object Nanos:
  inline val InOneMicros  = 1000L
  inline val InOneMillis  = InOneMicros  * 1000
  inline val InOneSecond  = InOneMillis  * 1000
  inline val InOneMinute  = InOneSecond  * 60
  inline val InOneHour    = InOneMinute  * 60
  inline val InOneDay     = InOneHour    * 24
  inline val InOneWeek    = InOneDay     * 7

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
