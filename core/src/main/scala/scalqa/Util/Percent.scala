package scalqa; package Util

import java.math.{ BigDecimal => BD }

class Percent private (protected val real: Double) extends AnyVal with Any.Datum.Double.Number[Percent] {

  protected def setup = Percent

  override def +(p: Percent) = make(real + p.real)

  override def -(p: Percent) = make(real - p.real)

  override def toString = real.toFloat.toString + "%"

  private[scalqa] def apply(v: BD): BD = v.divide(Percent.Big100).multiply(BD.valueOf(real))
}

object Percent extends Any.Datum.Double.Number.Setup[Percent] {
  private val Big100 = BD.valueOf(100)

  private[scalqa] def make(bd: BD, base: BD): Percent = new Percent(bd.divide(base).multiply(Big100).doubleValue)

  @inline final def make(v: Double): Percent = new Percent(v)

  val Hundred = new Percent(100)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Percent ->
 *
 *     General 'percent' presentation.
 *
 *     Note: Percent is aliased  to scalqa root and can universally be used without 'Util' prefix.
 *
 * @object Percent ->    [[Percent]] can be created by built-it constructor on any primitive (like: Int, Double, etc)
 *     {{{
 *       3.Percent.lp     // Prints: 3.0%
 *       3.14.Percent.lp  // Prints: 3.14%
 *     }}}
 *
 * @def toString -> String description
 *
 *     Double value is converted to Float and '%'
 *
 *    {{{
 *      3.1416.Percent.lp // Prints: 3.14%
 *    }}}
 *
 * @def make(v -> By Double
 *
 *     Easier way is to use built-in constructor:
 *     {{{
 *       3.14.Percent.lp  // Prints: 3.14%
 *     }}}
 */
