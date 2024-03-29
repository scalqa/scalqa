package scalqa; package lang; package array; import language.implicitConversions

import any.{ Specialized as S }

transparent trait _methods:

  extension[A](inline x:Array[A])
    inline def stream                                          (using inline s:S[A]) : s.Stream & Able.Size = z.Stream(x)
    inline def stream(inline sz:Int)                           (using inline s:S[A]) : s.Stream & Able.Size = z.Stream(x,sz)

    inline def pack                                       (using inline s:S[A]) : s.Pack               = z.pack(x)

    inline def copyTo(a:Array[A])                                               : Unit                 = {val v=x; val sz= v.length min  a.length;        v.copyTo(a,0,  0,sz)}
    inline def copyTo(a:Array[A], pos: Int)                                     : Unit                 = {val v=x; val sz= v.length min (a.length - pos); v.copyTo(a,pos,0,sz)}
    inline def copyTo(inline a:Array[A], inline pos:Int,
                                           inline from:Int, inline size:Int)    : Unit                 = System.arraycopy(x,from,a,pos,size)
    inline def newArray(inline size: Int)                 (using inline s:S[A]) : s.Array              = z.newArray(x,size)
    inline def contains(inline v: A)                      (using inline s:S[A]) : Boolean              = z.contains(x,v)

    inline def + ( inline v: A)                           (using inline s:S[A]) : s.Array              = z.join(x,v)
    inline def ++( inline v: Stream[A])                   (using inline s:S[A]) : s.Array              = z.joinAll(x,v)
    inline def +@( inline i: Int, inline v: A)            (using inline s:S[A]) : s.Array              = z.joinAt(x,i,v)
    inline def ++@(inline i: Int, inline v: Stream[A])    (using inline s:S[A]) : s.Array              = z.joinAllAt(x,i,v)
    inline def copySize(inline size: Int)                 (using inline s:S[A]) : s.Array              = z.copySize(x,size)

    inline def join(inline v: A)                          (using inline s:S[A]) : s.Array              = z.join(x,v)
    inline def joinAll(inline v: Stream[A])               (using inline s:S[A]) : s.Array              = z.joinAll(x,v)
    inline def joinAt(inline i:Int, inline v: A)          (using inline s:S[A]) : s.Array              = z.joinAt(x,i,v)
    inline def joinAllAt(inline i:Int,inline v: Stream[A])(using inline s:S[A]) : s.Array              = z.joinAllAt(x,i,v)

    inline def fill(inline v: A)                          (using inline s:S[A]) : Unit                 = {val a=x; z.fill(a,0,a.length,v)}
    inline def fillRange(inline start:Int,inline size:Int,inline v:A)
                                                          (using inline s:S[A]) : Unit                 = z.fill(x,start,size,v)
    inline def fillRange(r: Int.Range, inline v: A)       (using inline s:S[A]) : Unit                 = z.fill(x,r.start,r.size,v)

    inline def takeRange(inline start:Int,inline size:Int)(using inline s:S[A]) : s.Array              = z.range.take(x,start,size)
    inline def takeRange(r: Int.Range)                    (using inline s:S[A]) : s.Array              = z.range.take(x,r.start,r.size)
    inline def dropRange(inline start:Int,inline size:Int)(using inline s:S[A]) : s.Array              = z.range.drop(x,start,size)
    inline def dropRange(r: Int.Range)                    (using inline s:S[A]) : s.Array              = z.range.drop(x,r.start,r.size)

    inline def sort         (using inline c:Ordering[A])  (using inline s:S[A]) : Unit                 = z.sort(x,c)
    inline def sortRange(inline start:Int, inline size: Int)
                            (using inline c:Ordering[A])  (using inline s:S[A]) : Unit                 = z.sortRange(x,start,size,c)
    inline def sortRange(r :Int.Range)
                            (using inline c:Ordering[A])  (using inline s:S[A]) : Unit                 = z.sortRange(x,r.start,r.size,c)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _methods -> ### Array Extension Methods

    Extension methods are universaly avaialble for all Array types.

@def stream  -> Elements stream

    Returns stream of array elements

@def stream  -> Sized stream

    Returns stream of array elements limited to given size

@def + -> Shortcut to 'join'

    Copies base array to a new array with given element appended

@def join -> Join element

    Copies base array to a new array with given element appended

@def ++ -> Shortcut to 'joinAll'

    Copies base array to a new array with given stream of elements appended

@def joinAll -> Join multiple elements

    Copies base array to a new array with given stream of elements appended

@def +@ -> Shortcut to 'joinAt'

    Copies base array to a new array with given element inserted at given position

@def joinAt -> Join element at position

    Copies base array to a new array with given element inserted at given position

@def ++@ -> Shortcut to 'joinAllAt'

    Copies base array to a new array with given stream of elements inserted at given position

@def joinAllAt -> Join multiple elements at position

    Copies base array to a new array with given stream of elements inserted at given position

@def copyTo -> Copy to array

    Copies base array elements to given array

    Note. Efficient JVM System.arraycopy method is used

@def copyTo -> Copy to array

    Copies base array elements to given array, starting at given position

    Note. Efficient JVM System.arraycopy method is used

@def copyTo -> Copy to array

    Copies base array elements to given array, starting at given 'pos'

    'from' and 'size' specify base array range to be copied

    Note. Efficient JVM System.arraycopy method is used

@def newArray -> New Array

    Creates new empty array of the same type as base array, but with given size

@def copySize -> Copy with new size

    Creates new Array of specified size (can be larger or smaller), with appropriate elements copied from base array

@def contains -> Contains check

    Returns `true` if array contains equal value, `false - otherwise

@def dropRange -> Drop range

    Copies base array to a new array without elements of specified range

@def dropRange -> Drop range

    Copies base array to a new array without elements of specified range

@def takeRange -> Take range

    Copies given range of elements a new array

@def takeRange -> Take range

    Copies given range of elements a new array

@def fill -> Fill value

    Assigns given value to all base array positions

@def fillRange -> Fill range with value

    Assigns given value to base array positions within given range

@def fillRange -> Fill range with value

    Assigns given value to base array positions within given range

@def sort -> Sort array

    Sorts array elements

@def sortRange -> Sort array range

    Sorts array elements within given range

@def sortRange -> Sort array range

    Sorts array elements within given range

*/