package scalqa; package Numeric; package Z; package Math

private[Numeric] object Long extends Math[Long] {

  val isWhole = true

  val Zero = 0L
  val One = 1L
  val MinusOne = -1L

  val sorting = Sorting.The.Long

  @inline def Max = scalqa.Long.Max
  @inline def Min = scalqa.Long.Min

  @inline def add(n1: Long, n2: Long) = n1 + n2
  @inline def subtract(n1: Long, n2: Long) = n1 - n2
  @inline def divide(n1: Long, n2: Long) = n1 / n2
  @inline def multiply(n1: Long, n2: Long) = n1 * n2
  @inline def remainder(n1: Long, n2: Long) = n1 % n2
  @inline def negate(n: Long): Long = -n

  @inline def apply(v: Int) = v.toLong
  @inline def apply(v: Long) = v.toLong
  @inline def apply(v: Double) = v.toLong
  @inline def apply(v: Numeric) = v.toLong

  @inline def toInt(v: Long) = v.toInt
  @inline def toLong(v: Long) = v.toLong
  @inline def toDouble(v: Long) = v.toDouble
  @inline def toShort(v: Long) = v.toShort
  @inline def toFloat(v: Long) = v.toFloat
  @inline def toChar(v: Long) = v.toChar
  @inline def toByte(v: Long) = v.toByte

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/