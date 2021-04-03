package scalqa; package `val`; package stream; package custom; import language.implicitConversions

import scala.{ collection as C }
import java.{ lang as L, util as U}

transparent trait _extension extends _extensionDefault:
  extension[A](inline x: L.Iterable[A])           @tn("stream") inline def ~ : ~[A]            = z.a.Java.Stream_fromIterable[A](x)
  extension[A](inline x: U.Iterator[A])           @tn("stream") inline def ~ : ~[A]            = z.a.Java.Stream_fromIterator[A](x)
  extension   (inline x: Product)                 @tn("stream") inline def ~ : ~[(String,Any)] = z.a.Scala.Stream_fromProduct(x)
  extension[A](inline x: C.immutable.ArraySeq[A]) @tn("stream") inline def ~ : ~[A]            = x.unsafeArray.~.cast[~[A]]
  extension[A](inline x: C.IndexedSeq[A])         @tn("stream") inline def ~ : ~[A]            = new z.a.Scala.Stream_fromIndexedSeq[A](x)
  extension[A](inline x: C.LinearSeq[A])          @tn("stream") inline def ~ : ~[A]            = new z.a.Scala.Stream_fromLinearSeq[A](x)

private[custom] trait _extensionDefault:
  extension[A](inline x: C.IterableOnce[A])       @tn("stream") inline def ~ : ~[A]            = z.a.Scala(x)


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _extension -> ### Global Streaming Extensions

  The below extensions methods are universally available within Scalqa.
  They add conversion to stream to Java and Scala collections.

*/