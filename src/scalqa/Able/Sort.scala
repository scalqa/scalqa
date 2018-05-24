package scalqa; package Able

trait Sort[A, TARGET] extends Any {

  def sort(implicit o: Sorting[A]): TARGET

  def sortReversed(implicit o: Sorting[A]) = sort(o.asReversed)

  def sortBy[B](f: A => B)(implicit o: Sorting[B]): TARGET = sort(o.asMap(f))

  def sortBy[B, C](f1: A => B, f2: A => C)(implicit o1: Sorting[B], o2: Sorting[C]): TARGET = sortBy(a => (f1(a), f2(a)))(o1 asForTuple o2)

  def sortBy[B, C, D](f1: A => B, f2: A => C, f3: A => D)(implicit o1: Sorting[B], o2: Sorting[C], o3: Sorting[D]): TARGET = sortBy(a => (f1(a), f2(a), f3(a)))(o1.asForTuple(o2, o3))

  def sortReversedBy[B](f: A => B)(implicit o: Sorting[B]): TARGET = sortBy(f)(o.asReversed)

  def sortReversedBy[B, C](f1: A => B, f2: A => C)(implicit o1: Sorting[B], o2: Sorting[C]): TARGET = sortReversedBy(a => (f1(a), f2(a)))(o1 asForTuple o2)

  def sortReversedBy[B, C, D](f1: A => B, f2: A => C, f3: A => D)(implicit o1: Sorting[B], o2: Sorting[C], o3: Sorting[D]): TARGET = sortReversedBy(a => (f1(a), f2(a), f3(a)))(o1.asForTuple(o2, o3))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Sort -> '''Generic Sort'''
 */
