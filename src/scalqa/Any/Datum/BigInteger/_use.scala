package scalqa; package Any; package Datum.BigInteger

import java.math.{ BigInteger => JBig, BigDecimal }

trait _use[TYPE <: _use[TYPE]] extends Any with Any.Datum.Comparable[TYPE, java.math.BigInteger] with Any.Datum.Z.Number.Use[TYPE] {

  def abs: TYPE = make(real.abs)
  def signum: Int = real.signum
  def round(scale: Int, r: Custom.Rounding = \/) = make(Util.BigDecimal.make(new BigDecimal(real)).round(scale, r).real.toBigInteger)

  def unary_- = make(real.negate)

  def *(v: TYPE): TYPE = make(real.multiply(v.real))
  def *(v: Long): TYPE = make(real.multiply(JBig.valueOf(v)))

  def /(v: TYPE) = make(real.divide(v.real))
  def /(v: Long): TYPE = make(real.divide(JBig.valueOf(v)))

  def %(v: TYPE) = make(real.remainder(v.real))
  def %(v: Long): TYPE = make(real.remainder(JBig.valueOf(v)))

  def +(v: TYPE): TYPE = make(real.add(v.real))
  def +(v: Long): TYPE = make(real.add(JBig.valueOf(v)))
  def +(v: Percent, V: \/ = \/): TYPE = make(real.add(apply(v).real))

  def -(v: TYPE): TYPE = make(real.subtract(v.real))
  def -(v: Long): TYPE = make(real.subtract(JBig.valueOf(v)))
  def -(v: Percent, V: \/ = \/): TYPE = make(real.subtract(apply(v).real))

  def apply(v: Percent): TYPE = make(v(new BigDecimal(real)).toBigInteger)
  def %@(v: TYPE): Percent = Percent.make(new BigDecimal(real), new BigDecimal(v.real))
  def %@(v: Double): Percent = Percent.make(new BigDecimal(real), BigDecimal.valueOf(v))
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
