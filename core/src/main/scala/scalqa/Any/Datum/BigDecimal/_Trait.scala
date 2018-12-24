package scalqa; package Any; package Datum.BigDecimal

trait _Trait[TYPE <: _Trait[TYPE]] extends Any with _compare[TYPE] with _convert with _use[TYPE] with Custom.Number.Like {

  protected def setup: Setup[TYPE]

  protected def realNumber = real

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
