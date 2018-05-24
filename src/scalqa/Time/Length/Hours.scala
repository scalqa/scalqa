package scalqa; package Time; package Length

class Hours private (protected val real: Long) extends AnyVal with Z.Custom {
  protected override type THIS = Hours
  protected def companion = Hours

  private[Time] def _totalMillis = value * Length.MillisOfHour

}

object Hours extends Z.Custom.Companion[Hours]("hour") {

  def get(v: Long) = new Hours(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Hours ->
 *
 *     [[Hours]] is a unit representing [[Time.Length]] of specified number of hours.
 *
 *     Note: It does not implement [[Time.Length]] directly, but is implicitly converted to it.
 *
 * @object Hours -> [[Hours]] can be created by built-it constructor on [[Int]] type.
 *     {{{
 *       1.Hour.lp      // Prints: 1 hour
 *       3.Hours.lp     // Prints: 3 hours
 *       1000.Hours.lp  // Prints: 1000 hours
 *     }}}
 */
