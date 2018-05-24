package scalqa; package Time

package object Precise {
  private lazy val clock = java.time.Clock.systemUTC

  def get: Precise = get(clock.instant)

  def get(seconds: Time.Length.Seconds, nanos: Time.Length.Nanos): Precise = new Precise(seconds + nanos / Long.OneBillion, nanos % Long.OneBillion toInt)

  def get(t: Time, micros: Time.Length.Micros, nanos: Time.Length.Nanos = 0): Precise = get(t.totalSeconds, t.subMillis * Long.OneMillion + micros * Long.OneThousand + nanos toInt)

  def get(i: java.time.Instant): Precise = new Precise(i.getEpochSecond, i.getNano)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def get: -> Current precise time.
 *
 *   Getting instant from java.time.Clock.systemUTC.instant
 *
 *   {{{
 *       // Tried
 *       Time.Precise.get.lp
 *       // Printed no micros or nanos
 *       2018-04-09 16:45:11.468.000.000
 *       // Apparently not every JVM supports precise clock.
 *  }}}
 *
 * @def get(t -> By time and extras.
 *
 *   {{{
 *       val d = Day.get(1995,4,6)
 *       val t = Time.get(d, 4.Hours, 30.Minutes)
 *       Time.Precise.get(t, 0, 22).lp // Prints: 1995-04-06 04:30:00.000.000.022
 *       Time.Precise.get(t, 100).lp   // Prints: 1995-04-06 04:30:00.000.100.000
 *   }}}
 *
 * @def get(i -> By instant
 *
 *   Time by java.time.Instant
 */
