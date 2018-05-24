package scalqa; package Time; package Length

class Minutes private (protected val real: Long) extends AnyVal with Z.Custom {
  protected override type THIS = Minutes
  protected def companion = Minutes

  private[Time] def _totalMillis = value * Length.MillisOfMinute

}

object Minutes extends Z.Custom.Companion[Minutes]("min") {

  def get(v: Long) = new Minutes(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Minutes ->
 *
 *     [[Minutes]] is a unit representing [[Time.Length]] of specified number of minutes.
 *
 *     Note: It does not implement [[Time.Length]] directly, but is implicitly converted to it.
 *
 * @object Minutes -> [[Minutes]] can be created by built-it constructor on [[Int]] type.
 *     {{{
 *       1.Minute.lp      // Prints: 1 min
 *       3.Minutes.lp     // Prints: 3 mins
 *       1000.Minutes.lp  // Prints: 1000 mins
 *     }}}
 */
