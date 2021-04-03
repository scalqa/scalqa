package scalqa; package gen; package time; package x; import language.implicitConversions

import Time.Length

trait Base[A<:Any.Raw.Long]:

  extension(x: A)
    @tn("nanosTotal")  protected       def nanosTotal                         : Long
    @tn("millisTotal") protected       def millisTotal                        : Long
    @tn("roundTo")                     def roundTo(l:Length)(using r:Rounding): A
    @tn("day")                         def day                                : Day       = x.general.day
    @tn("week")                        def week                               : Week.Day  = x.day.weekDay
    @tn("dayTime")                     def dayTime                            : DayTime   = x.general.dayTime
    @tn("month")                       def month                              : Month     = x.day.month
    @tn("year")                        def year = x.day.year
    @tn("age")                         def age                                : Length    = { val cm = System.currentTimeMillis; val m = x.millisTotal; if (cm <= m) \/ else (cm - m).Millis }
    @tn("lengthTo")                    def lengthTo(that: Time)               : Length    = Length.fromNanos((that.nanosTotal - x.nanosTotal).abs)
    @tn("isFuture")                    def isFuture                           : Boolean   = x.general > Time()
    @tn("isPast")                      def isPast                             : Boolean   = x.general < Time()
    @tn("general")      protected      def general                            : Gen.Time
    @tn("isDayStart")   private[scalqa]def isDayStart                         : Boolean   = x.general == x.day.start
    @tn("isMonthStart") private[scalqa]def isMonthStart                       : Boolean   = x.general == x.month.start
    @tn("isYearStart")  private[scalqa]def isYearStart                        : Boolean   = x.general == x.year.start
    @tn("toBrief")                     def toBrief                            : String    = { val t : Time = x.general
      /**/                                                                                    if (t.isVoid) "\\/"
      /**/                                                                                    else { val x = t.roundTo(1.Second)(using DOWN); if (x.day.isCurrent) x.dayTime.tag else x.tag }
      /**/                                                                                   }


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@def toBrief -> Short String.

       Time is rounded to 1.Second.

       For current Day, day portion is ommited.


@def lengthTo -> Range duration

       Returns [[Length]] between `this` and `that`.


@def general -> Time conversion.

       Converts `this` to [[Time]].


@def year -> Year.

       [[Year]], which includes `this` time instance.


@def month -> Month.

       [[Month]], which includes `this` time instance.


@def day -> Day.

       [[Day]], which includes `this` time instance.


@def dayTime -> DayTime component.

       [[DayTime]] component of `this` time instance.


@def age -> [[Length]] to current.

       Returns [[Length]] from `this` time to current time.

       If `this` is in future, void [[Length]] is returned.


@def isFuture -> Check if in future.

      Returns `true` if this time is greater than current.


@def isPast -> Check if in past.

      Returns `true` if this time is less or equal to current.


@def roundTo -> Round .

       Rounding `this` up by [[Length]] specified.

        ```
           // DayTime based generic example
           val dt: DayTime = DayTime(10, 15, 46, 990)

           dt.TP                 // Prints: 10:15:46.990
           dt.pad(1.Second).TP   // Prints: 10:15:47
           dt.pad(10.Seconds).TP // Prints: 10:15:50
           dt.pad(1.Minute).TP   // Prints: 10:16
        ```


*/
