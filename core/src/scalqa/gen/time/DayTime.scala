package scalqa; package gen; package time; import language.implicitConversions

import Time.DayTime
import Time.Length

object DayTime extends Long.Opaque.Data.Ordered[DayTime]("DayTime") with time.x.Nanos.LengthBase:
  /**/           inline def _0_Hours                           : DayTime = 0L.opaque
  /**/           inline def _24_Hours                          : DayTime = apply(24.Hours)
  /**/                  def current                            : DayTime = Time.current.dayTime
  /**/                  def apply(hours:Int,min:Int,sec:Int =0): DayTime = (hours.Hours.nanosTotal + min.Minutes.nanosTotal + sec.Seconds.nanosTotal ).opaque
  /**/                  def apply(unit: Length, more: Length*) : DayTime = more.map(_.nanosTotal).fold(unit.nanosTotal)(_ + _).opaque
  /**/           inline def nanos(inline n: Long)              : DayTime = n.opaque
  /**/           inline def millis(inline m: Long)             : DayTime = (m * 1000000).opaque
  /**/           inline def seconds(inline v: Long)            : DayTime = millis(v * 1000)
  override              def value_isVoid(v: DayTime)           : Boolean = v.real == 0L
  override              def value_tag(v: DayTime)              : String  = z.formatDayTime(v, true)
  implicit       inline def implicitFromLength(inline v:Length): DayTime = v.nanosTotal.opaque
  implicit       inline def implicitRequest(v: \/)             : DayTime = 0L.opaque
  implicit       inline def implicitRequest(v: CURRENT)        : DayTime = current

  extension(x: DayTime)
    /**/         inline def length                             : Length  = Length.fromNanos(x.real)
    /**/                def tagBrief                           : String  = z.formatDayTime(x, false)
    @tn("plus")  inline def +(inline l: Length)                : DayTime = (x.nanosTotal + l.nanosTotal).opaque
    @tn("minus") inline def -(inline l: Length)                : DayTime = (x.nanosTotal - l.nanosTotal).opaque

  object OPAQUE:
    opaque type TYPE <: Long.Opaque = Long.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object OPAQUE  -> ### Time within Day

        [[DayTime]] is an opaque Long value holding nanoseconds since midnigth

@def current  -> Current DayTime.


@def apply(unit -> By generic units.

     Creates [[DayTime]] specified by one or more [Length]s in any order.

     ```
         DayTime(10.Hours, 15.Seconds).TP             // Prints: 10:00:15
         DayTime(10.Hours, 15.Seconds, 45.Minutes).TP // Prints: 10:45:15
     ```


@def millis -> By milliseconds.

       Creates a [[DayTime]] by total milliseconds.

       If `value` exceeds the whole day, the day divided remainder will be used.

       If `value` is negative, [[DayTime]] down from max value is taken.

     ```
         DayTime.millis(10001).TP  // Prints: 0:00:10.001
         DayTime.millis(-10001).TP // Prints: 23:59:49.999
     ```


@def length -> [[Length]] from midnight.

*/
