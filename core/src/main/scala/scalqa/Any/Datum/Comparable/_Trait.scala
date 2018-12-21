package scalqa; package Any; package Datum; package Comparable

trait _Trait[TYPE <: _Trait[TYPE, VALUE], VALUE <: java.lang.Comparable[VALUE]] extends Any with Datum.Ref[TYPE, VALUE] {

  protected def setup: Setup[TYPE, VALUE]

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
