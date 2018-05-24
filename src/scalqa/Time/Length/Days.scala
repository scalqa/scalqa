package scalqa; package Time; package Length

class Days private (protected val real: Long) extends AnyVal with Z.Custom {
  protected override type THIS = Days
  protected def companion = Days

  private[Time] def _totalMillis = value * Length.MillisOfDay

}

object Days extends Z.Custom.Companion[Days]("day", 1) {

  def get(v: Long) = new Days(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Days ->
 *
 *     [[Days]] is a unit representing [[Time.Length]] of specified number of days.
 *
 *     Note: It does not implement [[Time.Length]] directly, but is implicitly converted to it.
 *
 * @object Days -> [[Days]] can be created by built-it constructor on [[Int]] type.
 *     {{{
 *       1.Day.lp      // Prints: 1 day
 *       3.Days.lp     // Prints: 3 days
 *       1000.Days.lp  // Prints: 1000 days
 *     }}}
 */
