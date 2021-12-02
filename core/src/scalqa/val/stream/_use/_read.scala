package scalqa; package `val`; package stream; package _use; import language.implicitConversions

transparent trait _read:

  extension[A](inline x: Stream[A])
    inline def read                    : A                     = x.readOpt.get
    inline def readOpt                 : Opt[A]                = x.readOpt
    inline def readStream(inline cnt: Int) : Stream[A] & Able.Size = z._use._read.stream(x,cnt)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _read -> ### Stream Iteration Interface

  The methods below are special. Unlike most others, they can be called on the same stream many times.

@def read -> Next element

    Delivers next stream element

    ```
      val s : Stream[Char] = 'A' <> 'Z'

      s.read.TP  // Prints A
      s.read.TP  // Prints B
      s.read.TP  // Prints C
    ```
    Note: If stream is empty, [[read]] will fail.  So, use a safer [[readOpt]] in most cases

@def readOpt -> Next optional element

    Delivers next stream element or void option if stream is empty

    ```
      val s : Stream[Char] = 'A' <> 'C'

      s.readOpt.TP  // Prints Opt(A)
      s.readOpt.TP  // Prints Opt(B)
      s.readOpt.TP  // Prints Opt(C)
      s.readOpt.TP  // Prints Opt(VOID)
    ```

@def readStream -> Read many elements

    Immediatelly removes given number of elements from current stream and returns them as a new stream

    ```
      val s : Stream[Int] = 1 <> 12

      s.readStream(3).TP  // Prints Stream(1, 2, 3)
      s.readStream(4).TP  // Prints Stream(4, 5, 6, 7)
      s.readStream(7).TP  // Prints Stream(8, 9, 10, 11, 12)
      s.readStream(8).TP  // Prints Stream()
    ```
    Note: If requested number of elements is not available, the number returned is less (0 if empty)
*/