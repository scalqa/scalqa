package scalqa; package Sorting

trait _Trait[-A] {

  def apply(x: A, y: A): Position =
    if (voidPosition.isEither) position(x, y)
    else if (x.isVoid) { if (y.isVoid) Position.Either else voidPosition }
    else if (y.isVoid) voidPosition.reverse
    else position(x, y)

  protected def position(x: A, y: A): Position

  protected def voidPosition: Position = Position.Either

}

object _Trait {

  import scala.language.implicitConversions

  implicit def zzLibrary[A](v: Sorting[A]) = new _library[A](v)
  implicit def zzGet[A](v: \/.type): Sorting[A] = The.Void.cast

  implicit def zzGet[A](v: java.util.Comparator[A]): Sorting[A] = get(v)

  implicit def zzSortingJavaComparable = The.JavaComparable
  implicit def zzSortingItself = The.Itself
  implicit def zzSortingByte = The.Byte
  implicit def zzSortingChar = The.Char
  implicit def zzSortingShort = The.Short
  implicit def zzSortingLong = The.Long
  implicit def zzSortingFloat = The.Float
  implicit def zzSortingDouble = The.Double
  implicit def zzSortingBoolean = The.Boolean
  implicit def zzSortingInt = The.Int

  @inline private[Sorting] def voidPosition(s: Sorting[_]) = s.voidPosition
  @inline private[Sorting] def position[A](s: Sorting[A], x: A, y: A) = s.position(x, y)
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
 *   [[Sorting]] is Scalqa's equivalent to Scala's ''Ordering'' and Java's ''Comparator''
 *
 *   [[Sorting]]  is necessary because of new concept of ''void'' elements introduced, which had to be incorporated in ordering process.
 *
 *   Note: [[Sorting]] has rich type library attached
 *
 * @def apply -> Compare
 *
 *     Compares two elements and returns their correct [[Position]] according to this [[Sorting]]
 *     {{{
 *       Sorting.The.Int(1, 5).lp // Prints: AsIs
 *
 *       Sorting.The.Int(5, 1).lp // Prints: Inverse
 *
 *       Sorting.The.Int(1, 1).lp // Prints: Either
 *     }}}
 *
 *  @def position( -> Define position
 *
 *    This is the only abstract method of [[Sorting]] to be implemented
 *
 *    Returns [[Sorting.Position]] of two provided elements
 *
 * @def voidPosition: -> Position of void elements
 *
 *     Returns default ''Either'', which means that void elements will be mix sorted with all non void elements
 *
 *     Can be overridden with ''AsIs'', so void elements will precede all non voids
 *
 *     Can be overridden with ''Inverse'', so void elements will trail all non voids
 *
 */
