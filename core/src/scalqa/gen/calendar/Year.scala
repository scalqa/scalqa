package scalqa; package gen; package calendar; import language.implicitConversions

import Calendar.Year

object Year extends Int.Opaque.Data.Sequential[Year]("Year"):
  /**/     inline def apply(inline v: Int)      : Year      = v.opaque
  /**/     inline def current                   : Year      = Time.current.year
  override        def value_tag(v: Year)        : String    = v.toString
  override        def value_isVoid(v: Year)     : Boolean   = v.real == Int.min

  implicit inline def implicitRequest(v: \/)    : Year      = Int.min.opaque
  implicit inline def implicitRequest(v:CURRENT): Year      = current

  extension (x: Year)
    /**/   inline def number                    : Int       = x.real
    /**/   inline def isLeap                    : Boolean   = java.time.Year.isLeap(x.real)
    /**/          def start                     : Time      = Day(x.number,1,1).start
    /**/   inline def period                    : Period    = Period(x.start,  x.next.start)
    /**/          def months                    : Month.Idx = zMonths(x)
    /**/          def days                      : Day.Idx   = zDays(x)
    /**/          def isCurrent                 : Boolean   = x == Year.current

  object OPAQUE:
    opaque type TYPE <: Int.Opaque = Int.Opaque

  // ****************************************************************************************************
  private class zDays(v: Year) extends Day.Idx:
    val from          = Day(v.number, 1, 1)
    val size          = if (v.isLeap) 366 else 365
    def apply(i: Int) = from + i

  private class zMonths(v: Year) extends Month.Idx:
    def size          = 12;
    def apply(i: Int) = Month(v.number, i + 1)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object OPAQUE  -> ### Calendar Year

    [[Year]] is an opaque Int value, holding literally the year number

@def number -> Year number.

     ```
        2018.Year.number.TP // Prints: 2018
     ```

@def isLeap -> Leap year indicator.

     Leap years have an extra day - Feb 29th.

     Leap years usually happen every 4 years. But, let's check:

     ```
         // Find every 4th year, which is not leap
         (0 <> 2050).~.map(_.Year).take(_.number % 4 == 0).remove(_.isLeap).TP
         // Output
         ~(100, 200, 300, 500, 600, 700, 900, 1000, 1100, 1300, 1400, 1500, 1700, 1800, 1900)
     ```


@def days -> Index of days.

     Index of all [[Day]]s for the year.

     Size is 366 for leap and 365 for regular years.

     ```
        2018.Year.days.~.range.TP
        // Output
         2018-01-01 <> 2018-12-31
     ```


@def months -> Index of months.

     Index of all [[Month]]s for the year.

     Size is always 12.
     ```
         2018.Year.months.~.TP
         // Output
         ~(2018-01, 2018-02, 2018-03, 2018-04, 2018-05, 2018-06, 2018-07, 2018-08, 2018-09, 2018-10, 2018-11, 2018-12)
     ```


@def start -> Year start time

     Returns [[Time]] for the first moment of the year

     ```
         2018.Year.start.TP // prints: Time{day=2018-01-01,time=0:00}
     ```


@def period -> Year period

     Returns [[Period]] from the first moment of the year and the first moment of the next year exclusive.

     ```
        2018.Year.period.TP // prints: 2018-01-01 0:00:00 to 2019-01-01 0:00:00
     ```

*/
