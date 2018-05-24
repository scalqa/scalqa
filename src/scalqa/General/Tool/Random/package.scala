package scalqa; package General.Tool

package object Random {
  private[scalqa] def This = this

  def int: Int = App.Pro.RandomEngine().int

  def oneFraction: Double = App.Pro.RandomEngine().oneFraction

  def intBelow(ceiling: Int) = { var v = int; if (v < 0) v = -v; v % ceiling }

  def boolean = intBelow(2) == 0

  def chance(chance: Percent): Boolean = chance.toInt > intBelow(100)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Random -> '''Random Number Generator'''
 *
 *   Globally available random number generating Tool
 *
 *   Default random Engine is java.util.Random
 *
 *   Custom Engine can be set at [[App.Pro.RandomEngine]]
 *
 * @def int: -> Random Int
 *
 *     Return random Int from 0 to Int.Max
 *
 * @def oneFraction: -> Random 1.0 fraction
 *
 *     Returns random Double from 0 to 1 exclusive
 *
 * @def intBelow -> Random Int within
 *
 *     Return random Int from 0 to ''ceiling'' exclusive
 *
 * @def boolean -> Random true or false
 *
 *     Returns random ''true'' or ''false'' with 50% chance each
 *
 * @def chance -> Random true or false with odds
 *
 *     Returns ''true'' with given ''chance'' percent probability
 *     {{{
 *         // Prints "Hooray" with 15 percent chance
 *         if(Random.chance(10.Percent)) Print("Hooray")
 *     }}}
 */
