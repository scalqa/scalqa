package scalqa; package Time

package object DayTime {
  private[scalqa] def This = this

  val Min = get(0);
  val Max = get(23, 59, 59, 999)

  def get: DayTime = Time.get.dayTime

  def get(h: Length.Hours, m: Length.Minutes = 0, s: Length.Seconds = 0, l: Length.Millis = 0): DayTime = getByMillis(0L + h.length.totalMillis + m.length.totalMillis + s.length.totalMillis + l.length.totalMillis)

  def getParse(s: String): DayTime = Z.format.parse(s)

  def get(unit: Length, more: Length*): DayTime = getByMillis(more.all.map(_.totalMillis.toLong).fold(unit.totalMillis.toLong, _ + _))

  def getByMillis(m: Long): DayTime = { val v = m % Length.MillisOfDay; val ms = if (v >= 0) v else Length.MillisOfDay + v; new DayTime(ms.toInt) }

  def currentPro(changeEvery: Time.Length): Pro.O[DayTime] = Time.currentPro(changeEvery).asMap(_.dayTime)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @val Min -> Minimal value.
 *   {{{ DayTime.Min.lp // Prints: 0:00 }}}
 *
 * @val Max -> Maximum value.
 *   {{{ DayTime.Max.lp // Prints: 23:59:59.999 }}}
 *
 *
 * @def get: -> Current DayTime.
 *
 * @def get(h: -> By standard units.
 *
 *   {{{
 *       DayTime.get(10,45,33).lp    // Prints: 10:45:33
 *       DayTime.get(10,0,21,90).lp  // Prints: 10:00:21.090
 *   }}}
 *
 * @def get(unit: -> By generic units.
 *
 *   Creates [[DayTime]] specified by one or more [Time.Length]s in any order.
 *
 *   {{{
 *       DayTime.get(10.Hours, 15.Seconds).lp             // Prints: 10:00:15
 *       DayTime.get(10.Hours, 15.Seconds, 45.Minutes).lp // Prints: 10:45:15
 *   }}}
 *
 * @def getByMillis -> By milliseconds.
 *
 *     Creates a [[DayTime]] by total milliseconds.
 *
 *     If ''value'' exceeds the whole day, the day divided remainder will be used.
 *
 *     If ''value'' is negative, [[DayTime]] down from Max value is taken.
 *
 *   {{{
 *       DayTime.getByMillis(10001).lp  // Prints: 0:00:10.001
 *       DayTime.getByMillis(-10001).lp // Prints: 23:59:49.999
 *   }}}
 *
 */
