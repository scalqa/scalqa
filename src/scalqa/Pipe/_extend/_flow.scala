package scalqa; package Pipe; package _extend

trait _flow[A] extends Flow._extend._flow[A] with __[A] {

  def parallel: Flow[A] = Z.flow.parallel(This, 1)

  def parallelGroup(groupSize: Int): Flow[A] = Z.flow.parallel(This, groupSize)

  def parallelIf(boolean: Boolean, groupSize: Int = 1): Flow[A] = if (boolean) Z.flow.parallel(This, groupSize) else This

  def parallelIfOver(threshold: Int, groupSize: Int = 1): Flow[A] = This.yieldSizeAtLeast(threshold + 1).to((a, b) => b ? (Z.flow.parallel(a, groupSize), a))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _flow -> '''Flow Control'''
 *
 *
 * @def parallel: -> Parallel
 *
 *    Returns [[Pipe.Flow]] with parallel execution
 *
 *    Each consecutive element will be sent to a new thread for processing
 *
 *    {{{
 *       (1 <> 5).all.parallel.peek(Print.ls("Value:", _, '\t', App.Thread.name)).drain
 *
 *       // Output
 *       Value: 1    ForkJoinPool.commonPool-worker-9
 *       Value: 3    ForkJoinPool.commonPool-worker-11
 *       Value: 2    main
 *       Value: 4    ForkJoinPool.commonPool-worker-2
 *       Value: 5    ForkJoinPool.commonPool-worker-4
 *    }}}
 *
 * @def parallelGroup -> Parallel groupped
 *
 *    Returns [[Pipe.Flow]] with parallel execution
 *
 *    @param groupSize size of a batch of consecutive elements sent to each parallel thread at one time
 *
 *    {{{
 *         (1 <> 6).all.parallelGroup(3).peek(Print.ls("Value:", _, '\t', App.Thread.name)).drain
 *
 *         // Output
 *         Value: 1    ForkJoinPool.commonPool-worker-2
 *         Value: 4    main
 *         Value: 2    ForkJoinPool.commonPool-worker-2
 *         Value: 3    ForkJoinPool.commonPool-worker-2
 *         Value: 5    main
 *         Value: 6    main
 *    }}}
 *
 *  @def parallelIf( -> Conditionally parallel
 *
 *     Switches to parallel execution if boolean == true
 *
 *     Returns [[Pipe.Flow]], which could be implemented as sequential [[Pipe]] or parallel [[Pipe.Flow]]
 *
 *     @param groupSize size of a batch of consecutive elements sent to each parallel thread at one time
 *
 *     {{{
 *
 *         def all(par: Boolean) =  (1 <> 99).all.parallelIf(par)
 *
 *         all(true)    // Returnes parallel Pipe.Flow
 *         all(false)   // Returnes Pipe as Pipe.Flow
 *     }}}
 *
 *  @def parallelIfOver( -> Conditionally parallel
 *
 *     Switches to parallel execution if number of elements exceeds ''threshold''
 *
 *     Returns [[Pipe.Flow]], which could be implemented as sequential [[Pipe]] or parallel [[Pipe.Flow]]
 *
 *     @param groupSize size of a batch of consecutive elements sent to each parallel thread at one time.
 *
 *     {{{
 *         (1 <> 99).all.parallelIfOver(50)    // Returnes parallel Pipe.Flow
 *
 *         (1 <> 10).all.parallelIfOver(50)    // Returnes Pipe as Pipe.Flow
 *     }}}
 */
