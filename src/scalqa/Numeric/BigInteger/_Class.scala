package scalqa; package Numeric; package BigInteger

import java.{ math => J }

class _Class private[BigInteger] (val real: J.BigInteger) extends AnyVal with Any.Value.Ref[J.BigInteger] with Numeric {
  protected override type THIS = BigInteger
  protected override type VALUE = J.BigInteger
  protected def companion = _Class

  def *(v: BigInteger): BigInteger = this * v.real
  def /(v: BigInteger): BigInteger = this / v.real
  def +(v: BigInteger): BigInteger = this + v.real
  def -(v: BigInteger): BigInteger = this - v.real

  def *(v: Long): BigInteger = this * J.BigInteger.valueOf(v)
  def /(v: Long): BigInteger = this / J.BigInteger.valueOf(v)
  def +(v: Long): BigInteger = this + J.BigInteger.valueOf(v)
  def -(v: Long): BigInteger = this - J.BigInteger.valueOf(v)
}

object _Class extends Any.Value.Ref.Companion[BigInteger, J.BigInteger] with Numeric.Companion[BigInteger, J.BigInteger] {

  protected def math: Math[J.BigInteger] = Z.Math.BigInteger

  protected def get(v: J.BigInteger) = new BigInteger(v)

  import scala.language.implicitConversions

  implicit def zzGet(v: Long): BigInteger = J.BigInteger.valueOf(v)

  implicit def zzGet(v: J.BigInteger): BigInteger = new BigInteger(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class -> '''Big Integer'''
 *
 *    [[BigInteger]] is used for really large integer calculations
 *
 *    @example
 *    {{{
 *       import Numeric.BigInteger
 *       val theBig: BigInteger = 58.I.~.repeat(35).foldAs[BigInteger](1, _ * _)
 *       val TenB: BigInteger = 10L * 1000 * 1000 * 1000
 *       val YearSecs: BigInteger = 60 * 60 * 24 * 365
 *       Print.ls("Bitcoin address size digits=", theBig.toString.length, "\n", theBig,
 *         "\n\nSuppose, there is 10 billion computers in the world capable counting 10 billion numbers a second each\n",
 *         "\n  Together theys will count", TenB * TenB, "a second",
 *         "\n  Together theys will count", TenB * TenB * YearSecs, "a year",
 *         "\n  Together theys will count", TenB * TenB * YearSecs * TenB, "in 10 billions years - the 'Age of Universe'",
 *         "\n\nIt is required", theBig / ((TenB * TenB * YearSecs * TenB)),
 *         "'Ages of Universe'\nfor all todays computers together to just simply count all Bitcoin adresses")
 *
 *       // Output
 *       Bitcoin address size digits= 62
 *       52478302028992644968172978478148648556151605660894866578604032
 *
 *       Suppose, there is 10 billion computers in the world capable counting 10 billion numbers a second each
 *
 *         Together theys will count 100000000000000000000 a second
 *         Together theys will count 3153600000000000000000000000 a year
 *         Together theys will count 31536000000000000000000000000000000000 in 10 billions years - the 'Age of Universe'
 *
 *       It is required 1664076041000527808478341 'Ages of Universe'
 *       for all todays computers together to just simply count all Bitcoin adresses
 *   }}}
 */
