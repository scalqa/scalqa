package scalqa

package object Any {
  type BiMap[A, B] = BiMap._Trait[A, B]
  type Class[A] = Class._Class[A]
  type Enum[A <: Enum[A]] = Enum._Class[A]
  type Event = Event._Trait
  type Itself[A] = Itself._Class[A]
  type Extra = Extra._Trait
  type O = O._Trait
  type Value = Value._Trait

  def isVoid(v: Any): Boolean = v match {
    case v: Able.Void => Able.Void._Trait.isVoid(v): @inline
    case null         => true
    case v: String    => v.length == 0
    case _            => false
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Any ->  Package for base '''scala.Any''' type
 *
 *   Package [[Any]] is a natural extension of root functionality
 *
 *   All these types could logically be located in Scalqa root package, but moved to [[Any]] because of potential naming conflicts or to reduce root crowding
 *
 * @def isVoid -> Void check
 *
 *     This is the central way to check an instance for voidness
 *
 *     There is only 3 types of void objects:
 *
 *       - ''null'' is always void
 *       - [[String]] instance with 'length==0' is void
 *       - [[Any]] instance implementing [[Able.Void]] where 'isVoid==true' is void
 *
 *      Note. There is a better way to run this method. ''isVoid'' shortcut is universally available on any [[Any]] instance through library
 *
 *      {{{
 *        (null: String).isVoid lp  // Prints: true
 *
 *        "".isVoid lp              // Prints: true
 *
 *        (\/ : Percent).isVoid lp  // Prints: true
 *
 *        10.Percent.isVoid lp      // Prints: false
 *      }}}
 */
