package scalqa; package `val`; package stream; package _build; package _filter

import z._build.{ _filter => Z }

transparent trait _drop :
  extension[A](inline x: ~[A])
    /**/              inline def drop(inline f: A => Boolean)                     : ~[A] = new Z.drop(x, f)
    /**/              inline def dropWhile(inline f: A => Boolean)                : ~[A] = new Z.dropWhile(x, f)
    /**/              inline def dropFirst(inline n: Int)                         : ~[A] = new Z.dropFirst(x, n)
    @tn("drop_Range") inline def drop_<>(inline i: Int.<>)                        : ~[A] = new Z.drop_Interval(x, i)
    /**/              inline def dropLast(n: Int)                                 : ~[A] = new Z.dropLast(x,n)
    /**/              inline def dropEvery(nTh: Int)                              : ~[A] = new Z.dropEvery(x,nTh)
    /**/              inline def dropDuplicates                                   : ~[A] = new Z.dropDuplicates(x)
    /**/              inline def dropDuplicatesBy[B](inline f: A=>B)              : ~[A] = new Z.dropDuplicates.By(x,f)
    /**/              inline def dropSequence(inline seq: ~[A])                   : ~[A] = new  z._build._mutate.replaceSequence(x,  seq.><,\/)
    /**/              inline def dropSequenceBy[B](inline f:A=>B,inline seq: ~[B]): ~[A] = new  z._build._mutate.replaceSequence(x,f,seq.><,\/)
    /**/              inline def dropOnly(inline v: A)                            : ~[A] = Z.values.dropOne(x,v)
    /**/              inline def dropValues(inline v: ~[A])                       : ~[A] = Z.values.drop(x,v)
    /**/              inline def dropValuesBy[B](inline f:A=>B,inline v: ~[B])    : ~[A] = Z.values.dropBy(x,f,v)
    /**/              inline def dropVoid       (using inline d: Any.Def.Void[A]) : ~[A] = new Z.dropVoid(x)
    /**/              inline def DROP(inline f: A => Boolean)                     : ~[A] = Z.drop.HEAVY(x,f)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def dropValues -> Multi value reversed filter

    Drops only provided set of values

    ```
       (0 <>> 10).~.dropValues(8,3,5).TP

       // Output
       ~(0, 1, 2, 4, 6, 7, 9)
    ```

    Note: [[dropValues]] is macro optimized when given value tuples sized from 2 to 5

@def dropValuesBy -> Mapped multi value reversed filter

    Drops only values, which convert to provided set of values

    ```
       (0 <>> 10).~.dropValuesBy(_ % 5, (1,3) ).TP

       // Output
       ~(0, 2, 4, 5, 7, 9)
    ```

    Note: [[dropValuesBy]] is macro optimized when given value tuples sized from 2 to 5

@def drop -> Reverse filter

    Disallows [[scalqa.val.Stream ~]] elements satisfying the given function

    ```
       (0 <>> 10).~.drop(_ > 5).TP

       // Output
       ~(0, 1, 2, 3, 4, 5)
    ```

    Note: Scala equivalent is called "filterNot"

@def DROP -> Heavy reversed filter

    Disallows [[scalqa.val.Stream ~]] elements satisfying the given function

    [[DROP]] is functionally equivalent to [[drop]], but is fully inlined. It makes compiled code larger, but guarantees the best possible performance on large streams.

@def drop_<> -> Range reversed filter

      Only allows elements outside specified sequencial range

      ```
         ('a' <> 'f').~.drop_<>(2 <> 3).TP

         // Output
         ~(a, b, e, f)
      ```

      Note: Range indexing starts from 0

@def dropEvery -> Every Nth element reversed filter

      Drops every **nTh** element

      ```
         (1 <> 10).~.dropEvery(3).TP   // Prints: ~(1, 2, 4, 5, 7, 8, 10)
      ```

@def dropFirst -> Head reversed filter

       Drops given number of first elements

      ```
         (1 <> 10).~.dropFirst(3).TP  // Prints  ~(4, 5, 6, 7, 8, 9, 10)
      ```

@def dropLast -> Tail reversed filter

      Drops given number of elements coming last

      ```
         (1 <> 10).~.dropLast(3).TP  // Prints  ~(1, 2, 3, 4, 5, 6, 7)
      ```

      Note: This method will block on unlimited streams

@def dropOnly -> Single value reversed filter

    Drops only specified value.

    ```
       (1 <> 4).~.dropOnly(3).TP

       // Output
       ~(1, 2, 4)
    ```

    Note: [[dropOnly]] is more efficient than general filter ".drop(_ == value)", because there is no function involved.

@def dropWhile -> Coditional reversed head filter

      Discards first consecutive elements satisfying the condition

      ```
         def stream = (1 <> 5).~ ++ (1 <> 5)

         stream.TP                     // Prints ~(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)

         stream.dropWhile(_ <= 3).TP   // Prints ~(4, 5, 1, 2, 3, 4, 5)
      ```

      Note: Everything starting from the first non compliant element will be allowed (including later compliant elements)

@def dropVoid -> Void value reversed filter

      Drops elements which test to be void

@def dropDuplicates -> Duplicates reversed filter

      Drops elements equal to the passed in prior position

      Note: To generally get rid of all duplicates, the stream must be sorted to arrange duplicates in sequence
      ```
      (1 <> 10).~.repeat(3).dropDuplicates.tp // Prints ~(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
      ```
@def dropDuplicatesBy -> Mapped duplicates reversed filter

      Drops elements, which evaluate to the same value as elements passed in prior position

      Note: To generally get rid of all duplicates, the stream must be sorted by the mapping function

      ```
         (1 <> 100).~.dropDuplicatesBy(_.toString.length).TP

         // Output
         ~(1, 10, 100)
      ```
*/
