package scalqa; package Util

package object Random {

  def int: Int = App.Setup.RandomSourcePro().int

  def intBelow(ceiling: Int) = { var v = int; if (v < 0) v = -v; v % ceiling }

  def boolean = intBelow(2) == 0

  def chance(chance: Percent): Boolean = chance.toInt > intBelow(100)

  def percent: Percent = { val f = fractionOfOne; if (f == 0) Percent.Hundred else Percent.make(f * 100) }

  def fractionOfOne: Double = App.Setup.RandomSourcePro().fractionOfOne

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Random -> `Random Number Generator`
 *
 *   Default random source is java.util.Random
 *
 *   Custom source can be set in App.Setup
 *
 * @def int: -> Random Int
 *
 *     Returns random Int from 0 to Int.MaxValue
 *
 * @def fractionOfOne: -> Random 1.0 fraction
 *
 *     Returns random Double from 0 to 1 exclusive
 *
 * @def percent: -> Random percent
 *
 *     Returns random [[Percent]] from 0 exclusive to 100 inclusive
 *
 * @def intBelow -> Random Int within
 *
 *     Returns random Int from 0 to `ceiling` exclusive
 *
 * @def boolean -> Random true or false
 *
 *     Returns random `true` or `false` with 50% chance each
 *
 * @def chance -> Random true or false with odds
 *
 *     Returns `true` with given `chance` percent probability
 *     {{{
 *         // Prints "Hooray" with 15 percent chance
 *         if(Random.chance(15.Percent)) "Hooray".lp
 *     }}}
 */
