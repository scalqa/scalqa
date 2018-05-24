package scalqa; package Numeric; package Z; package Math

import java.math.{ BigDecimal => JBig }

private[Numeric] object BigDecimal extends Math[JBig] {

  val isWhole = false

  val Zero = JBig.valueOf(0)
  val One = JBig.valueOf(1)
  val MinusOne = JBig.valueOf(-1)

  val sorting = new Sorting[JBig] { def position(x: JBig, y: JBig) = Sorting.Position.getByInt(x.compareTo(y)) }

  def add(n1: JBig, n2: JBig) = n1.add(n2)
  def subtract(n1: JBig, n2: JBig) = n1.subtract(n2)
  def divide(n1: JBig, n2: JBig) = n1.divide(n2)
  def multiply(n1: JBig, n2: JBig) = n1.multiply(n2)
  def remainder(n1: JBig, n2: JBig) = n1.remainder(n2)
  def negate(n: JBig): JBig = n.negate
  override def power(n: JBig, p: Int): JBig = n.pow(p)

  def apply(v: Int) = JBig.valueOf(v.toLong)
  def apply(v: Long) = JBig.valueOf(v.toLong)
  def apply(v: Double) = JBig.valueOf(v.toLong)
  def apply(v: Numeric) = v.I.letAs(classOf[BigDecimal]).map(_.real) or JBig.valueOf(v.toDouble)

  def toInt(v: JBig) = v.intValue
  def toLong(v: JBig) = v.longValue
  def toDouble(v: JBig) = v.doubleValue
  def toShort(v: JBig) = v.shortValue
  def toFloat(v: JBig) = v.floatValue
  def toChar(v: JBig) = v.intValue.toChar
  def toByte(v: JBig) = v.intValue.toByte

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/