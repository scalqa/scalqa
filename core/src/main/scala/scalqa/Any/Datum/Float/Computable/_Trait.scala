package scalqa; package Any; package Datum.Float; package Computable

trait _Trait[TYPE <: Computable[TYPE]] extends Any with Ordered[TYPE] with Any.Datum.Z.Computable[TYPE] {
  protected def setup: Setup[TYPE]

  def abs: TYPE = make(real.abs)

  def +(v: TYPE, V: \/ = \/) = make(real + v.real)
  def +(p: Percent) = make(real + real(p))

  def -(v: TYPE, V: \/ = \/) = make(real - v.real)
  def -(p: Percent) = make(real - real(p))

  def %@(v: TYPE) = Percent.make(real.toDouble / v.real * 100)

  def *(v: Int) = make(real * v)
  def *(v: Float) = make(real * v)

  def /(v: Int) = make(real / v)
  def /(v: Float) = make(real / v)
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def *(v: Int) -> Multiply by
 *
 *     Returns a new value, which is `this` value multiplied by `v`
 *
 * @def *(v: Float) -> Multiply by
 *
 *     Returns a new value, which is `this` value multiplied by `v`
 *
 * @def /(v: Int) -> Divide by
 *
 *     Returns a new value, which is `this` value divided by `v`
 *
 * @def /(v: Float) -> Divide by
 *
 *     Returns a new value, which is `this` value divided by `v`
 */