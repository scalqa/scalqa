package scalqa; package Any; package Datum; package Ref

abstract class Setup[TYPE <: Datum.Ref[TYPE, VAL], VAL] extends Any.Datum.Setup[TYPE] {
  private[scalqa]type VALUE = VAL

  protected def make(v: VALUE): TYPE

  protected def undo(v: TYPE): VALUE = _Trait.real(v)

  private[scalqa] def ilk = Ilk.Refs

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
