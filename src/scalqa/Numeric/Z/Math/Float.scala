package scalqa; package Numeric; package Z; package Math

private[Numeric] object Float extends Math[Float] {

  val isWhole = false

  val Zero = 0F
  val One = 1F
  val MinusOne = -1F

  val sorting = Sorting.The.Float

  @inline def add(n1: Float, n2: Float) = n1 + n2
  @inline def subtract(n1: Float, n2: Float) = n1 - n2
  @inline def divide(n1: Float, n2: Float) = n1 / n2
  @inline def multiply(n1: Float, n2: Float) = n1 * n2
  @inline def remainder(n1: Float, n2: Float) = n1 % n2
  @inline def negate(n: Float): Float = -n

  @inline def apply(v: Int) = v.toFloat
  @inline def apply(v: Long) = v.toFloat
  @inline def apply(v: Double) = v.toFloat
  @inline def apply(v: Numeric) = v.toFloat

  @inline def toInt(v: Float) = v.toInt
  @inline def toLong(v: Float) = v.toLong
  @inline def toDouble(v: Float) = v.toDouble
  @inline def toShort(v: Float) = v.toShort
  @inline def toFloat(v: Float) = v.toFloat
  @inline def toChar(v: Float) = v.toChar
  @inline def toByte(v: Float) = v.toByte

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/