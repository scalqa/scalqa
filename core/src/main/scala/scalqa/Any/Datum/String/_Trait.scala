package scalqa; package Any; package Datum; package String

import Custom.String.{ _library => L }

trait _Trait[TYPE <: _Trait[TYPE]] extends Any with Datum.Comparable[TYPE, java.lang.String]
  with L._evaluate._Trait[TYPE] with L._modify[TYPE] with L._substring[TYPE] with L._transform[TYPE] {

  protected def setup: Setup[TYPE]

  @inline final def undo(v: TYPE) = v.real

  override def toString = real

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
