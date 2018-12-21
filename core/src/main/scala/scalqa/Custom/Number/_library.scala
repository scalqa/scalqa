package scalqa; package Custom; package Number

class _library private[scalqa] (protected val real: Number) extends AnyVal {

  def toShort: Short = real.shortValue

  def toInt: Int = real.intValue

  def toFloat: Float = real.floatValue

  def toLong: Long = real.longValue

  def toDouble: Double = real.doubleValue

  def toChar: Char = real.intValue.toChar

  def toByte: Byte = real.byteValue

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
