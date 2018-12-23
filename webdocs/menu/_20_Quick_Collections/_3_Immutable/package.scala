package Quick_Collections

/**
 *  `[[scalqa.Idx.I Idx.I]]` is an Immutable Indexed Collection trait with following implementations:
 *   [[scalqa.Ints Ints]], [[scalqa.Longs Longs]], [[scalqa.Shorts Shorts]], [[scalqa.Doubles Doubles]], [[scalqa.Floats Floats]],
 *   [[scalqa.Bytes Bytes]], [[scalqa.Chars Chars]], [[scalqa.Booleans Booleans]], and [[scalqa.Refs Refs]]
 *
 *  All are implemented as AnyVal Array wrap with no mutation methods, so the collections memory footprint is just an Array itself
 *
 *  Easiest way to create an immutable collection is from a Stream:
 *
 *  {{{
 *    val c : Chars        = ('a' <> 'z').all.toRaw[Chars]
 *
 *    val i : Ints         = (1 <> 10000).all.toRaw[Ints]
 *
 *    val r : Refs[String] = (1 <> 10000).map("string" + _).all.to[Refs]
 *  }}}
 *
 *  Generally [[scalqa.Idx.I Idx.I]] grow performance correlates with the performance of Array itself,
 *  and it is drastically different when building [[Growing_Small small]] and [[Growing_Large large]] collections
 */
package object Immutable { val sort_3 = () }
