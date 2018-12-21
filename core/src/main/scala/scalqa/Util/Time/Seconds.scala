package scalqa; package Util; package Time

class Seconds private[scalqa] (val real: Long) extends AnyVal with Like.Unit[Seconds] with Time.Like.Core.A.Millis {
  protected def setup = Seconds

  @inline def totalMillis = Time.Z.MillisInOneSecond * real Millis

}

object Seconds extends Like.Unit.Setup[Seconds]("sec", 2) {

  @inline def make(v: Long) = new Seconds(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Seconds ->
 *
 *     [[Seconds]] is a unit representing [[Duration]] of specified number of seconds.
 *
 *     Note: It does not implement [[Duration]] directly, but is implicitly converted to it.
 *
 * @object Seconds -> [[Seconds]] can be created by built-it constructor on Int type.
 *     {{{
 *       1.Second.lp      // Prints: 1 sec
 *       3.Seconds.lp     // Prints: 3 secs
 *       1000.Seconds.lp  // Prints: 1000 secs
 *     }}}
 */
