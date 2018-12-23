package scalqa; package Any; package Datum.Double; package Number

trait _compare extends Any with Any.Datum.Z.Number.Compare {

  @inline final def ==(v: Byte) = real == v
  @inline final def ==(v: Short) = real == v
  @inline final def ==(v: Int) = real == v
  @inline final def ==(v: Long) = real == v
  @inline final def ==(v: Float) = real == v
  @inline final def ==(v: Double) = real == v

  @inline final def !=(v: Byte) = real != v
  @inline final def !=(v: Short) = real != v
  @inline final def !=(v: Int) = real != v
  @inline final def !=(v: Long) = real != v
  @inline final def !=(v: Float) = real != v
  @inline final def !=(v: Double) = real != v

  @inline final def <(v: Byte) = real < v
  @inline final def <(v: Short) = real < v
  @inline final def <(v: Int) = real < v
  @inline final def <(v: Long) = real < v
  @inline final def <(v: Float) = real < v
  @inline final def <(v: Double) = real < v

  @inline final def <=(v: Byte) = real <= v
  @inline final def <=(v: Short) = real <= v
  @inline final def <=(v: Int) = real <= v
  @inline final def <=(v: Long) = real <= v
  @inline final def <=(v: Float) = real <= v
  @inline final def <=(v: Double) = real <= v

  @inline final def >(v: Byte) = real > v
  @inline final def >(v: Short) = real > v
  @inline final def >(v: Int) = real > v
  @inline final def >(v: Long) = real > v
  @inline final def >(v: Float) = real > v
  @inline final def >(v: Double) = real > v

  @inline final def >=(v: Byte) = real >= v
  @inline final def >=(v: Short) = real >= v
  @inline final def >=(v: Int) = real >= v
  @inline final def >=(v: Long) = real >= v
  @inline final def >=(v: Float) = real >= v
  @inline final def >=(v: Double) = real >= v

  protected def real: Double
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
