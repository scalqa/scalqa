package scalqa; package `val`; package stream; package _build; package _filter

import z._build.{ _filter => _Z, filter => Z }

transparent trait _take :
  extension[A](inline x: ~[A])
    /**/              inline def take(inline f: A => Boolean)                : ~[A] = new _Z.take(x,f)
    /**/              inline def takeType[B](using inline t:ClassTag[B])     : ~[B] = new _Z.takeType(x)
    /**/              inline def takeWhile(inline f: A => Boolean)           : ~[A] = new _Z.takeWhile(x,f)
    /**/              inline def takeFirst(n: Int)                           : ~[A] = new _Z.take_Range(x,0 <>> n)
    @tn("take_Range") inline def take_<>(inline i: Int.<>)                   : ~[A] = new _Z.take_Range(x,i)
    /**/              inline def takeLast(inline n: Int)                     : ~[A] = new _Z.takeLast(x,n)
    /**/              inline def takeEvery(inline nTh: Int)                  : ~[A] = new _Z.takeEvery(x,nTh)
    /**/              inline def takeIndexed(inline f:(Int,A)=>Boolean,
                                                          inline start:Int=0): ~[A] = new _Z.takeIndexed(x,f,start)
    /**/              inline def takeDuplicates                              : ~[A] = new _Z.takeDuplicates(x)
    /**/              inline def takeDuplicatesBy[B](inline f: A=>B)         : ~[A] = new _Z.takeDuplicates.By(x,f)

    /**/              inline def takeAll(inline v: ~[A])                     : ~[A] = Z.takeAll(x,v)
    /**/              inline def takeAllBy[B](inline f: A=>B, inline v: ~[B]): ~[A] = Z.takeAllBy[A,B](x,f,v)
    /**/              inline def takeOnly(inline v: A, inline vs: A*)        : ~[A] = Z.takeOnly(x,v,vs)
    /**/              inline def takeOnlyBy[B](inline f:A=>B, inline v: B*)  : ~[A] = Z.takeOnlyBy(x,f,v)
    /**/              inline def TAKE(inline f: A => Boolean)                : ~[A] = Z.TAKE(x,f)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def take -> Main filter

    Only takes [[scalqa.val.Stream ~]] elements satisfying the given function

    ```
       (0 <>> 10).~.take(_ > 5).TP

       // Output
       ~(6, 7, 8, 9)
    ```

    Note: Traditional method [[filter]] is also available and can be used, but [[take]] is prefferable in most cases.

@def TAKE -> Heavy filter

    Filters [[scalqa.val.Stream ~]] elements according to given function

    [[TAKE]] is functionally equivalent to [[take]], but is fully inlined. It makes compiled code larger, but guarantees the best possible performance on large streams.

@def take_<> -> Range filter

      Only allows elements withing specified sequencial range

      ```
         ('a' <> 'z').~.take_<>(1 <> 7).TP

         // Output
         ~(b, c, d, e, f, g, h)
      ```

      Note: Sequence indexing starts from 0

@def takeAll -> Multi element filter

      Only lets elements equal to the found in given stream

      ```
         ('a' <> 'z').~.takeAll(~~('z','x','b')).TP   // Prints ~('b','x','y')

         ('a' <> 'z').~.takeAll('b' <> 'f') .TP       // Prints ~('b','c','d','e','f')
      ```

@def takeAllBy -> Multi element mapped filter

      Only lets elements, which mapped value is found in given stream

      ```
         ('a' <> 'z').~.takeAllBy(_.toInt % 10, ~~(1,3,7)).TP

         // Output
         ~(a, e, g, k, o, q, u, y)
      ```

@def takeEvery -> Every Nth element filter

      Only lets every **nTh** element

      ```
         (1 <> 20).~.takeEvery(4).TP   // Prints: ~(4, 8, 12, 16, 20)
      ```

@def takeFirst -> Head filter

       Only takes given number of first elements

      ```
         (1 <> 10).~.takeFirst(3).TP  // Prints  ~(1, 2, 3)
      ```

@def takeIndexed -> Indexed filter

      Only lets elements satisfying the given function, which also accepts element sequential index

       ```
         ('a' <> 'z').~.takeIndexed((i, _) => i >= 2 && i <= 7, 1).TP

         // Output
         ~(b, c, d, e, f, g)
      ```
      Note: By default indexing starts from 0, but starting value can also be explicitly specified.

@def takeLast -> Tail filter

      Only takes given number of elements coming last

      ```
         (1 <> 10).~.takeLast(3).TP  // Prints  ~(8, 9, 10)
      ```

      Note: This method will block on unlimited streams

@def takeOnly -> Enumerated values filter

    Filters only specified values.

    ```
       (0 <>> 10).~.takeOnly(5).TP

       // Output
       ~(5)
    ```

    Note: When single value is given, [[takeOnly]] is more efficient than general filter ".take(_ == value)", because there is no function involved.

@def takeType -> Type filter

      Only lets elements of specified type

      ```
         ~~(1, '2', "3", new Object(), 0.0).takeType[String].TP  // Prints: ~(3)
      ```

@def takeWhile -> Conditional head filter

      Only takes first consecutive elements satisfying the condition

      ```
         def stream = (1 <> 5).~ ++ (1 <> 5)

         stream.TP                     // Prints ~(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)

         stream.takeWhile(_ <= 3).TP    // Prints ~(1, 2, 3)
      ```

      Note: Everything starting from the first non compliant element will be discarded (including later compliant elements)

@def takeDuplicates -> Duplicates filter

      Takes only elements equal to the passed in prior position

      Note: To generally get all duplicates, the stream must be sorted to arrange them in sequence

      ```
          ~~(1,1,2,3,3,4,5,5,5).takeDuplicates.tp

          // Output
          ~(1, 3, 5, 5)
      ```

@def takeDuplicatesBy -> Mapped duplicates filter

      Takes only elements, which evaluate to the same value as elements passed in prior position

      Note: To generally get all duplicates, the stream must be sorted by the mapping function

      ```
         (0 <> 10).~.takeDuplicatesBy(_ / 2).TP

         // Output
         ~(1, 3, 5, 7, 9)
      ```
*/
