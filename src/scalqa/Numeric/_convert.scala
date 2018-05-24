package scalqa; package Numeric

trait _convert extends Any with __ {

  def toShort = math.toShort(value)

  def toInt = math.toInt(value)

  def toFloat = math.toFloat(value)

  def toLong = math.toLong(value)

  def toDouble = math.toDouble(value)

  def toChar = math.toChar(value)

  def toByte = math.toByte(value)

  def voidZero: THIS = if (value != math.Zero) this.cast else companion._void

  protected def companion: Companion[THIS, VALUE]

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def voidZero -> 0 to void conversion
 *
 *     If ''this'' value is 0, void value is returned
 *
 *     Otherwise ''this'' is returned
 *
 *     Note: Void is equivalent to 0 in most calculations
 *
 * @def toShort -> Short value
 *
 *     Converts ''this'' [[Numeric]] to [[Short]]
 *
 * @def toInt -> Int value
 *
 *     Converts ''this'' [[Numeric]] to [[Int]]
 *
 * @def toFloat -> Float value
 *
 *     Converts ''this'' [[Numeric]] to [[Float]]
 *
 * @def toLong -> Long value
 *
 *     Converts ''this'' [[Numeric]] to [[Long]]
 *
 * @def toDouble -> Double value
 *
 *     Converts ''this'' [[Numeric]] to [[Double]]
 *
 * @def toChar -> Char value
 *
 *     Converts ''this'' [[Numeric]] to [[Char]]
 *
 * @def toByte -> Byte value
 *
 *     Converts ''this'' [[Numeric]] to [[Byte]]
 *
 */
