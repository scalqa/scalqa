package scalqa; package `val`; package stream; package _Build

import z.build.{ filter => F }

transparent trait _filter extends _Filter._take with _Filter._drop:

  extension[A](inline x: ~[A])
    inline def filter(inline f: A => Boolean)     : ~[A] = new F.take(x,f)
    inline def withFilter(inline f: A => Boolean) : ~[A] = x.take(f)
    inline def FILTER(inline f: A => Boolean)     : ~[A] = x.TAKE(f)

object _filter:
  type _take =  _Filter._take
  type _drop =  _Filter._drop

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _filter -> ### Stream Filtering Interface

@def filter ->  Legacy filter

    Filters [[scalqa.val.Stream Stream]] elements according to given function

    ```
       (0 <>> 10).~.filter(_ > 5).TP

       // Output
       ~(6, 7, 8, 9)
    ```

    Note: [[take]] is usually used instead.

*/

