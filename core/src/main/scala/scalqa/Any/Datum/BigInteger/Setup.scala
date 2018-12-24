package scalqa; package Any; package Datum.BigInteger

import java.math.{ BigInteger => JBig }

abstract class Setup[TYPE <: Datum.BigInteger[TYPE]] protected extends Datum.Comparable.Setup[TYPE, java.math.BigInteger] {

  implicit def zzMake(v: \/) = make(java.math.BigInteger.valueOf(0))

  implicit val Numeric: Custom.Numeric[TYPE] = new Custom.Numeric[TYPE] with math.Integral[TYPE] {

    def divByInt(v: TYPE, int: Int): TYPE = make(undo(v).divide(JBig.valueOf(int)))

    def toNumber(v: TYPE) = undo(v)

    def toBig(v: TYPE) = scalqa.Util.BigDecimal.make(new java.math.BigDecimal(undo(v)))

    def compare(x: TYPE, y: TYPE) = undo(x).compareTo(undo(y))

    def apply(v: \/) = make(Zero)

    def fromInt(x: Int) = make(java.math.BigInteger.valueOf(x))

    def minus(x: TYPE, y: TYPE) = make(undo(x).subtract(undo(y)))

    def negate(x: TYPE) = make(undo(x).negate)

    def plus(x: TYPE, y: TYPE) = make(undo(x).add(undo(y)))

    def times(x: TYPE, y: TYPE) = make(undo(x).multiply(undo(y)))

    def quot(x: TYPE, y: TYPE) = make(undo(x).divide(undo(y)))

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
