package scalqa; package `val`; import stream.*; import language.implicitConversions

trait Stream[+A]:
  @tn("read_Opt") def read_? : Opt[A]

object Stream extends z.util._default with _Build with _Use:
  type AnyType[A] = Stream[A] | RawType[A]
  type RawType[A] = lang.boolean.g.Stream[A & Boolean.Raw] | lang.byte.g.Stream[A & Byte.Raw] | lang.char .g.Stream[A & Char.Raw]  | lang.short .g.Stream[A & Short.Raw]
                  | lang.int    .g.Stream[A & Int.Raw]     | lang.long.g.Stream[A & Long.Raw] | lang.float.g.Stream[A & Float.Raw] | lang.double.g.Stream[A & Double.Raw]

  // ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  /**/           inline def apply[A](inline v: A)                 : ~[A]             = z.a.VarArg.Stream_ofOne[A](v)
  /**/           inline def apply[A](inline v1: A, inline v2: A)  : ~[A]             = z.a.VarArg.Stream_ofTwo[A](v1, v2)
  /**/                  def apply[A](v1: A, v2: A, v3: A, vs: A*) : ~[A]             = if (vs.isEmpty) z.a.VarArg.Stream_ofThree[A](v1,v2,v3) else z.a.VarArg.Stream_ofMany[A](v1,v2,v3,vs)
  @tn("getVoid") inline def void[A]                               : ~[A]             = ZZ.voidStream
  /**/                  def unapplySeq[A](v: ~[A])                : Option[Seq[A]]   = Some(v.toSeq)

  implicit       inline def implicitFromAbleStream[A](inline v:Able.~[A]): ~[A]      = v.~

  given givenCanEqualStream[A,B](using CanEqual[A,B]): CanEqual[~[A],~[B]] = CanEqual.derived
  given givenDocDef[A :Given.DocDef]                  : Given.DocDef[~[A]]  = z.util.DocDef()

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def _build  = stream._Build;   type _build     = stream._Build
  transparent inline def _use    = stream._Use;     type _use       = stream._Use
  transparent inline def Flow    = stream.Flow;     type Flow[A]    = stream.Flow[A]
  transparent inline def Preview = stream.Preview;  type Preview[A] = stream.Preview[A]
  transparent inline def Custom  = stream.Custom

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
        - [building](stream/_Build.html) stream pipeline
        - [using](stream/_Use.html) stream data

      By Scalqa convention, method names, which return [[~]], are ended with '_~'

      ```
      val s: ~[Char] = "ABCD".char_~

      s.TP  // Prints ~(A, B, C, D)
      ```


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
