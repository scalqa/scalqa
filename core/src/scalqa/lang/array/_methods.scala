package scalqa; package lang; package array; import language.implicitConversions

import any.{ Specialized as S }

transparent trait _methods:

  extension[A](inline x:Array[A])
    @tn("stream")     inline def ~                                      (using inline A: S[A]) : A.~ & Able.Size = z.Stream(x)
    @tn("stream")     inline def ~(inline sz:Int)                       (using inline A: S[A]) : A.~ & Able.Size = z.Stream(x,sz)

    @tn("pack")       inline def ><                                     (using inline A: S[A]) : A.><            = z.pack(x)

    /**/              inline def copyTo(a:Array[A])                                            : Unit            = {val v=x; val sz= v.length min  a.length;        v.copyTo(a,0,  0,sz)}
    /**/              inline def copyTo(a:Array[A], pos: Int)                                  : Unit            = {val v=x; val sz= v.length min (a.length - pos); v.copyTo(a,pos,0,sz)}
    /**/              inline def copyTo(inline a:Array[A], inline pos:Int,
                                                           inline from:Int, inline size:Int)   : Unit            = System.arraycopy(x,from,a,pos,size)
    /**/              inline def newArray(inline size: Int)             (using inline A: S[A]) : A.Array         = z.newArray(x,size)
    /**/              inline def contains(inline v: A)                  (using inline A: S[A]) : Boolean         = z.contains(x,v)

    @tn("_join")      inline def + ( inline v: A)                       (using inline A: S[A]) : A.Array         = z.join(x,v)
    @tn("_joinAll")   inline def ++( inline v: ~[A])                    (using inline A: S[A]) : A.Array         = z.joinAll(x,v)
    @tn("_joinAt")    inline def +@( inline i: Int, inline v: A)        (using inline A: S[A]) : A.Array         = z.joinAt(x,i,v)
    @tn("_joinAllAt") inline def ++@(inline i: Int, inline v: ~[A])     (using inline A: S[A]) : A.Array         = z.joinAllAt(x,i,v)
    /**/              inline def copySize(inline size: Int)             (using inline A: S[A]) : A.Array         = z.copySize(x,size)

    /**/              inline def join(inline v: A)                      (using inline A: S[A]) : A.Array         = z.join(x,v)
    /**/              inline def joinAll(inline v: ~[A])                (using inline A: S[A]) : A.Array         = z.joinAll(x,v)
    /**/              inline def joinAt(inline i:Int, inline v: A)      (using inline A: S[A]) : A.Array         = z.joinAt(x,i,v)
    /**/              inline def joinAllAt(inline i:Int,inline v: ~[A]) (using inline A: S[A]) : A.Array         = z.joinAllAt(x,i,v)

    /**/              inline def fill(inline v: A)                      (using inline A: S[A]) : Unit            = {val a=x; z.fill(a,0,a.length,v)}
    @tn("fill_Range") inline def fill_<>(inline start:Int,inline size:Int,inline v:A)
                                                                        (using inline A: S[A]) : Unit            = z.fill(x,start,size,v)
    @tn("fill_Range") inline def fill_<>(r: Int.<>, inline v: A)        (using inline A: S[A]) : Unit            = z.fill(x,r.start,r.size,v)

    @tn("take_Range") inline def take_<>(inline start:Int,inline size:Int)(using inline A:S[A]): A.Array         = z.range.take(x,start,size)
    @tn("take_Range") inline def take_<>(r: Int.<>)                     (using inline A: S[A]) : A.Array         = z.range.take(x,r.start,r.size)
    @tn("drop_Range") inline def drop_<>(inline start:Int,inline size:Int)(using inline A:S[A]): A.Array         = z.range.drop(x,start,size)
    @tn("drop_Range") inline def drop_<>(r: Int.<>)                     (using inline A: S[A]) : A.Array         = z.range.drop(x,r.start,r.size)

    /**/              inline def sort       (using inline c:Ordering[A])(using inline A: S[A]) : Unit            = z.sort(x,c)
    @tn("sort_Range") inline def sort_<>(inline start:Int, inline size: Int)
                                            (using inline c:Ordering[A])(using inline A: S[A]) : Unit            = z.sortRange(x,start,size,c)
    @tn("sort_Range") inline def sort_<>(r :Int.<>)
                                            (using inline c:Ordering[A])(using inline A: S[A]) : Unit            = z.sortRange(x,r.start,r.size,c)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _methods -> ### Array Extension Methods

    Extension methods are universaly avaialble for all Array types.

    The methods are heavily overloaded to work efficiently when array type is explicit, but they fall back on slower inmpementations when array is generic.

@def ~  -> Elements stream

    Returns stream of array elements

@def ~  -> Sized stream

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

@def drop_<> -> Drop range

    Copies base array to a new array without elements of specified range

@def drop_<> -> Drop range

    Copies base array to a new array without elements of specified range

@def take_<> -> Take range

    Copies given range of elements a new array

@def take_<> -> Take range

    Copies given range of elements a new array

@def fill -> Fill value

    Assigns given value to all base array positions

@def fill_<> -> Fill range with value

    Assigns given value to base array positions within given range

@def fill_<> -> Fill range with value

    Assigns given value to base array positions within given range

@def sort -> Sort array

    Sorts array elements

@def sort_<> -> Sort array range

    Sorts array elements within given range

@def sort_<> -> Sort array range

    Sorts array elements within given range

*/