package scalqa; package String; package _library; package _evaluate

trait _compare extends Any with Sorting.Comparable with __ {
  protected type VALUE = String
  protected type SORTABLE = String

  def sortingPositionTo(that: String): Sorting.Position = Sorting.Position.getByInt(This.compareTo(that))

  def ===(v: String.Like): Boolean = This == v.value

  def =!=(v: String.Like): Boolean = This != v.value
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def === -> Value equal
 *
 *   Checks if the base value is equal
 *
 *   {{{
 *     "abc" === "abc".Text lp // Prints: true
 *
 *     "abc" ==  "abc".Text lp // Prints: false
 *   }}}
 *
 * @def =!= -> Value not equal
 *
 *   Checks if the base value is not equal
 *
 *   {{{
 *     "abc" =!= "abc".Text lp // Prints: false
 *
 *     "abc"  != "abc".Text lp // Prints: true
 *   }}}
 */
