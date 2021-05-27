package scalqa; package `val`; package stream; package _Build; package _Filter

import z.build.{ filter => F }

transparent trait _drop :
  extension[A](inline x: ~[A])
    /**/              inline def drop(inline f: A => Boolean)            : ~[A] = new F.drop(x, f)
    /**/              inline def dropWhile(inline f: A => Boolean)       : ~[A] = new F.dropWhile(x, f)
    /**/              inline def dropFirst(inline n: Int)                : ~[A] = new F.dropFirst(x, n)
    @tn("drop_Range") inline def drop_<>(inline i: Int.<>)               : ~[A] = new F.drop_Interval(x, i)
    /**/              inline def dropLast(n: Int)                        : ~[A] = new F.dropLast(x.cast[~[Ref]], n).cast[~[A]]
    /**/              inline def dropEvery(nTh: Int)                     : ~[A] = new F.dropEvery(x,nTh)
    /**/              inline def dropSame                                : ~[A] = new F.dropSame(x)
    /**/              inline def dropSameBy[B](inline f: A=>B)           : ~[A] = new F.dropSame.By(x,f)
  extension[A](x: ~[A])
    /**/                     def dropAll(v: ~[A])                        : ~[A] = { val set=v.toSet;  if(set.isEmpty) x else x.DROP(v => set.contains(v))}
    /**/                     def dropAllBy[B](f: A=>B,v: ~[B])           : ~[A] = { val set=v.toSet;  if(set.isEmpty) x else x.DROP(v => set.contains(f(v)))}
    /**/                     def dropOnly(v: A, vs: A*)                  : ~[A] = if(vs.isEmpty) x.DROP(_ == v) else dropAll(vs.~ + v)
    /**/                     def dropOnlyBy[B](f:A=>B,vs: B*)            : ~[A] = dropAllBy(f,vs.~)
    /**/                     def dropVoid       (using Self.VoidTag[A]) : ~[A] = new F.dropVoid(x) // do not inline, there is same method in Opt - trouble when Opt[~[_]]
  extension[A](inline x: ~[A])
    /**/              inline def DROP(inline f: A => Boolean)            : ~[A] = { class DROP(x: ~[A]) extends z.a.Pipe[A](x){@tn("read_Opt") def read_? ={var o=x.read_?; while(o.nonEmpty){ if(!f(o.cast[A])) return o; o=x.read_?}; o}}; new DROP(x)}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
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

      Note: Sequence indexing starts from 0

@def dropAll -> Multi element reversed filter

      Only lets elements not found in given stream

      ```
         ('a' <> 'z').~.dropAll('c' <> 'x') .TP       // Prints ~(a, b, y, z)
      ```

@def dropAllBy -> Multi element mapped reversed filter

      Only lets elements, which mapped value is not found in given stream

      ```
         ('a' <> 'z').~.dropAllBy(_.Int % 10, ~~(1,3,7,4,6)).TP

         // Output
         ~(b, c, d, f, i, l, m, n, p, s, v, w, x, z)
      ```

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

    Note: [[dropOnly]] is more efficient than general filter, because there is no function involved.

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

@def dropSame -> Duplicates reversed filter

      Drops elements equal to the passed in prior position

      Note: To generally get rid of all duplicates, the stream must be sorted to arrange duplicates in sequence

@def dropSameBy -> Mapped duplicates reversed filter

      Drops elements, which evaluate to the same value as elements passed in prior position

      Note: To generally get rid of all duplicates, the stream must be sorted by the mapping function

      ```
         (1 <> 100).~.dropSameBy(_.toString.length).TP

         // Output
         ~(1, 10, 100)
      ```
*/
