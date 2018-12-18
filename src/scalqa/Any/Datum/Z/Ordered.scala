package scalqa; package Any; package Datum; package Z

private[scalqa] trait Ordered[TYPE] extends Any {

  def <(v: TYPE): Boolean

  def <=(v: TYPE): Boolean

  def >(v: TYPE): Boolean

  def >=(v: TYPE): Boolean

  def max(v: TYPE): TYPE

  def min(v: TYPE): TYPE

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def <( -> Is less test
 *
 *    Returns true if `this` is less than v, `false` otherwise
 *
 * @def <=( -> Is less or equal test
 *
 *    Returns true if `this` is less or equal to v, `false` otherwise
 *
 * @def >( -> Is greater test
 *
 *    Returns true if `this` is greater than v, `false` otherwise
 *
 * @def >=( -> Is greater or equal test
 *
 *    Returns true if `this` is greater or equal to v, `false` otherwise
 *
 * @def min -> Minimum value
 *
 *     Returns minimum of `this` and provided value
 *
 * @def max -> Maximum value
 *
 *     Returns maximum of `this` and provided value
 */
