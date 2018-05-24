package scalqa; package Time; package Length

class Weeks private (protected val real: Long) extends AnyVal with Z.Custom {
  protected override type THIS = Weeks
  protected def companion = Weeks

  private[Time] def _totalMillis = value * Length.MillisOfWeek

}

object Weeks extends Z.Custom.Companion[Weeks]("week") {

  def get(v: Long) = new Weeks(v)

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
 *     [[Weeks]] is a unit representing [[Time.Length]] of specified number of weeks.
 *
 *     Note: It does not implement [[Time.Length]] directly, but is implicitly converted to it.
 *
 * @object Weeks -> [[Weeks]] can be created by built-it constructor on [[Int]] type.
 *     {{{
 *       1.Week.lp      // Prints: 1 week
 *       3.Weeks.lp     // Prints: 3 weeks
 *       1000.Weeks.lp  // Prints: 1000 weeks
 *     }}}
 */
