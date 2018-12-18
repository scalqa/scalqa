package scalqa; package Custom; package Long

class _library private[scalqa] (private val real: Long) extends AnyVal {

  def isVoid = real == 0L

  def allUp: ~[Long] = new Z.stream.Up(real)

  def allDown: ~[Long] = new Z.stream.Down(real)

  def toBrief: String =
    if (real >= Util.OneTrillion) (real * 10 / Util.OneTrillion / 10D) + "t"
    else if (real >= Util.OneBillion) (real * 10 / Util.OneBillion / 10D) + "g"
    else if (real >= Util.OneMillion) (real * 10 / Util.OneMillion / 10D) + "m"
    else if (real >= Util.OneThousand) (real * 10 / Util.OneThousand / 10D) + "k"
    else "" + real

  def %@(v: Double) = Percent.make(real / v * 100)
  def apply(p: Percent) = real * p.toDouble / 100 toLong
  def +(v: Percent) = real + apply(v) toLong
  def -(v: Percent) = real - apply(v) toLong

  def round(scale: Int, r: Custom.Rounding = \/) = r.scale(real.toDouble, scale).toLong
  def Minute: Util.Time.Minutes = Minutes
  def Minutes: Util.Time.Minutes = Util.Time.Minutes.make(real)

  def Hour: Util.Time.Hours = Hours
  def Hours: Util.Time.Hours = Util.Time.Hours.make(real)

  def Day: Util.Time.Days = Days
  def Days: Util.Time.Days = Util.Time.Days.make(real)

  def Second: Util.Time.Seconds = Seconds
  def Seconds: Util.Time.Seconds = Util.Time.Seconds.make(real)

  def Millis = Util.Time.Millis.make(real)

  def Micros = Util.Time.Micros.make(real)

  def Nanos = Util.Time.Nanos.make(real)

  def Number: java.lang.Long = java.lang.Long.valueOf(real)

  def Big = Util.BigInteger.make(real)

  def <>(that: Long): Range[Long] = new Z.Range(real, false, that, false)
  def <>>(that: Long): Range[Long] = new Z.Range(real, false, that, true)
  def <<>(that: Long): Range[Long] = new Z.Range(real, true, that, false)
  def <<>>(that: Long): Range[Long] = new Z.Range(real, true, that, true)
  def <>+(size: Int): Range[Long] = new Z.Range(real, false, real + size, false)
  def <>>+(size: Int): Range[Long] = new Z.Range(real, false, real + size, true)
  def <>! : Range[Long] = new Z.Range(real, false, real, false)
  def <>>! : Range[Long] = new Z.Range(real, false, real, true)
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def allUp -> Up stream
 *
 *   Creates a stream of elements from `this` to Long.MaxValue
 *
 *   Note. The stream usually is huge, so it should be extended with some restriction.
 *
 *   {{{
 *     10L.allUp.letNext(5).lp
 *     // Output
 *     ~(10, 11, 12, 13, 14)
 *   }}}
 *
 * @def allDown -> Down stream
 *
 *   Creates a stream of elements from `this` to Long.MinValue
 *
 *   Note. The stream usually is huge, so it should be extended with some restriction.
 *
 *   {{{
 *     0L.allDown.letNext(5).lp
 *     // Output
 *     ~(0, -1, -2, -3, -4)
 *   }}}
 *
 *      * @def Number -> "Long Number" constructor
 *
 *     Built-in constructor to create java.lang.Long instances
 *
 * @def Days -> Days constructor
 *
 *     Built-in constructor to create [[Util.Time.Days]] instances
 *
 *     {{{ 11.Days.lp // Prints: 11 days}}}
 *
 * @def Day: -> Days constructor
 *
 *     Same as 'Days', but recommended for use with base 1
 *
 *     {{{ 1.Day.lp // Prints: 1 day}}}
 *
 * @def Hours -> Hours constructor
 *
 *     Built-in constructor to create [[Util.Time.Hours]] instances
 *
 *     {{{ 11.Hours.lp // Prints: 11 hours}}}
 *
 * @def Hour: -> Hours constructor
 *
 *     Same as 'Hours', but recommended for use with base 1
 *
 *     {{{ 1.Hour.lp // Prints: 1 hour}}}
 *
 * @def Minutes -> Minutes constructor
 *
 *     Built-in constructor to create [[Util.Time.Minutes]] instances
 *
 *     {{{ 11.Minutes.lp // Prints: 11 mins}}}
 *
 * @def Minute: -> Minutes constructor
 *
 *     Same as 'Minutes', but recommended for use with base 1
 *
 *     {{{ 1.Minute.lp // Prints: 1 min}}}
 *
 * @def Seconds -> Seconds constructor
 *
 *     Built-in constructor to create [[Util.Time.Seconds]] instances
 *
 *     {{{ 11.Seconds.lp // Prints: 11 secs}}}
 *
 * @def Second: -> Seconds constructor
 *
 *     Same as 'Seconds', but recommended for use with base 1
 *
 *     {{{ 1.Second.lp // Prints: 1 sec}}}
 *
 * @def Millis -> Millis constructor
 *
 *     Built-in constructor to create [[Util.Time.Millis]] instances
 *
 *     {{{ 99.Millis.lp // Prints: 99 millis}}}
 *
 * @def Micros -> Micros constructor
 *
 *     Built-in constructor to create [[Util.Time.Micros]] instances
 *
 *     {{{ 99.Micros.lp // Prints: 99 micros}}}
 *
 * @def Nanos -> Nanos constructor
 *
 *     Built-in constructor to create [[Util.Time.Nanos]] instances
 *
 *     {{{ 99.Nanos.lp // Prints: 99 nanos}}}
 *
 *
 */
