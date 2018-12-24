package scalqa; package Any; package Datum.Double

trait _Trait[TYPE <: _Trait[TYPE]] extends Any with Any.Datum[TYPE, Double] with Custom.Number.Like {

  protected def real: Double

  protected def realNumber = java.lang.Double.valueOf(real)

  protected def setup: Setup[TYPE]

  def make(v: Double): TYPE = setup.Map(v)
}

private object _Trait {

  def real(v: _Trait[_]) = v.real

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
