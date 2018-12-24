package scalqa; package Any; package Datum.Byte; package Number

trait _compare extends Any with Any.Datum.Z.Number.Compare {

  def ==(v: Byte) = real == v
  def ==(v: Short) = real == v
  def ==(v: Int) = real == v
  def ==(v: Long) = real == v
  def ==(v: Float) = real == v
  def ==(v: Double) = real == v

  def !=(v: Byte) = real != v
  def !=(v: Short) = real != v
  def !=(v: Int) = real != v
  def !=(v: Long) = real != v
  def !=(v: Float) = real != v
  def !=(v: Double) = real != v

  def <(v: Byte) = real < v
  def <(v: Short) = real < v
  def <(v: Int) = real < v
  def <(v: Long) = real < v
  def <(v: Float) = real < v
  def <(v: Double) = real < v

  def <=(v: Byte) = real <= v
  def <=(v: Short) = real <= v
  def <=(v: Int) = real <= v
  def <=(v: Long) = real <= v
  def <=(v: Float) = real <= v
  def <=(v: Double) = real <= v

  def >(v: Byte) = real > v
  def >(v: Short) = real > v
  def >(v: Int) = real > v
  def >(v: Long) = real > v
  def >(v: Float) = real > v
  def >(v: Double) = real > v

  def >=(v: Byte) = real >= v
  def >=(v: Short) = real >= v
  def >=(v: Int) = real >= v
  def >=(v: Long) = real >= v
  def >=(v: Float) = real >= v
  def >=(v: Double) = real >= v

  protected def real: Byte
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
