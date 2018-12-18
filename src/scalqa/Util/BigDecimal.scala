package scalqa; package Util

class BigDecimal(val real: java.math.BigDecimal) extends AnyVal with Any.Datum.BigDecimal[BigDecimal] {
  protected def setup = BigDecimal

  override def toString = real.toString

}

object BigDecimal extends Any.Datum.BigDecimal.Setup[BigDecimal] {

  def make(v: java.math.BigDecimal) = new BigDecimal(v)

  def make(v: BigInteger): BigDecimal = make(new java.math.BigDecimal(v.real))

  def make(v: Double): BigDecimal = make(java.math.BigDecimal.valueOf(v))

  def make(v: Long): BigDecimal = make(java.math.BigDecimal.valueOf(v))

  def make(v: String): BigDecimal = make(new java.math.BigDecimal(v))
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class BigDecimal -> `Big Decimal`
 *
 *   [[BigDecimal]] is used for really large floating point calculations
 *
 *   {{{
 *     // Calculate number Pi using Nilakantha series
 *
 *     2.0.Big
 *       .I.unfold(_.last + 4)
 *       .take(1000) // the more ther better
 *       .map(v => (4.0.Big / (v * (v + 1) * (v + 2)) - 4.0.Big / ((v + 2) * (v + 3) * (v + 4))))
 *       .fold(3.0.Big)(_ + _)
 *       .lp
 *
 *     // Prints: 3.1415926535585900763679167025419016466613791096007613231066955478
 *   }}}
 */
