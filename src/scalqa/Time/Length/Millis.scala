package scalqa; package Time; package Length

class Millis private[Millis] (protected val real: Long) extends AnyVal with Z.Custom {
  protected override type THIS = Millis

  protected def companion = Millis

  private[Time] def _totalMillis = value
  private[Time] override def _preciseNanos = (_totalMillis % 1000 * Long.OneMillion).toInt

}

object Millis extends Z.Custom.Companion[Millis]("millis", 3) {

  def get(v: Long) = new Millis(v)

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
 *     [[Millis]] is a unit representing [[Time.Length]] of specified number of milliseconds.
 *
 *     Note: It does not implement [[Time.Length]] directly, but is implicitly converted to it.
 *
 * @object Millis -> [[Millis]] can be created by built-it constructor on [[Int]] type.
 *     {{{
 *       1.Millis.lp     // Prints: 1 millis
 *       3.Millis.lp     // Prints: 3 millis
 *       5000.Millis.lp  // Prints: 5000 millis
 *     }}}
 */
