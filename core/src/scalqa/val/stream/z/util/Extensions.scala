package scalqa; package `val`; package stream; package z; package util; import language.implicitConversions

import scala.{ collection as SCALA }
import java.{  util as JAVA}

transparent trait GlobalMethods extends DefaultGlobalMethods:
  extension[A](inline x: java.lang.Iterable[A])       @tn("stream") inline def ~ : ~[A]            = z.x.Java.Stream_fromIterable[A](x)
  extension[A](inline x: JAVA.Iterator[A])            @tn("stream") inline def ~ : ~[A]            = z.x.Java.Stream_fromIterator[A](x)
  extension   (inline x: Product)                     @tn("stream") inline def ~ : ~[(String,Any)] = z.x.Scala.Stream_fromProduct(x)
  extension[A](inline x: SCALA.immutable.ArraySeq[A]) @tn("stream") inline def ~ : ~[A]            = x.unsafeArray.~.cast[~[A]]
  extension[A](inline x: SCALA.IndexedSeq[A])         @tn("stream") inline def ~ : ~[A]            = new z.x.Scala.Stream_fromIndexedSeq[A](x)
  extension[A](inline x: SCALA.LinearSeq[A])          @tn("stream") inline def ~ : ~[A]            = new z.x.Scala.Stream_fromLinearSeq[A](x)

trait DefaultGlobalMethods:
  extension[A](inline x: SCALA.IterableOnce[A])       @tn("stream") inline def ~ : ~[A]            = z.x.Scala.mkStream(x)


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Constructors -> ### Global Streaming Extensions

  The below extensions methods are universally available within Scalqa.
  They add ".~" method to all Java and Scala collections.

*/