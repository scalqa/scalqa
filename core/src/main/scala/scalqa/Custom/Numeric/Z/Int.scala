package scalqa; package Custom; package Numeric; package Z

private[scalqa] object Int extends Numeric[Int] with math.Integral[Int] {

  @inline final def negate(x: Int) = -x
  @inline final def minus(x: Int, y: Int) = x - y
  @inline final def plus(x: Int, y: Int) = x + y
  @inline final def times(x: Int, y: Int) = x * y
  @inline final def quot(x: Int, y: Int) = x / y
  @inline final def rem(x: Int, y: Int) = x % y

  @inline final def fromInt(x: Int) = x
  @inline final def toDouble(x: Int) = x toDouble
  @inline final def toFloat(x: Int) = x toFloat
  @inline final def toInt(x: Int) = x toInt
  @inline final def toLong(x: Int) = x toLong

  @inline final override def zero = 0
  @inline final override def one = 1

  override def abs(x: Int) = if (x < 0) negate(x) else x
  override def signum(x: Int): Int = if (x < 0) -1 else if (x > 0) 1 else 0

  def compare(x: Int, y: Int) = java.lang.Integer.compare(x, y)
  def divByInt(v: Int, int: Int) = v / int
  def toNumber(v: Int) = java.lang.Integer.valueOf(v)
  def toBig(v: Int) = Util.BigDecimal.make(v)

  override def toString = "Custom.Numeric.Int"
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
