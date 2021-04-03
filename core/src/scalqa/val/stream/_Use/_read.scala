package scalqa; package `val`; package stream; package _Use; import language.implicitConversions

transparent trait _read:

  extension[A](inline x: ~[A])
    /**/               inline def read                    : A                = x.read_?.get
    @tn("read_Opt")    inline def read_?                  : Opt[A]           = x.read_?
    @tn("read_Stream") inline def read_~(inline cnt: Int) : ~[A] & Able.Size = z.use.read.stream(x,cnt)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _read -> ### Read Interface

  The methods below are special. Unlike most others, they can be called on the same stream many times.

@def read -> Next element

    Delivers next stream element

    ```
      val s : ~[Char] = 'A' <> 'Z'

      s.read.TP  // Prints A
      s.read.TP  // Prints B
      s.read.TP  // Prints C
    ```
    Note: If stream is empty, [[read]] will fail.  So, use a safer [[read_?]] in most cases

@def read_? -> Next optional element

    Delivers next stream element or void option if stream is empty

    ```
      val s : ~[Char] = 'A' <> 'C'

      s.read_?.TP  // Prints Opt(A)
      s.read_?.TP  // Prints Opt(B)
      s.read_?.TP  // Prints Opt(C)
      s.read_?.TP  // Prints Opt(\/)
    ```

@def read_~ -> Read many elements

    Immediatelly removes given number of elements from current stream and returns them as a new stream

    ```
      val s : ~[Int] = 1 <> 12

      s.read_~(3).TP  // Prints ~(1, 2, 3)
      s.read_~(4).TP  // Prints ~(4, 5, 6, 7)
      s.read_~(7).TP  // Prints ~(8, 9, 10, 11, 12)
      s.read_~(8).TP  // Prints ~()
    ```
    Note: If requested number of elements is not available, the number returned is less (0 if empty)
*/