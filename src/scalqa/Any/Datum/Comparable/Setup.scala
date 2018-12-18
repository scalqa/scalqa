package scalqa; package Any; package Datum; package Comparable

abstract class Setup[TYPE <: Comparable[TYPE, VALUE], VALUE <: java.lang.Comparable[VALUE]] extends Datum.Ref.Setup[TYPE, VALUE] {

  implicit val Ordering: Ordering[TYPE] = new Ordering[TYPE] { def compare(x: TYPE, y: TYPE) = undo(x).compareTo(undo(y)) }

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
