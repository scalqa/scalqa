package scalqa; package gen; package time; package x; import language.implicitConversions

import Time.Length

transparent trait Base[A<:Any.Long]:

  extension(x: A)
    protected def genTime       : Gen.Time
    /**/      def day           : Day       = x.genTime.day
    /**/      def dayTime       : DayTime   = x.genTime.dayTime
    /**/      def week          : Week      = x.day.week
    /**/      def month         : Month     = x.day.month
    /**/      def year          : Year      = x.day.year
    /**/      def isFuture      : Boolean   = x.genTime > CURRENT
    /**/      def isPast        : Boolean   = x.genTime < CURRENT
    /**/      def isDayStart    : Boolean   = x.genTime == x.day.start
    /**/      def isMonthStart  : Boolean   = x.genTime == x.month.start
    /**/      def isYearStart   : Boolean   = x.genTime == x.year.start
    /**/      def tagBrief      : String    = x.genTime.^.to(t => if (t.isVoid) "\\/" else { val x = t.roundTo(1.Second)(using DOWN); if (x.day.isCurrent) x.dayTime.tag else x.tag })

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@def tagBrief -> Short String.

       Time is rounded to 1.Second.

       For current Day, day portion is ommited.

@def genTime -> Time conversion.

       Converts `this` to [[Time]].


@def year -> Year.

       [[Year]], which includes `this` time instance.


@def month -> Month.

       [[Month]], which includes `this` time instance.


@def day -> Day.

       [[Day]], which includes `this` time instance.


@def dayTime -> DayTime component.

       [[DayTime]] component of `this` time instance.

@def isFuture -> Check if in future.

      Returns `true` if this time is greater than current.


@def isPast -> Check if in past.

      Returns `true` if this time is less or equal to current.


*/
