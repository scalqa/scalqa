package scalqa; package Range

trait _Trait[A] extends Any with _basic[A] with _evaluate[A] with _all[A]

object _Trait extends {

  import scala.language.implicitConversions

  implicit def zzGet[A](v: \/.type)(implicit s: Sorting[A]): Range[A] = new Z.Void(s)

  implicit def zzAll[A](v: Range[A])(implicit is: Int.Step[A], s: Sorting[A]): ~[A] = v.all

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> '''Generic Range'''
 *
 *    [[Range]] is defined for given type of elements
 *
 *    [[Range]] has ''start'', ''end'', and [[Sorting]] defining the order of elements
 *
 *    [[Range]] has a notion that an element can be within the range, i.e. between start and end, or outside
 *
 *    Note. [[Range]] is implicitly converted to a filter function, returning ''true'' if an element is within [[Range]] and ''false'' otherwise
 *
 *    [[Range]] can be created with special built-in constructors attached to every type, see [[Any._library._range]]
 *
 *    {{{
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
 *    }}}
 */
