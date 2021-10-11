package scalqa; package lang; import language.implicitConversions

import scala.{ collection as C }
import `val`.stream.z.x.{ Java as J, Scala as S }

object More:

  transparent trait IterableOnce_methods:
    extension[A](inline x: C.IterableOnce[A])
                                                  @tn("stream") inline def ~                           : ~[A] = S.Stream_fromIterableOnce(x)
                                                  @tn("pack")   inline def >< (using A:Specialized[A]) : A.>< = x.~.><

  transparent trait Iterable_methods:
    extension[A](inline x: java.lang.Iterable[A])
                                                  @tn("stream") inline def ~                           : ~[A] = J.Stream_fromIterable[A](x)
                                                  @tn("pack")   inline def >< (using A:Specialized[A]) : A.>< = x.~.><

  transparent trait Iterator_methods:
    extension[A](inline x: java.util.Iterator[A])
                                                  @tn("stream") inline def ~                           : ~[A] = J.Stream_fromIterator[A](x)
                                                  @tn("pack")   inline def >< (using A:Specialized[A]) : A.>< = x.~.><

  // *****************************************************************************************
  transparent trait z_Methods extends IterableOnce_methods with Iterable_methods with Iterator_methods:
    // Efficiency extras
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
@trait IterableOnce_methods -> ### Scala Collections Root Extension.

    These are extension methods universally available for scala.collections.IterableOnce.

    IterableOnce is the root of Scala collections, thus those methods will be avalable on all extensions like: Seq, List, Vector, etc.

@trait Iterable_methods -> ### Java Collections Root Extension.

    These are extension methods universally available for java.lang.Iterable.

    Iterable is the root of Java collections, thus those methods will be avalable on all extensions like: List, Vector, Set, etc.

@trait Iterator_methods -> ### Java Iterator Extension Methods.

    These are extension methods universally available for java.util.Iterator.

*/