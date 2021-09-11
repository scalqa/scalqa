package scalqa; package gen

object Calendar:
  type Week  = calendar.Week.TYPE.DEF;    transparent inline def Week  = calendar.Week
  type Day   = calendar.Day.TYPE.DEF;     transparent inline def Day   = calendar.Day
  type Month = calendar.Month.TYPE.DEF;   transparent inline def Month = calendar.Month
  type Year  = calendar.Year.TYPE.DEF;    transparent inline def Year  = calendar.Year

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Calendar -> ### Calendar Library
*/