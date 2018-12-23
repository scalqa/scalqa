package scalqa; package Util; package Time

class Weeks private[scalqa] (val real: Long) extends AnyVal with Like.Unit[Weeks] with Time.Like.Core.A.Millis {
  protected def setup = Weeks

  @inline final def totalMillis = Time.Z.MillisInOneWeek * real Millis

}

object Weeks extends Like.Unit.Setup[Weeks]("week", 2) {

  @inline final def make(v: Long) = new Weeks(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Weeks ->
 *
 *     [[Weeks]] is a unit representing [[Duration]] of specified number of weeks.
 *
 *     Note: It does not implement [[Duration]] directly, but is implicitly converted to it.
 *
 * @object Weeks -> [[Weeks]] can be created by built-it constructor on Int type.
 *     {{{
 *       1.Week.lp      // Prints: 1 week
 *       3.Weeks.lp     // Prints: 3 weeks
 *       1000.Weeks.lp  // Prints: 1000 weeks
 *     }}}
 */
