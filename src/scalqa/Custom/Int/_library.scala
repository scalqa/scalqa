package scalqa; package Custom; package Int

class _library private[scalqa] (private val real: Int) {

  def isVoid = real == 0

  def all: ~[Int] = real.Range.all

  def allUp: ~[Int] = Z.stream.up(real)

  def allDown: ~[Int] = Z.stream.down(real)

  def %@(v: Double) = Percent.make(real.toDouble / v * 100)
  def apply(p: Percent): Int = real * p.toDouble / 100 toInt
  def +(v: Percent): Int = real + apply(v)
  def -(v: Percent): Int = real - apply(v)

  def round(scale: Int, r: Custom.Rounding = \/) = r.scale(real.toDouble, scale).toInt

  def Range: Idx.Range = if (real > 0) Idx.Range.fromStartAndSize(0, real) else \/
  def Week: Util.Time.Weeks = Weeks
  def Weeks: Util.Time.Weeks = Util.Time.Weeks.make(real)
  def Year = scalqa.Year.make(real)
  def Number: java.lang.Integer = java.lang.Integer.valueOf(real)

  def <>(that: Int): Idx.Range = Idx.Range.fromStartAndSize(real, that - real + 1)
  def <>>(that: Int): Idx.Range = Idx.Range.fromStartAndSize(real, that - real)
  def <<>(that: Int): scalqa.Range[Int] = new Z.Range(real, true, that, false)
  def <<>>(that: Int): scalqa.Range[Int] = new Z.Range(real, true, that, true)
  def <>+(size: Int): Idx.Range = Idx.Range.fromStartAndSize(real, size + 1)
  def <>>+(size: Int): Idx.Range = Idx.Range.fromStartAndSize(real, size)
  def <>! : Idx.Range = Idx.Range.fromStartAndSize(real, 1)
  def <>>! : Idx.Range = Idx.Range.fromStartAndSize(real, 0)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def Range: ->  Creates range from 0 to `this` with exclusive end.
 *
 * @def Number -> "Int Number" constructor
 *
 *     Built-in constructor to create java.lang.Integer instances
 *
 * @def Year -> Year constructor
 *
 *     Built-in constructor to create [[Year]] instances
 *
 *     {{{
 *         2018.Year.lp        // Prints: 2018
 *         2018.Year.isLeap.lp // Prints: false
 *     }}}
 *
 * @def Weeks -> Weeks constructor
 *
 *     Built-in constructor to create [[Util.Time.Weeks]] instances
 *
 *     {{{ 11.Weeks.lp // Prints: 11 weeks}}}
 *
 * @def Week: -> Weeks constructor
 *
 *     Same as 'Weeks', but recommended for use with base 1
 *
 *     {{{ 1.Week.lp // Prints: 1 week}}}
 *
 * @def all: -> All in range
 *
 *   Creates a stream of Ints from 0 to `this` exclusive
 *
 *   {{{
 *     12.all lp // Prints:  ~(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
 *   }}}
 *
 * @def allUp -> Up stream
 *
 *   Creates a stream of elements from `this` to Int.MaxValue
 *
 *   Note. The stream usually is very large, so it should be extended with some restriction
 *
 *   {{{
 *     10.allUp.letNext(5) lp  // Prints: ~(10, 11, 12, 13, 14)
 *   }}}
 *
 * @def allDown -> Down stream
 *
 *   Creates a stream of elements from `this` to Int.MinValue
 *
 *   Note. The stream usually is very large, so it should be extended with some restriction
 *
 *   {{{
 *     0.allDown.letNext(5) lp // Prints: ~(0, -1, -2, -3, -4)
 *   }}}*
 */
