package scalqa; package lang; import language.implicitConversions

import scala.{ collection as C }
import `val`.stream.z.x.{ Java as J, Scala as S }

object More:

  transparent trait IterableOnce_methods:
    extension[A](inline x: C.IterableOnce[A])
                                                  inline def valStream                   : Stream[A] = S.Stream_fromIterableOnce(x)
                                                  inline def stream                      : Stream[A] = S.Stream_fromIterableOnce(x)
                                                  inline def pack(using A:Specialized[A]): A.Pack    = x.stream.pack

  transparent trait Iterable_methods:
    extension[A](inline x: java.lang.Iterable[A])
                                                  inline def valStream                   : Stream[A] = J.Stream_fromIterable[A](x)
                                                  inline def stream                      : Stream[A] = J.Stream_fromIterable[A](x)
                                                  inline def pack(using A:Specialized[A]): A.Pack    = x.stream.pack

  transparent trait Iterator_methods:
    extension[A](inline x: java.util.Iterator[A])
                                                  inline def valStream                   : Stream[A] = J.Stream_fromIterator[A](x)
                                                  inline def stream                      : Stream[A] = J.Stream_fromIterator[A](x)
                                                  inline def pack(using A:Specialized[A]): A.Pack    = x.stream.pack

  // *****************************************************************************************
  transparent trait z_Methods extends IterableOnce_methods with Iterable_methods with Iterator_methods:
    // Efficiency extras
    extension   (inline x: Product)
                                                  inline def stream                      : Stream[(String,Any)] = S.Stream_fromProduct(x)
                                                  inline def valStream                   : Stream[(String,Any)] = S.Stream_fromProduct(x)
    extension[A](inline x: C.immutable.ArraySeq[A])
                                                  inline def stream                      : Stream[A]            = x.unsafeArray.stream.cast[Stream[A]]
                                                  inline def valStream                   : Stream[A]            = x.unsafeArray.stream.cast[Stream[A]]
    extension[A](inline x: C.IndexedSeq[A])
                                                  inline def stream                      : Stream[A]            = new S.Stream_fromIndexedSeq[A](x)
                                                  inline def valStream                   : Stream[A]            = new S.Stream_fromIndexedSeq[A](x)
    extension[A](inline x: C.LinearSeq[A])
                                                  inline def stream                      : Stream[A]            = new S.Stream_fromLinearSeq[A](x)
                                                  inline def valStream                   : Stream[A]            = new S.Stream_fromLinearSeq[A](x)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait IterableOnce_methods -> ### Scala Collections Root Extension.

    These are extension methods universally available for scala.collections.IterableOnce.

    IterableOnce is the root of Scala collections, thus those methods will be avalable on all extensions like: Seq, List, Vector, etc.

@trait Iterable_methods -> ### Java Collections Root Extension.

    These are extension methods universally available for java.lang.Iterable.

    Iterable is the root of Java collections, thus those methods will be avalable on all extensions like: List, Vector, Set, etc.

@trait Iterator_methods -> ### Java Iterator Extension Methods.

    These are extension methods universally available for java.util.Iterator.

*/