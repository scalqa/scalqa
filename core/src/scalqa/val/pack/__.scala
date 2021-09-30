package scalqa; package `val`; import pack.*; import language.implicitConversions

abstract class Pack[A] private[scalqa]() extends Idx[A]:
  type THIS_TYPE <: Pack[A]
  /**/                     def join (v: A)                                 : THIS_TYPE
  /**/                     def joinAll(v: ~[A])                            : THIS_TYPE
  /**/                     def joinAt(i: Int, v: A)                        : THIS_TYPE
  /**/                     def joinAllAt(i: Int, v: ~[A])                  : THIS_TYPE
  @tn("join")       inline def + (inline v: A)                             : THIS_TYPE  = join(v)
  @tn("joinAll")    inline def ++(inline v: ~[A])                          : THIS_TYPE  = joinAll(v)
  @tn("join")       inline def +@ (inline i: Int, inline v: A)             : THIS_TYPE  = joinAt(i,v)
  @tn("joinAllAt")  inline def ++@(inline i: Int, inline v: ~[A])          : THIS_TYPE  = joinAllAt(i,v)
  // -------------------------
  /**/                     def head                                        : A          = apply(0)
  @tn("head_Opt")          def head_?                                      : Opt[A]     = if(size==0) \/ else apply(0)
  /**/                     def tail                                        : ><[A]      = if(size<=1) \/ else new z.Tail[A](this,1)
  // -------------------------
  /**/              inline def takeFirst(cnt: Int)                         : THIS_TYPE  = take_<>(0,cnt)
  /**/              inline def takeLast (cnt: Int)                         : THIS_TYPE  = take_<>(cnt,size - cnt)
  @tn("take_Range")        def take_<>(from: Int, size: Int)               : THIS_TYPE
  @tn("take_Range") inline def take_<>(r: Int.<>)                          : THIS_TYPE  = take_<>(r.start,r.size)
  // -------------------------
  /**/              inline def dropFirst(cnt: Int)                         : THIS_TYPE  = take_<>(cnt,size - cnt)
  /**/              inline def dropLast (cnt: Int)                         : THIS_TYPE  = take_<>(0,size - cnt)
  @tn("drop_Range")        def drop_<>(from: Int, size: Int)               : THIS_TYPE
  @tn("drop_Range") inline def drop_<>(r: Int.<>)                          : THIS_TYPE  = take_<>(r.start,r.size)
  /**/                     def toBuffer                                    : Buffer[A]
  /**/              inline def raw(using inline A:Specialized.Primitive[A]): A.><       = z.raw(this)
  @tn("compact")           def ><                                          : THIS_TYPE

object Pack:
  /**/                     def apply[A](v: A)                              : ><[A]      = z.Few.Pack_ofOne(v)
  /**/                     def apply[A](v1: A, v2: A)                      : ><[A]      = z.Few.Pack_ofTwo(v1, v2)
  /**/                     def apply[A](v1: A, v2: A, v3: A, vs: A*)       : ><[A]      = if (vs.isEmpty) z.Few.Pack_ofThree(v1, v2, v3) else z.ArrayPack(v1, v2, v3, vs)
  @tn("getVoid")    inline def void[A]                                     : ><[A]      = ZZ.Void[A]
  /**/              inline def fromArray[A](a: Array[AnyRef])              : ><[A]      = fromArray(a,a.length)
  /**/                     def fromArray[A](a: Array[AnyRef], sz: Int)     : ><[A]      = new z.ArrayPack(a.copySize(sz),sz)
  implicit          inline def implicitRequest[A](v: \/)                   : ><[A]      = void[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Pack -> ### >< is Value Pack

   [><](Pack.html) is the most ubiquitous immutable collection, like List in Scala

   Unlike List, [><](Pack.html) is mostly backed by an Array and can be specialized. It usually has smaller memory footprint and in most cases is faster to manipulate data.

@def raw -> Specialize

   This operation will not compile for reference types

   Returns specialized pack for undelying primitive type

   Note: If this instance is already specialized, it is returned as is

@def head -> First element

    Returns first elements or fails for empty ><

    Use [[head_?]] for safer access

@def head_? -> First optional element

    Returns first elements or empty option for empty ><

@def tail -> Pack without first element

    Note. The returned [[tail]] can be empty

@def takeFirst -> Head filter

    Creates a new >< from current ><, taking only given number of first elements

@def dropFirst -> Head reversed filter

    Creates a new >< from current ><, skipping given number of first elements

@def takeLast -> Tail filter

    Creates a new >< from current ><, taking only given number of last elements

@def dropLast -> Tail reversed filter

    Creates a new >< from current ><, skipping given number of last elements

@def take_<> -> Range filter

    Creates a new >< from current ><, taking only elements within given range

@def take_<> -> Range filter

    Creates a new >< from current ><, taking only elements within given range

@def drop_<> -> Range reversed filter

    Creates a new >< from current ><, skipping elements within given range

@def drop_<> -> Range reversed filter

    Creates a new >< from current ><, skipping elements within given range

@def join -> Join value

    Creates a new >< with given value appended to the end of current ><

@def + -> Alias for [[join]]

    Creates a new >< with given value appended to the end of current ><

@def joinAll -> Join stream

    Creates a new >< with given stream values appended to the end of current ><

@def ++ -> Alias for [[joinAll]]

    Creates a new >< with given stream values appended to the end of current ><

@def joinAt -> Join value at position

    Creates a new >< with given value inserted into current >< at given position

@def +@ -> Alias for [[joinAt]]

    Creates a new >< with given value inserted into current >< at given position

@def joinAllAt -> Join stream at position

    Creates a new >< with given stream values inserted into current >< at given position

@def ++@ -> Alias for [[joinAllAt]]

    Creates a new >< with given stream values inserted into current >< at given position

@def toBuffer -> Make Buffer

    Creates a [[scalqa.val.Buffer Buffer]] collection filled with >< elements

    Both Buffer and >< are mostly Array based, so the convertions between them are very efficient

@def >< -> Optimize storage

    Returns this.type

    Pack is mostly backed by Array. When created from an unknown size stream, Array within pack can end up with larger capacity than required.
    Because most Packs are short lived, it is wastfull to copy by default this potentially big array to proper size, but operation >< on >< type does exactly this on request.

    So, when assigning type >< to a longer term variable, it might be usefull to "double pack" if memory is a concern

    ```
    val pack = (1 <> 1_000_000).~.drop(_ % 100 == 0).><.><
    ```

    Note. [[><]] can be called multiple times, but will do anything only if type >< is not compacted

@def void  -> Get void instance

@def implicitRequest   -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

*/
