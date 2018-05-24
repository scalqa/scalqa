package scalqa; package Numeric; package Z; package Math

private[Numeric] object Byte extends Math[Byte] {

  val isWhole = true

  val Zero = 0.toByte
  val One = 1.toByte
  val MinusOne = -1.toByte

  val sorting = Sorting.The.Byte

  @inline def add(n1: Byte, n2: Byte) = (n1 + n2).toByte
  @inline def subtract(n1: Byte, n2: Byte) = (n1 - n2).toByte
  @inline def divide(n1: Byte, n2: Byte) = (n1 / n2).toByte
  @inline def multiply(n1: Byte, n2: Byte) = (n1 * n2).toByte
  @inline def remainder(n1: Byte, n2: Byte) = (n1 % n2).toByte
  @inline def negate(n: Byte): Byte = (-n).toByte

  @inline def apply(v: Int) = v.toByte
  @inline def apply(v: Long) = v.toByte
  @inline def apply(v: Double) = v.toByte
  @inline def apply(v: Numeric) = v.toByte

  @inline def toInt(v: Byte) = v.toInt
  @inline def toLong(v: Byte) = v.toLong
  @inline def toDouble(v: Byte) = v.toDouble
  @inline def toShort(v: Byte) = v.toShort
  @inline def toFloat(v: Byte) = v.toFloat
  @inline def toChar(v: Byte) = v.toChar
  @inline def toByte(v: Byte) = v.toByte
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/