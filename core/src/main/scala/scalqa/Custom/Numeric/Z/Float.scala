package scalqa; package Custom; package Numeric; package Z

private[scalqa] object Float extends Numeric[Float] with math.Fractional[Float] {

  @inline def negate(x: Float) = -x
  @inline def minus(x: Float, y: Float) = x - y
  @inline def plus(x: Float, y: Float) = x + y
  @inline def times(x: Float, y: Float) = x * y
  @inline def div(x: Float, y: Float) = x / y
  @inline def rem(x: Float, y: Float) = x % y

  @inline def fromInt(x: Int) = x toFloat
  @inline def toDouble(x: Float) = x toDouble
  @inline def toFloat(x: Float) = x toFloat
  @inline def toInt(x: Float) = x toInt
  @inline def toLong(x: Float) = x toLong

  @inline override def zero = 0F
  @inline override def one = 1F

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
