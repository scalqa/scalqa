package scalqa; package Any; package Datum.BigInteger

trait _convert extends Any with Any.Datum.Z.Number.Convert {

  protected def real: java.math.BigInteger

  def toByte = real.byteValue

  def toShort = real.shortValue

  def toInt = real.intValue

  def toLong = real.longValue

  def toDouble = real.doubleValue

  def toFloat = real.floatValue

  def toBig = Util.BigDecimal.make(new java.math.BigDecimal(real))

  def toNumber = real

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
