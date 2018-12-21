package scalqa; package Util; package Enum

abstract class _Class[ENUM <: _Class[ENUM]](protected val setup: Setup[ENUM]) {

  lazy val name = setup.names(ordinal)

  val ordinal: Int = setup.register(this.asInstanceOf[ENUM])

  override def toString = name

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class -> A standard way to create enumerated types
 *
 *     {{{
 *         sealed class Direction extends Util.Enum[Direction](Direction)
 *
 *         object Direction extends Util.Enum.Setup[Direction] {
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
 *     Returns `name`
 *
 * @val name -> Name as defined
 *
 *     Returns `enum` name as it was defined in the class file
 *
 *     Name is found by introspection
 *
 * @val ordinal -> Sequential index
 *
 *     Idx of `enum` in the order it was created
 *
 *     Idx starts from 0
 *
 */
