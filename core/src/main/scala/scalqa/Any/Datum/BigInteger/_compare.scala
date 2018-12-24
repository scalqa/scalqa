package scalqa; package Any; package Datum.BigInteger

trait _compare[TYPE <: _compare[TYPE]] extends Any with Any.Datum.Comparable[TYPE, java.math.BigInteger] with math.Ordered[TYPE] with Any.Datum.Z.Number.Compare {

  def compare(v: TYPE): Int = real.compareTo(v.real)

  def ==(v: Byte) = real.byteValue == v
  def ==(v: Short) = real.shortValue == v
  def ==(v: Int) = real.intValue == v
  def ==(v: Long) = real.longValue == v
  def ==(v: Float) = real.floatValue == v
  def ==(v: Double) = real.doubleValue == v

  def !=(v: Byte) = real.byteValue != v
  def !=(v: Short) = real.shortValue != v
  def !=(v: Int) = real.intValue != v
  def !=(v: Long) = real.longValue != v
  def !=(v: Float) = real.floatValue != v
  def !=(v: Double) = real.doubleValue != v

  def <(v: Byte) = real.byteValue < v
  def <(v: Short) = real.shortValue < v
  def <(v: Int) = real.intValue < v
  def <(v: Long) = real.longValue < v
  def <(v: Float) = real.floatValue < v
  def <(v: Double) = real.doubleValue < v

  def <=(v: Byte) = real.byteValue <= v
  def <=(v: Short) = real.shortValue <= v
  def <=(v: Int) = real.intValue <= v
  def <=(v: Long) = real.longValue <= v
  def <=(v: Float) = real.floatValue <= v
  def <=(v: Double) = real.doubleValue <= v

  def >(v: Byte) = real.byteValue > v
  def >(v: Short) = real.shortValue > v
  def >(v: Int) = real.intValue > v
  def >(v: Long) = real.longValue > v
  def >(v: Float) = real.floatValue > v
  def >(v: Double) = real.doubleValue > v

  def >=(v: Byte) = real.byteValue >= v
  def >=(v: Short) = real.shortValue >= v
  def >=(v: Int) = real.intValue >= v
  def >=(v: Long) = real.longValue >= v
  def >=(v: Float) = real.floatValue >= v
  def >=(v: Double) = real.doubleValue >= v

  def min(v: TYPE): TYPE = if (this <= v) make(real) else v

  def max(v: TYPE): TYPE = if (this >= v) make(real) else v

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
