package scalqa; package Util; package Time

class Days private[scalqa] (val real: Long) extends AnyVal with Like.Unit[Days] with Time.Like.Core.A.Millis {
  protected def setup = Days

  def totalMillis = Time.Z.MillisInOneDay * real Millis

}

object Days extends Like.Unit.Setup[Days]("day", 1) {

  def make(v: Long) = new Days(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Days ->
 *
 *     [[Days]] is a unit representing [[Duration]] of specified number of days.
 *
 *     Note: It does not implement [[Duration]] directly, but is implicitly converted to it.
 *
 * @object Days -> [[Days]] can be created by built-it constructor on Int type.
 *     {{{
 *       1.Day.lp      // Prints: 1 day
 *       3.Days.lp     // Prints: 3 days
 *       1000.Days.lp  // Prints: 1000 days
 *     }}}
 */
