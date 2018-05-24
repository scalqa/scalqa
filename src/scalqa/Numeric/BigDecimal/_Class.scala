package scalqa; package Numeric; package BigDecimal

import java.{ math => J }

class _Class private[BigDecimal] (val real: J.BigDecimal) extends AnyVal with Any.Value.Ref[J.BigDecimal] with Numeric {
  protected override type THIS = BigDecimal
  protected override type VALUE = J.BigDecimal
  protected def companion = _Class

  def /(v: BigDecimal, scale: Int, r: Round): BigDecimal = real.divide(v.real, scale, r.real)

  def *(v: BigDecimal): BigDecimal = this * v.real
  def /(v: BigDecimal): BigDecimal = this / v.real
  def +(v: BigDecimal): BigDecimal = this + v.real
  def -(v: BigDecimal): BigDecimal = this - v.real

  def *(v: Long): BigDecimal = this * J.BigDecimal.valueOf(v)
  def /(v: Long): BigDecimal = this / J.BigDecimal.valueOf(v)
  def +(v: Long): BigDecimal = this + J.BigDecimal.valueOf(v)
  def -(v: Long): BigDecimal = this - J.BigDecimal.valueOf(v)

  def *(v: Double): BigDecimal = this * J.BigDecimal.valueOf(v)
  def /(v: Double): BigDecimal = this / J.BigDecimal.valueOf(v)
  def +(v: Double): BigDecimal = this + J.BigDecimal.valueOf(v)
  def -(v: Double): BigDecimal = this - J.BigDecimal.valueOf(v)

}

object _Class extends Any.Value.Ref.Companion[BigDecimal, J.BigDecimal] with Numeric.Companion[BigDecimal, J.BigDecimal] {

  protected def get(v: J.BigDecimal) = new BigDecimal(v)

  protected def math: Math[J.BigDecimal] = Z.Math.BigDecimal

  import scala.language.implicitConversions

  implicit def zzGet(v: Double): BigDecimal = J.BigDecimal.valueOf(v)

  implicit def zzGet(v: J.BigDecimal): BigDecimal = new BigDecimal(v)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class -> '''Big Decimal'''
 *
 *   [[Numeric.BigDecimal]] is used for really large floating point calculations
 *   @example
 *   {{{
 *       // Calculate number Pi using Nilakantha series with 100 scale precise divisions
 *       import Numeric.BigDecimal
 *       val Scale = 100
 *       val Round = BigDecimal.Round.HalfUp
 *
 *       var v: BigDecimal = -2
 *       def next = { v += 4; v }
 *       val BigFour: BigDecimal = 4
 *
 *       val pi = (1 <> 1000000) // The more, the better
 *         .all.swap(next)
 *         .map(v => (BigFour / (v * (v + 1) * (v + 2), Scale, Round) - BigFour / ((v + 2) * (v + 3) * (v + 4), Scale, Round)))
 *         .foldAs[BigDecimal](3.0D, _ + _)
 *
 *       pi.lp // Prints: 3.1415926535897932384313934301544657748368178367530393536772837656438690619833217166481462091366344806
 *   }}}
 */
