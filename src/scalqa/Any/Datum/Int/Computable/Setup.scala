package scalqa; package Any; package Datum.Int; package Computable

abstract class Setup[TYPE <: Computable[TYPE]] protected extends Ordered.Setup[TYPE] {

  implicit val Numeric: Custom.Numeric[TYPE] = new Numeric

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
