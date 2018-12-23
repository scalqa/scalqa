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

    @inline final def fromInt(x: Int) = make(java.math.BigDecimal.valueOf(x))

    @inline final def minus(x: TYPE, y: TYPE) = make(undo(x).subtract(undo(y)))

    @inline final def negate(x: TYPE) = make(undo(x).negate)

    @inline final def plus(x: TYPE, y: TYPE) = make(undo(x).add(undo(y)))

    @inline final def times(x: TYPE, y: TYPE) = make(undo(x).multiply(undo(y)))

    @inline final def div(x: TYPE, y: TYPE) = make(undo(x).divide(undo(y)))

    @inline final def rem(x: TYPE, y: TYPE) = make(undo(x).remainder(undo(y)))

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
