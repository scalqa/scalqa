package scalqa; package Any; package Datum.Byte; package Number

trait _use[TYPE <: _use[TYPE]] extends Any with Computable[TYPE] with Any.Datum.Z.Number.Use[TYPE] {

  def signum: Int = real.signum
  def unary_- = make(real.unary_- toByte)

  def *(v: TYPE) = make(real * v.real toByte)
  def /(v: TYPE) = make(real / v.real toByte)
  def %(v: TYPE) = make(real % v.real toByte)

  def %@(v: Double) = Percent.make(real / v * 100)

  def +(v: Byte) = make(real + v toByte)
  def -(v: Byte) = make(real - v toByte)
  def %(v: Byte) = make(real % v toByte)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def +(v: Byte -> Add value
 *
 *     Returns a new value, which is an addition of `this` and `v`
 *
 * @def -(v: Byte -> Subtract value
 *
 *     Returns a new value, which is a subtraction of `v` from `this`
 *
 * @def %(v: Byte -> Remainder
 *
 *     Returns a new value, which is remainder of `this` divided by `v`
 */
