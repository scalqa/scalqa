package scalqa; package Stream; package Flow; package _consume

trait _aggregate[A] { self: Flow[A] =>

  def reduce(bf: Folding[A]): A = reduceOpt(bf).value

  def reduceOpt(bf: Folding[A]): Opt[A]

  def fold(start: A)(bf: Folding[A]): A = foldFlowAs[A](start)(bf, bf)

  def foldFlowAs[B: Ilk](start: B)(bf: Folding.As[B, A], cf: Folding[B]): B

  // ----------------------------------------------------------------------------------------

  def sum(implicit n: Numeric[A]): A = foldFlowAs(n.zero)(n.plus, n.plus)

  def range(implicit c: Ordering[A]): Range[A] = foldFlowAs[Range[A]](\/)(_ extendTo _, _ join _)

  def min(implicit o: Ordering[A]): A = minOpt.value
  def minOpt(implicit o: Ordering[A]): Opt[A] = reduceOpt((x, y) => if (o.compare(x, y) <= 0) x else y)

  def minBy[B](f: Mapping[A, B])(implicit o: Ordering[B]): A = minByOpt(f).value
  def minByOpt[B](f: Mapping[A, B])(implicit o: Ordering[B]): Opt[A] = reduceOpt((x, y) => if (o.compare(f(x), f(y)) <= 0) x else y)

  def max(implicit o: Ordering[A]): A = maxOpt.value
  def maxOpt(implicit o: Ordering[A]): Opt[A] = reduceOpt((x, y) => if (o.compare(x, y) >= 0) x else y)

  def maxBy[B](f: Mapping[A, B])(implicit o: Ordering[B]): A = maxByOpt(f).value
  def maxByOpt[B](f: Mapping[A, B])(implicit o: Ordering[B]): Opt[A] = reduceOpt((x, y) => if (o.compare(f(x), f(y)) >= 0) x else y)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _aggregate ->  `Reduce Interface`
 *
 *     All methods fully pump the pipeline
 *
 * @def reduce( -> Reduces elements with a Folding functions
 *
 *   Will fail for empty Stream
 *
 * @def reduceOpt -> Reduces elements with a Folding functions
 *
 *   Returns Opt.Void for for empty Stream
 *
 * @def fold( -> Basic fold
 *
 *   Folds elements with a binary function
 *
 *   Returns `start` value for empty pipeline
 *
 *   @param start seed value to start with
 *   @param bf binary function to fold elements with
 *
 *   @example
 *   {{{
 *      // Multiply every element by next
 *
 *      (1 <> 10).all.fold(1, _ * _).lp   // Prints: 3628800
 *   }}}
 *
 * @def foldFlowAs -> Fold and convert
 *
 *   Folds and converts elements with a binary function.
 *
 *   Returns Opt.Void for empty pipeline
 *
 *   @param start seed value to start with
 *   @param bf binary function to fold elements with
 *   @param cf collect function to put together results of parallel computations. It is not required and ignored for [[Stream]]
 *
 *   @example
 *   {{{
 *       // Calculate sum of first 1000 Ints in 10 concurrent jobs
 *
 *       (1 <> 1000).all.parallelGroup(100).foldFlowAs[Long](0L, _ + _, _ + _).lp // Prints: 500500
 *   }}}
 *
 * @def sum( -> Sum
 *
 *   Computes sum value of all elements
 *
 *   {{{
 *       (0 <> 1000).all.sum.lp // Prints: 500500
 *   }}}
 *
 *
 * @def range -> Element Range
 *
 *   Selects min and max elements (according to the Ordering ), and returns result as [[Range]]
 *
 *   Note. Range is void for empty pipelines.
 *
 *   {{{
 *       (4 ~+ 1 + 12 + 7).range.lp
 *
 *       // Output
 *       1 <> 12
 *   }}}
 *
 * @def min( -> Smallest
 *
 *   Selects minimal element, based on the Ordering
 *
 *   Fails for empty stream
 *
 *   {{{
 *       (4 ~+ 3 + 12 + 7).minOpt.lp // Prints: 3
 *   }}}
 *
 * @def minOpt -> Smallest
 *
 *   Selects minimal element, based on the Ordering
 *
 *   {{{
 *       (4 ~+ 3 + 12 + 7).minOpt.lp // Prints: Opt(3)
 *   }}}
 *
 * @def minBy[ -> Smallest by property
 *
 *   Selects minimal element, based on mapping
 *
 *   Fails for empty stream
 *
 *   {{{
 *       ("AA" ~+ "B" + "CCCC" + "DDD").minBy(_.length).lp // Prints: B
 *   }}}
 *
 * @def minByOpt -> Smallest by property option
 *
 *   Selects minimal element, based on mapping
 *
 *   {{{
 *       ("AA" ~+ "B" + "CCCC" + "DDD").minBy(_.length).lp // Prints: Opt(B)
 *   }}}
 *
 * @def max( -> Largest
 *
 *   Selects maximum element, based on the Ordering
 *
 *   Fails for empty stream
 *
 *   {{{
 *       ~.*(4, 3, 12, 7).maxOpt.lp // Prints: 12
 *   }}}
 *
 * @def maxOpt -> Largest
 *
 *  Selects maximum element, based on the Ordering
 *
 *   {{{
 *       ~.*(4, 3, 12, 7).maxOpt.lp // Prints: Opt(12)
 *   }}}
 *
 * @def maxBy[ -> Largest by property
 *
 *   Selects maximum element, based on mapping
 *
 *   Fails for empty stream
 *
 *   {{{
 *       ("AA" ~+ "B" + "CCCC" + "DDD").maxBy(_.length).lp // Prints: CCCC
 *   }}}
 *
 * @def maxByOpt -> Largest by property option
 *
 *   Selects maximum element, based on mapping
 *
 *   {{{
 *       ("AA" ~+ "B" + "CCCC" + "DDD").maxBy(_.length).lp // Prints: Opt(CCCC)
 *   }}}
 */
