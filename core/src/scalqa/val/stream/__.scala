package scalqa; package `val`; import stream.*; import language.implicitConversions

trait Stream[+A]:
  def readOpt : Opt[A]

object Stream extends z_StreamDefaults with _Build with _Use:
  /**/          inline def apply[A](inline v: A)                                  : Stream[A]             = z.x.VarArg.Stream_ofOne[A](v)
  /**/          inline def apply[A](inline v1: A, inline v2: A)                   : Stream[A]             = z.x.VarArg.Stream_ofTwo[A](v1, v2)
  /**/                 def apply[A](v1: A, v2: A, v3: A, vs: A*)                  : Stream[A]             = if (vs.isEmpty) z.x.VarArg.Stream_ofThree[A](v1,v2,v3) else z.x.VarArg.Stream_ofMany[A](v1,v2,v3,vs)
  /**/          inline def fromIterator[A]    (inline v: java.util.Iterator[A])   : Stream[A]             = new z.x.Java.Stream_fromIterator(v)
  /**/          inline def fromSpliterator[A] (inline v: java.util.Spliterator[A]): Stream[A]             = new z.x.Java.Stream_fromSpliterator(v)
  /**/          inline def fromEnumeration[A] (inline v: java.util.Enumeration[A]): Stream[A]             = new z.x.Java.Stream_fromEnumeration(v)
  /**/          inline def fromIterable[A]    (inline v: java.lang.Iterable[A])   : Stream[A]             = z.x.Java.Stream_fromIterable(v)
  /**/          inline def fromProduct        (inline v: Product)                 : Stream[(String,Any)]  = new z.x.Scala.Stream_fromProduct(v)
  /**/          inline def fromIterableOnce[A]
                                       (inline v:scala.collection.IterableOnce[A]): Stream[A]             = z.x.Scala.Stream_fromIterableOnce[A](v)
  /**/                 def unapplySeq[A](v: Stream[A])                            : Option[Seq[A]]        = Some(v.toSeq)
  @tn("getVoid")inline def void[A]                                                : Stream[A]             = ZZ.VoidStream[A]
  implicit      inline def implicitRequest       [A](v:VOID)                      : Stream[A]             = void
  implicit      inline def implicitRequest       [A](v: EMPTY)                    : Stream[A] & Able.Size = void.cast[Stream[A] & Able.Size]
  implicit      inline def implicitFromAbleStream[A](inline v:Able.Stream[A])     : Stream[A]             = v.stream

  /**/   given z_CanEqualStream[A,B] (using CanEqual[A,B]): CanEqual[Stream[A],Stream[B]] = CanEqual.derived
  inline given z_Doc[A   ](using inline v: Any.Def.Tag[A]): Any.Def.Doc[Stream[A]]   = ZZ.streamDoc(v)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def _build  = stream._Build;   type _build     = stream._Build
  transparent inline def _use    = stream._Use;     type _use       = stream._Use
  transparent inline def Flow    = stream.Flow;     type Flow[A]    = stream.Flow[A]
  transparent inline def Preview = stream.Preview;  type Preview[A] = stream.Preview[A]
  transparent inline def Custom  = stream.Custom

class z_StreamDefaults:
  implicit inline def implicitFromRange       [A](inline v: Range[A])(using Able.Sequence[A])   : Stream[A] = v.stream
  implicit inline def implicitFromIterable    [A](inline v: java.lang.Iterable[A])              : Stream[A] = z.x.Java.Stream_fromIterable(v)
  implicit inline def implicitFromIterator    [A](inline v: java.util.Iterator[A])              : Stream[A] = new z.x.Java.Stream_fromIterator(v)
  implicit inline def implicitFromIterableOnce[A](inline v: scala.collection.IterableOnce[A])   : Stream[A] = z.x.Scala.Stream_fromIterableOnce[A](v)
  implicit inline def implicitFromArray       [A](inline v: Array[A])                           : Stream[A] = v.stream
  implicit inline def implicitFromOpt         [A](inline v: Opt[A])                             : Stream[A] = {val o=v; o.stream }
  implicit inline def implicitFromResult      [A](inline v: Result[A])                          : Stream[A] = {val o=v; o.stream }
  implicit inline def implicitFromTupleOfFew  [A](inline v: (A,A)|(A,A,A)|(A,A,A,A)|(A,A,A,A,A)): Stream[A] = stream.z.util.tupleOfFewMacro(v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Stream -> ### Value Stream

      Read about Stream in the [Guide](../../../Guide/Features/Stream.html).

      Stream has just one method to be implemented, but it has large attached libraries for:
        - [building stream pipeline](stream/_Build.html)
        - [using stream data](stream/_Use.html)

@def fromIterator     -> Explicit constructor from Iterator     \n\n Note: There is also global implicit conversion from `Iterator` to `Stream`
@def fromSpliterator  -> Constructor from Spliterator
@def fromEnumeration  -> Constructor from Enumeration
@def fromIterable     -> Explicit constructor from Iterable     \n\n Note: There is also global implicit conversion from `Iterable` to `Stream`
@def fromIterableOnce -> Explicit constructor from IterableOnce \n\n Note: There is also global implicit conversion from `IterableOnce` to `Stream`
@def fromProduct      -> Constructor from Product

@object Stream -> ### Value Stream Companion

@def readOpt  -> Read next option

      Optionally returns next element or empty option

      If empty option is returned, the stream is considered exhasted and should be discarded

      This is the only real method of stream interface, the rest of functionality is provided with extension methods for:

        - [building](stream/_Build.html) stream pipeline
        - [using](stream/_Use.html) stream data


@def apply            -> Single element consructor
@def apply            -> Double element consructor
@def apply            -> Multi element consructor
@def void             -> Get void instance
*/
