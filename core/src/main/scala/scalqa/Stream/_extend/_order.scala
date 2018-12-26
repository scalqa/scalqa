package scalqa; package Stream; package _extend

trait _order[A] { self: Stream[A] =>

  def sort(implicit o: Ordering[A]): ~[A] = Z.extend.order.sort(this, o)

  def sortBy[B](f: Mapping[A, B])(implicit o: Ordering[B]): ~[A] = Z.extend.order.sortBy(this, o, f)

  def sortBy[B: Ordering, C: Ordering](f1: Mapping[A, B], f2: Mapping[A, C]): ~[A] = sortBy(new Mapping[A, (B, C)] { def apply(v: A) = (f1(v), f2(v)) })

  def sortBy[B: Ordering, C: Ordering, D: Ordering](f1: Mapping[A, B], f2: Mapping[A, C], f3: Mapping[A, D]): ~[A] = sortBy(new Mapping[A, (B, C, D)] { def apply(v: A) = (f1(v), f2(v), f3(v)) })

  def sortReversed(implicit o: Ordering[A]): ~[A] = Z.extend.order.sort(this, o.reverse)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _order -> `Ordering Interface`
 *
 * @def sort( -> Sort
 *
 *   Sorts stream elements with provided Ordering
 *
 *   {{{
 *      (5 ~+ 1 + 4 + 2 + 3).sort.lp
 *      // Output
 *      ~(1, 2, 3, 4, 5)
 *   }}}
 *
 * @def sortReversed( -> Sort reversed
 *
 *   Sorts pipeline elements with provided Ordering, which is reversed
 *
 *   {{{
 *      (5 ~+ 1 + 4 + 2 + 3).sortReversed.lp
 *      // Output
 *      ~(5, 4, 3, 2, 1)
 *   }}}
 *
 * @def sortBy[B] -> Sort by property
 *
 *   Sorts pipeline on element's property, which is provided by given function
 *
 *   {{{
 *      ~.*("aaaa", "bb", "ccc", "d").sortBy(_.length).lp
 *
 *      // Output
 *      ~(d, bb, ccc, aaaa)
 *   }}}
 *
 * @def sortBy[B: Ordering, C: Ordering] -> Sort by two properties
 *
 *   Sorts pipeline on first property, and then, if indeterminate on second
 *
 * @def sortBy[B: Ordering, C: Ordering, D: Ordering] -> Sort by three properties
 *
 *   Sorts pipeline on first property, then if indeterminate on second, etc...
 *
 */
