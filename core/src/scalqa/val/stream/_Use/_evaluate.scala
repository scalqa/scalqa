package scalqa; package `val`; package stream; package _use; import language.implicitConversions

transparent trait _evaluate:

  extension[A](inline x: ~[A])
    @tn("find_Opt")           inline def find_?(inline f: A => Boolean)     : Opt[A]            = z._use._evaluate.find.opt(x,f)
    /**/                      inline def find(  inline f: A => Boolean)     : A                 = z._use._evaluate.find.opt(x,f).get
    @tn("findPosition_Opt")   inline def findPosition_?(inline f:A=>Boolean): Int.Opt           = z._use._evaluate.find.position_Opt(x,f)
    /**/                      inline def count                              : Int               = z._use._evaluate.count.all(x)
    /**/                      inline def count(inline f: A => Boolean)      : Int               = z._use._evaluate.count.conditional(x,f)
    /**/                      inline def countAndTime                       : (Int,Time.Length) = z._use._evaluate.count.andTime(x)

    /**/                      inline def equalsStart(   inline v: ~[A])     : Boolean           = z._use._evaluate.equals[A](x,v,false)
    @tn("equalsStart_Result") inline def equalsStart_??(inline v: ~[A])     : Result[true]      = z._use._evaluate.equals[A](x,v,false)
    /**/                      inline def equalsAll(     inline v: ~[A])     : Boolean           = z._use._evaluate.equals[A](x,v,true)
    @tn("equalsAll_Result")   inline def equalsAll_??(  inline v: ~[A])     : Result[true]      = z._use._evaluate.equals[A](x,v,true)
    /**/                      inline def exists( inline f: A => Boolean)    : Boolean           = z._use.evaluate.exists(x,f)
    /**/                      inline def isEvery(inline f: A => Boolean)    : Boolean           = z._use.evaluate.isEvery(x,f)
    /**/                      inline def contains(inline value: A)          : Boolean           = z._use.evaluate.contains(x,value)
    /**/                      inline def last                               : A                 = z._use.evaluate.last_Opt(x).get
    @tn("last_Opt")           inline def last_?                             : Opt[A]            = z._use.evaluate.last_Opt(x)

    inline def countFew(inline f1:A=>Boolean, inline f2:A=>Boolean, inline f3:A=>Boolean= \/, inline f4:A=>Boolean= \/, inline f5:A=>Boolean= \/)
      : (Int,Int) | (Int,Int,Int) | (Int,Int,Int,Int) | (Int,Int,Int,Int,Int) = z._use._evaluate.count.few(x,f1,f2,f3,f4,f5)

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
      (1 <> 1000).~.find(_ > 100).TP  // Prints 101
    ```

    Note: If value is not found [[find]] fails, use  [[find_?]] in most cases

@def find_? -> Optional find value

    Finds the first value accepted by given predicate or returns void option if not found

    ```
    (1 <> 1000).~.find_?(_ > 100).TP   // Prints Opt(101)

    (1 <> 10).~.find_?(_ > 100).TP     // Prints Opt(\/)
    ```

@def findPosition_? -> Find index

       Optionally returns index for the first element satisfying the predicate or Int.Opt(\/) if none found

       ```
          (50 <> 500).~.findPosition_?(_ == 400)  // Retuns Int.Opt(350)
       ```

@def exists -> Exists check

    Returns true if there is an elemnet satisfying given predicate

@def isEvery -> Forall check

    Returns true if every single element satisfies the given predicate

@def contains -> Value check

    Returns true if stream contains given value.

@def count -> All count

    Counts all stream elements

@def count -> Conditional count

    Counts all stream elements, which satisfy given predicate

@def countAndTime -> Count and time

    Returns all elements count and Time.Length it took to pump the stream

    ```
       val (cnt,time) = (1 <> 1000).~.peek(_ => J.sleep(1.Millis)).countAndTime

       ("" + cnt + " elements processed in " + time.tag).TP

       // Output
       1000 elements processed in 1.488880500 sec
    ```

@def countFew -> Multi count

     Simultaneously counts values for up to 5 different predicates

     Returns tuple of appropriate size with values corresponding to the given mappings

     For empty Stream returned tuple will hold zeros

     ```
      val (large, odd, even) = (1 <>> 1000).~.countFew(_ > 100, _ % 2 == 0, _ % 2 == 1)

      large.TP    // Prints 899
      odd.TP      // Prints 499
      even.TP     // Prints 500
     ```

@def last_? -> Last element

       Optionally returns the last element or Opt(\/)


@def last ->  Last element

       Returns the last stream element

       Fails if empty


@def equalsAll -> Equal check

       Iterates both streams and compares all corresponding elements

       Returns `true` if all are equal, `false`` otherwise

@def equalsAll_?? -> Equal check

       Iterates both streams and compares all corresponding elements

       When first not equal pair is found, the problem result is returned

       If all elements are equal, Result[true] is returned

       ```
        (0 <> 10).~.equalsAll_??(0 <> 10).TP
        // Prints: Result(true)

        (0 <> 10).~.equalsAll_??(0 <>> 10).TP
        // Prints: Result(Problem(Second stream has less elements))

        ((0 <> 5).~ + 7 + 8).equalsAll_??(0 <> 10).TP
        // Prints: Result(Problem(Fail at index 6: 7 != 6))
       ```
       Note: The returned problem contains message with basic description

@def equalsStart -> Equal start check

       Checks if starting elements of two streams (to a point where one stream ends) are equal

@def equalsStart_?? -> Equal start check

       Checks if starting elements of two streams (to a point where one stream ends) are equal

       ```
        (0 <> 10).~.equalsStart_??(0 <> 1000).TP
        // Prints: Result(true)

        (0 <> 1000).~.equalsStart_??(0 <> 10).TP
        // Prints: Result(true)

        ((0 <> 5).~ + 7 + 8).equalsStart_??(0 <> 10).TP
        // Prints: Result(Problem(Fail at index 6: 7 != 6))
       ```

       Note: The returned problem result contains message with basic description
 */

