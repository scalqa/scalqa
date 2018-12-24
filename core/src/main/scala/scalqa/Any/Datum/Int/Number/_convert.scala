package scalqa; package Any; package Datum.Int; package Number

trait _convert extends Any with Any.Datum.Z.Number.Convert {

  def toByte = real.toByte

  def toShort = real.toShort

  def toInt = real.toInt

  def toLong = real.toLong

  def toDouble = real.toDouble

  def toFloat = real.toFloat

  def toNumber = java.lang.Integer.valueOf(real)

  protected def real: Int
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
