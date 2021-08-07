package scalqa; package `val`; package stream; package _build; import language.implicitConversions

import gen.`given`.StreamShape
import z._build.{ _mutate => M }

transparent trait _mutate:
  self: Stream.type =>

  extension[A,STM<: ~~.RawType[A]](inline x: ~[A])
    /**/          inline def raw(using inline s:StreamShape.Raw[A,STM]): STM               = M.raw(x,s)
  extension[A](inline x: ~[A])
    /**/          inline def ref                                       : ~[A]              = x
    /**/          inline def reverse                                   : ~[A]              = new M.reverse(x)
    /**/          inline def reverseEvery(inline size: Int)            : ~[A]              = new M.reverseEvery(x, size)
    /**/          inline def shuffle                                   : ~[A]              = new M.shuffle(x)
    /**/          inline def transpose[B](using inline f:A => ~[B])    : ~[~[B]]           = new M.transpose[A](x,f.cast[A => ~[AnyRef]]).cast[~[~[B]]]
    /**/          inline def synchronize                               : ~[A]              = new M.synchronize(x)
  extension[A] (x: ~[A])
    /**/                 def load                                      : ~[A] & Able.Size  = x.toBuffer.~.enableSize
    /**/                 def hideSizeData                              : ~[A]              = if(x.sizeLong_?) new M.hideSizeData(x) else x
    /**/                 def enablePreview                             : ~[A] & Preview[A] = x match{ case v: Preview[_] => v.cast[Preview[A]]; case v => M.preview(v)}
    /**/                 def enableSize                                : ~[A] & Able.Size  = x match{ case v: Able.Size => x.cast[~[A] & Able.Size];  case v => M.enableSize(v)}
    @tn("nonEmpty_Opt")  def nonEmpty_?                                : Opt[~[A]]         = x.sizeLong_? match
                                                                                                          case o if o.nonEmpty => o.take(_ > 0).map(_ => x)
                                                                                                          case _ => {val b=x.enablePreview; if(b.preview_?) b.? else \/}

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
      val nonSyncStream: ~[Int] = (0 <>> 10000).~

      (1 <> 10000).~.parallel.map(_ => nonSyncStream.read ).~.sort.takeDuplicates.count.tp  // Prints 0 to few hundred count

      val syncStream: ~[Int] = (0 <>> 10000).~.synchronize

      (1 <> 10000).~.parallel.map(_ => syncStream.read ).~.sort.takeDuplicates.count.tp    // Prints 0
    ```

@def ref -> Generalize

     If stream is specialized it will be up-cast to general Val.Stream type, and further operations will be general (unless they are specialized, like [[map]])

     ```
        val special : Int.><  = (1 <> 10).~.><

        val general : ><[Int] = (1 <> 10).~.ref.><

        special.getClass.TP // Prints class scalqa.lang.int.g.Pack

        general.getClass.TP // Prints class scalqa.val.pack.z.ArrayPack
     ```
     Note: This is a true zero cost operation.  It does not change byte code (only compiler context)

@def enableSize -> Adds sizing information

      If Stream already has sizing, this method is a simple cast, otherwise, the elements might be buffered and counted.

@def hideSizeData -> Loose size information

      Many streams return ''sizeLong_?'', knowing their current size

      [[hideSizeData]] drops sizing information, so some optimizations will not be available

      This is primarily for testing and debugging

@def load -> Preload all

     Immediately loads all stream elements into memory, so they are no longer dependent on underlying sources.

     ```
        def strm : ~[String] = ?_?_?

        strm.load

        // is functionally same as

        strm.toBuffer.~
      ```

@def nonEmpty_? -> Non empty option
    Optionally returns stream, if it is not empty.

    Note: If stream does not have sizing information, this method will immediately preload at lease the first element.

@def enablePreview -> Enables preview capabilities

     Returns [[scalqa.val.stream.Preview ~~.Preview]], which allows to pre-load and inspect elements, even before they are read

     ```
        def strm : ~[String] = ?_?_?

        if(strm.enablePreview.previewSize > 1000) "Stream is over 1K".TP
      ```

@def raw -> Specialized stream

    Converts current stream into specialized on underlying primitive data. If stream is already specialized, the conversion is a simple cas t.

    ```
        val s  : ~[Int] = 1 <> 10

        val ss : Int.~  = s.raw
    ```

    Note: If underlying type is not primitive, the method will not compile

@def reverse -> Reverse order

       Re-arranges all elements is reverse order

       ```
        ('A' <> 'F').~.reverse.TP  // Prints ~(F, E, D, C, B, A)
       ```

@def reverseEvery -> Reverse order in segments

       Reverses order of elements within segments of fixed size

       ```
        (1 <> 15).~.reverseEvery(5).TP

        (1 <> 15).~.reverseEvery(5).reverseEvery(3).reverseEvery(7).TP

        // Output
        ~(5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 15, 14, 13, 12, 11)

        ~(7, 2, 1, 10, 5, 4, 3, 12, 11, 6, 15, 14, 9, 8, 13)
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
       def stream : ~[~[Int]] = ~~(11 <> 15,
                                   List(21, 22, 23, 24, 25),
                                   Vector(31, 32, 33, 34, 35))

       stream.print

       stream.transpose.print

       // Output
       ---------------------
       ?
       ---------------------
       ~(11, 12, 13, 14, 15)
       ~(21, 22, 23, 24, 25)
       ~(31, 32, 33, 34, 35)
       ---------------------

       -------------
       ?
       -------------
       ~(11, 21, 31)
       ~(12, 22, 32)
       ~(13, 23, 33)
       ~(14, 24, 34)
       ~(15, 25, 35)
       -------------
     ```
*/
