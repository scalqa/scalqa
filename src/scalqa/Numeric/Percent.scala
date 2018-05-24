package scalqa; package Numeric

class Percent private (protected val real: Double) extends AnyVal with Double.Like {
  protected override type THIS = Percent
  protected def companion = Percent

  override def toString = value.round(2) + "%"

  def apply(number: Double): Double = number / 100d * value

}

object Percent extends Double.Like.Companion[Percent] {

  def get(v: Double) = new Percent(v)

  def getScaled(value: Double, scale: Double): Percent = get(value / scale * 100)

  def getDifference(v1: Double, v2: Double): Percent = if (v1 < v2) getScaled(v2 - v1, v2) else getScaled(v1 - v2, v1)

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
 *     Note: Percent is generalized to Scalqa root and can universally be used without 'Numeric' prefix.
 *
 *
 * @object Percent ->    [[Percent]] can be created by built-it constructor on any primitive (like: [[Int]], [[Double]], etc)
 *     {{{
 *       3.Percent.lp     // Prints: 3.0%
 *       3.14.Percent.lp  // Prints: 3.14%
 *     }}}
 *
 * @def get( -> By Double
 *
 *     Easier way is to use built-in constructor:
 *     {{{
 *       3.14.Percent.lp  // Prints: 3.14%
 *     }}}
 *
 * @def getScaled -> By value and scale
 *
 *     {{{
 *       Percent.getScaled(5, 50).lp  // Prints: 10.0%
 *     }}}
 *
 * @def getDifference -> By difference
 *
 *     Two values difference is ''getScaled'' against the largest value.
 *
 *     {{{
 *         Percent.getDifference(100, 30).lp // Prints: 70.0%
 *     }}}
 *
 * @def apply -> Value percent
 *
 *     Returns ''this'' [[Percent]] value of ''number''
 *
 *     {{{
 *       3.Percent(1000).lp // Prints: 30.0
 *     }}}
 *
 * @def toString -> String description
 *
 *     Value is rounded to 2 decimals after period and '%' sign is added.
 *
 *  {{{
 *      3.1416.Percent.lp // Prints: 3.14%
 *  }}}
 *
 */
