package scalqa; package Custom; package Numeric

abstract class _Class[@specialized(DATA) A] extends math.Numeric[A] with Custom.Ordering[A] {

  def plus(x: A, y: A): A
  def minus(x: A, y: A): A
  def times(x: A, y: A): A
  def negate(x: A): A

  def fromInt(x: Int): A
  def toInt(x: A): Int
  def toLong(x: A): Long
  def toFloat(x: A): Float
  def toDouble(x: A): Double

  def divByInt(v: A, int: Int): A
  def toNumber(v: A): Number
  def toBig(v: A): Util.BigDecimal

  override def zero = _zero; private val _zero = fromInt(0)
  override def one = _one; private val _one = fromInt(1)

  override def abs(x: A): A = if (compare(x, zero) < 0) negate(x) else x

  override def signum(x: A): Int = {
    val v = compare(x, zero)
    if (v < 0) -1
    else if (v > 0) 1
    else 0
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
