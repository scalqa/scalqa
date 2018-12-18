package scalqa; package Any; package Datum.Short; package Computable

trait _Trait[TYPE <: _Trait[TYPE]] extends Any with Ordered._Trait[TYPE] with Any.Datum.Z.Computable[TYPE] {
  protected def setup: Setup[TYPE]

  def abs: TYPE = make(real.abs)

  def +(v: TYPE, V: \/ = \/) = make(real + v.real toByte)
  def +(p: Percent) = make(real + real(p) toByte)

  def -(v: TYPE, V: \/ = \/) = make(real - v.real toByte)
  def -(p: Percent) = make(real - real(p) toByte)

  def %@(v: TYPE) = Percent.make(real.toDouble / v.real * 100)

  def *(v: Short) = make(real * v toByte)
  def /(v: Short) = make(real / v toByte)
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def *(v: Short -> Multiply by
 *
 *     Returns a new value, which is `this` value multiplied by `v`
 *
 * @def /(v: Short -> Divide by
 *
 *     Returns a new value, which is `this` value divided by `v`
 */
