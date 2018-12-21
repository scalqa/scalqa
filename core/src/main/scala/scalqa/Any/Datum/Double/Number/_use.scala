package scalqa; package Any; package Datum.Double; package Number

trait _use[TYPE <: _use[TYPE]] extends Any with Computable[TYPE] with Any.Datum.Z.Number.Use[TYPE] {

  def signum: Int = real.signum
  def round(scale: Int, r: Custom.Rounding = \/) = make(r.scale(real, scale))
  def unary_- = make(real.unary_-)

  def *(v: TYPE) = make(real * v.real)
  def /(v: TYPE) = make(real / v.real)
  def %(v: TYPE) = make(real % v.real)

  def %@(v: Double) = Percent.make(real / v * 100)

  def +(v: Int) = make(real + v)
  def +(v: Long) = make(real + v)
  def +(v: Float) = make(real + v)
  def +(v: Double) = make(real + v)

  def -(v: Int) = make(real - v)
  def -(v: Long) = make(real - v)
  def -(v: Float) = make(real - v)
  def -(v: Double) = make(real - v)

  def %(v: Int) = make(real % v)
  def %(v: Long) = make(real % v)
  def %(v: Float) = make(real % v)
  def %(v: Double) = make(real % v)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def +(v: Int -> Add value
 *
 *     Returns a new value, which is an addition of `this` and `v`
 *
 * @def +(v: Long -> Add value
 *
 *     Returns a new value, which is an addition of `this` and `v`
 *
 * @def +(v: Float -> Add value
 *
 *     Returns a new value, which is an addition of `this` and `v`
 *
 * @def +(v: Double -> Add value
 *
 *     Returns a new value, which is an addition of `this` and `v`
 *
 * @def -(v: Int -> Subtract value
 *
 *     Returns a new value, which is a subtraction of `v` from `this`
 *
 * @def -(v: Long -> Subtract value
 *
 *     Returns a new value, which is a subtraction of `v` from `this`
 *
 * @def -(v: Float -> Subtract value
 *
 *     Returns a new value, which is a subtraction of `v` from `this`
 *
 * @def -(v: Double -> Subtract value
 *
 *     Returns a new value, which is a subtraction of `v` from `this`
 *
 * @def %(v: Int -> Remainder
 *
 *     Returns a new value, which is remainder of `this` divided by `v`
 *
 * @def %(v: Long -> Remainder
 *
 *     Returns a new value, which is remainder of `this` divided by `v`
 *
 * @def %(v: Float -> Remainder
 *
 *     Returns a new value, which is remainder of `this` divided by `v`
 *
 * @def %(v: Double -> Remainder
 *
 *     Returns a new value, which is remainder of `this` divided by `v`
 */
