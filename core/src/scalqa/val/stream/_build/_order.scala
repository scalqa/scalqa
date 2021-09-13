package scalqa; package `val`; package stream; package _build; import language.implicitConversions

import z._build.{ _order as Z }

transparent trait _order:

  extension[A](inline x: ~[A])
    inline def sort                                                   (using inline o:Ordering[A]): ~[A] = new Z.sort(x)
    inline def sortReversed                                           (using inline o:Ordering[A]): ~[A] = new Z.sortReversed(x)
    inline def sortBy[B]    (inline f: A=>B)                          (using inline o:Ordering[B]): ~[A] = new Z.sortBy(x, f)
    inline def sortBy[B,C]  (f1:A=>B,f2:A=>C)                    (using  Ordering[B], Ordering[C]): ~[A] = new Z.sortBy(x, v => (f1(v), f2(v)))
    inline def sortBy[B,C,D](f1:A=>B,f2:A=>C,f3:A=>D)(using Ordering[B], Ordering[C], Ordering[D]): ~[A] = new Z.sortBy(x, v => (f1(v), f2(v), f3(v)))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _order -> ### Stream Ordering Interface

@def sort -> Sort

     Sorts stream elements with given Ordering

     ```
        ~~(5, 1, 4, 2, 3).sort.TP  // Prints ~(1, 2, 3, 4, 5)
     ```

@def sortBy -> Sort by property

     Sorts stream of elements based on a single property

     ```
        ~~("aaaa", "bb", "ccc", "d").sortBy(_.length).TP

        // Output
        ~(d, bb, ccc, aaaa)
     ```

@def sortBy -> Sort by two properties

     Sorts stream on first property, and then, if indeterminate on second


@def sortBy -> Sort by three properties

     Sorts stream on first property, then if indeterminate on second, etc...

@def sortReversed -> Sort reversed

     Reverse sorts stream elements with given Ordering

     ```
        ~~(5, 1, 4, 2, 3).sortReversed.TP  // Prints ~(5, 4, 3, 2, 1)
     ```
 */

