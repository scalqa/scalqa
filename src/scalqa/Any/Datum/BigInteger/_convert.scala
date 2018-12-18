package scalqa; package Any; package Datum.BigInteger

trait _convert extends Any with Any.Datum.Z.Number.Convert {

  protected def real: java.math.BigInteger

  @inline def toByte = real.byteValue

  @inline def toShort = real.shortValue

  @inline def toInt = real.intValue

  @inline def toLong = real.longValue

  @inline def toDouble = real.doubleValue

  @inline def toFloat = real.floatValue

  @inline def toBig = Util.BigDecimal.make(new java.math.BigDecimal(real))

  @inline def toNumber = real

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
