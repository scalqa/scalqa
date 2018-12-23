package scalqa; package Util

package object Range {
  private[scalqa] def This = this

  def apply[A: Ordering: Ilk](start: A, end: A, endEx: Boolean = false): Range[A] = general(start, false, end, endEx)

  def make[A: Ordering: Ilk](start: A, end: A, endEx: Boolean = false): Range[A] = general(start, false, end, endEx)

  def one[A: Ordering](a: A, ex: Boolean)(implicit i: Ilk[A]): Range[A] = i.primitiveOpt.map(_ => general(a, false, a, ex)) or Z.A.One.make(a, ex)

  def general[A](start: A, startEx: Boolean, end: A, endEx: Boolean)(implicit o: Ordering[A], i: Ilk[A]): Range[A] =
    i.ilkOpt.map(_.mkRange(start, startEx, end, endEx, o)) or new Z.A.Any[A](start, startEx, end, endEx, o)

  @inline final def startContains[A](r: Range[A], v: A, x: Boolean = false) = Z.Base.startContains(r, v, x)
  @inline final def endContains[A](r: Range[A], v: A, x: Boolean = false) = Z.Base.endContains(r, v, x)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

/**
 * @def apply -> 'make' overload
 *
 *     Same as 'make' for shorter expression where applicable
 *
 * @def make[ -> By values
 *
 *   Creates range with default inclusive values
 *
 *   {{{ Range.make(1,5) // Same as: (1 <> 5) }}}
 *
 * @def general -> By values
 *
 *   Creates range with explicit exclusive designations
 *
 *   {{{ Range.make(1,true,5,true) // Same as: (1 <<>> 5) }}}
 *
 * @object Range ->
 *
 *   [[Range]] can be created with special built-in constructors attached to every type, see [[Any._library]]
 *
 *   {{{
 *       'A' <> 'D'   // Range[Char] from 'A' to 'D'
 *
 *       "X" <>> "Z"  // Range[String] from "X" to "Z" exclusive
 *
 *       1.0 <<> 5.0  // Range[Double] from exclusive 1.0 to 5.0
 *
 *       1  <<>> 5    // Range[Int] from exclusive 1 to 5 exclusive
 *
 *       5L <>+ 3     // Range[Long] from 5 to 8
 *
 *       5D <>>+ 3    // Range[Double] from 5.0 to 8.0 exclusive
 *
 *       "abc" <>!    // Range[String] from "abc" to "abc"
 *
 *       "abc" <>>!   // Range[String] from "abc" to "abc" exclusive
 *   }}}
 */
