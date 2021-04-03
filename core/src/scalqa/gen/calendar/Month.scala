package scalqa; package gen; package calendar; import language.implicitConversions

import Calendar.Month

object Month extends Int.Custom.Data.Sequential[Month]("Month"):
  /**/     def apply(year: Int, month: Int)       : Month   = (year * 12 + month - 1).asOpaque[Month]
  /**/     def apply()                            : Month   = Day().month
  override def tag(v: Month)                      : String  = v.year.tag + "-" + { if (v.number > 9) v.number else "0" + v.number }
  override def isVoid(v: Month)                   : Boolean = v.real == Int.min
  implicit inline def xxRequest(inline v: \/)     : Month   = Int.min.asOpaque[Month]
  implicit inline def xxRequest(inline v: CURRENT): Month   = apply()

  extension (x: Month)
    inline def index     : Int      = x.real
    inline def year      : Year     = Year(x.real / 12)
    inline def number    : Int      = x.real % 12 + 1
    /**/   def start     : Time     = x.days(0).start
    inline def period    : Period   = Period(x.start, x.next.start)
    /**/   def isCurrent : Boolean  = x == Day().month
    /**/   def days      : Day.Idx  = new zDays(x)

  object opaque:
    opaque type `type` <: Opaque.Int = Opaque.Int

  // ***************************************************************************************************************
  private class zDays(v: Month) extends Day.Idx:
    def apply(i: Int) = Day(v.year.number, v.number, i + 1);
    val size = v.number match { case 2 => if (v.year.isLeap) 29 else 28; case 4 | 6 | 9 | 11 => 30; case _ => 31 }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object opaque -> ### Calendar Month

    [[Month]] is an opaque Int value, holding month index since start of 1970

@def apply()  -> Current month.


@def apply(year -> Month by year and month numbers.

       Note, month number is within 1 <> 12.


@def days -> | of days.

     [[!]] of all [[Day]]s for the month.

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

      | is calculated as: (year.number * 12 + month.number - 1)

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
