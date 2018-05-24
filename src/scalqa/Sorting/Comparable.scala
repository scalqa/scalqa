package scalqa; package Sorting

trait Comparable extends Any with Itself {

  protected def _target: Any

  protected def sortingPositionTo(that: SORTABLE): Position

  def <(that: SORTABLE): Boolean = sortingPositionTo(that).isAsIs

  def >(that: SORTABLE): Boolean = sortingPositionTo(that).isInverse

  def <=(that: SORTABLE): Boolean = sortingPositionTo(that).isNotInverse

  def >=(that: SORTABLE): Boolean = sortingPositionTo(that).isNotAsIs

  def min(that: SORTABLE): SORTABLE = if (_target.isVoid) that else if (that.isVoid) _target.cast else if (<=(that)) _target.cast else that

  def max(that: SORTABLE): SORTABLE = if (_target.isVoid) that else if (that.isVoid) _target.cast else if (>=(that)) _target.cast else that

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Comparable ->
 *
 *     [[Sorting.Comparable]] extends [[Sorting.Itself]].
 *
 *     Instances of this type are not only sortable,
 *     they are also comparable to each other with comparison operators
 *
 *     "min" and 'max" can also be determined
 *
 * @def <( -> Compare less
 *
 *     Returns true if ''this'' is less than ''that''
 *
 * @def >( -> Compare greater
 *
 *     Returns true if ''this'' is greater than ''that''
 *
 * @def <= -> Compare less or equal
 *
 *     Returns true if ''this'' is less or equal to ''that''
 *
 * @def >= -> Compare greater or equal
 *
 *     Returns true if ''this'' is greater or equal to ''that''
 *
 * @def min -> Minimal
 *
 *     Returns minimal out of ''this'' and ''that''
 *
 * @def max -> Maximal
 *
 *     Returns maximal out of ''this'' and ''that''
 *
 */
