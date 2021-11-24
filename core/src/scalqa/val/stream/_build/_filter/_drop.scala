package scalqa; package `val`; package stream; package _build; package _filter

import z._build.{ _filter => Z }

transparent trait _drop :
  extension[A](inline x: Stream[A])
    inline def drop(inline f: A => Boolean)                         : Stream[A] = new Z.drop(x, f)
    inline def dropWhile(inline f: A => Boolean)                    : Stream[A] = new Z.dropWhile(x, f)
    inline def dropFirst(inline n: Int)                             : Stream[A] = new Z.dropFirst(x, n)
    inline def dropRange(inline i: Int.Range)                       : Stream[A] = new Z.drop_Interval(x, i)
    inline def dropLast(n: Int)                                     : Stream[A] = new Z.dropLast(x,n)
    inline def dropEvery(nTh: Int)                                  : Stream[A] = new Z.dropEvery(x,nTh)
    inline def dropDuplicates                                       : Stream[A] = new Z.dropDuplicates(x)
    inline def dropDuplicatesBy[B](inline f: A=>B)                  : Stream[A] = new Z.dropDuplicates.By(x,f)
    inline def dropSequence(inline seq: Stream[A])                  : Stream[A] = new  z._build._mutate.replaceSequence(x,  seq.pack,\/)
    inline def dropSequenceBy[B](inline f:A=>B,inline seq:Stream[B]): Stream[A] = new  z._build._mutate.replaceSequence(x,f,seq.pack,\/)
    inline def dropOnly(inline v: A)                                : Stream[A] = Z.values.dropOne(x,v)
    inline def dropValues(inline v: Stream[A])                      : Stream[A] = Z.values.drop(x,v)
    inline def dropValuesBy[B](inline f:A=>B,inline v: Stream[B])   : Stream[A] = Z.values.dropBy(x,f,v)
    inline def dropVoid           (using inline d: Any.Def.Void[A]) : Stream[A] = new Z.dropVoid(x)
    inline def DROP(inline f: A => Boolean)                         : Stream[A] = Z.drop.HEAVY(x,f)

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
       (0 <>> 10).stream.dropValues(8,3,5).TP

       // Output
       Stream(0, 1, 2, 4, 6, 7, 9)
    ```

    Note: [[dropValues]] is macro optimized when given value tuples sized from 2 to 5

@def dropValuesBy -> Mapped multi value reversed filter

    Drops only values, which convert to provided set of values

    ```
       (0 <>> 10).stream.dropValuesBy(_ % 5, (1,3) ).TP

       // Output
       Stream(0, 2, 4, 5, 7, 9)
    ```

    Note: [[dropValuesBy]] is macro optimized when given value tuples sized from 2 to 5

@def drop -> Reverse filter

    Disallows [[scalqa.val.Stream Stream]] elements satisfying the given function

    ```
       (0 <>> 10).stream.drop(_ > 5).TP

       // Output
       Stream(0, 1, 2, 3, 4, 5)
    ```

    Note: Scala equivalent is called "filterNot"

@def DROP -> Heavy reversed filter

    Disallows [[scalqa.val.Stream Stream]] elements satisfying the given function

    [[DROP]] is functionally equivalent to [[drop]], but is fully inlined. It makes compiled code larger, but guarantees the best possible performance on large streams.

@def dropRange -> Range reversed filter

      Only allows elements outside specified sequencial range

      ```
         ('a' <> 'f').stream.dropRange(2 <> 3).TP

         // Output
         Stream(a, b, e, f)
      ```

      Note: Range indexing starts from 0

@def dropEvery -> Every Nth element reversed filter

      Drops every **nTh** element

      ```
         (1 <> 10).stream.dropEvery(3).TP   // Prints: Stream(1, 2, 4, 5, 7, 8, 10)
      ```

@def dropFirst -> Head reversed filter

       Drops given number of first elements

      ```
         (1 <> 10).stream.dropFirst(3).TP  // Prints  Stream(4, 5, 6, 7, 8, 9, 10)
      ```

@def dropLast -> Tail reversed filter

      Drops given number of elements coming last

      ```
         (1 <> 10).stream.dropLast(3).TP  // Prints  Stream(1, 2, 3, 4, 5, 6, 7)
      ```

      Note: This method will block on unlimited streams

@def dropOnly -> Single value reversed filter

    Drops only specified value.

    ```
       (1 <> 4).stream.dropOnly(3).TP

       // Output
       Stream(1, 2, 4)
    ```

    Note: [[dropOnly]] is more efficient than general filter ".drop(_ == value)", because there is no function involved.

@def dropWhile -> Coditional reversed head filter

      Discards first consecutive elements satisfying the condition

      ```
         def stream = (1 <> 5).stream ++ (1 <> 5)

         stream.TP                     // Prints Stream(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)

         stream.dropWhile(_ <= 3).TP   // Prints Stream(4, 5, 1, 2, 3, 4, 5)
      ```

      Note: Everything starting from the first non compliant element will be allowed (including later compliant elements)

@def dropVoid -> Void value reversed filter

      Drops elements which test to be void

@def dropDuplicates -> Duplicates reversed filter

      Drops elements equal to the passed in prior position

      Note: To generally get rid of all duplicates, the stream must be sorted to arrange duplicates in sequence
      ```
      (1 <> 10).stream.repeat(3).dropDuplicates.tp // Prints Stream(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
      ```
@def dropDuplicatesBy -> Mapped duplicates reversed filter

      Drops elements, which evaluate to the same value as elements passed in prior position

      Note: To generally get rid of all duplicates, the stream must be sorted by the mapping function

      ```
         (1 <> 100).stream.dropDuplicatesBy(_.toString.length).TP

         // Output
         Stream(1, 10, 100)
      ```
*/
