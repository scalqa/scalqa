package scalqa; package `val`; package stream; package _build

import z._build.{ _extend => X }

transparent trait _extend:
  self: Stream.type =>

  extension[A](inline x: ~[A])
    @tn("join")      inline def +  (inline v: A)                            : ~[A] = new X.join(x, v)
    @tn("joinAll")   inline def ++ (inline v: ~[A])                         : ~[A] = new X.joinAll(x, v)
    @tn("joinAt")    inline def +@ (inline index: Int, inline v: A)         : ~[A] = new X.joinAllAt(x, index, ~~(v))
    @tn("joinAllAt") inline def ++@(inline index: Int, inline v: ~[A])      : ~[A] = new X.joinAllAt(x, index, v)

    /**/             inline def join   (inline v: A)                        : ~[A] = new X.join(x, v)
    /**/             inline def joinAll(inline v: ~[A])                     : ~[A] = new X.joinAll(x, v)
    /**/             inline def joinAt(   inline index: Int, inline v: A)   : ~[A] = new X.joinAllAt(x, index, ~~(v))
    /**/             inline def joinAllAt(inline index: Int, inline v: ~[A]): ~[A] = new X.joinAllAt(x, index, v)
    /**/
    /**/             inline def default(inline v: => A)                     : ~[A] = x.nonEmpty_? or ~~(v)
    /**/             inline def unfold(f: ~[A] => Opt[A])                   : ~[A] = new X.unfold(x, f)
    /**/             inline def repeat(inline times: Int)                   : ~[A] = new X.repeat(x, times)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _extend -> ### Interface to Add Stream Elements

@def + -> Alias for [[join]]

      Creates a new [[scalqa.val.Stream ~]] with given element appended to current [[scalqa.val.Stream ~]]

      ```
         ((1 <> 5).~ + 99 + 100).TP

         // Output
         ~(1, 2, 3, 4, 5, 99, 100)
      ```

@def join -> Join element

      Creates a new [[scalqa.val.Stream ~]] with given element appended to current [[scalqa.val.Stream ~]]

      ```
         (1 <> 5).~.join(99).join(100).TP

         // Output
         ~(1, 2, 3, 4, 5, 99, 100)
      ```

@def ++ -> Alias for [[joinAll]]

      Creates a new [[scalqa.val.Stream ~]] with given elements appended to current [[scalqa.val.Stream ~]]

      ```
         (('1' <> '9').~ ++ ('a' <> 'd') ++ ('A' <> 'D')).TP

         // Output
         ~(1, 2, 3, 4, 5, 6, 7, 8, 9, a, b, c, d, A, B, C, D)
      ```

@def joinAll -> Join all

      Creates a new [[scalqa.val.Stream ~]] with given elements appended to current [[scalqa.val.Stream ~]]

      ```
         ('1' <> '9').~.joinAll('a' <> 'd').joinAll('A' <> 'D').TP

         // Output
         ~(1, 2, 3, 4, 5, 6, 7, 8, 9, a, b, c, d, A, B, C, D)
      ```

@def +@ -> Alias for [[joinAt]]

      Creates a new [[scalqa.val.Stream ~]] with given element inserted into current [[scalqa.val.Stream ~]] at given index

      If index is out of range, the element is prepended or appended

      ```
        (('a' <> 'd').~ +@ (2, 'X')).TP

         // Output
         ~(a, b, X, c, d)
      ```

@def joinAt -> Join element at position

      Creates a new [[scalqa.val.Stream ~]] with given element inserted into current [[scalqa.val.Stream ~]] at given index

      If index is out of range, the element is prepended or appended

      ```
        ('a' <> 'd').~.joinAt(2, 'X').TP

         // Output
         ~(a, b, X, c, d)
      ```

@def ++@ -> Alias for [[joinAllAt]]

     Creates a new [[scalqa.val.Stream ~]] with given elements inserted into current [[Stream]] at given index

     If index is out of range, the elements are prepended or appended

     ```
         (('a' <> 'f').~ ++@ (3, 'X' <> 'Z')).TP

         // Output
         ~(a, b, c, X, Y, Z, d, e, f)
     ```

@def joinAllAt -> Join all at position

     Creates a new [[scalqa.val.Stream ~]] with given elements inserted into current [[Stream]] at given index

     If index is out of range, the elements are prepended or appended

     ```
         ('a' <> 'f').~.joinAllAt(3, 'X' <> 'Z').TP

         // Output
         ~(a, b, c, X, Y, Z, d, e, f)
     ```

@def default -> Default element

       If current [[scalqa.val.Stream ~]] is empty, the given element will be appended

       Otherwise current [[scalqa.val.Stream ~]] will not change
       ```
         (1 <>> 1).~.default(99).TP // Prints ~(99)

         (1 <>> 5).~.default(99).TP // Prints ~(1, 2, 3, 4)
       ```

@def repeat -> Repeat elements

      Creates a new [[scalqa.val.Stream ~]] where each elements from current [[scalqa.val.Stream ~]] is repeated given number of times

      ```
        (0 <> 2).~.repeat(3).TP

        // Output
        ~(0, 0, 0, 1, 1, 1, 2, 2, 2)
      ```

@def unfold -> Lazy generator

      Lazily unfolds next stream value with a function taking all prior values

      If the given function returns void option, the stream ends

      ```
        // Unfolding Fibonacci Sequence

        (0 <> 1).~.unfold(_.takeLast(2).sum).takeFirst(20).TP

        // Output
        ~(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181)
      ```
      Note: Method `.takeFirst(20)` is needed, because otherwise the stream will never end and would be hard to print out

*/
