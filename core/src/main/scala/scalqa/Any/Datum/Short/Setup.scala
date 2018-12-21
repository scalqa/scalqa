package scalqa; package Any; package Datum.Short

abstract class Setup[TYPE <: Datum.Short[TYPE]] protected extends Any.Datum.Setup[TYPE] {
  private[scalqa]type VALUE = Short
  private[scalqa] def ilk = Ilk.Shorts

  protected def make(v: Short): TYPE
  protected def undo(v: TYPE): Short = _Trait.real(v)

  implicit override val Map: BiMap[Short, TYPE] = new BiMap[Short, TYPE] {
    @inline def apply(v: Short) = make(v)
    @inline def undo(v: TYPE) = _Trait.real(v)
  }

  implicit val Ordering: Ordering[TYPE] = new Ordering[TYPE] { def compare(x: TYPE, y: TYPE) = java.lang.Integer.compare(undo(x), undo(y)) }
  implicit def zzMake(v: \/) = make(0)

  // ***********************************************************************************************
  private[Datum] class Numeric extends Custom.Numeric[TYPE] with math.Integral[TYPE] {

    def divByInt(v: TYPE, int: Int): TYPE = make(undo(v) / int toShort)

    def toNumber(v: TYPE) = java.lang.Short.valueOf(undo(v))

    def toBig(v: TYPE) = scalqa.Util.BigDecimal.make(undo(v))

    def compare(x: TYPE, y: TYPE) = java.lang.Short.compare(undo(x), undo(y))

    @inline def fromInt(x: Int) = make(x toByte)

    @inline def minus(x: TYPE, y: TYPE) = make(undo(x) - undo(y) toByte)

    @inline def negate(x: TYPE) = make(-undo(x) toByte)

    @inline def plus(x: TYPE, y: TYPE) = make(undo(x) + undo(y) toByte)

    @inline def times(x: TYPE, y: TYPE) = make(undo(x) * undo(y) toByte)

    @inline def quot(x: TYPE, y: TYPE) = make(undo(x) / undo(y) toByte)

    @inline def rem(x: TYPE, y: TYPE) = make(undo(x) % undo(y) toByte)

    @inline def toDouble(x: TYPE) = undo(x).toDouble

    @inline def toFloat(x: TYPE) = undo(x).toFloat

    @inline def toInt(x: TYPE) = undo(x).toInt

    @inline def toLong(x: TYPE) = undo(x).toLong
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/