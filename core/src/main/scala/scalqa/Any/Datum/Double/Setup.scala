package scalqa; package Any; package Datum.Double

abstract class Setup[TYPE <: Datum.Double[TYPE]] protected extends Any.Datum.Setup[TYPE] {
  private[scalqa]type VALUE = Double
  private[scalqa] def ilk = Ilk.Doubles

  protected def make(v: Double): TYPE
  protected def undo(v: TYPE): Double = _Trait.real(v)

  implicit override val Map: BiMap[Double, TYPE] = new BiMap[Double, TYPE] {
    @inline def apply(v: Double) = make(v)
    @inline def undo(v: TYPE) = _Trait.real(v)
  }

  implicit val Ordering: Ordering[TYPE] = new Ordering[TYPE] { def compare(x: TYPE, y: TYPE) = java.lang.Double.compare(undo(x), undo(y)) }
  implicit def zzMake(v: \/) = make(0)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
