package scalqa; package `val`; import stream.*; import language.implicitConversions

trait Stream[+A]:
  @tn("read_Opt") def read_? : Opt[A]

object Stream extends z.util._default with _build with _use:
  type AnyType[A] = Stream[A] | RawType[A]
  type RawType[A] = lang.boolean.g.Stream[A & Raw.Boolean] | lang.byte.g.Stream[A & Raw.Byte] | lang.char .g.Stream[A & Raw.Char]  | lang.short .g.Stream[A & Raw.Short]
                  | lang.int    .g.Stream[A & Raw.Int]     | lang.long.g.Stream[A & Raw.Long] | lang.float.g.Stream[A & Raw.Float] | lang.double.g.Stream[A & Raw.Double]

  /**/           inline def apply[A](inline v: A)                 : ~[A]             = z.a.VarArg.Stream_ofOne[A](v)
  /**/           inline def apply[A](inline v1: A, inline v2: A)  : ~[A]             = z.a.VarArg.Stream_ofTwo[A](v1, v2)
  /**/                  def apply[A](v1: A, v2: A, v3: A, vs: A*) : ~[A]             = if (vs.isEmpty) z.a.VarArg.Stream_ofThree[A](v1,v2,v3) else z.a.VarArg.Stream_ofMany[A](v1,v2,v3,vs)
  @tn("getVoid") inline def void[A]                               : ~[A]             = ZZ.voidStream
  /**/                  def unapplySeq[A](v: ~[A])                : Option[Seq[A]]   = Some(v.toSeq)

  implicit       inline def implicitFromAbleStream[A](inline v:Able.~[A]): ~[A]      = v.~

  given givenCanEqualStream[A,B](using CanEqual[A,B]): CanEqual[~[A],~[B]] = CanEqual.derived
  given givenDocTag[A :Self.DocTag]                  : Self.DocTag[~[A]]  = z.util.DocTag()

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  inline def _build  = stream._build;   type _build     = stream._build
  inline def _use    = stream._use;     type _use       = stream._use
  inline def Flow    = stream.Flow;     type Flow[A]    = stream.Flow[A]
  inline def Preview = stream.Preview;  type Preview[A] = stream.Preview[A]
  /**/   val Custom  = stream.Custom

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Stream -> ### ~ is Value Stream

      Note. Stream companion object is [[scalqa.val.stream.Stream$ Val.~]], but when called without prefix it is [[scalqa.val.stream.Stream$ ~~]] (double tilde).

      Stream has just one method to be implemented, but it has large attached libraries for:
        - [building](stream/_build.html) stream pipeline
        - [using](stream/_use.html) stream data

      By Scalqa convention, method names, which return [[~]], are ended with '_~'

      ```
      val s: ~[Char] = "ABCD".char_~

      s.TP  // Prints ~(A, B, C, D)
      ```

      Read more in the [Guide](../../../guide/features/Stream.html).

@object Stream -> ### Value Stream Companion

      Note. Stream companion object is [[scalqa.val.stream.Stream$ Val.~]], but when called without prefix it is [[scalqa.val.stream.Stream$ ~~]] (double tilde).

@def read_?  -> Read next option

      Optionally returns next element or empty option

      If empty option is returned, the stream is considered exhasted and should be discarded

      This is the only real method of stream interface, the rest of functionality is provided with extension methods

@def apply            -> Single element consructor
@def apply            -> Double element consructor
@def apply            -> Multi element consructor
@def void             -> Get void instance
*/
