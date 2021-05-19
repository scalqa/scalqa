package scalqa; package `val`; package stream; package z; package util; import language.implicitConversions

class _default:
  self: Stream.type =>

  inline def fromIterator[A]    (inline v: java.util.Iterator[A])                   : ~[A]             = new z.a.Java.Stream_fromIterator(v)
  inline def fromSpliterator[A] (inline v: java.util.Spliterator[A])                : ~[A]             = new z.a.Java.Stream_fromSpliterator(v)
  inline def fromEnumeration[A] (inline v: java.util.Enumeration[A])                : ~[A]             = new z.a.Java.Stream_fromEnumeration(v)
  inline def fromIterable[A]    (inline v: java.lang.Iterable[A])                   : ~[A]             = z.a.Java.Stream_fromIterable(v)
  inline def fromIterableOnce[A](inline v: scala.collection.IterableOnce[A])        : ~[A]             = z.a.Scala[A](v)
  inline def fromProduct        (inline v: Product)                                 : ~[(String,Any)]  = new z.a.Scala.Stream_fromProduct(v)

  implicit inline def implicitRequestVoid[A](inline v: \/)                                    : ~[A] & Able.Size = void.cast[~[A] & Able.Size]
  implicit inline def implicitFromRange[A:Able.Sequence](inline v: Range[A])                  : ~[A]             = v.~
  implicit inline def implicitFromIterable[A](inline v: java.lang.Iterable[A])                : ~[A]             = z.a.Java.Stream_fromIterable(v)
  implicit inline def implicitFromIterator[A](inline v: java.util.Iterator[A])                : ~[A]             = new z.a.Java.Stream_fromIterator(v)
  implicit inline def implicitFromIterableOnce[A](inline v: scala.collection.IterableOnce[A]) : ~[A]             = z.a.Scala[A](v)
  implicit inline def implicitFromOpt[A](inline v: Opt[A])                                    : ~[A]             = {val o=v; o.~ }
  implicit inline def implicitFromResult[A](inline v: Result[A])                              : ~[A]             = {val o=v; o.~ }
  implicit inline def implicitFromArray[A](inline v: Array[A])                                : ~[A]             = v.~

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def fromIterator     -> Explicit constructor from Iterator     \n\n Note: There is also global implicit conversion from `Iterator` to `Stream`
@def fromSpliterator  -> Constructor from Spliterator
@def fromEnumeration  -> Constructor from Enumeration
@def fromIterable     -> Explicit constructor from Iterable     \n\n Note: There is also global implicit conversion from `Iterable` to `Stream`
@def fromIterableOnce -> Explicit constructor from IterableOnce \n\n Note: There is also global implicit conversion from `IterableOnce` to `Stream`
@def fromProduct      -> Constructor from Product
*/