package scalqa; package `val`; package stream; package _use; import language.implicitConversions

import z._use.{ _evaluate as _Z, evaluate as Z }

transparent trait _evaluate:

  extension[A](inline x: Stream[A])
    inline def findOpt(inline f: A => Boolean)               : Opt[A]            = _Z.find.opt(x,f)
    inline def find(  inline f: A => Boolean)                : A                 = _Z.find.opt(x,f).get
    inline def findPositionOpt(inline f:A=>Boolean)          : Int.Opt           = _Z.find.positionOpt(x,f)
    inline def findSequencePositionOpt(inline v: Stream[A])  : Int.Opt           = _Z.find.sequencePositionOpt(x,v)
    inline def count                                         : Int               = _Z.count.all(x)
    inline def count(inline f: A => Boolean)                 : Int               = _Z.count.conditional(x,f)
    inline def countAndTime                                  : (Int,Time.Length) = _Z.count.andTime(x)

    inline def startsWithSequence(      inline v: Stream[A]) : Boolean           = _Z.equals.sequence[A](x,v,false)
    inline def startsWithSequenceResult(inline v: Stream[A]) : Result[true]      = _Z.equals.sequence[A](x,v,false)
    inline def equalsSequence(          inline v: Stream[A]) : Boolean           = _Z.equals.sequence[A](x,v,true)
    inline def equalsSequenceResult(    inline v: Stream[A]) : Result[true]      = _Z.equals.sequence[A](x,v,true)
    inline def exists( inline f: A => Boolean)               : Boolean           = Z.exists(x,f)
    inline def isEvery(inline f: A => Boolean)               : Boolean           = Z.isEvery(x,f)
    inline def contains(inline value: A)                     : Boolean           = Z.contains(x,value)
    inline def containsSequence(inline seq: Stream[A])       : Boolean           = Z.containsSequence(x,seq)
    inline def last                                          : A                 = Z.lastOpt(x).get
    inline def lastOpt                                       : Opt[A]            = Z.lastOpt(x)

    inline def countFew(inline f1:A=>Boolean, inline f2:A=>Boolean, inline f3:A=>Boolean= \/, inline f4:A=>Boolean= \/, inline f5:A=>Boolean= \/)
      : (Int,Int) | (Int,Int,Int) | (Int,Int,Int,Int) | (Int,Int,Int,Int,Int) = _Z.count.few(x,f1,f2,f3,f4,f5)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _evaluate -> ### Stream Evaluation Interface

@def find -> Find value

    Finds the first value accepted by given predicate

    ```
      (1 <> 1000).stream.find(_ > 100).TP  // Prints 101
    ```

    Note: If value is not found [[find]] fails, use  [[findOpt]] in most cases

@def findOpt -> Optional find value

    Finds the first value accepted by given predicate or returns void option if not found

    ```
    (1 <> 1000).stream.findOpt(_ > 100).TP   // Prints Opt(101)

    (1 <> 10).stream.findOpt(_ > 100).TP     // Prints Opt(\/)
    ```

@def findPositionOpt -> Find index

       Optionally returns index for the first element satisfying the predicate or Int.Opt(\/) if none found

       ```
          (50 <> 500).stream.findPositionOpt(_ == 400)  // Retuns Int.Opt(350)
       ```

@def findSequencePositionOpt -> Find start index

       Optionally returns index where given stream value sequence matches current stream values

@def exists -> Exists check

    Returns true if there is an elemnet satisfying given predicate

@def isEvery -> Forall check

    Returns true if every single element satisfies the given predicate

@def contains -> Value check

    Returns true if stream contains given value.

@def containsSequence -> Sequence check

    Returns true if stream contains given sequence of values.

@def count -> All count

    Counts all stream elements

@def count -> Conditional count

    Counts all stream elements, which satisfy given predicate

@def countAndTime -> Count and time

    Returns all elements count and Time.Length it took to pump the stream

    ```
       val (cnt,time) = (1 <> 1000).stream.peek(_ => J.sleep(1.Millis)).countAndTime

       ("" + cnt + " elements processed in " + time.tag).TP

       // Output
       1000 elements processed in 1.488880500 sec
    ```

@def countFew -> Multi count

     Simultaneously counts values for up to 5 different predicates

     Returns tuple of appropriate size with values corresponding to the given mappings

     For empty Stream returned tuple will hold zeros

     ```
      val (large, odd, even) = (1 <>> 1000).stream.countFew(_ > 100, _ % 2 == 0, _ % 2 == 1)

      large.TP    // Prints 899
      odd.TP      // Prints 499
      even.TP     // Prints 500
     ```

@def lastOpt -> Last element

       Optionally returns the last element or Opt(\/)


@def last ->  Last element

       Returns the last stream element

       Fails if empty


@def equalsSequence -> Equal check

       Iterates both streams and compares all corresponding elements

       Returns `true` if all are equal, `false`` otherwise

@def equalsSequenceResult -> Equal check

       Iterates both streams and compares all corresponding elements

       When first not equal pair is found, the problem result is returned

       If all elements are equal, Result[true] is returned

       ```
        (0 <> 10).stream.equalsAllResult(0 <> 10).TP
        // Prints: Result(true)

        (0 <> 10).stream.equalsAllResult(0 <>> 10).TP
        // Prints: Result(Problem(Second stream has less elements))

        ((0 <> 5).stream + 7 + 8).equalsAllResult(0 <> 10).TP
        // Prints: Result(Problem(Fail at index 6: 7 != 6))
       ```
       Note: The returned problem contains message with basic description

@def startsWithSequence -> Equal start check

       Checks if starting elements of two streams (to a point where one stream ends) are equal

@def startsWithSequenceResult -> Equal start check

       Checks if starting elements of two streams (to a point where one stream ends) are equal

       ```
        (0 <> 10).stream.equalsStartResult(0 <> 1000).TP
        // Prints: Result(true)

        (0 <> 1000).stream.equalsStartResult(0 <> 10).TP
        // Prints: Result(true)

        ((0 <> 5).stream + 7 + 8).equalsStartResult(0 <> 10).TP
        // Prints: Result(Problem(Fail at index 6: 7 != 6))
       ```

       Note: The returned problem result contains message with basic description
 */

