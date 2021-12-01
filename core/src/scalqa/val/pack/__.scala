package scalqa; package `val`; import pack.*; import language.implicitConversions

abstract class Pack[A] private[scalqa]() extends Idx[A]:
  type THIS_TYPE <: Pack[A]
  /**/                     def join (v: A)                                 : THIS_TYPE
  /**/                     def joinAll(v: Stream[A])                       : THIS_TYPE
  /**/                     def joinAt(i: Int, v: A)                        : THIS_TYPE
  /**/                     def joinAllAt(i: Int, v: Stream[A])             : THIS_TYPE
  @tn("join")       inline def + (inline v: A)                             : THIS_TYPE  = join(v)
  @tn("joinAll")    inline def ++(inline v: Stream[A])                     : THIS_TYPE  = joinAll(v)
  @tn("join")       inline def +@ (inline i: Int, inline v: A)             : THIS_TYPE  = joinAt(i,v)
  @tn("joinAllAt")  inline def ++@(inline i: Int, inline v: Stream[A])     : THIS_TYPE  = joinAllAt(i,v)
  // -------------------------
  /**/              inline def takeFirst(cnt: Int)                         : THIS_TYPE  = takeRange(0,cnt)
  /**/              inline def takeLast (cnt: Int)                         : THIS_TYPE  = takeRange(cnt,size - cnt)
  /**/                     def takeRange(from: Int, size: Int)             : THIS_TYPE
  /**/              inline def takeRange(r: Int.Range)                     : THIS_TYPE  = takeRange(r.start,r.size)
  // -------------------------
  /**/              inline def dropFirst(cnt: Int)                         : THIS_TYPE  = takeRange(cnt,size - cnt)
  /**/              inline def dropLast (cnt: Int)                         : THIS_TYPE  = takeRange(0,size - cnt)
  /**/                     def dropRange(from: Int, size: Int)             : THIS_TYPE
  /**/              inline def dropRange(r: Int.Range)                     : THIS_TYPE  = takeRange(r.start,r.size)
  /**/                     def toBuffer                                    : Buffer[A]
  /**/              inline def raw(using inline A:Specialized.Primitive[A]): A.Pack     = z.raw(this)
  /**/                     def pack                                        : THIS_TYPE
  /**/              inline def foreach[U](inline f: A=>U)                  : Unit       = z.foreach(this,f)
  /**/                     def z_foreach[U](f: A=>U)                       : Unit

object Pack:
  /**/                     def apply[A](v: A)                       : Pack[A]       = z.Few.Pack_ofOne(v)
  /**/                     def apply[A](v1: A, v2: A)               : Pack[A]       = z.Few.Pack_ofTwo(v1, v2)
  /**/                     def apply[A](v1: A, v2: A, v3: A, vs: A*): Pack[A]       = if (vs.isEmpty) z.Few.Pack_ofThree(v1, v2, v3) else z.ArrayPack(v1, v2, v3, vs)
  @tn("getVoid")    inline def void[A]                              : Pack[A]       = ZZ.Void[A]
  /**/              inline def fromArray[A](a: Array[AnyRef])       : Pack[A]       = fromArray(a,a.length)
  /**/                     def fromArray[A](a: Array[AnyRef],sz:Int): Pack[A]       = new z.ArrayPack(a.copySize(sz),sz)
  /**/                     def unapplySeq[A](v: Pack[A])            : Option[Seq[A]]= Some(v.toSeqView)
  implicit          inline def implicitRequest[A](v: \/)            : Pack[A]       = void[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Pack -> ### Value Pack

   [Pack](Pack.html) is the most ubiquitous immutable collection, like List in Scala

   Unlike List, [Pack](Pack.html) is mostly backed by an Array and can be specialized. It usually has smaller memory footprint and in most cases is faster to manipulate data.

@def foreach -> Process all elements

   Applies given function to each Pack element.

   This method is more eficient than Stream foreach.

@def raw -> Specialize

   This operation will not compile for reference types

   Returns specialized pack for undelying primitive type

   Note: If this instance is already specialized, it is returned as is

@def takeFirst -> Head filter

    Creates a new Pack from current Pack, taking only given number of first elements

@def dropFirst -> Head reversed filter

    Creates a new Pack from current Pack, skipping given number of first elements

@def takeLast -> Tail filter

    Creates a new Pack from current Pack, taking only given number of last elements

@def dropLast -> Tail reversed filter

    Creates a new Pack from current Pack, skipping given number of last elements

@def takeRange -> Range filter

    Creates a new Pack from current Pack, taking only elements within given range

@def takeRange -> Range filter

    Creates a new Pack from current Pack, taking only elements within given range

@def dropRange -> Range reversed filter

    Creates a new Pack from current Pack, skipping elements within given range

@def dropRange -> Range reversed filter

    Creates a new Pack from current Pack, skipping elements within given range

@def join -> Join value

    Creates a new Pack with given value appended to the end of current Pack

@def + -> Alias for [[join]]

    Creates a new Pack with given value appended to the end of current Pack

@def joinAll -> Join stream

    Creates a new Pack with given stream values appended to the end of current Pack

@def ++ -> Alias for [[joinAll]]

    Creates a new Pack with given stream values appended to the end of current Pack

@def joinAt -> Join value at position

    Creates a new Pack with given value inserted into current Pack at given position

@def +@ -> Alias for [[joinAt]]

    Creates a new Pack with given value inserted into current Pack at given position

@def joinAllAt -> Join stream at position

    Creates a new Pack with given stream values inserted into current Pack at given position

@def ++@ -> Alias for [[joinAllAt]]

    Creates a new Pack with given stream values inserted into current Pack at given position

@def toBuffer -> Make Buffer

    Creates a [[scalqa.val.Buffer Buffer]] collection filled with Pack elements

    Both Buffer and Pack are mostly Array based, so the convertions between them are very efficient

@def pack -> Optimize storage

    Returns this.type

    Pack is mostly backed by Array. When created from an unknown size stream, Array within pack can end up with larger capacity than required.
    Because most Packs are short lived, it is wastfull to copy by default this potentially big array to proper size, but operation "pack" on "Pack" type does exactly this on request.

    So, when assigning type Pack to a longer term variable, it might be usefull to "double pack" if memory is a concern

    ```
    val pack = (1 <> 1_000_000).stream.drop(_ % 100 == 0).pack.pack
    ```

    Note. [[pack]] can be called multiple times, but will do anything only if type Pack is not compacted

@def void  -> Get void instance

@def implicitRequest   -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

*/
