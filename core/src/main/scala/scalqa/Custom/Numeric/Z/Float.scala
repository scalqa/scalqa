package scalqa; package Custom; package Numeric; package Z

private[scalqa] object Float extends Numeric[Float] with math.Fractional[Float] {

  @inline final def negate(x: Float) = -x
  @inline final def minus(x: Float, y: Float) = x - y
  @inline final def plus(x: Float, y: Float) = x + y
  @inline final def times(x: Float, y: Float) = x * y
  @inline final def div(x: Float, y: Float) = x / y
  @inline final def rem(x: Float, y: Float) = x % y

  @inline final def fromInt(x: Int) = x toFloat
  @inline final def toDouble(x: Float) = x toDouble
  @inline final def toFloat(x: Float) = x toFloat
  @inline final def toInt(x: Float) = x toInt
  @inline final def toLong(x: Float) = x toLong

  @inline final override def zero = 0F
  @inline final override def one = 1F

  override def abs(x: Float) = if (x < 0) negate(x) else x
  override def signum(x: Float): Int = if (x < 0) -1 else if (x > 0) 1 else 0

  def compare(x: Float, y: Float) = java.lang.Float.compare(x, y)
  def divByInt(v: Float, int: Int) = v / int
  def toNumber(v: Float) = java.lang.Float.valueOf(v)
  def toBig(v: Float) = Util.BigDecimal.make(v)

  override def toString = "Custom.Numeric.Float"
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
