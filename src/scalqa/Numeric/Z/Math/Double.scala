package scalqa; package Numeric; package Z; package Math

private[Numeric] object Double extends Math[Double] {

  val isWhole = false

  val Zero = 0D
  val One = 1D
  val MinusOne = -1D

  val sorting = Sorting.The.Double

  @inline def add(n1: Double, n2: Double) = n1 + n2
  @inline def subtract(n1: Double, n2: Double) = n1 - n2
  @inline def divide(n1: Double, n2: Double) = n1 / n2
  @inline def multiply(n1: Double, n2: Double) = n1 * n2
  @inline def remainder(n1: Double, n2: Double) = n1 % n2
  @inline def negate(n: Double): Double = -n

  @inline def apply(v: Int) = v.toDouble
  @inline def apply(v: Long) = v.toDouble
  @inline def apply(v: Double) = v.toDouble
  @inline def apply(v: Numeric) = v.toDouble

  @inline def toInt(v: Double) = v.toInt
  @inline def toLong(v: Double) = v.toLong
  @inline def toDouble(v: Double) = v.toDouble
  @inline def toShort(v: Double) = v.toShort
  @inline def toFloat(v: Double) = v.toFloat
  @inline def toChar(v: Double) = v.toChar
  @inline def toByte(v: Double) = v.toByte

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/