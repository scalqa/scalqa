package scalqa; package Any; package Datum.BigDecimal

import java.math.{ BigDecimal => JBig }

trait _use[TYPE <: _use[TYPE]] extends Any with Any.Datum.Comparable[TYPE, java.math.BigDecimal] {

  def abs: TYPE = make(real.abs)
  def signum: Int = real.signum
  def round(scale: Int, r: Custom.Rounding = \/) = make(real.setScale(scale, r.bigDecimalRound))

  def unary_- = make(real.negate)

  def *(v: TYPE): TYPE = make(real.multiply(v.real))
  def *(v: Double): TYPE = make(real.multiply(JBig.valueOf(v)))
  def *(v: Long): TYPE = make(real.multiply(JBig.valueOf(v)))

  def /(v: TYPE)(implicit r: Custom.Rounding = \/, s: Custom.Number.Scale = DEFAULT): TYPE = make { real.divide(v.real, s.value, r.bigDecimalRound) }
  def /(v: Double): TYPE = this./(make(JBig.valueOf(v)))
  def /(v: Long): TYPE = this./(make(JBig.valueOf(v)))

  def %(v: TYPE) = make(real.remainder(v.real))
  def %(v: Double): TYPE = make(real.remainder(JBig.valueOf(v)))
  def %(v: Long): TYPE = make(real.remainder(JBig.valueOf(v)))

  def +(v: TYPE): TYPE = make(real.add(v.real))
  def +(v: Double): TYPE = make(real.add(JBig.valueOf(v)))
  def +(v: Long): TYPE = make(real.add(JBig.valueOf(v)))
  def +(v: Percent, V: \/ = \/): TYPE = make(real.add(v(real)))

  def -(v: TYPE): TYPE = make(real.subtract(v.real))
  def -(v: Double): TYPE = make(real.subtract(JBig.valueOf(v)))
  def -(v: Long): TYPE = make(real.subtract(JBig.valueOf(v)))
  def -(v: Percent, V: \/ = \/): TYPE = make(real.subtract(v(real)))

  def apply(v: Percent): TYPE = make(v(real))
  def %@(v: TYPE): Percent = Percent.make(real, v.real)
  def %@(v: Double): Percent = Percent.make(real, JBig.valueOf(v))
  def %@(v: Long): Percent = Percent.make(real, JBig.valueOf(v))
}

private object _use {
  val Big100 = JBig.valueOf(100)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def signum -> Sign function
 *
 *     Returns -1 if `this` <  0
 *
 *     Returns  0 if `this` == 0
 *
 *     Returns  1 if `this` >  0 *
 *
 * @def round -> Round value
 *
 *     Negative `scale` specifies number of rounding digits before the period
 *
 *     Positive `scale` specifies number of rounding digits after the period
 *
 *      Note. Positive scale does not make sense if this is integral value
 *
 *      By default the rounding is done "half up'
 *
 * @def unary_- -> Negate
 *
 *     Returns a new value, which is negated `this`
 *
 * @def *(v: TYPE -> Multiply by
 *
 *     Returns a new value, which is `this` value multiplied by `v`
 *
 * @def /(v: TYPE -> Divide by
 *
 *     Returns a new value, which is `this` value divided by `v`
 *
 * @def %(v: TYPE -> Remainder
 *
 *     Returns a new value, which is remainder of `this` divided by `v`
 *
 * @def %@(v: TYPE) -> Percent At
 *
 *     Returns percentage of `this` compared to `v`
 *
 * @def %@(v: Double) -> Percent At
 *
 *     Returns percentage of `this` compared to `v`
 *
 */
