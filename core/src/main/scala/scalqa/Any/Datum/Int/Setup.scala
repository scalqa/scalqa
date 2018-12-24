package scalqa; package Any; package Datum.Int

abstract class Setup[TYPE <: Datum.Int[TYPE]] protected extends Any.Datum.Setup[TYPE] {
  private[scalqa] type VALUE = Int
  private[scalqa] def ilk = Ilk.Ints

  protected def make(v: Int): TYPE
  protected def undo(v: TYPE): Int = _Trait.real(v)

  implicit override val Map: BiMap[Int, TYPE] = new BiMap[Int, TYPE] {
    def apply(v: Int) = make(v)
    def undo(v: TYPE) = _Trait.real(v)
  }

  implicit val Ordering: Ordering[TYPE] = new Ordering[TYPE] { def compare(x: TYPE, y: TYPE) = java.lang.Integer.compare(undo(x), undo(y)) }
  implicit def zzMake(v: \/) = make(0)

  // ***************************************************************************************************
  private[Datum] class Numeric extends Custom.Numeric[TYPE] with math.Integral[TYPE] {

    def divByInt(v: TYPE, int: Int): TYPE = make(undo(v) / int)

    def toNumber(v: TYPE) = java.lang.Integer.valueOf(undo(v))

    def toBig(v: TYPE) = scalqa.Util.BigDecimal.make(undo(v))

    def compare(x: TYPE, y: TYPE) = java.lang.Integer.compare(undo(x), undo(y))

    def fromInt(x: Int) = make(x)

    def minus(x: TYPE, y: TYPE) = make(undo(x) - undo(y))

    def negate(x: TYPE) = make(-undo(x))

    def plus(x: TYPE, y: TYPE) = make(undo(x) + undo(y))

    def times(x: TYPE, y: TYPE) = make(undo(x) * undo(y))

    def quot(x: TYPE, y: TYPE) = make(undo(x) / undo(y))

    def rem(x: TYPE, y: TYPE) = make(undo(x) % undo(y))

    def toDouble(x: TYPE) = undo(x).toDouble

    def toFloat(x: TYPE) = undo(x).toFloat

    def toInt(x: TYPE) = undo(x).toInt

    def toLong(x: TYPE) = undo(x).toLong
  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
