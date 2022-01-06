package scalqa; package lang; import language.implicitConversions

import scala.{ collection as C }
import `val`.stream.z.x.{ Java as J, Scala as S }

object More:

  transparent trait ScalaCollections:
    extension[A](inline x: C.IterableOnce[A])
                                                  inline def ~~                          : Stream[A] = S.Stream_fromIterableOnce(x)
                                                  inline def stream                      : Stream[A] = S.Stream_fromIterableOnce(x)
                                                  inline def pack(using s:Specialized[A]): s.Pack    = x.stream.pack

  transparent trait JavaCollections:
    extension[A](inline x: java.lang.Iterable[A])
                                                  inline def ~~                          : Stream[A] = J.Stream_fromIterable[A](x)
                                                  inline def stream                      : Stream[A] = J.Stream_fromIterable[A](x)
                                                  inline def pack(using s:Specialized[A]): s.Pack    = x.stream.pack

  // *****************************************************************************************
  transparent trait z_Methods extends ScalaCollections with JavaCollections:

    extension[A](inline x: java.util.Iterator[A])
      inline def ~~                          : Stream[A] = J.Stream_fromIterator[A](x)
      inline def stream                      : Stream[A] = J.Stream_fromIterator[A](x)
      inline def pack(using s:Specialized[A]): s.Pack    = x.stream.pack

    // Efficiency extras
    extension   (inline x: Product)
                                                  inline def stream                      : Stream[(String,Any)] = S.Stream_fromProduct(x)
                                                  inline def ~~                          : Stream[(String,Any)] = S.Stream_fromProduct(x)
    extension[A](inline x: C.immutable.ArraySeq[A])
                                                  inline def stream                      : Stream[A]            = x.unsafeArray.stream.cast[Stream[A]]
                                                  inline def ~~                          : Stream[A]            = x.unsafeArray.stream.cast[Stream[A]]
    extension[A](inline x: C.IndexedSeq[A])
                                                  inline def stream                      : Stream[A]            = new S.Stream_fromIndexedSeq[A](x)
                                                  inline def ~~                          : Stream[A]            = new S.Stream_fromIndexedSeq[A](x)
    extension[A](inline x: C.LinearSeq[A])
                                                  inline def stream                      : Stream[A]            = new S.Stream_fromLinearSeq[A](x)
                                                  inline def ~~                          : Stream[A]            = new S.Stream_fromLinearSeq[A](x)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait ScalaCollections -> ### Scala Collections Extension

    These are extension methods universally available for all Scala Collections, which extend scala.collections.IterableOnce.

    Scala Seq, List, Vector, and the likes are covered.

    Also note that all Scala collections are implicitly convertibe to Stream, thus they can be used directly everywhere where Stream is required:

    ```
      val buf: Buffer[String] = NEW

      buf ++= Stream("A","B") ++= List("C","D") ++= Vector("E","F") ++= Seq("X","Y","Z")

    ```

@trait JavaCollections -> ### Java Collections Extension

    These are extension methods universally available for all Java Collections, which extend java.lang.Iterable.

    Java List, Vector, Set, Iterator, etc. have those methods.

    Also note that all Java collections are implicitly convertibe to Stream, thus they can be used directly everywhere where Stream is required.

@def stream -> Stream of elements \n\n Returns Stream of collection elements
@def stream -> Stream of elements \n\n Returns Stream of collection elements

@def pack -> Pack of elements \n\n Returns Pack of collection elements
@def pack -> Pack of elements \n\n Returns Pack of collection elements

@def ~~ -> Alias to .stream \n\n Note. In cases when target collection already has a "stream" method with different semantics, calling ~~ is the only option.
@def ~~ -> Alias to .stream \n\n Note. In cases when target collection already has a "stream" method with different semantics, calling ~~ is the only option.

*/