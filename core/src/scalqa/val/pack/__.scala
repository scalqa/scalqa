package scalqa; package `val`; import pack.*; import language.implicitConversions

import Shape.OfPack.*

abstract class Pack[A] extends Idx[A]:
  type THIS_TYPE <: Pack[A]
  /**/                     def join (v: A)                                        : THIS_TYPE
  /**/                     def joinAll(v: ~[A])                                   : THIS_TYPE
  /**/                     def joinAt(i: Int, v: A)                               : THIS_TYPE
  /**/                     def joinAllAt(i: Int, v: ~[A])                         : THIS_TYPE
  @tn("_join")      inline def + (inline v: A)                                    : THIS_TYPE  = join(v)
  @tn("_joinAll")   inline def ++(inline v: ~[A])                                 : THIS_TYPE  = joinAll(v)
  @tn("_joinAt")    inline def +@ (inline i: Int, inline v: A)                    : THIS_TYPE  = joinAt(i,v)
  @tn("_joinAllAt") inline def ++@(inline i: Int, inline v: ~[A])                 : THIS_TYPE  = joinAllAt(i,v)
  // -------------------------
  /**/                     def head                                               : A          = apply(0)
  @tn("head_Opt")          def head_?                                             : Opt[A]     = if(size==0) \/ else apply(0)
  /**/                     def tail                                               : ><[A]      = if(size<=1) \/ else new z.Tail[A](this,1)
  // -------------------------
  /**/              inline def takeFirst(cnt: Int)                                : THIS_TYPE  = take_<>(0,cnt)
  /**/              inline def takeLast (cnt: Int)                                : THIS_TYPE  = take_<>(cnt,size - cnt)
  @tn("take_Range")        def take_<>(from: Int, size: Int)                      : THIS_TYPE
  @tn("take_Range") inline def take_<>(r: Int.<>)                                 : THIS_TYPE  = take_<>(r.start,r.size)
  // -------------------------
  /**/              inline def dropFirst(cnt: Int)                                : THIS_TYPE  = take_<>(cnt,size - cnt)
  /**/              inline def dropLast (cnt: Int)                                : THIS_TYPE  = take_<>(0,size - cnt)
  @tn("drop_Range")        def drop_<>(from: Int, size: Int)                      : THIS_TYPE
  @tn("drop_Range") inline def drop_<>(r: Int.<>)                                 : THIS_TYPE  = take_<>(r.start,r.size)
  /**/                     def toBuffer                                           : Buffer[A]
  /**/              inline def raw[PACK<:Raw[A]] (using inline s:Tag.Raw[A,PACK]) : PACK       = z.raw(this,s)
  /**/                     def compact                                            : this.type

object Pack:
  /**/                 def apply[A](v: A)                        : ><[A] = z.Few.Pack_ofOne(v)
  /**/                 def apply[A](v1: A, v2: A)                : ><[A] = z.Few.Pack_ofTwo(v1, v2)
  /**/                 def apply[A](v1: A, v2: A, v3: A, vs: A*) : ><[A] = if (vs.isEmpty) z.Few.Pack_ofThree(v1, v2, v3) else z.ArrayPack(v1, v2, v3, vs)
  @tn("getVoid")inline def void[A]                               : ><[A] = ZZ.voidPack[A]
  implicit      inline def xxRequest[A](inline v: \/)            : ><[A] = void[A]
  implicit      inline def xxStream [A](inline v: ~[A])          : ><[A] = v.><

  private[scalqa]      def fromArray[A](a: Array[Ref], sz: Int)  : ><[A] = new z.ArrayPack(a.copySize(sz),sz)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Pack -> ### List for Processing

   [[scalqa.val.Pack Pack]] is the most ubiquitous immutable collection, like scala.List

   Unlike List, [[scalqa.val.Pack Pack]] is mostly backed by Array and can be specialized

   Usually [[scalqa.val.Pack Pack]] has smaller memory footprint and in most cases is faster to manipulate data

@def raw -> Specialize

   This operation will not compile for reference types

   Returns specialized List for undelying primitive type

   Note: If this instance is already specialized, it is returned as as

@def head -> First element

    Returns first elements or fails for empty Pack

    Use [[head_?]] for safer access

@def head_? -> First optional element

    Returns first elements or empty option for empty Pack

@def tail -> Pack without first element

    Note. The returned [[tail]] can be empty

@def takeFirst -> Head filter

    Creates a new Pack from current Pack, taking only given number of first elements

@def dropFirst -> Head reversed filter

    Creates a new Pack from current Pack, skipping given number of first elements

@def takeLast -> Tail filter

    Creates a new Pack from current Pack, taking only given number of last elements

@def dropLast -> Tail reversed filter

    Creates a new Pack from current Pack, skipping given number of last elements

@def take_<> -> Range filter

    Creates a new Pack from current Pack, taking only elements within given range

@def take_<> -> Range filter

    Creates a new Pack from current Pack, taking only elements within given range

@def drop_<> -> Range reversed filter

    Creates a new Pack from current Pack, skipping elements within given range

@def drop_<> -> Range reversed filter

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

@def toBuffer -> To Buffer

    Creates a [[scalqa.val.Buffer Buffer]] collection filled with Pack elements

    Both Buffer and Pack are mostly Array based, so the convertions between them are very efficient

@def compact -> Optimize storage

    Pack is mostly backed by Array. When created from an unknown size stream, Array within Pack can end up with larger capacity than required.
    Because most Packs are short lived, it is wastfull to copy by default this potentially big array to proper size, but operation [[compact]] does exactly this on reqest.

    So, when assigning Pack to a longer term variable, it might be usefull to run [[compact]] if memory is a concern

    ```
    val list = (1 <> 1_000_000).~.drop(_ % 100 == 0).><.compact
    ```

    Note. [[compact]] can be called multiple times, but will do anything only if Pack is not compacted

@def void  -> Get void instance

@def xxRequest -> General void instance request \n\n It is possible to use general request \/ to get void instance of this type, thanks to this implicit conversion.

*/
