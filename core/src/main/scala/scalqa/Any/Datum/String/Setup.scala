package scalqa; package Any; package Datum; package String

abstract class Setup[TYPE <: _Trait[TYPE]] extends Datum.Comparable.Setup[TYPE, java.lang.String] {

  implicit def zzMake(v: \/) = make("")

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
