package scalqa; package Any; package Datum.Short; package Number

trait _Trait[TYPE <: _Trait[TYPE]] extends Any with Computable[TYPE] with _compare with _convert with _use[TYPE] {
  protected def setup: Setup[TYPE]

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
