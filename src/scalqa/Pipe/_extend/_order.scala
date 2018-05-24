package scalqa; package Pipe; package _extend

trait _order[A] extends __[A] {

  def sort(implicit s: Sorting[A]): Pipe[A] = new Z.order.sort(This)

  def sortBy[B](f: A => B)(implicit s: Sorting[B]): Pipe[A] = new Z.order.sortBy(This, s, f)

  def sortReversed(implicit o: Sorting[A]): Pipe[A] = sort(o.asReversed)

  // -----------------------------------------------------------------------------------------------------------------------------
  def sortBy[B, C](f1: A => B, f2: A => C)(implicit s1: Sorting[B], s2: Sorting[C]): Pipe[A] = sortBy(a => (f1(a), f2(a)))(s1 asForTuple s2)

  def sortBy[B, C, D](f1: A => B, f2: A => C, f3: A => D)(implicit s1: Sorting[B], s2: Sorting[C], s3: Sorting[D]): Pipe[A] = sortBy(a => (f1(a), f2(a), f3(a)))(s1.asForTuple(s2, s3))

  def sortReversedBy[B](f: A => B)(implicit o: Sorting[B]): Pipe[A] = sortBy(f)(o.asReversed)

  def sortReversedBy[B, C](f1: A => B, f2: A => C)(implicit s1: Sorting[B], s2: Sorting[C]): Pipe[A] = sortReversedBy(a => (f1(a), f2(a)))(s1 asForTuple s2)

  def sortReversedBy[B, C, D](f1: A => B, f2: A => C, f3: A => D)(implicit s1: Sorting[B], s2: Sorting[C], s3: Sorting[D]): Pipe[A] = sortReversedBy(a => (f1(a), f2(a), f3(a)))(s1.asForTuple(s2, s3))

  def deemSorted(implicit s: Sorting[A]): Pipe[A] = new Z.order.deemSorted(This, s)

  def deemSortedBy[B](m: A => B)(implicit s: Sorting[B]): Pipe[A] = new Z.order.deemSortedBy(This, s, m)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _order -> '''Ordering Interface'''
 *
 * @def sort( -> Sort
 *
 *   Sorts pipe elements on provided [[Sorting]]
 *
 *   @example
 *   {{{
 *      (5 ~ 1 ~ 4 ~ 2 ~ 3).sort.lp
 *      // Output
 *      ~(1, 2, 3, 4, 5)
 *   }}}
 *
 * @def sortReversed( -> Sort reversed
 *
 *   Sorts pipeline elements on provided [[Sorting]], which is used in reverse order
 *
 *   @example
 *   {{{
 *      (5 ~ 1 ~ 4 ~ 2 ~ 3).sortReversed.lp
 *      // Output
 *      ~(5, 4, 3, 2, 1)
 *   }}}
 *
 * @def sortBy[B] -> Sort by property
 *
 *   Sorts pipeline on element's property, which is provided by given function
 *
 *   @example
 *   {{{
 *      *("aaaa", "bb", "ccc", "d").sortBy(_.length).lp
 *
 *      // Output
 *      ~(d, bb, ccc, aaaa)
 *   }}}
 *
 * @def sortBy[B, C] -> Sort by two properties
 *
 *   Sorts pipeline on first property, and then, if indeterminate, on second
 *
 * @def sortBy[B, C, D] -> Sort by three properties
 *
 *   Sorts pipeline on first property, then if, if indeterminate, on second, etc...
 *
 * @def sortReversedBy[B] -> Sort by property in reverse
 *
 *   Sorts pipeline on element's property, which is provided by given function
 *
 *   [[Sorting]] is used in reverse
 *
 *   @example
 *   {{{
 *      *("aaaa", "bb", "ccc", "d").sortReversedBy(_.length).lp
 *
 *      // Output
 *      ~(aaaa, ccc, bb, d)
 *   }}}
 *
 * @def sortReversedBy[B, C] -> Sorts by two properties in reverse.
 *
 *   Sorts pipeline on first property, and then, if indeterminate, on second
 *
 *   [[Sorting]]s are used in reverse
 *
 * @def sortReversedBy[B, C, D] -> Sorts by three properties in reverse.
 *
 *   Sorts pipeline on first property, then if, if indeterminate, on second, etc...
 *
 *   [[Sorting]]s are used in reverse
 *
 * @def deemSorted( -> Considers elements sorted
 *
 *   Updates [[Metadata]] to indicate sorted elements, without doing any actual sorting
 *
 *   Note. If in reality the elements are not sorted, some methods like ''letAll'' will be unpredictable
 *
 * @def deemSortedBy -> Considers elements sorted by property
 *
 *   Updates [[Metadata]] to indicate elements sorted by property, without doing any sorting
 *
 *   Note. If in reality the elements are not sorted, some methods like ''letAllBy'' will be unpredictable
 */
