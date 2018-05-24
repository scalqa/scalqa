package scalqa; package Numeric; package Z; package Math

private[Numeric] object Short extends Math[Short] {

  val isWhole = true

  val Zero = 0.toShort
  val One = 1.toShort
  val MinusOne = -1.toShort

  val sorting = Sorting.The.Short

  @inline def Max = scalqa.Short.Max
  @inline def Min = scalqa.Short.Min

  @inline def add(n1: Short, n2: Short) = (n1 + n2).toShort
  @inline def subtract(n1: Short, n2: Short) = (n1 - n2).toShort
  @inline def divide(n1: Short, n2: Short) = (n1 / n2).toShort
  @inline def multiply(n1: Short, n2: Short) = (n1 * n2).toShort
  @inline def remainder(n1: Short, n2: Short) = (n1 % n2).toShort
  @inline def negate(n: Short): Short = (-n).toShort

  @inline def apply(v: Int) = v.toShort
  @inline def apply(v: Long) = v.toShort
  @inline def apply(v: Double) = v.toShort
  @inline def apply(v: Numeric) = v.toShort

  @inline def toInt(v: Short) = v.toInt
  @inline def toLong(v: Short) = v.toLong
  @inline def toDouble(v: Short) = v.toDouble
  @inline def toShort(v: Short) = v.toShort
  @inline def toFloat(v: Short) = v.toFloat
  @inline def toChar(v: Short) = v.toChar
  @inline def toByte(v: Short) = v.toByte

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/