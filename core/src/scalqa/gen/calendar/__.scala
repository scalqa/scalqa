package scalqa; package gen

object Calendar:
  type Week  = calendar.Week.opaque.`type`;    inline def Week  = calendar.Week
  type Day   = calendar.Day.opaque.`type`;     inline def Day   = calendar.Day
  type Month = calendar.Month.opaque.`type`;   inline def Month = calendar.Month
  type Year  = calendar.Year.opaque.`type`;    inline def Year  = calendar.Year

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Calendar -> ### Calendar Library
*/