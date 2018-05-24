package scalqa; package Int; package _library

import Time.{ Length => L }

trait _constructor extends Any with __ {

  def Range: Range = if (This > 0) Int.Range.getByStartSize(0, This) else \/

  def Minute: L.Minutes = Minutes
  def Minutes: L.Minutes = L.Minutes.get(This)

  def Hour: L.Hours = Hours
  def Hours: L.Hours = L.Hours.get(This)

  def Day: L.Days = Days
  def Days: L.Days = L.Days.get(This)

  def Week: L.Weeks = Weeks
  def Weeks: L.Weeks = L.Weeks.get(This)

  def Year = Time.Year.get(This)

  def Rich = new scala.runtime.RichInt(This)

  def The: Int.The = Int.The.get(This)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def Range: ->  Creates range from 0 to ''this'' with exclusive end.
 *
 * @def The -> "The Int" constructor
 *
 *     Built-in constructor to create [[Int.The]] instances
 *
 *     {{{ 0.The.Class.lp  // Prints: scalqa.Int.The}}}
 *
 * @def Rich -> Scala library
 *
 *   Provides access to Scala RichInt library.
 *
 *   This library is available by default in Scala, but is disabled in Scalqa
 *
 *   {{{
 *      1000.Rich.toHexString.lp  // Prints: 3e8
 *   }}}
 *
 * @def Year -> Year constructor
 *
 *     Built-in constructor to create [[Year]] instances
 *
 *     {{{
 *         2018.Year.lp        // Prints: 2018
 *         2018.Year.isLeap.lp // Prints: false
 *     }}}
 *
 * @def Weeks -> Weeks constructor
 *
 *     Built-in constructor to create [[Time.Length.Weeks]] instances
 *
 *     {{{ 11.Weeks.lp // Prints: 11 weeks}}}
 *
 * @def Week: -> Weeks constructor
 *
 *     Same as 'Weeks', but recommended for use with base 1
 *
 *     {{{ 1.Week.lp // Prints: 1 week}}}
 *
 * @def Days -> Days constructor
 *
 *     Built-in constructor to create [[Time.Length.Days]] instances
 *
 *     {{{ 11.Days.lp // Prints: 11 days}}}
 *
 * @def Day: -> Days constructor
 *
 *     Same as 'Days', but recommended for use with base 1
 *
 *     {{{ 1.Day.lp // Prints: 1 day}}}
 *
 * @def Hours -> Hours constructor
 *
 *     Built-in constructor to create [[Time.Length.Hours]] instances
 *
 *     {{{ 11.Hours.lp // Prints: 11 hours}}}
 *
 * @def Hour: -> Hours constructor
 *
 *     Same as 'Hours', but recommended for use with base 1
 *
 *     {{{ 1.Hour.lp // Prints: 1 hour}}}
 *
 * @def Minutes -> Minutes constructor
 *
 *     Built-in constructor to create [[Time.Length.Minutes]] instances
 *
 *     {{{ 11.Minutes.lp // Prints: 11 mins}}}
 *
 * @def Minute: -> Minutes constructor
 *
 *     Same as 'Minutes', but recommended for use with base 1
 *
 *     {{{ 1.Minute.lp // Prints: 1 min}}}
 *
 */
