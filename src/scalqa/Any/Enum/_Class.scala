package scalqa; package Any; package Enum

abstract class _Class[ENUM <: _Class[ENUM]](protected val companion: Companion[ENUM]) extends Sorting.Itself {
  protected type SORTABLE = ENUM

  lazy val name = companion.names(ordinal)

  val ordinal: Int = companion.register(this.cast)

  protected def sortingPositionTo(s: ENUM) = Sorting.Position.getByInt(ordinal - s.ordinal)

  override def toString = name

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class -> A standard way to create enumerated types.
 *
 *     @example
 *     {{{
 *         sealed class Direction extends Any.Enum[Direction](Direction)
 *
 *         object Direction extends Any.Enum.Companion[Direction] {
 *
 *             val Up, Down = new Direction
 *
 *         }
 *
 *         Direction.Up.lp    // Prints: Direction{ordinal=0,name=Up}
 *         Direction.Down.lp  // Prints: Direction{ordinal=1,name=Down}
 *         Direction.all.lp   // Prints: ~(Up, Down)
 *     }}}
 *
 * @def toString -> Name
 *
 *     Returns ''name''
 *
 * @val name -> Name as defined.
 *
 *     Returns ''enum'' name as it was defined in the class file.
 *
 *     Name is found by introspection.
 *
 * @val ordinal -> Sequential index.
 *
 *     Index of ''enum'' in the order it was created.
 *
 *     Index starts from 0.
 *
 */
