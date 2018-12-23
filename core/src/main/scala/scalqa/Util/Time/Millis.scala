package scalqa; package Util; package Time

class Millis private[scalqa] (val real: Long) extends AnyVal with Like.Unit[Millis] with Time.Like.Core.A.Millis {
  protected def setup = Millis

  @inline final def totalMillis = real Millis

}

object Millis extends Like.Unit.Setup[Millis]("millis", 3) {

  @inline final def make(v: Long) = new Millis(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Millis ->
 *
 *     [[Millis]] is a unit representing [[Duration]] of specified number of milliseconds.
 *
 *     Note: It does not implement [[Duration]] directly, but is implicitly converted to it.
 */
