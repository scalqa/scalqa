package scalqa; package gen; package util; import language.implicitConversions

import scala.{ collection as C }
import `val`.stream.z.x.{ Java as J, Scala as S }

object Extension:

  object Scala:

    transparent trait IterableOnce:
      extension[A](inline x: C.IterableOnce[A])
                                                    @tn("stream") inline def ~                           : ~[A] = S.Stream_fromIterableOnce(x)
                                                    @tn("pack")   inline def >< (using A:Specialized[A]) : A.>< = x.~.><

  object Java:

    transparent trait Iterable:
      extension[A](inline x: java.lang.Iterable[A])
                                                    @tn("stream") inline def ~                           : ~[A] = J.Stream_fromIterable[A](x)
                                                    @tn("pack")   inline def >< (using A:Specialized[A]) : A.>< = x.~.><

    transparent trait Iterator:
      extension[A](inline x: java.util.Iterator[A])
                                                    @tn("stream") inline def ~                           : ~[A] = J.Stream_fromIterator[A](x)
                                                    @tn("pack")   inline def >< (using A:Specialized[A]) : A.>< = x.~.><

  // *****************************************************************************************
  transparent trait zMethods extends Scala.IterableOnce with Java.Iterable with Java.Iterator:

    extension   (inline x: Product)                 @tn("stream") inline def ~ : ~[(String,Any)] = S.Stream_fromProduct(x)
    extension[A](inline x: C.immutable.ArraySeq[A]) @tn("stream") inline def ~ : ~[A]            = x.unsafeArray.~.cast[~[A]]
    extension[A](inline x: C.IndexedSeq[A])         @tn("stream") inline def ~ : ~[A]            = new S.Stream_fromIndexedSeq[A](x)
    extension[A](inline x: C.LinearSeq[A])          @tn("stream") inline def ~ : ~[A]            = new S.Stream_fromLinearSeq[A](x)


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait IterableOnce -> ### Scala Collections Root Extension.

    These are extension methods universally available for scala.collections.IterableOnce.

    IterableOnce is the root of Scala collections, thus those methods will be avalable on most collections like: Seq, List, Vector, etc.

@trait Iterable -> ### Java Collections Root Extension.

    These are extension methods universally available for java.lang.Iterable.

    Iterable is the root of Java collections, thus those methods will be avalable on most collections like: List, Vector, Set, etc.

@trait Iterator -> ### Java Iterator Extension Methods.

    These are extension methods universally available for java.util.Iterator.

*/