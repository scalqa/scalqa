package scalqa; package `val`; package stream; package _use; import language.implicitConversions

transparent trait _process:

  extension[A](inline x: ~[A])
    inline def drain                                                        : Unit   = z._use.process.drain(x)
    inline def fornil[U](inline f:  =>U)                                    : Unit   = z._use.process.fornil(x,f)
    inline def process[U,W](inline foreachFun: A=>U, inline fornilFun: => W): Unit   = z._use.process(x,foreachFun,fornilFun)
    inline def foreach[U](inline f: A=>U)                                   : Unit   = z._use._process.foreach.any(x,f)
    inline def FOREACH[U](inline f: A=>U)                                   : Unit   = z._use._process.foreach.heavy(x,f)
    inline def foreachIndexed[U](inline f: (Int,A) => U,inline start: Int=0): Unit   = z._use._process.foreach.indexed(x,f,start)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _process -> ### Stream Processing Interface

@def drain -> Pump stream out

            Fetches and discards all stream elements

            This operation can be usefull for side effects built into streaming pipeline

            ```
              ('A' <> 'C').~.peek(_.TP).drain

              // Output
              A
              B
              C
            ```

@def foreach -> Process stream

            Applies given function to each stream element

            ```
              ('A' <> 'C').~.foreach(_.TP)

              // Output
              A
              B
              C
            ```

@def FOREACH -> Heavy process stream

            Applies given function to each stream element

            [[FOREACH]] is functionally equivalent to [[foreach]], but is fully inlined. It makes compiled code larger, but guarantees the best possible performance on large streams.

@def foreachIndexed -> For each indexed

            Calls given function with counter

            ```
              ('A' <> 'C').~.foreachIndexed((i,v) => "Element " + i + " = " + v TP(), 1)

              // Output
              Element 1 = A
              Element 2 = B
              Element 3 = C
            ```
            @param start starting value for indexing

@def fornil -> Run for nonexistent value

            Runs given function only if stream is empty.

            This operation is rarely useful and is provided for consistency.

            Use [[peekEmpty]] instead, it can be combined with other processing


@def process -> Process elements or empty case

            Applies given function to each stream element or runs second function when stream is empty

             ```
              ('A' <>> 'A').~.process(_.TP, "Empty".TP)

              // Output
              Empty
            ```

 */
