package scalqa; package Custom; package Numeric; package Z

private[scalqa] object Long extends Numeric[Long] with math.Integral[Long] {

  @inline final def negate(x: Long) = -x
  @inline final def minus(x: Long, y: Long) = x - y
  @inline final def plus(x: Long, y: Long) = x + y
  @inline final def times(x: Long, y: Long) = x * y
  @inline final def quot(x: Long, y: Long) = x / y
  @inline final def rem(x: Long, y: Long) = x % y

  @inline final def fromInt(x: Int) = x toInt
  @inline final def toDouble(x: Long) = x toDouble
  @inline final def toFloat(x: Long) = x toFloat
  @inline final def toInt(x: Long) = x toInt
  @inline final def toLong(x: Long) = x toLong

  @inline final override def zero = 0L
  @inline final override def one = 1L

  override def abs(x: Long) = if (x < 0) negate(x) else x
  override def signum(x: Long): Int = if (x < 0) -1 else if (x > 0) 1 else 0

  def compare(x: Long, y: Long) = java.lang.Long.compare(x, y)
  def divByInt(v: Long, int: Int) = v / int
  def toNumber(v: Long) = java.lang.Long.valueOf(v)
  def toBig(v: Long) = Util.BigDecimal.make(v)

  override def toString = "Custom.Numeric.Long"
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
