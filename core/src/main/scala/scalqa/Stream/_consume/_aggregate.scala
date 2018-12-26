package scalqa; package Stream; package _consume

trait _aggregate[A] extends Flow._consume._aggregate[A] { self: Stream[A] =>

  override def fold(start: A)(op: Folding[A]): A = Z.consume.aggregate.fold(this, start, op)
  override def foldAs[B: Ilk](start: B)(op: Folding.As[B, A]): B = Stream.Z.consume.aggregate.fold.as(this, start, op)
  override def foldFlowAs[B: Ilk](start: B)(op: Folding.As[B, A], cf: Folding[B] = null): B = foldAs(start)(op)

  override def reduce(op: Folding[A]): A = reduceOpt(op).value
  override def reduceOpt(op: Folding[A]): Opt[A] = Z.consume.aggregate.reduce.Opt(this, op)

  override def sum(implicit n: Numeric[A]): A = Z.consume.aggregate.sum(this)
  def sumFew[B: Numeric](f: Mapping[A, B]*): Idx[B] = Z.consume.aggregate.sum.few(this, f)

  def average(implicit n: Numeric[A]): A = Z.consume.aggregate.average.Opt(this) or n.zero
  def averageFew[B: Numeric](f: Mapping[A, B]*): Idx[B] = Z.consume.aggregate.average.Few(this, f)

  override def range(implicit c: Ordering[A]): Range[A] = foldAs[Range[A]](\/)(_ extendTo _)

  override def minOpt(implicit c: Ordering[A]): Opt[A] = Z.consume.aggregate.min.Opt(this)
  override def minByOpt[B](f: Mapping[A, B])(implicit o: Ordering[B]): Opt[A] = Z.consume.aggregate.min.ByOpt(this, f)

  override def maxOpt(implicit c: Ordering[A]): Opt[A] = Z.consume.aggregate.max.Opt(this)
  override def maxByOpt[B](f: Mapping[A, B])(implicit o: Ordering[B]): Opt[A] = Z.consume.aggregate.max.ByOpt(this, f)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _aggregate ->  `Aggregate Interface`
 *
 *   All methods fully pump the pipeline
 *
 * @def foldFlowAs -> foldAs
 *
 *   For [[Stream]] this method is same as [[foldAs]]
 *
 *   Only use it when dealing with [[Stream.Flow]] interface
 *
 * @def average( -> Average
 *
 *   Computes average
 *
 *   {{{
 *       (10.0 <> 15.0).all.average.lp // Prints: 12.5
 *   }}}
 *
 * @def foldAs[ -> Fold and convert
 *
 *   Folds and converts elements with a binary function
 *
 *   {{{
 *       // Calculate sum of first 1000 Ints
 *
 *       (1 <> 1000).all.foldAs[Long](0L, _ + _).lp // Prints: 500500
 *   }}}
 *
 *   @param start seed value to start with
 *   @param bf binary function to fold elements with
 *
 * @def averageFew -> Multi average
 *
 *   Simultaneously computes multiple average values for properties specified by several functions
 *
 *   Returns [[Idx]] with values corresponding to the given mappings
 *
 *   For empty pipelines returned [[Idx]] will still hold zero numerics, but will test `isVoid` positive
 *
 *   {{{
 *     def average3(stream: ~[Int]): Idx[Int] = stream.averageFew(AS_IS, _ * 10, _ * 100)
 *
 *     average3(1 <> 10).all lp   // Prints: ~(5, 55, 550)
 *
 *     average3(\/).all lp        // Prints: ~(0, 0, 0)
 *
 *     average3(\/).I.Opt lp      // Prints: Opt.Void
 *   }}}
 *
 *    Note: Currently this method is not specialized and will auto box primitives
 *
 * @def sumFew -> Multi sum
 *
 *   Simultaneously computes multiple sum values for properties specified by several functions
 *
 *   Returns [[Idx]], with values corresponding to the given mappings
 *
 *   For empty pipelines returned [[Idx]] will still hold zero numerics, but will test `isVoid` positive
 *
 *   {{{
 *     def sum3(stream: ~[Int]): Idx[Int] = stream.sumFew(AS_IS, _ * 10, _ * 100)
 *
 *     sum3(1.I repeat 10).all lp  // Prints: ~(10, 100, 1000)
 *
 *     sum3(\/).all lp             // Prints: ~(0, 0, 0)
 *
 *     sum3(\/).I.Opt lp           // Prints: Opt.Void
 *   }}}
 *
 *    Note: Currently this method is not specialized and will auto box primitives
 */
