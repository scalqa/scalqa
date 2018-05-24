package scalqa; package Time; package Length

class Seconds private (protected val real: Long) extends AnyVal with Z.Custom {
  protected override type THIS = Seconds
  protected def companion = Seconds

  private[Time] def _totalMillis = value * Length.MillisOfSecond

}

object Seconds extends Z.Custom.Companion[Seconds]("sec") {

  def get(v: Long) = new Seconds(v)

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
 *     [[Seconds]] is a unit representing [[Time.Length]] of specified number of seconds.
 *
 *     Note: It does not implement [[Time.Length]] directly, but is implicitly converted to it.
 *
 * @object Seconds -> [[Seconds]] can be created by built-it constructor on [[Int]] type.
 *     {{{
 *       1.Second.lp      // Prints: 1 sec
 *       3.Seconds.lp     // Prints: 3 secs
 *       1000.Seconds.lp  // Prints: 1000 secs
 *     }}}
 */
