package scalqa; package Any; package Able

trait Sort[A, THIS] extends Any {

  def sort(implicit c: Ordering[A]): THIS

  def sortBy[B](f: A => B)(implicit c: Ordering[B]): THIS = sort(c.asMappedView(f))

  def sortBy[B, C](f1: A => B, f2: A => C)(implicit o1: Ordering[B], o2: Ordering[C]): THIS = sortBy(a => (f1(a), f2(a)))

  def sortBy[B, C, D](f1: A => B, f2: A => C, f3: A => D)(implicit o1: Ordering[B], o2: Ordering[C], o3: Ordering[D]): THIS = sortBy(a => (f1(a), f2(a), f3(a)))

  def sortReversed(implicit c: Ordering[A]) = sort(c.reverse)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Sort -> `Generic Sort`
 *
 * @def sort( -> Sort elements
 *
 *     Sorts elements in `this` container
 *
 * @def sortBy[B] -> Sort by property
 *
 *     Sorts elements in `this` container based on given property map
 *
 * @def sortBy[B, C] -> Sort by two properties
 *
 *     Sorts elements in `this` container based on given two properties
 *
 * @def sortBy[B, C, D] -> Sort by three properties
 *
 *     Sorts elements in `this` container based on given three properties
 *
 * @def sortReversed( -> Sort in reverse
 *
 *     Sorts elements in `this` container in reverse
 *
 */
