package scalqa; package Custom; package Numeric; package Z

private[scalqa] object Long extends Numeric[Long] with math.Integral[Long] {

  def negate(x: Long) = -x
  def minus(x: Long, y: Long) = x - y
  def plus(x: Long, y: Long) = x + y
  def times(x: Long, y: Long) = x * y
  def quot(x: Long, y: Long) = x / y
  def rem(x: Long, y: Long) = x % y

  def fromInt(x: Int) = x toInt
  def toDouble(x: Long) = x toDouble
  def toFloat(x: Long) = x toFloat
  def toInt(x: Long) = x toInt
  def toLong(x: Long) = x toLong

  override def zero = 0L
  override def one = 1L

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
