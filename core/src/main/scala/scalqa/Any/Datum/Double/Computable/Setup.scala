package scalqa; package Any; package Datum.Double; package Computable

abstract class Setup[TYPE <: Computable[TYPE]] protected extends Ordered.Setup[TYPE] {

  implicit val Numeric: Custom.Numeric[TYPE] = new Custom.Numeric[TYPE] with math.Fractional[TYPE] {

    def divByInt(v: TYPE, int: Int): TYPE = make(undo(v) / int)

    def toNumber(v: TYPE) = java.lang.Double.valueOf(undo(v))

    def toBig(v: TYPE) = scalqa.Util.BigDecimal.make(undo(v))

    def compare(x: TYPE, y: TYPE) = java.lang.Double.compare(undo(x), undo(y))

    @inline final def fromInt(x: Int) = make(x.toDouble)

    @inline final def minus(x: TYPE, y: TYPE) = make(undo(x) - undo(y))

    @inline final def negate(x: TYPE) = make(-undo(x))

    @inline final def plus(x: TYPE, y: TYPE) = make(undo(x) + undo(y))

    @inline final def times(x: TYPE, y: TYPE) = make(undo(x) * undo(y))

    @inline final def div(x: TYPE, y: TYPE) = make(undo(x) / undo(y))

    @inline final def toDouble(x: TYPE) = undo(x).toDouble

    @inline final def toFloat(x: TYPE) = undo(x).toFloat

    @inline final def toInt(x: TYPE) = undo(x).toInt

    @inline final def toLong(x: TYPE) = undo(x).toLong
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
