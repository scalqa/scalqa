package scalqa; package Any; package Datum.Long; package Number

trait _convert extends Any with Any.Datum.Z.Number.Convert {

  @inline final def toByte = real.toByte

  @inline final def toShort = real.toShort

  @inline final def toInt = real.toInt

  @inline final def toLong = real.toLong

  @inline final def toDouble = real.toDouble

  @inline final def toFloat = real.toFloat

  @inline final def toNumber = java.lang.Long.valueOf(real)

  protected def real: Long
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
