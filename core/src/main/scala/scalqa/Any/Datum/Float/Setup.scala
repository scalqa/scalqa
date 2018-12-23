package scalqa; package Any; package Datum.Float

abstract class Setup[TYPE <: Datum.Float[TYPE]] protected extends Any.Datum.Setup[TYPE] {
  private[scalqa] type VALUE = Float
  private[scalqa] def ilk = Ilk.Floats

  protected def make(v: Float): TYPE
  protected def undo(v: TYPE): Float = _Trait.real(v)

  implicit override val Map: BiMap[Float, TYPE] = new BiMap[Float, TYPE] {
    @inline final def apply(v: Float) = make(v)
    @inline final def undo(v: TYPE) = _Trait.real(v)
  }

  implicit val Ordering: Ordering[TYPE] = new Ordering[TYPE] { def compare(x: TYPE, y: TYPE) = java.lang.Float.compare(undo(x), undo(y)) }
  implicit def zzMake(v: \/) = make(0)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
