package scalqa; package `val`; import stream.*; import language.implicitConversions

trait Stream[+A]:
  @tn("read_Opt") def read_? : Opt[A]

object Stream extends zStreamDefaults with _Build with _Use:
  /**/          inline def apply[A](inline v: A)                                  : ~[A]             = z.x.VarArg.Stream_ofOne[A](v)
  /**/          inline def apply[A](inline v1: A, inline v2: A)                   : ~[A]             = z.x.VarArg.Stream_ofTwo[A](v1, v2)
  /**/                 def apply[A](v1: A, v2: A, v3: A, vs: A*)                  : ~[A]             = if (vs.isEmpty) z.x.VarArg.Stream_ofThree[A](v1,v2,v3) else z.x.VarArg.Stream_ofMany[A](v1,v2,v3,vs)
  /**/          inline def fromIterator[A]    (inline v: java.util.Iterator[A])   : ~[A]             = new z.x.Java.Stream_fromIterator(v)
  /**/          inline def fromSpliterator[A] (inline v: java.util.Spliterator[A]): ~[A]             = new z.x.Java.Stream_fromSpliterator(v)
  /**/          inline def fromEnumeration[A] (inline v: java.util.Enumeration[A]): ~[A]             = new z.x.Java.Stream_fromEnumeration(v)
  /**/          inline def fromIterable[A]    (inline v: java.lang.Iterable[A])   : ~[A]             = z.x.Java.Stream_fromIterable(v)
  /**/          inline def fromProduct        (inline v: Product)                 : ~[(String,Any)]  = new z.x.Scala.Stream_fromProduct(v)
  /**/          inline def fromIterableOnce[A]
                                       (inline v:scala.collection.IterableOnce[A]): ~[A]             = z.x.Scala.Stream_fromIterableOnce[A](v)
  /**/                 def unapplySeq[A](v: ~[A])                                 : Option[Seq[A]]   = Some(v.toSeq)
  @tn("getVoid")inline def void[A]                                                : ~[A]             = ZZ.VoidStream[A]
  implicit      inline def implicitRequest       [A](v: \/)                       : ~[A]             = void
  implicit      inline def implicitRequest       [A](v: EMPTY)                    : ~[A] & Able.Size = void.cast[~[A] & Able.Size]
  implicit      inline def implicitFromAbleStream[A](inline v:Able.~[A])          : ~[A]             = v.~

  /**/   given zzCanEqualStream[A,B] (using CanEqual[A,B]): CanEqual[~[A],~[B]] = CanEqual.derived
  inline given zzDoc[A   ](using inline v: Any.Def.Tag[A]): Any.Def.Doc[~[A]]   = ZZ.streamDoc(v)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def _build  = stream._Build;   type _build     = stream._Build
  transparent inline def _use    = stream._Use;     type _use       = stream._Use
  transparent inline def Flow    = stream.Flow;     type Flow[A]    = stream.Flow[A]
  transparent inline def Preview = stream.Preview;  type Preview[A] = stream.Preview[A]
  transparent inline def Custom  = stream.Custom

class zStreamDefaults:
  implicit inline def implicitFromRange       [A](inline v: Range[A])(using Able.Sequence[A])   : ~[A] = v.~
  implicit inline def implicitFromIterable    [A](inline v: java.lang.Iterable[A])              : ~[A] = z.x.Java.Stream_fromIterable(v)
  implicit inline def implicitFromIterator    [A](inline v: java.util.Iterator[A])              : ~[A] = new z.x.Java.Stream_fromIterator(v)
  implicit inline def implicitFromIterableOnce[A](inline v: scala.collection.IterableOnce[A])   : ~[A] = z.x.Scala.Stream_fromIterableOnce[A](v)
  implicit inline def implicitFromArray       [A](inline v: Array[A])                           : ~[A] = v.~
  implicit inline def implicitFromOpt         [A](inline v: Opt[A])                             : ~[A] = {val o=v; o.~ }
  implicit inline def implicitFromResult      [A](inline v: Result[A])                          : ~[A] = {val o=v; o.~ }
  implicit inline def implicitFromTupleOfFew  [A](inline v: (A,A)|(A,A,A)|(A,A,A,A)|(A,A,A,A,A)): ~[A] = stream.z.util.tupleOfFewMacro(v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Stream -> ### ~ is Value Stream

      Read about ~ in the [Guide](../../../guide/features/Stream.html).

      Note. Stream companion object is [[scalqa.val.stream.Stream$ Val.~]], but when called without prefix it is [[scalqa.val.stream.Stream$ ~~]] (double tilde).

      Stream has just one method to be implemented, but it has large attached libraries for:
        - [building stream pipeline](stream/_Build.html)
        - [using stream data](stream/_Use.html)

      By Scalqa convention, method names, which return [[~]], are ended with '_~'

      ```
      "ABCD".char_~.TP  // Prints ~(A, B, C, D)
      ```

@def fromIterator     -> Explicit constructor from Iterator     \n\n Note: There is also global implicit conversion from `Iterator` to `Stream`
@def fromSpliterator  -> Constructor from Spliterator
@def fromEnumeration  -> Constructor from Enumeration
@def fromIterable     -> Explicit constructor from Iterable     \n\n Note: There is also global implicit conversion from `Iterable` to `Stream`
@def fromIterableOnce -> Explicit constructor from IterableOnce \n\n Note: There is also global implicit conversion from `IterableOnce` to `Stream`
@def fromProduct      -> Constructor from Product

@object Stream -> ### Value Stream Companion

      Note. Stream companion object is [[scalqa.val.stream.Stream$ Val.~]], but when called without prefix it is [[scalqa.val.stream.Stream$ ~~]] (double tilde).

@def read_?  -> Read next option

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
