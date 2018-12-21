package scalqa; package Custom; package Numeric; package Z

private[scalqa] object Double extends Numeric[Double] with math.Fractional[Double] {

  @inline def negate(x: Double) = -x
  @inline def minus(x: Double, y: Double) = x - y
  @inline def plus(x: Double, y: Double) = x + y
  @inline def times(x: Double, y: Double) = x * y
  @inline def div(x: Double, y: Double) = x / y
  @inline def rem(x: Double, y: Double) = x % y

  @inline def fromInt(x: Int) = x toDouble
  @inline def toDouble(x: Double) = x toDouble
  @inline def toFloat(x: Double) = x toFloat
  @inline def toInt(x: Double) = x toInt
  @inline def toLong(x: Double) = x toLong

  @inline override def zero = 0D
  @inline override def one = 1D

  override def abs(x: Double) = if (x < 0) negate(x) else x
  override def signum(x: Double): Int = if (x < 0) -1 else if (x > 0) 1 else 0

  def compare(x: Double, y: Double) = java.lang.Double.compare(x, y)
  def divByInt(v: Double, int: Int) = v / int
  def toNumber(v: Double) = java.lang.Double.valueOf(v)
  def toBig(v: Double) = Util.BigDecimal.make(v)

  override def toString = "Custom.Numeric.Double"
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
