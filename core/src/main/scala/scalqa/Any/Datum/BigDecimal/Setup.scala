package scalqa; package Any; package Datum.BigDecimal

abstract class Setup[TYPE <: Datum.BigDecimal[TYPE]] protected extends Any.Datum.Comparable.Setup[TYPE, java.math.BigDecimal] {

  implicit def zzMake(v: \/) = make(java.math.BigDecimal.valueOf(0))

  // *****************************************************************************************************************************
  implicit val Numeric: Custom.Numeric[TYPE] = new Custom.Numeric[TYPE] with math.Fractional[TYPE] {

    def divByInt(v: TYPE, int: Int): TYPE = make(undo(v).divide(java.math.BigDecimal.valueOf(int)))

    def toNumber(v: TYPE) = undo(v)

    def compare(x: TYPE, y: TYPE) = undo(x).compareTo(undo(y))

    def toBig(v: TYPE) = v match { case v: Util.BigDecimal => v; case v => Util.BigDecimal.make(undo(v)) }

    def apply(v: \/) = make(Zero)

    def fromInt(x: Int) = make(java.math.BigDecimal.valueOf(x))

    def minus(x: TYPE, y: TYPE) = make(undo(x).subtract(undo(y)))

    def negate(x: TYPE) = make(undo(x).negate)

    def plus(x: TYPE, y: TYPE) = make(undo(x).add(undo(y)))

    def times(x: TYPE, y: TYPE) = make(undo(x).multiply(undo(y)))

    def div(x: TYPE, y: TYPE) = make(undo(x).divide(undo(y)))

    def rem(x: TYPE, y: TYPE) = make(undo(x).remainder(undo(y)))

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
