package scalqa; package Stream; package _extend

trait _flow[A] extends Flow._extend._flow[A] { self: Stream[A] =>

  override def sequential: Stream[A] = this

  def parallel: Flow[A] = Z.extend.flow.parallel(this)

  def parallelIf(boolean: Boolean): Flow[A] = Z.extend.flow.parallel.If(this, boolean)

  def parallelIfOver(threshold: Int): Flow[A] = Z.extend.flow.parallel.ifOver(this, threshold)

  def preview: Stream[A] with Preview[A] = Z.extend.flow.preview.apply(this)

  def reverse: ~[A] = Z.extend.flow.reverse(this)

  def shuffle: ~[A] = Z.extend.flow.shuffle(this)

  def transpose[B](implicit f: Mapping[A, ~[B]]): ~[~[B]] = Z.extend.flow.transpose[A, B](this, f)

  def unfold(f: Mapping[~[A], A]): ~[A] = Z.extend.flow.unfold(this, f)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _flow -> `Flow Control`
 *
 * @def sequential: -> Returns self
 *
 *    This method is inherited from [[Stream.Flow]], which could be parallel
 *
 *    In Stream context `sequential` returns `this`
 *
 *    See [[Stream.Flow._extend._flow!.sequential Stream.Flow.sequential]]
 *
 * @def parallel: -> Parallel
 *
 *    Returns [[Stream.Flow]] with parallel execution
 *
 *    Each consecutive element will be sent to a new thread for processing
 *
 *    {{{
 *       (1 <> 5).all.parallel.peek("Value: " +  _ + "\t" + App.Thread.name lp).drain
 *
 *       // Output
 *       Value: 1    ForkJoinPool.commonPool-worker-9
 *       Value: 3    ForkJoinPool.commonPool-worker-11
 *       Value: 2    main
 *       Value: 4    ForkJoinPool.commonPool-worker-2
 *       Value: 5    ForkJoinPool.commonPool-worker-4
 *    }}}
 *
 *  @def parallelIfOver -> Conditionally parallel
 *
 *     Switches to parallel execution if number of elements exceeds `threshold`
 *
 *     Returns [[Stream.Flow]], which could be implemented as sequential [[Stream]] or parallel [[Stream.Flow]]
 *
 *     {{{
 *       (1 <> 50).all.parallelIfOver(100).isParallel.lp   // Prints: false
 *
 *       (1 <> 200).all.parallelIfOver(100).isParallel.lp  // Prints: true
 *     }}}
 *
 *  @def parallelIf( -> Conditionally parallel
 *
 *     Switches to parallel execution if boolean parameter == true
 *
 *     Returns [[Stream.Flow]], which could be implemented as sequential [[Stream]] or parallel [[Stream.Flow]]
 *
 *     {{{
 *         (1 <> 50).all.parallelIf(true).isParallel.lp   // Prints: true
 *
 *         (1 <> 50).all.parallelIf(false).isParallel.lp  // Prints: false
 *     }}}
 *
 * @def transpose -> Transpose
 *
 *     Transposes matrix where rows become columns
 *
 * {{{
 *     def all: ~[~[Int]] = ~.*(11 <> 15, List(21, 22, 23, 24, 25), Vector(31, 32, 33, 34, 35))
 *
 *     all.toText.lp
 *
 *     all.transpose.toText.lp
 *
 *     // Output
 *     ---------------------
 *     ?
 *     ---------------------
 *     ~(11, 12, 13, 14, 15)
 *     ~(21, 22, 23, 24, 25)
 *     ~(31, 32, 33, 34, 35)
 *     ---------------------
 *
 *     -------------
 *     ?
 *     -------------
 *     ~(11, 21, 31)
 *     ~(12, 22, 32)
 *     ~(13, 23, 33)
 *     ~(14, 24, 34)
 *     ~(15, 25, 35)
 *     -------------
 *  }}}
 *
 * @def reverse: -> Reverse order
 *
 *     Re-arranges elements is reverse order
 *
 * @def shuffle: -> Randomize order
 *
 *     Re-arranges elements is random order
 *
 *     Note: this operation requires full buffering and is not suitable for large streams
 *
 * @def preview: -> Adds preview capabilities
 *
 *     Preview allows to pre load and inspect elements, even before they go through [[Stream]]
 *
 * @def unfold -> Lazy infinite stream
 *
 *    Lazily unfolds next value with a function taking all prior values
 *
 *    {{{
 *
 *      // Unfoldifg Fibonacci Sequence
 *
 *     (0 ~+ 1).unfold(_.letLast(2).sum).letNext(20).lp
 *
 *      // Output
 *      ~(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181)
 *
 *    }}}
 */
