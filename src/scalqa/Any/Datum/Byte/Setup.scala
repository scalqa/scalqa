package scalqa; package Any; package Datum.Byte

abstract class Setup[TYPE <: Datum.Byte[TYPE]] protected extends Any.Datum.Setup[TYPE] {
  private[scalqa]type VALUE = Byte
  private[scalqa] def ilk = Ilk.Bytes

  protected def make(v: Byte): TYPE
  protected def undo(v: TYPE): Byte = _Trait.real(v)

  implicit override val Map: BiMap[Byte, TYPE] = new BiMap[Byte, TYPE] {
    @inline def apply(v: Byte) = make(v)
    @inline def undo(v: TYPE) = _Trait.real(v)
  }

  implicit val Ordering: Ordering[TYPE] = new Ordering[TYPE] { def compare(x: TYPE, y: TYPE) = java.lang.Integer.compare(undo(x), undo(y)) }
  implicit def zzMake(v: \/) = make(0)

  // *********************************************************************************
  private[Datum] class Numeric extends Custom.Numeric[TYPE] with math.Integral[TYPE] {

    def divByInt(v: TYPE, int: Int): TYPE = make(undo(v) / int toByte)

    def toNumber(v: TYPE) = java.lang.Byte.valueOf(undo(v))

    def toBig(v: TYPE) = scalqa.Util.BigDecimal.make(undo(v))

    def compare(x: TYPE, y: TYPE) = java.lang.Byte.compare(undo(x), undo(y))

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
