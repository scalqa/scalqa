package scalqa; package Any; package Datum; package Z

private[scalqa] trait Computable[TYPE] extends Any {

  def abs: TYPE

  def +(v: TYPE, V: \/ = \/): TYPE
  def +(p: Percent): TYPE

  def -(v: TYPE, V: \/ = \/): TYPE
  def -(p: Percent): TYPE

  def %@(v: TYPE): Percent

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def abs -> Absolute value
 *
 *     Returns absolute value of `this`
 *
 * @def +(v: TYPE -> Add value
 *
 *     Returns a new value, which is an addition of `this` and `v`
 *
 * @def +(p: Percent -> Add percent
 *
 *     Returns a new value, which is `this` with added percent of `this`
 *
 * @def -(v: TYPE -> Subtract value
 *
 *     Returns a new value, which is a subtraction of `v` from `this`
 *
 * @def -(p: Percent -> Subtract percent
 *
 *     Returns a new value, which is `this` with subtracted percent of `this`
 *
 * @def %@ -> Percent At
 *
 *     Returns percentage of `this` compared to `v`
 *
 */
