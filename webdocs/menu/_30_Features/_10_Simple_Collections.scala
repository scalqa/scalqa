package Features

/**
 *   `Collections Framework`
 *
 *    There are two base collection traits
 *
 *    - [[scalqa.Idx Idx]], which is 'Indexed Collection'
 *    - [[scalqa.Lookup Lookup]], which is 'Lookup Collection'
 *
 *    These collections are simplified to a point, where they can be routinely implemented by business objects
 *
 *    `[[scalqa.Idx Idx]]` has just 3 methods:
 *
 *    {{{
 *       def apply(i: Int): ELEMENT
 *
 *       def size         : Int
 *
 *       def all          : ~[ELEMENT]
 *     }}}
 *
 *     Method `all` returns [[scalqa.Stream.Interface Stream.Interface]], which is essentially a [[scalqa.Stream Stream]] of [[scalqa.Idx Idx]] elements.
 *     [[scalqa.Stream Stream]] is the only object to functionally process collection elements
 *
 *    [[scalqa.Idx Idx]] is a read only trait, but it has several flavors:
 *
 *       - `[[scalqa.Idx.M   Idx.M]]`   - which is Mutable Indexed Collection
 *       - `[[scalqa.Idx.O   Idx.O]]`   - which is Observable Indexed Collection
 *       - `[[scalqa.Idx.OM  Idx.OM]]`  - which is Observable and Mutable Indexed Collection
 *
 *     =Mutable=
 *
 *     Mutable implementations of [[scalqa.Idx Idx]] are based on [[scalqa.Idx.Array.Buffer Idx.Array.Buffer]], which is specialized for primitives
 *     {{{
 *         val sBuf : Idx.M[String] = NEW   // Creates new Array.Buffer.Refs
 *         val iBuf : Idx.M[Int]    = NEW   // Creates new Array.Buffer.Ints
 *     }}}
 *
 *      =Immutable=
 *
 *     Immutable implementations of [[scalqa.Idx.I Idx.I]] are based on unmodifiable array wrapper.
 *     These are: [[scalqa.Ints Ints]], [[scalqa.Longs Longs]], [[scalqa.Shorts Shorts]], [[scalqa.Doubles Doubles]], [[scalqa.Floats Floats]],
 *     [[scalqa.Bytes Bytes]], [[scalqa.Chars Chars]], [[scalqa.Booleans Booleans]], and [[scalqa.Refs Refs]]
 *
 *    These implementations are done as AnyVal, so their memory footprint is just an Array itself
 *
 *    {{{
 *      val c : Chars        = ('a' <> 'z').all.toRaw[Chars]
 *
 *      val i : Ints         = (1 <> 10000).all.toRaw[Ints]
 *
 *      val r : Refs[String] = (1 <> 10000).map("string" + _).all.to[Refs]
 *    }}}
 *
 *    =Observable=
 *
 *    Observable collections are mainly for the benefits of GUI controls. They allow to keep track of changes:
 *
 *    {{{
 *     val v: Idx.OM[Char] = NEW
 *
 *     v.onChange(_.all.lp) // On change, print change
 *
 *     v addAll 'a' <> 'l'  // Prints: ~(Add{range=0 <>> 12,items=[a,b,c,d,e,f,g,h,i,j,k,l]})
 *
 *     v(0) = 'W'           // Prints: ~(Remove{index=0,item=a}, Add{index=0,item=W})
 *
 *     v removeAt 5 <> 10   // Prints: ~(Remove{range=5 <>> 11,items=[f,g,h,i,j,k]})
 *
 *     v.all.lp             // Prints: ~(W, b, c, d, e, l, m)
 *
 *     v.sortReversed       // Prints ~(Reposition{range=0 <>> 7,indexes=[(0,6)(1,5)(2,4)(4,2)(5,1)(6,0)]})
 *
 *     v.all.lp             // Prints: ~(m, l, e, d, c, b, W)
 *    }}}
 */
class Simple_Collections { val sort_10 = () }
