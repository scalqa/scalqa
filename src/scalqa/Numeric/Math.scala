package scalqa; package Numeric

abstract class Math[VAL] protected {

  val isWhole: Boolean

  val One: VAL
  val MinusOne: VAL
  val Zero: VAL

  val sorting: Sorting[VAL]

  def add(n1: VAL, n2: VAL): VAL
  def subtract(n1: VAL, n2: VAL): VAL
  def divide(n1: VAL, n2: VAL): VAL
  def multiply(n1: VAL, n2: VAL): VAL
  def remainder(n1: VAL, n2: VAL): VAL
  def negate(n: VAL): VAL
  def power(n: VAL, p: Int): VAL = apply(java.lang.Math.pow(toDouble(n), p))

  def apply(v: Int): VAL
  def apply(v: Long): VAL
  def apply(v: Double): VAL
  def apply(v: Numeric): VAL

  def toShort(v: VAL): Short
  def toInt(v: VAL): Int
  def toLong(v: VAL): Long
  def toFloat(v: VAL): Float
  def toDouble(v: VAL): Double
  def toChar(v: VAL): Char
  def toByte(v: VAL): Byte

  def round(n: VAL, i: Int, trimOnly: Boolean = false): VAL = Z.Math.Round(n, this, i, trimOnly)

  def format(v: VAL, decimalFormatPattern: String): String = {
    val f = new java.text.DecimalFormat(decimalFormatPattern)
    if (isWhole) f.format(toLong(v)) else f.format(toDouble(v))
  }
}

object Math {
  @inline def Byte: Math[Byte] = Z.Math.Byte
  @inline def Char: Math[Char] = Z.Math.Char
  @inline def Short: Math[Short] = Z.Math.Short
  @inline def Long: Math[Long] = Z.Math.Long
  @inline def Int: Math[Int] = Z.Math.Int
  @inline def Double: Math[Double] = Z.Math.Double
  @inline def Float: Math[Float] = Z.Math.Float
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
