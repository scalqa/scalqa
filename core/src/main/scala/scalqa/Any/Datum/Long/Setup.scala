package scalqa; package Any; package Datum.Long

abstract class Setup[TYPE <: Datum.Long[TYPE]] protected extends Any.Datum.Setup[TYPE] {
  private[scalqa] type VALUE = Long
  private[scalqa] def ilk = Ilk.Longs

  protected def make(v: Long): TYPE
  protected def undo(v: TYPE): Long = _Trait.real(v)

  implicit override val Map: BiMap[Long, TYPE] = new BiMap[Long, TYPE] {
    def apply(v: Long) = make(v)
    def undo(v: TYPE) = _Trait.real(v)
  }

  implicit val Ordering: Ordering[TYPE] = new Ordering[TYPE] { def compare(x: TYPE, y: TYPE) = java.lang.Long.compare(undo(x), undo(y)) }
  implicit def zzMake(v: \/) = make(0)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
