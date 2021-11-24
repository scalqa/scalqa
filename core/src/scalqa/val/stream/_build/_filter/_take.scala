package scalqa; package `val`; package stream; package _build; package _filter

import z._build.{ _filter => Z }

transparent trait _take :
  extension[A](inline x: Stream[A])
    inline def take(inline f: A => Boolean)                     : Stream[A] = new Z.take(x,f)
    inline def takeType[B](using inline t:ClassTag[B])          : Stream[B] = new Z.takeType(x)
    inline def takeWhile(inline f: A => Boolean)                : Stream[A] = new Z.takeWhile(x,f)
    inline def takeFirst(n: Int)                                : Stream[A] = new Z.take_Range(x,0 <>> n)
    inline def takeRange(inline i: Int.Range)                   : Stream[A] = new Z.take_Range(x,i)
    inline def takeLast(inline n: Int)                          : Stream[A] = new Z.takeLast(x,n)
    inline def takeEvery(inline nTh: Int)                       : Stream[A] = new Z.takeEvery(x,nTh)
    inline def takeIndexed(inline f:(Int,A)=>Boolean,
                                        inline start:Int=0)     : Stream[A] = new Z.takeIndexed(x,f,start)
    inline def takeDuplicates                                   : Stream[A] = new Z.takeDuplicates(x)
    inline def takeDuplicatesBy[B](inline f: A=>B)              : Stream[A] = new Z.takeDuplicates.By(x,f)

    inline def takeOnly(inline v: A)                            : Stream[A] = Z.values.takeOne(x,v)
    inline def takeValues(inline v: Stream[A])                  : Stream[A] = Z.values.take(x,v)
    inline def takeValuesBy[B](inline f:A=>B,inline v:Stream[B]): Stream[A] = Z.values.takeBy(x,f,v)
    inline def TAKE(inline f: A => Boolean)                     : Stream[A] = Z.take.HEAVY(x,f)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def takeValues -> Multi value filter

    Takes only provided set of values

    ```
         ('a' <> 'z').stream.takeValues('z','x','b').TP   // Prints Stream('b','x','y')

         ('a' <> 'z').stream.takeValues('b' <> 'f').TP    // Prints Stream('b','c','d','e','f')

    ```

    Note: [[takeValues]] is macro optimized when given value tuples sized from 2 to 5

@def takeValuesBy -> Mapped multi value filter

    Takes only values, which convert to provided set of values

    ```
       (0 <>> 10).stream.takeValuesBy(_ % 5, (1,3) ).TP

       // Output
       Stream(1, 3, 6, 8)
    ```

    Note: [[takeValuesBy]] is macro optimized when given value tuples sized from 2 to 5


@def take -> Main filter

    Only takes [[scalqa.val.Stream Stream]] elements satisfying the given function

    ```
       (0 <>> 10).stream.take(_ > 5).TP

       // Output
       Stream(6, 7, 8, 9)
    ```

    Note: Traditional method [[filter]] is also available and can be used, but [[take]] is prefferable in most cases.

@def TAKE -> Heavy filter

    Filters [[scalqa.val.Stream Stream]] elements according to given function

    [[TAKE]] is functionally equivalent to [[take]], but is fully inlined. It makes compiled code larger, but guarantees the best possible performance on large streams.

@def takeRange -> Range filter

      Only allows elements withing specified sequencial range

      ```
         ('a' <> 'z').stream.takeRange(1 <> 7).TP

         // Output
         Stream(b, c, d, e, f, g, h)
      ```

      Note: Range indexing starts from 0

@def takeEvery -> Every Nth element filter

      Only lets every **nTh** element

      ```
         (1 <> 20).stream.takeEvery(4).TP   // Prints: Stream(4, 8, 12, 16, 20)
      ```

@def takeFirst -> Head filter

       Only takes given number of first elements

      ```
         (1 <> 10).stream.takeFirst(3).TP  // Prints  Stream(1, 2, 3)
      ```

@def takeIndexed -> Indexed filter

      Only lets elements satisfying the given function, which also accepts element sequential index

       ```
         ('a' <> 'z').stream.takeIndexed((i, _) => i >= 2 && i <= 7, 1).TP

         // Output
         Stream(b, c, d, e, f, g)
      ```
      Note: By default indexing starts from 0, but starting value can also be explicitly specified.

@def takeLast -> Tail filter

      Only takes given number of elements coming last

      ```
         (1 <> 10).stream.takeLast(3).TP  // Prints  Stream(8, 9, 10)
      ```

      Note: This method will block on unlimited streams

@def takeOnly -> Single value filter

    Filters only specified value.

    ```
       (0 <>> 10).stream.takeOnly(5).TP

       // Output
       Stream(5)
    ```

    Note: [[takeOnly]] is more efficient than general filter ".take(_ == value)", because there is no function involved.

@def takeType -> Type filter

      Only lets elements of specified type

      ```
         Stream(1, '2', "3", new Object(), 0.0).takeType[String].TP  // Prints: Stream(3)
      ```

@def takeWhile -> Conditional head filter

      Only takes first consecutive elements satisfying the condition

      ```
         def stream = (1 <> 5).stream ++ (1 <> 5)

         stream.TP                     // Prints Stream(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)

         stream.takeWhile(_ <= 3).TP    // Prints Stream(1, 2, 3)
      ```

      Note: Everything starting from the first non compliant element will be discarded (including later compliant elements)

@def takeDuplicates -> Duplicates filter

      Takes only elements equal to the passed in prior position

      Note: To generally get all duplicates, the stream must be sorted to arrange them in sequence

      ```
          Stream(1,1,2,3,3,4,5,5,5).takeDuplicates.tp

          // Output
          Stream(1, 3, 5, 5)
      ```

@def takeDuplicatesBy -> Mapped duplicates filter

      Takes only elements, which evaluate to the same value as elements passed in prior position

      Note: To generally get all duplicates, the stream must be sorted by the mapping function

      ```
         (0 <> 10).stream.takeDuplicatesBy(_ / 2).TP

         // Output
         Stream(1, 3, 5, 7, 9)
      ```
*/

