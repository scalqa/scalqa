package scalqa; package Any; package Datum.Int; package Ordered

trait _Trait[TYPE <: _Trait[TYPE]] extends Any with Datum.Int[TYPE] with Any.Datum.Z.Ordered[TYPE] {
  protected def setup: Setup[TYPE]

  def <(v: TYPE) = real < v.real
  def <=(v: TYPE) = real <= v.real
  def >(v: TYPE) = real > v.real
  def >=(v: TYPE) = real >= v.real

  def min(v: TYPE): TYPE = if (this <= v) make(real) else v
  def max(v: TYPE): TYPE = if (this >= v) make(real) else v
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
