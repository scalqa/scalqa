package scalqa; package Time

class Gmt private (protected val real: Long) extends AnyVal with Any.Value.Long with Like with Like.Core.The.Millis {
  protected type THIS = Gmt
  protected type TARGET = Gmt

  protected def companion = Gmt

  protected def _totalMillis = value

  def toTime = Time.getByMillis(real)

  override def day = Day.getByIndex(real / Length.MillisOfDay toInt)

  override def dayTime: DayTime = DayTime.getByMillis(real % Length.MillisOfDay toInt)

  override def toString: String = day + " " + dayTime

  protected def _get(millis: Long) = new Gmt(millis)

}

object Gmt extends Any.Value.Long.Companion[Gmt] {

  protected def get(v: Long) = new Gmt(v)

  def getByMillis(m: Long) = get(m)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Gmt ->
 *
 *    [[Time.Gmt]] is same as [[Time]] without localization
 *
 *    {{{
 *      val time = Time.get
 *      val gmt = time.Gmt
 *
 *      time.dayTime.toBrief lp // Prints: 13:34
 *
 *      gmt.dayTime.toBrief lp  // Prints: 17:34
 *
 *      // Nevertheless they are data equal
 *
 *      (time === gmt) lp       // Prints: true
 * }}}
 */
