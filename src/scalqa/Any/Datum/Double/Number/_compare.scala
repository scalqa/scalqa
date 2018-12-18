package scalqa; package Any; package Datum.Double; package Number

trait _compare extends Any with Any.Datum.Z.Number.Compare {

  @inline def ==(v: Byte) = real == v
  @inline def ==(v: Short) = real == v
  @inline def ==(v: Int) = real == v
  @inline def ==(v: Long) = real == v
  @inline def ==(v: Float) = real == v
  @inline def ==(v: Double) = real == v

  @inline def !=(v: Byte) = real != v
  @inline def !=(v: Short) = real != v
  @inline def !=(v: Int) = real != v
  @inline def !=(v: Long) = real != v
  @inline def !=(v: Float) = real != v
  @inline def !=(v: Double) = real != v

  @inline def <(v: Byte) = real < v
  @inline def <(v: Short) = real < v
  @inline def <(v: Int) = real < v
  @inline def <(v: Long) = real < v
  @inline def <(v: Float) = real < v
  @inline def <(v: Double) = real < v

  @inline def <=(v: Byte) = real <= v
  @inline def <=(v: Short) = real <= v
  @inline def <=(v: Int) = real <= v
  @inline def <=(v: Long) = real <= v
  @inline def <=(v: Float) = real <= v
  @inline def <=(v: Double) = real <= v

  @inline def >(v: Byte) = real > v
  @inline def >(v: Short) = real > v
  @inline def >(v: Int) = real > v
  @inline def >(v: Long) = real > v
  @inline def >(v: Float) = real > v
  @inline def >(v: Double) = real > v

  @inline def >=(v: Byte) = real >= v
  @inline def >=(v: Short) = real >= v
  @inline def >=(v: Int) = real >= v
  @inline def >=(v: Long) = real >= v
  @inline def >=(v: Float) = real >= v
  @inline def >=(v: Double) = real >= v

  protected def real: Double
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
