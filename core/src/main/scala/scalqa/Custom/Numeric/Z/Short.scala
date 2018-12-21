package scalqa; package Custom; package Numeric; package Z

private[scalqa] object Short extends Numeric[Short] with math.Integral[Short] {

  @inline def negate(x: Short) = -x toShort
  @inline def minus(x: Short, y: Short) = x - y toShort
  @inline def plus(x: Short, y: Short) = x + y toShort
  @inline def times(x: Short, y: Short) = x * y toShort
  @inline def quot(x: Short, y: Short) = x / y toShort
  @inline def rem(x: Short, y: Short) = x % y toShort

  @inline def fromInt(x: Int) = x toShort
  @inline def toDouble(x: Short) = x toDouble
  @inline def toFloat(x: Short) = x toFloat
  @inline def toInt(x: Short) = x toInt
  @inline def toLong(x: Short) = x toLong

  override val zero = 0 toShort
  override val one = 1 toShort

  override def abs(x: Short) = if (x < 0) negate(x) else x
  override def signum(x: Short): Int = if (x < 0) -1 else if (x > 0) 1 else 0

  def compare(x: Short, y: Short) = java.lang.Short.compare(x, y)
  def divByInt(v: Short, int: Int) = v / int toShort
  def toNumber(v: Short) = java.lang.Short.valueOf(v)
  def toBig(v: Short) = Util.BigDecimal.make(v)

  override def toString = "Custom.Numeric.Short"
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
