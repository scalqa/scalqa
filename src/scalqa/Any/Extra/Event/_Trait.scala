package scalqa; package Any; package Extra; package Event

trait _Trait extends Like {

  protected def _addEvent(scope: AnyRef, _target: AnyRef) = _addEntry(scope, _target)

  protected[Extra] override def _fireEvent[T](scope: AnyRef, f: T => Any): Int = super._fireEvent(scope, f)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
