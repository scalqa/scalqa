package scalqa; package Custom; package Double

class _library private[scalqa] (private val real: Double) {

  def roundWholeUp: Double = Math.ceil(real)

  def roundWholeDown: Double = Math.floor(real) // it is different from toInt on negatives

  def round(scale: Int, r: Custom.Rounding = \/) = r.scale(real, scale)

  def %@(v: Double) = Util.Percent.make(real / v * 100)

  def apply(p: Percent): Double = real * p.toDouble / 100
  def +(v: Percent): Double = real + apply(v)
  def -(v: Percent): Double = real - apply(v)

  def Percent = Util.Percent.make(real)
  def Big = Util.BigDecimal.make(real)
  def Number: java.lang.Double = java.lang.Double.valueOf(real)

  def <>(that: Double): Range[Double] = new Z.Range(real, false, that, false)
  def <>>(that: Double): Range[Double] = new Z.Range(real, false, that, true)
  def <<>(that: Double): Range[Double] = new Z.Range(real, true, that, false)
  def <<>>(that: Double): Range[Double] = new Z.Range(real, true, that, true)
  def <>+(size: Int): Range[Double] = new Z.Range(real, false, real + size, false)
  def <>>+(size: Int): Range[Double] = new Z.Range(real, false, real + size, true)
  def <>! : Range[Double] = new Z.Range(real, false, real, false)
  def <>>! : Range[Double] = new Z.Range(real, false, real, true)
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def Percent -> Percent constructor
 *
 *     Built-in constructor to create [[Util.Percent Percent]] instances
 *
 *     {{{
 *         5.Percent lp      // Prints: 5.0%
 *
 *         100.0.Percent lp  // Prints: 100.0%
 *     }}}
 *
 *
 * @def Number -> "Double Number" constructor
 *
 *     Built-in constructor to create java.lang.Double instances *
 *
 *       * @def roundWholeUp -> Round up to integer
 *
 *     Rounds this Double up to the closest whole value
 *
 *     See [[https://docs.oracle.com/javase/7/docs/api/java/lang/Math.html#ceil(double) java.Math.ceil]] for details
 *     {{{
 *       11.566.roundWholeUp lp   // Prints: 12.0
 *     }}}
 *
 *
 * @def roundWholeDown -> Round down to integer
 *
 *     Rounds this Double down to the closest whole value
 *
 *     See [[https://docs.oracle.com/javase/7/docs/api/java/lang/Math.html#floor(double) java.Math.floor]] for details
 *     {{{
 *        11.566.roundWholeDown lp   // Prints: 12.0
 *
 *       -11.566.roundWholeDown lp   // Prints: -12.0
 *     }}}
 */
