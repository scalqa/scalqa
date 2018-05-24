package scalqa; package Time; package Length

class Micros private (protected val real: Long) extends AnyVal with Z.Custom {
  protected override type THIS = Micros
  protected def companion = Micros

  private[Time] def _totalMillis = value / 1000
  private[Time] override def _totalSeconds = value / 1000000
  private[Time] override def _preciseNanos = ((value % 1000000) * 1000).toInt
}

object Micros extends Z.Custom.Companion[Micros]("micros", 3) {

  def get(v: Long) = new Micros(v)

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
 *     [[Micros]] is a unit representing [[Time.Length]] of specified number of microseconds.
 *
 *     Note: It does not implement [[Time.Length]] directly, but is implicitly converted to it.
 *
 * @object Micros -> [[Micros]] can be created by built-it constructor on [[Int]] type.
 *     {{{
 *       1.Micros.lp     // Prints: 1 micros
 *       3.Micros.lp     // Prints: 3 micros
 *       5000.Micros.lp  // Prints: 5000 micros
 *     }}}
 */
