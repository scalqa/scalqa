package scalqa; package Util; package Time

class Gmt private[scalqa] (protected val real: Long) extends AnyVal with Like[Gmt] with Like.Core.A.Millis with Any.Datum.Long.Ordered[Gmt] {
  protected def setup = Gmt

  def totalMillis = real.Millis

  def toTime = Time.fromMillis(real)

  override def day = Day.fromIndex(totalMillis / Z.MillisInOneDay toInt)

  override def dayTime: DayTime = DayTime.fromMillis(totalMillis % Z.MillisInOneDay toInt)

  def round(l: Duration, r: Custom.Rounding = \/): Gmt = make(r.remainder(totalMillis.real, l.totalMillis.real))

  def +(l: Duration) = make(totalMillis.real + l.totalMillis.real)
  def +~(v: ~[Duration]) = make(v.foldAs(totalMillis.real)(_ + _.totalMillis.real))

  def -(l: Duration) = make(totalMillis.real - l.totalMillis.real)
  def -~(v: ~[Duration]) = make(v.map(_.totalMillis.real).fold(totalMillis.real)(_ - _))

  override def toString = day +- dayTime
}

object Gmt extends Any.Datum.Long.Ordered.Setup[Gmt] {

  protected def make(v: Long) = new Gmt(v)

  def fromMillis(v: Long) = new Gmt(v)

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
 *      val time = Time.now
 *      val gmt = time.Gmt
 *
 *      time.dayTime.brief lp // Prints: 13:34
 *
 *      gmt.dayTime.brief lp  // Prints: 17:34
 *
 *      // Nevertheless they are data equal
 *
 *      (time.real == gmt.real) lp       // Prints: true
 * }}}
 */
