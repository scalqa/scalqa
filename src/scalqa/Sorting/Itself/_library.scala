package scalqa; package Sorting; package Itself

class _library[A] private[Itself] (protected val _target: Itself) extends AnyVal with Comparable {
  protected type SORTABLE = A

  @inline def sortingPositionTo(that: A): Position = _Trait.sortingPositionTo(_target, that)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
