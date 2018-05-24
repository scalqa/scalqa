package scalqa; package Sorting; package Itself

trait _Trait extends Any {
  protected type SORTABLE

  protected def sortingPositionTo(that: SORTABLE): Position

}

object _Trait {

  @inline private[Itself] def sortingPositionTo[A](c: Itself, a: A) = c.sortingPositionTo(a.cast)

  import scala.language.implicitConversions

  implicit def zzLibrary[A](v: Itself) = new _library[v.SORTABLE](v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait ->
 *
 *   [[Sorting.Itself]] trait indicates that there is some built-in, inherent way to sort elements of this type.
 *
 *   If implemented, all instances of the type will always be sortable,
 *   which means that there will always be an implicit [[Sorting]] available.
 *
 *   Note: The only abstract method is "protected", but it can be called through the library
 *
 * @def sortingPositionTo(that -> Sorting Position
 *
 *     Returns [[Sorting.Position]] where ''this'' should be put relative to ''that''
 *
 *     {{{
 *       //Generic String example
 *       "ABC".sortingPositionTo("XY").lp  // Prints: AsIs
 *       "ABC".sortingPositionTo("ABC").lp // Prints: Either
 *       "ABC".sortingPositionTo("A").lp   // Prints: Inverse
 *     }}}
 */
