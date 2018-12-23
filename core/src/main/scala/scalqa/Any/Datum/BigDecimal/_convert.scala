package scalqa; package Any; package Datum.BigDecimal

trait _convert extends Any with Any.Datum.Z.Number.Convert {

  protected def real: java.math.BigDecimal

  @inline final def toByte = real.byteValue

  @inline final def toShort = real.shortValue

  @inline final def toInt = real.intValue

  @inline final def toLong = real.longValue

  @inline final def toDouble = real.doubleValue

  @inline final def toFloat = real.floatValue

  @inline final def toBigInteger = Util.BigInteger.make(real.toBigInteger)

  @inline final def toNumber = real

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
