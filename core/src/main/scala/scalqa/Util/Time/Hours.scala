package scalqa; package Util; package Time

class Hours private[scalqa] (val real: Long) extends AnyVal with Like.Unit[Hours] with Time.Like.Core.A.Millis {
  protected def setup = Hours

  def totalMillis = Time.Z.MillisInOneHour * real Millis

}

object Hours extends Like.Unit.Setup[Hours]("hour", 2) {

  def make(v: Long) = new Hours(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Hours ->
 *
 *     [[Hours]] is a unit representing [[Duration]] of specified number of hours.
 *
 *     Note: It does not implement [[Duration]] directly, but is implicitly converted to it.
 *
 * @object Hours -> [[Hours]] can be created by built-it constructor on Int type.
 *     {{{
 *       1.Hour.lp      // Prints: 1 hour
 *       3.Hours.lp     // Prints: 3 hours
 *       1000.Hours.lp  // Prints: 1000 hours
 *     }}}
 */
