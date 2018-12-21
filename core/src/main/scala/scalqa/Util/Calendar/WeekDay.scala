package scalqa; package Util; package Calendar

sealed class WeekDay extends Util.Enum[WeekDay](WeekDay) {

  def isWeekend = isSun || isSat

  def isWorkday = !isWeekend

  def isSun = this == WeekDay.Sun

  def isMon = this == WeekDay.Mon

  def isTue = this == WeekDay.Tue

  def isWed = this == WeekDay.Wed

  def isThu = this == WeekDay.Thu

  def isFri = this == WeekDay.Fri

  def isSat = this == WeekDay.Sat

}

object WeekDay extends Util.Enum.Setup[WeekDay] {

  val Sun, Mon, Tue, Wed, Thu, Fri, Sat = new WeekDay

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @def isWeekend -> Checks if weekend
 *
 *     Returns true if `this` instance is Sunday or Saturday
 *
 * @def isWorkday -> Checks if not weekend
 *
 *     Returns true if `this` instance is neither Sunday or Saturday
 *
 * @def isSun -> Checks if Sunday
 *
 *     Returns true if `this` instance represents Sunday
 *
 * @def isMon -> Checks if Monday
 *
 *     Returns true if `this` instance represents Monday
 *
 * @def isTue -> Checks if Tuesday
 *
 *     Returns true if `this` instance represents Tuesday
 *
 * @def isWed -> Checks if Wednesday
 *
 *     Returns true if `this` instance represents Wednesday
 *
 * @def isThu -> Checks if Thursday
 *
 *     Returns true if `this` instance represents Thursday
 *
 * @def isFri -> Checks if Friday
 *
 *     Returns true if `this` instance represents Friday
 *
 * @def isSat -> Checks if Saturday
 *
 *     Returns true if `this` instance represents Saturday
 *
 *
 * @class WeekDay -> `Sunday to Saturday Enumeration`
 */
