package scalqa; package `val`; package stream; package _Build; import language.implicitConversions

import z.build.{ peek => P }

transparent trait _peek:
  self: Stream.type =>

  extension[A](x: ~[A])
    inline def peek[U](inline f: A => U)                                : ~[A]  = new P.peek(x,f)
    inline def peekIndexed[U](inline f: (Int,A)=>U, inline start:Int=0) : ~[A]  = new P.peekIndexed(x, f, start)
    /**/   def peekStart[U](f: Time=>U)                                 : ~[A]  = x.peekEvents(_.onBeforeFirst(f))
    /**/   def peekEnd[U](  f: (Int,Time.Length)=>U)                    : ~[A]  = x.peekEvents(_.onAfterLast(f))
    /**/   def peekEmpty[U](f: => U)                                    : ~[A]  = x.peekEvents(_.onEmpty(() => f))
    /**/   def peekEvents[U]( f: Custom.Event => U)                     : ~[A]  = new P.monitor(x, new Custom.Event().^(f(_)))
    /**/   def peekMonitor(v: Custom.Event.Monitor)                     : ~[A]  = if (v.^.isVoid) x else new P.monitor(x, v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _peek -> ### Stream Inspection Interface

      The below methods do not change stream data, but allow to inspect it in a variety of ways

@def peek -> Inspect

      The given function will be run with every passing stream element.

     ```
        (1 <> 5).~.peek(_.TP).drain

        // Output
        1
        2
        3
        4
        5
     ```

@def peekIndexed -> Indexed peek

     The given function will be executed with every passing element and its index.

     ```
        ('a' <> 'f').~.peekIndexed((i,c) => (""+i+" : "+c).TP, 1).drain

        // Output
        1 : a
        2 : b
        3 : c
        4 : d
        5 : e
        6 : f
     ```
     Note. By default indexing starts with 0, but it can be specified


@def peekStart -> Peek start

     The given function is executed once, just before the first elements is about to pass.

     ```
        ('a' <> 'f').~.peekStart(time => "Started at: "+time).drain
     ```

     Note: This will not run for empty streams

@def peekEnd -> Peek end

     The given function is executed once, when stream is exhausted

     The function receives total element count and Time.Length, it took for all elements to pass

     ```
        (1 <> 10).~
          .peek(_ => J.sleep(100.Millis))
          .peekEnd((cnt,time) => "Elements: "+cnt+"  total time: "+time.tag TP())
          .drain

        // Output
        Elements: 10  total time: 0.904106700 sec
     ```

     Note: This will not run for empty streams

@def peekEmpty -> Peek empty

    The given function is executed once, only if stream is empty

      ```
        (1 <> 10).~.drop(_ > 0).peekEmpty("Stream is empty".TP).drain

        // Output
        Stream is empty
      ```

@def peekEvents -> Custom events

    Allows to setup [[scalqa.val.stream.custom.Event ~~.Custom.Events]] multiple monitoring events

    ```
      (1 <> 1000).~
        .peek(_ => J.sleep(5.Millis))
        .peekEvents(e => {
          e.onBeforeFirst(t   => "Started at: "+ t.dayTime.tag TP())
          e.onEvery(1.Second, (c,t) => "  Processed "+c+" in "+t.tag TP())
          e.onAfterLast((c,t) => "Finished in: "+ t.tag + ",  Element count: " + c TP())
        })
        .drain

      // Output

      Started at: 14:05:39.333
        Processed 187 in 1.018583400 sec
        Processed 371 in 2.020508100 secs
        Processed 557 in 3.021843300 secs
        Processed 743 in 4.023837400 secs
        Processed 928 in 5.026982 secs
      Finished in: 5.411673300 secs, Element count: 1000
    ```

@def peekMonitor -> Custom monitor

    Adds pre-build [[scalqa.val.stream.custom.event.Monitor ~~.Custom.Event.Monitor ]]

  	If passed monitor tests to be void (`.isEmpty`), the operation is ignored
*/
