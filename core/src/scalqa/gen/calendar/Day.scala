  package scalqa; package gen; package calendar; import language.implicitConversions

import Calendar.Day

object Day extends Int.Opaque.Data.Sequential[Day]("Day"):
  /**/        inline def fromIndex(epochDay: Int)         : Day                   = epochDay.toOpaque
  /**/        inline def current                          : Day                   = z.Day.current
  /**/               def apply(year:Int,month:Int,day:Int): Day                   = java.time.LocalDate.of(year, month, day).toEpochDay.toInt.toOpaque
  /**/               def apply(m: Month, day: Int)        : Day                   = apply(m.year.number, m.number, day)
  /**/               def unapply(v: Day)                  : Option[(Int,Int,Int)] = Some((v.year.number,v.month.number,v.number))
  override           def value_tag(v:Day)                 : String                = v.month.tag + "-" + { val s = v.number.toString; if (s.length < 2) "0" + s else s }
  override           def value_isVoid(v: Day)             : Boolean               = v.real == Int.min

  implicit    inline def implicitRequest(v: \/)           : Day                   = Int.min.toOpaque
  implicit    inline def implicitRequest(v: CURRENT)      : Day                   = current

  extension (x: Day)
    /**/      inline def index                            : Int                   = x.real
    /**/             def number                           : Int                   = z.Day.setup(x).number
    /**/             def week                             : Week                  = Week.fromIndex(x.real / 7)
    /**/             def month                            : Month                 = z.Day.setup(x).month
    /**/             def year                             : Year                  = z.Day.setup(x).year
    /**/             def weekDay                          : Week.Day              = Week.Day(((Int.max - 5L + x.real) % 7).toInt)
    /**/             def isCurrent                        : Boolean               = x == Day.current
    /**/      inline def period                           : Period                = Period(x.start, x.next.start)
    @tn("and")inline def &(inline l: Time.Length)         : Time                  = Time(x, l)
    /**/             def start                            : Time                  = z.Day.setup(x).start

  object TYPE:
    opaque type DEF <: Int.Opaque = Int.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@type DEF  -> ### Calendar Date

       [[Day]] is an opaque Int value, holding day index since start of 1970

       ```
         // Find all Fridays the 13th for this century
         (2000 <>> 2100).stream.map(_.Year).flatMap(_.days)
            .take(d => d.number == 13 && d.weekDay.isFri)
            .peek(_.TP)
            .count.self("Total Count: " + _ tp())

         // Output
         2001-04-13
         2001-07-13
         . . . . .
         2099-11-13
         Total Count: 172
       ```

@def isCurrent -> Checks if `today`.

     Returns `true` if `this` day is `today`.

      ```
         Day().isCurrent.TP // Prints: true
      ```


@def weekDay -> Sunday to Saturday enumereration value.

     Returns [[WeekDay]] value corresponding to this day.

      ```
         // Calculate number of each WeakDay in the year 2000
         2000.Year.days.stream.map(_.weekDay)
             .countFew(_.isSun, _.isMon, _.isTue, _.isWed, _.isThu, _.isFri, _.isSat).stream.TP
         // Output
         Stream(53, 52, 52, 52, 52, 52, 53)
      ```


@def index -> Set sequential index.

      Day 1970-01-01 has index 0

      ```
        Day(1900, 1, 31).index.TP // Prints: -25537
        Day(1970, 1, 31).index.TP // Prints: 30
        Day(2018, 1, 31).index.TP // Prints: 17562
      ```


@def start -> Day start time.

     Returns [[Time]] for the first moment of the day.

     ```
         Day(2018, 1, 1).start.TP // prints: Time{day=2018-01-01,time=0:00}
     ```


@def period -> Day period

     Returns [[Period]] from the first moment of the day and the first moment of the next day exclusive.

     ```
        Day(2018, 1, 1).period.TP // prints: 2018-01-01 0:00:00 to 2018-01-02 0:00:00
     ```

@def number -> Day number within the month.

      Number is from 1 and up to 31


@def year -> Day's year.

      Returns [[Year]] which contains this [[Day]].


@def month -> Day's month.

      Returns [[Month]] which contains this [[Day]].

*/
