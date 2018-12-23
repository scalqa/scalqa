package scalqa; package Custom; package Numeric; package Z

private[scalqa] object Byte extends Numeric[Byte] with math.Integral[Byte] {

  @inline final def negate(x: Byte) = -x toByte
  @inline final def minus(x: Byte, y: Byte) = x - y toByte
  @inline final def plus(x: Byte, y: Byte) = x + y toByte
  @inline final def times(x: Byte, y: Byte) = x * y toByte
  @inline final def quot(x: Byte, y: Byte) = x / y toByte
  @inline final def rem(x: Byte, y: Byte) = x % y toByte

  @inline final def fromInt(x: Int) = x toByte
  @inline final def toDouble(x: Byte) = x toDouble
  @inline final def toFloat(x: Byte) = x toFloat
  @inline final def toInt(x: Byte) = x toInt
  @inline final def toLong(x: Byte) = x toLong

  override val zero = 0 toByte
  override val one = 1 toByte

  override def abs(x: Byte) = if (x < 0) negate(x) else x
  override def signum(x: Byte): Int = if (x < 0) -1 else if (x > 0) 1 else 0

  def compare(x: Byte, y: Byte) = java.lang.Byte.compare(x, y)
  def divByInt(v: Byte, int: Int) = v / int toByte
  def toNumber(v: Byte) = java.lang.Byte.valueOf(v)
  def toBig(v: Byte) = Util.BigDecimal.make(v)

  override def toString = "Custom.Numeric.Byte"
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
