package scalqa; package Any; package Datum.Z.Number

private[scalqa] trait Use[TYPE] extends Any {

  def signum: Int

  def round(scale: Int, r: Custom.Rounding = \/): TYPE

  def unary_- : TYPE

  def *(v: TYPE): TYPE

  def /(v: TYPE): TYPE

  def %(v: TYPE): TYPE

  def %@(v: TYPE): Percent

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
 * @def %@ -> Percent At
 *
 *     Returns percentage of `this` compared to `v`
 */
