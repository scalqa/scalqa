package scalqa; package Numeric; package Z; package Math

private[Numeric] object Char extends Math[Char] {

  val isWhole = true

  val Zero = 0.toChar
  val One = 1.toChar
  val MinusOne = -1.toChar

  val sorting = Sorting.The.Char

  @inline def add(n1: Char, n2: Char) = (n1 + n2).toChar
  @inline def subtract(n1: Char, n2: Char) = (n1 - n2).toChar
  @inline def divide(n1: Char, n2: Char) = (n1 / n2).toChar
  @inline def multiply(n1: Char, n2: Char) = (n1 * n2).toChar
  @inline def remainder(n1: Char, n2: Char) = (n1 % n2).toChar
  @inline def negate(n: Char): Char = (-n).toChar

  @inline def apply(v: Int) = v.toChar
  @inline def apply(v: Long) = v.toChar
  @inline def apply(v: Double) = v.toChar
  @inline def apply(v: Numeric) = v.toChar

  @inline def toInt(v: Char) = v.toInt
  @inline def toLong(v: Char) = v.toLong
  @inline def toDouble(v: Char) = v.toDouble
  @inline def toShort(v: Char) = v.toShort
  @inline def toFloat(v: Char) = v.toFloat
  @inline def toChar(v: Char) = v.toChar
  @inline def toByte(v: Char) = v.toByte
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/