package scalqa; package Util; package Time

class Minutes private[scalqa] (val real: Long) extends AnyVal with Like.Unit[Minutes] with Time.Like.Core.A.Millis {
  protected def setup = Minutes

  @inline def totalMillis = Time.Z.MillisInOneMinute * real Millis

}
object Minutes extends Like.Unit.Setup[Minutes]("min", 2) {

  @inline def make(v: Long) = new Minutes(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Minutes ->
 *
 *     [[Minutes]] is a unit representing [[Duration]] of specified number of minutes.
 *
 *     Note: It does not implement [[Duration]] directly, but is implicitly converted to it.
 *
 * @object Minutes -> [[Minutes]] can be created by built-it constructor on Int type.
 *     {{{
 *       1.Minute.lp      // Prints: 1 min
 *       3.Minutes.lp     // Prints: 3 mins
 *       1000.Minutes.lp  // Prints: 1000 mins
 *     }}}
 */
