package scalqa; package `val`; package stream; package _build

import z._build.{ _filter => F }

transparent trait _Filter extends _filter._take with _filter._drop:

  extension[A](inline x: ~[A])
    inline def filter    (inline f: A => Boolean) : ~[A] = x.take(f)
    inline def withFilter(inline f: A => Boolean) : ~[A] = x.take(f)
    inline def FILTER    (inline f: A => Boolean) : ~[A] = x.TAKE(f)

object _Filter:
  type _take =  _filter._take
  type _drop =  _filter._drop

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _Filter -> ### Stream Filtering Interface

@def filter ->  Legacy filter

    Filters [[scalqa.val.Stream ~]] elements according to given function

    ```
       (0 <>> 10).~.filter(_ > 5).TP

       // Output
       ~(6, 7, 8, 9)
    ```

    Note: [[take]] is usually used instead.

@def FILTER -> Legacy heavy filter

    Filters [[scalqa.val.Stream ~]] elements according to given function

    [[FILTER]] is functionally equivalent to [[filter]], but is fully inlined. It makes compiled code larger, but guarantees the best possible performance on large streams.

    Note: [[TAKE]] is usually used instead.
*/

