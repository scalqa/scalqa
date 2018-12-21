package scalqa; package Any; package Datum.Double; package Number

abstract class Setup[TYPE <: Number[TYPE]] protected extends Computable.Setup[TYPE] {

  implicit def zzToNumber(v: TYPE): java.lang.Number = v.toNumber

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
