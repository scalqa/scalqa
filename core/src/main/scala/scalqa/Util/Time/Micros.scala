package scalqa; package Util; package Time

class Micros private[scalqa] (val real: Long) extends AnyVal with Like.Unit[Micros] with Time.Like.Core.A.Nanos {
  protected def setup = Micros

  def totalNanos = real * 1000 Nanos

}

object Micros extends Like.Unit.Setup[Micros]("micros", 3) {

  def make(v: Long) = new Micros(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Micros ->
 *
 *     [[Micros]] is a unit representing [[Duration]] of specified number of microseconds.
 *
 *     Note: It does not implement [[Duration]] directly, but is implicitly converted to it.
 *
 * @object Micros -> [[Micros]] can be created by built-it constructor on Int type.
 *     {{{
 *       1.Micros.lp     // Prints: 1 micros
 *       3.Micros.lp     // Prints: 3 micros
 *       5000.Micros.lp  // Prints: 5000 micros
 *     }}}
 */
