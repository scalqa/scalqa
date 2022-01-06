package scalqa; package `val`; package stream; package _build; import language.implicitConversions

import z._build.{ _mutate => _Z, mutate => Z }

transparent trait _mutate:
  self: Stream.type =>

  extension[A](inline x: Stream[A])
    inline def ref                                                        : Stream[A]              = x
    inline def raw              (using inline sp:Specialized.Primitive[A]): sp.Stream              = _Z.raw(x)
    inline def reverse                                                    : Stream[A]              = new _Z.reverse(x)
    inline def reverseEvery(inline size: Int)                             : Stream[A]              = new _Z.reverseEvery(x, size)
    inline def shuffle                                                    : Stream[A]              = new _Z.shuffle(x)
    inline def transpose[B]               (using inline f:A => Stream[B]) : Stream[Stream[B]]      = new _Z.transpose(x,f)
    inline def synchronize                                                : Stream[A]              = new _Z.synchronize(x)
    inline def load                                                       : Stream[A] & Able.Size  = Z.load(x)
    inline def hideSizeData                                               : Stream[A]              = Z.hideSizeData(x)
    inline def enablePreview                                              : Stream[A] & Preview[A] = Z.enablePreview(x)
    inline def enableSize                                                 : Stream[A] & Able.Size  = Z.enableSize(x)
    inline def replaceSequence(inline seq: Stream[A],inline to: Stream[A]): Stream[A]              = _Z.replaceSequence(x,seq.pack,to.pack)
    inline def replaceSequenceBy[B](inline f:A=>B,
                               inline seq: Stream[B],inline to: Stream[A]): Stream[A]              = _Z.replaceSequence(x,f,seq.pack,to.pack)
    @tn("nonEmptyOpt")
    inline def nonEmptyOpt                                                 : Opt[Stream[A]]         = Z.nonEmptyOpt(x)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _mutate -> ### Various Stream Mutation Interface

@def synchronize -> Synchronize access

     Nothing fancy, just a convenience "synchronized" wrapper

     ```
      val nonSyncStream: Stream[Int] = (0 <>> 10000).stream

      (1 <> 10000).stream.parallel.map(_ => nonSyncStream.read ).stream.sort.takeDuplicates.count.tp  // Prints 0 to few hundred count

      val syncStream: Stream[Int] = (0 <>> 10000).stream.synchronize

      (1 <> 10000).stream.parallel.map(_ => syncStream.read ).stream.sort.takeDuplicates.count.tp    // Prints 0
    ```

@def ref -> Generalize

     If stream is specialized it will be up-cast to general Val.Stream type, and further operations will be general (unless they are specialized, like [[map]])

     ```
        val special : Int.Pack  = (1 <> 10).stream.pack

        val general : Pack[Int] = (1 <> 10).stream.ref.pack

        special.getClass.TP // Prints class scalqa.lang.int.g.Pack

        general.getClass.TP // Prints class scalqa.val.pack.z.ArrayPack
     ```
     Note: This is a true zero cost operation.  It does not change byte code (only compiler context)

@def enableSize -> Adds sizing information

      If Stream already has sizing, this method is a simple cast, otherwise, the elements might be buffered and counted.

@def hideSizeData -> Loose size information

      Many streams return ''sizeLongOpt'', knowing their current size

      [[hideSizeData]] drops sizing information, so some optimizations will not be available

      This is primarily for testing and debugging

@def load -> Preload all

     Immediately loads all stream elements into memory, so they are no longer dependent on underlying sources.

     ```
        def s : Stream[String] = ?_?_?

        s.load

        // is functionally same as

        s.toBuffer.stream
      ```

@def nonEmptyOpt -> Non empty option

    Optionally returns stream, if it is not empty.

    Note: If stream does not have sizing information, this method will immediately preload at least the first element.

@def enablePreview -> Enables preview capabilities

     Returns [[scalqa.val.stream.Preview Stream.Preview]], which allows to pre-load and inspect elements, even before they are read

     ```
        def strm : Stream[String] = ?_?_?

        if(strm.enablePreview.previewSize > 1000) "Stream is over 1K".TP
      ```

@def raw -> Specialize

    Converts current stream into specialized on underlying primitive type. If stream is already specialized, the conversion is a simple cast.

    ```
        val s  : Stream[Int]     = 1 <> 10

        val ss : Int.Stream = s.raw
    ```

    Note: If underlying type is not primitive, the method will not compile

@def reverse -> Reverse order

       Re-arranges all elements is reverse order

       ```
        ('A' <> 'F').stream.reverse.TP  // Prints Stream(F, E, D, C, B, A)
       ```

@def reverseEvery -> Reverse order in segments

       Reverses order of elements within segments of fixed size

       ```
        (1 <> 15).stream.reverseEvery(5).TP

        (1 <> 15).stream.reverseEvery(5).reverseEvery(3).reverseEvery(7).TP

        // Output
        Stream(5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 15, 14, 13, 12, 11)

        Stream(7, 2, 1, 10, 5, 4, 3, 12, 11, 6, 15, 14, 9, 8, 13)
       ```

       Use Case: Predefined Shuffle

       For testing purposes it is often required to get elements in random order. However the order cannot be completely random, if we want to replicate bugs

       [[reverseEvery]] can shuffle elements in a predefined order which looks random

@def shuffle -> Randomize order

       Re-arranges elements is random order

      Note. "reverseEvery" might be a better choice if need repeatable randomness

@def transpose -> Transpose

     Transposes matrix where rows become columns

      ```
       def stream : Stream[Stream[Int]] = Stream(11 <> 15,
                                   List(21, 22, 23, 24, 25),
                                   Vector(31, 32, 33, 34, 35))

       stream.print

       stream.transpose.print

       // Output
       ---------------------
       ?
       ---------------------
       Stream(11, 12, 13, 14, 15)
       Stream(21, 22, 23, 24, 25)
       Stream(31, 32, 33, 34, 35)
       ---------------------

       -------------
       ?
       -------------
       Stream(11, 21, 31)
       Stream(12, 22, 32)
       Stream(13, 23, 33)
       Stream(14, 24, 34)
       Stream(15, 25, 35)
       -------------
     ```
*/
