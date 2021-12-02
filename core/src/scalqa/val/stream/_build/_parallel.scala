package scalqa; package `val`; package stream; package _build; import language.implicitConversions

transparent trait _parallel:
  self: Stream.type =>

  extension[A](x: Stream[A])
    def parallel                                                                             : Flow[A] = J.Setup.parallelFlowSetupPro()(x.cast[Stream[Any]],VOID).cast[Flow[A]]
    def parallelIf(v: Boolean)                                                               : Flow[A] = if (v) x.parallel else z.flow.SequencialFlow(x)
    def parallelIfOver(threshold: Int)                                                       : Flow[A] = { val b = x.enablePreview; b.parallelIf(b.previewSize > threshold) }
    def parallelWithPriority(p: J.Vm.Priority, parallelism: Int = J.Vm.availableProcessors-1): Flow[A] = J.Setup.parallelFlowSetupPro()(x.cast[Stream[Any]],(p,parallelism)).cast[Flow[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _parallel -> ### Stream Parallel Execution Interface

@def parallel -> Parallel

      Returns [[scalqa.val.stream.Flow Stream.Flow]] with parallel execution

      Each consecutive element will be sent to a new thread for processing

      ```
         (1 <> 5).stream
            .parallel
            .map("Value: " + _ + "\t" + Thread.currentThread.getName)
            .foreach(println)

         // Possible Output
         Value: 1    ForkJoinPool.commonPool-worker-9
         Value: 3    ForkJoinPool.commonPool-worker-11
         Value: 2    main
         Value: 4    ForkJoinPool.commonPool-worker-2
         Value: 5    ForkJoinPool.commonPool-worker-4
      ```

@def parallelIf ->  Conditionally parallel

       Returns [[scalqa.val.stream.Flow Stream.Flow]] with parallel or sequential implementation, depending on given parameter

       ```
           (1 <> 50).stream.parallelIf(true).isParallel   // Returns true

           (1 <> 50).stream.parallelIf(false).isParallel  // Returns false
       ```

@def parallelIfOver -> Conditionally parallel

      Returns [[scalqa.val.stream.Flow Stream.Flow]] with parallel or sequential implementation, depending on stream having element count equal or greater than given ''threshold''

       ```
         (1 <> 50).stream.parallelIfOver(100).isParallel   // Returns false

         (1 <> 200).stream.parallelIfOver(100).isParallel  // Returns true
       ```

@def parallelWithPriority -> Parallel with Priority

     This is very expensive operation, because it creates a custom thread pool. It only sutable for long running streams

      ```
         (1 <> 100).stream.parallelWithPriority(MIN, 4).foreach(v => ())

         (1 <> 100).stream.parallelWithPriority(MAX).foreach(v => ())

         (1 <> 100).stream.parallelWithPriority(J.Priority(5), 4).foreach(v => ())
      ```

      Note: ``parallelism`` determines how many parallel threads are allowed.  Default value is CPU core count minus 1
*/

