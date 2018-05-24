package scalqa; package Numeric; package Z; package Math

private[Numeric] object Int extends Math[Int] {

  val isWhole = true

  val Zero = 0
  val One = 1
  val MinusOne = -1

  val sorting = Sorting.The.Int

  @inline def add(n1: Int, n2: Int) = n1 + n2
  @inline def subtract(n1: Int, n2: Int) = n1 - n2
  @inline def divide(n1: Int, n2: Int) = n1 / n2
  @inline def multiply(n1: Int, n2: Int) = n1 * n2
  @inline def remainder(n1: Int, n2: Int) = n1 % n2
  @inline def negate(n: Int): Int = -n

  @inline def apply(v: Int) = v.toInt
  @inline def apply(v: Long) = v.toInt
  @inline def apply(v: Double) = v.toInt
  @inline def apply(v: Numeric) = v.toInt

  @inline def toInt(v: Int) = v.toInt
  @inline def toLong(v: Int) = v.toLong
  @inline def toDouble(v: Int) = v.toDouble
  @inline def toShort(v: Int) = v.toShort
  @inline def toFloat(v: Int) = v.toFloat
  @inline def toChar(v: Int) = v.toChar
  @inline def toByte(v: Int) = v.toByte
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/