package scalqa; package Util; package Time

class Nanos private[scalqa] (val real: Long) extends AnyVal with Like.Unit[Nanos] with Time.Like.Core.A.Nanos {
  protected def setup = Nanos

  @inline final def totalNanos = real Nanos

}

object Nanos extends Like.Unit.Setup[Nanos]("nanos", 3) {

  @inline final def make(v: Long) = new Nanos(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Nanos ->
 *
 *     [[Nanos]] is a unit representing [[Duration]] of specified number of nanoseconds.
 *
 *     Note: It does not implement [[Duration]] directly, but is implicitly converted to it.
 *
 * @object Nanos -> [[Nanos]] can be created by built-it constructor on Int type.
 *     {{{
 *       1.Nanos.lp     // Prints: 1 nanos
 *       3.Nanos.lp     // Prints: 3 nanos
 *       5000.Nanos.lp  // Prints: 5000 nanos
 *     }}}
 */
