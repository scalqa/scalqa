package scalqa; package Pipe; package Flow; package _pump

trait _reduce[A] extends __[A] {

  def fold(start: A, bf: (A, A) ⇒ A): A = foldAsOpt[A](start, bf, bf.cast) or start

  def foldOpt(bf: (A, A) ⇒ A): Opt[A]

  def foldAsOpt[B](start: B, bf: (B, A) ⇒ B, cf: (B, B) => B): Opt[B]

  // ----------------------------------------------------------------------------------------
  def average[NUM <: Numeric](implicit c: Any.As.Numeric[A, NUM]): NUM = Z.reduce.average(This, c)
  def averageFew[B, NUM <: Numeric](f: A => B*)(implicit c: Any.As.Numeric[B, NUM]): Index[NUM] = Z.reduce.average.few(This, f: _*)

  def sum[NUM <: Numeric](implicit c: Any.As.Numeric[A, NUM]): NUM = Z.reduce.sum(This, c)
  def sumFew[B, NUM <: Numeric](f: A => B*)(implicit c: Any.As.Numeric[B, NUM]): Index[NUM] = Z.reduce.sum.few(This, f: _*)

  def range(implicit s: Sorting[A]): Range[A] = Z.reduce.range(This)(s)
  def minOpt(implicit s: Sorting[A]): Opt[A] = Z.reduce.range.minOpt(This, s)
  def maxOpt(implicit s: Sorting[A]): Opt[A] = Z.reduce.range.maxOpt(This, s)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _reduce ->  '''Reduce Interface'''
 *
 *     All methods fully pump the pipeline
 *
 * @def fold( -> Basic fold
 *
 *   Folds elements with a binary function
 *
 *   Returns ''start'' value for empty pipeline
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
 * @def foldOpt( -> Optional fold
 *
 *   Folds elements with a binary function
 *
 *   Returns Opt.Void for empty pipeline
 *
 *   @param bf binary function to fold elements with.
 *
 *   @example
 *   {{{
 *      // Multiply every element by next
 *
 *     (1 <> 10).all.foldOpt(_ * _).lp // Prints: Opt(3628800)
 *   }}}
 *
 * @def foldAsOpt -> Fold and convert
 *
 *   Folds and converts elements with a binary function.
 *
 *   Returns Opt.Void for empty pipeline
 *
 *   @param start seed value to start with
 *   @param bf binary function to fold elements with
 *   @param cf collect function to put together results of parallel computations. It is not required and ignored for [[Pipe]]
 *
 *   @example
 *   {{{
 *       // Calculate sum of first 1000 Ints in 10 concurrent jobs
 *
 *       (1 <> 1000).all.parallelGroup(100).foldAsOpt[Long](0L, _ + _, _ + _).lp // Prints: 500500
 *   }}}
 *
 * @def average[ -> Average
 *
 *   Computes average
 *
 *   @example
 *   {{{
 *       (10.0 <> 15.0).all.average.lp // Prints: 12.5
 *   }}}
 *
 * @def averageFew -> Multi average
 *
 *   Simultaneously computes multiple average values for properties specified by several functions
 *
 *   Returns [[Index Index[Numeric]]], each corresponding to the given function
 *
 *   For empty pipelines returned [[Index]] will still hold zero numerics, but will test ''isVoid'' positive
 *
 *   @example
 *   {{{
 *     def average3(pipe: ~[Int]): Index[Numeric] = pipe.averageFew(SELF, _ * 10, _ * 100)
 *
 *     average3(1 <> 10).all lp  // Prints: ~(5, 55, 550)
 *
 *     average3(\/).all lp       // Prints: ~(0, 0, 0)
 *
 *     average3(\/).Opt lp       // Prints: Opt.Void
 *   }}}
 *
 * @def sum[ -> Sum
 *
 *   Computes sum value of all elements
 *
 *   @example
 *   {{{
 *       (0 <> 1000).all.sum.lp // Prints: 500500
 *   }}}
 *
 * @def sumFew -> Multi sum
 *
 *   Simultaneously computes multiple sum values for properties specified by several functions
 *
 *   Returns [[Index Index[Numeric]]], each corresponding to the given function
 *
 *   For empty pipelines returned [[Index]] will still hold zero numerics, but will test ''isVoid'' positive
 *
 *   @example
 *   {{{
 *       def sum3(pipe: ~[Int]): Index[Numeric] = pipe.sumFew(SELF, _ * 10, _ * 100)
 *
 *       sum3((1 <> 10).all.swap(1)).all lp  // Prints: ~(10, 100, 1000)
 *
 *       sum3(\/).all lp                     // Prints: ~(0, 0, 0)
 *
 *       sum3(\/).Opt lp                     // Prints: Opt.Void
 *   }}}
 *
 * @def range -> Element Range
 *
 *   Calculates min and max elements (according to the [[Sorting]]), and returns result as [[Range]]
 *
 *   Note. Range is void for empty pipelines.
 *
 *   @example
 *   {{{
 *       (4 ~ 1 ~ 12 ~ 7).range.lp
 *
 *       // Output
 *       1 <> 12
 *   }}}
 *
 * @def minOpt -> Smallest
 *
 *   Calculates minimal element, based on the [[Sorting]]
 *
 *   @example
 *   {{{
 *       (4 ~ 3 ~ 12 ~ 7).minOpt.lp // Prints: Opt(3)
 *   }}}
 *
 * @def maxOpt -> Largest
 *
 *  Calculates maximum element, based on the [[Sorting]]
 *
 *   @example
 *   {{{
 *       *(4, 3, 12, 7).maxOpt.lp // Prints: Opt(12)
 *   }}}
 */
