package scalqa; package `val`; package stream; package _Build; import language.implicitConversions

import z.build.{ zip => Z }

transparent trait _zip:
  self: Stream.type =>

  extension[A](inline x: ~[A])
    inline def unzip[B,C]                          (using inline f: A => (B,C)) : (~[B],~[C])    = Z.unzip(x,f)
    inline def zip[B](inline that: ~[B])                                        : ~[(A,B)]       = new Z.zip(x,that)
    inline def zipAll[B](inline that: ~[B], thisDflt: Opt[A], thatDflt: Opt[B]) : ~[(A,B)]       = new Z.zipAll(x,that,thisDflt,thatDflt)
    inline def zipKey[B]  (inline f: A => B)                                    : ~[(B,A)]       = new Z.zipKey(x,f)
    inline def zipValue[B](inline f: A => B)                                    : ~[(A,B)]       = new Z.zipValue(x,f)
    inline def zipNext                                                          : ~[(A,Opt[A])]  = new Z.zipNext(x)
    inline def zipPrior                                                         : ~[(Opt[A],A)]  = new Z.zipPrior(x)
    inline def zipFoldAs[B](inline start: B, inline f: (B,A) => B)              : ~[(A,B)]       = new Z.zipFoldAs(x,start,f)
    inline def zipIndex                                                         : ~[(Int,A)]     = new Z.zipIndex(x,0)
    inline def zipIndex(inline start: Int)                                      : ~[(Int,A)]     = new Z.zipIndex(x,start)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _zip -> ### Zip Interface

@def unzip -> Unzips stream in two

    Unzips a stream of tupled values in two

     ```
      val pairs = ('a' <> 'g').~.zipValue(_.toUpper).><

      pairs.~.TP  // Prints ~((a,A), (b,B), (c,C), (d,D), (e,E), (f,F), (g,G))

      val (left, right) = pairs.~.unzip

      left.TP   // Prints ~(a, b, c, d, e, f, g)

      right.TP  // Prints ~(G, F, E, D, C, B, A)
     ```

@def zip -> Merge

     Merges two streams in one, creating tuples of corresponding elements


     ```
        (1 <> 100).~.zip('A' <> 'D').TP  // Prints ~((1,A), (2,B), (3,C), (4,D))
     ```

     If one of the streams is shorter, the excess elements are lost


@def zipAll -> Merge stream

     Merges two streams in one, creating tuples of corresponding elements

     If one of the streams is shorter, the provided defaults are used. If the default is not available, operation fails


     ```
        ('a' <> 'f').~.zip('A' <> 'H', '?', '?').TP

        // Output
        ~((a,A), (b,B), (c,C), (d,D), (e,E), (f,F), (?,G), (?,H))
     ```

     @param  that the stream to merge with **this**
     @param  thisDflt if **this** [[scalqa.val.Stream Stream]] has fewer elements,  ''thisDflt'' will be used to fill the voids. Fails if ''thisDflt'' is required, but not available
     @param  thatDflt if **that** [[scalqa.val.Stream Stream]] has fewer elements,  ''thatDflt'' will be used to fill the voids. Fails if ''thatDflt'' is required, but not available


@def zipFoldAs -> Merges current folding value

      ```
       (1 <> 7).~.zipFoldAs(0L)(_ + _).print

       // "Running Total" Output
       -- --
       ?  ?
       -- --
       1  1
       2  3
       3  6
       4  10
       5  15
       6  21
       7  28
      ```

@def zipIndex  -> Merge index

     Creates a new [[scalqa.val.Stream Stream]] with elements paired with their sequential position, starting at 0

     ```
        ('A' <> 'F').~.zipIndex.TP

        // Output

        ~((0,A), (1,B), (2,C), (3,D), (4,E), (5,F))
     ```

     Note:  Index is the first element in the resulting tuples


@def zipIndex ->  Merge number
     Creates a new [[scalqa.val.Stream Stream]] with elements paired with their sequential position
     Note:  Index is the first element in the resulting tuples.

     ```
         ('A' <> 'F').~.zipIndex('A'.toInt) TP  // Prints Stream((65,A), (66,B), (67,C), (68,D), (69,E), (70,F))
     ```
     @param start index initial value


@def zipKey -> Merge property first

     Creates a new [[scalqa.val.Stream Stream]] with elements paired with their property, defined by given function

     The paired value is in the first tuple position

     ```
        ('A' <> 'F').~.zipKey(_.Int).TP  // Prints ~((65,A), (66,B), (67,C), (68,D), (69,E), (70,F))
     ```

@def zipValue -> Merge property

     Creates a new [[scalqa.val.Stream Stream]] with elements paired with their property, defined by given function

     The paired value is in the second tuple position

     ```
        ('A' <> 'F').~.zipValue(_.Int).TP  // Prints ~((A,65), (B,66), (C,67), (D,68), (E,69), (F,70))
     ```


@def zipPrior -> Merge with prior

     Creates new [[scalqa.val.Stream Stream]] with elements paired with the optional prior element

     ```
        (1 <> 5).~.zipPrior.TP  // Prints ~((Opt(\/),1), (Opt(1),2), (Opt(2),3), (Opt(3),4), (Opt(4),5))
     ```


@def zipNext -> Merge with next

     Creates new [[scalqa.val.Stream Stream]] with elements paired with the optional next element

     ```
        (1 <> 5).~.zipNext.TP  // Prints ~((1,Opt(2)), (2,Opt(3)), (3,Opt(4)), (4,Opt(5)), (5,Opt(\/)))
     ```
*/
