package scalqa; package Custom; package Numeric; package Z

private[scalqa] object Char extends Numeric[Char] with math.Integral[Char] {

  def negate(x: Char) = -x toChar
  def minus(x: Char, y: Char) = x - y toChar
  def plus(x: Char, y: Char) = x + y toChar
  def times(x: Char, y: Char) = x * y toChar
  def quot(x: Char, y: Char) = x / y toChar
  def rem(x: Char, y: Char) = x % y toChar

  def fromInt(x: Int) = x toChar
  def toDouble(x: Char) = x toDouble
  def toFloat(x: Char) = x toFloat
  def toInt(x: Char) = x toInt
  def toLong(x: Char) = x toLong

  override val zero = 0 toChar
  override val one = 1 toChar

  override def abs(x: Char) = if (x < 0) negate(x) else x
  override def signum(x: Char): Int = if (x < 0) -1 else if (x > 0) 1 else 0

  def compare(x: Char, y: Char) = java.lang.Character.compare(x, y)
  def divByInt(v: Char, int: Int) = v / int toChar
  def toNumber(v: Char) = java.lang.Integer.valueOf(v)
  def toBig(v: Char) = Util.BigDecimal.make(v)

  override def toString = "Custom.Numeric.Char"
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
