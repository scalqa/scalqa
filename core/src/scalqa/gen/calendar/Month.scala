package scalqa; package gen; package calendar; import language.implicitConversions

import Calendar.Month

object Month extends Int.Opaque.Data.Sequential[Month]("Month"):
  /**/     inline def fromIndex(epochMonth: Int) : Month    = epochMonth.toOpaque
  /**/            def apply(year: Int,month: Int): Month    = (year * 12 + month - 1).toOpaque
  /**/            def current                    : Month    = Day.current.month
  override        def value_tag(v: Month)        : String   = v.year.tag + "-" + { if (v.number > 9) v.number else "0" + v.number }
  override        def value_isVoid(v: Month)     : Boolean  = v.real == Int.min

  implicit inline def implicitRequest(v: \/)     : Month    = Int.min.toOpaque
  implicit inline def implicitRequest(v: CURRENT): Month    = current

  extension (x: Month)
    /**/   inline def index                      : Int      = x.real
    /**/   inline def year                       : Year     = Year(x.real / 12)
    /**/   inline def number                     : Int      = x.real % 12 + 1
    /**/          def start                      : Time     = Day(x,1).start
    /**/   inline def period                     : Period   = Period(x.start, x.next.start)
    /**/          def isCurrent                  : Boolean  = x == Month.current
    /**/          def days                       : Day.Idx  = new z_Days(x)

  object TYPE:
    opaque type DEF <: Int.Opaque = Int.Opaque

  // ***************************************************************************************************************
  private class z_Days(v: Month) extends Day.Idx:
    def apply(i: Int) = Day(v.year.number, v.number, i + 1);
    val size          = v.number match { case 2 => if (v.year.isLeap) 29 else 28; case 4 | 6 | 9 | 11 => 30; case _ => 31 }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@type DEF  -> ### Calendar Month

    [[Month]] is an opaque Int value, holding month index since start of 1970

@def current  -> Current month.

@def apply(year -> Month by year and month numbers.

       Note, month number is within 1 <> 12.


@def days -> Index of days.

     Index of all [[Day]]s for the month.

     ```
        Month(2018, 1).days.~.range.TP
        // Output
        2018-01-01 <> 2018-01-31
     ```


@def year -> Month's year.

      Returns [[Year]] which contains this [[Month]].


@def number -> Month number within the year.

      Number is within 1 <> 12


@def index -> Set sequential index.

      Index is calculated as: (year.number * 12 + month.number - 1)

      ```
         Month(2018, 1).index.TP // Prints: 24216
         Month(2018, 2).index.TP // Prints: 24217
         Month(2018, 3).index.TP // Prints: 24218
      ```


@def start -> Month start time

     Returns [[Time]] for the first moment of the month

     ```
         Month(2018, 1).start.TP // prints: Time{day=2018-01-01,time=0:00}
     ```


@def period -> Year period

     Returns [[Period]] from the first moment of the month and the first moment of the next month exclusive.

     ```
        Month(2018, 1).period.TP // prints: 2018-01-01 0:00:00 to 2018-02-01 0:00:00
     ```

*/
