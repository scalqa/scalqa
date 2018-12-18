package scalqa

package object Any {
  type Class[A] = Class._Class[A]
  type Datum[A, B] = Datum._Trait[A, B]
  type Itself[A] = Itself._Class[A]
  type O = O._Trait
  type Collection[+A] = Collection._Trait[A]
  type Wrap[+A] = Wrap._Trait[A]

  def isVoid(v: Any): Boolean = v match {
    case v: Able.Void => v.isVoid
    case null         => true
    case v: String    => v.length == 0
    case v: Array[_]  => v.length == 0
    case v: Int       => v == 0
    case v: Long      => v == 0
    case v: Double    => v == 0
    case v: Float     => v == 0
    case v: Short     => v == 0
    case _            => false
  }

  private[scalqa] def toString(v: Any) = v.Class.label.copyAfter("scalqa.")

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Any ->  Package for base `scala.Any` type
 *
 *   Package [[Any]] is a natural extension of root functionality
 *
 *   All included types could logically be located in the root package, but moved to [[Any]] because of potential naming conflicts or to reduce root crowding
 *
 * @def isVoid -> Void check
 *
 *     This is the central way to check an instance for voidness
 *
 *     [[Any]] is void only in following cases:
 *
 *       - `null` is always void
 *       - String instance with 'length==0' is void
 *       - Array instance with 'length==0' is void
 *       - Short == 0 is void
 *       - Int == 0 is void
 *       - Long == 0 is void
 *       - Float == 0 is void
 *       - Double == 0 is void
 *       - [[Any]] instance implementing [[Any.Able.Void]] where 'isVoid==true' is void
 *
 *      Note. There is a better way to run this method. `isVoid` shortcut is universally available on every [[Any]] instance through library
 *
 *      {{{
 *        (null: String).isVoid lp  // Prints: true
 *
 *        "".isVoid lp              // Prints: true
 *
 *        (\/ : Percent).isVoid lp  // Prints: true
 *
 *        10.isVoid lp             // Prints: false
 *      }}}
 */
