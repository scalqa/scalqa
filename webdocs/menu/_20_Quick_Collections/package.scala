/**
 *  Scalqa introduces a basic collections framework with following main entities:
 *
 *  [[scalqa.Any.Collection Collection]]
 *  {{{
 *    trait Any.Collection[+T] {
 *
 *     def size: Int
 *
 *     def all : ~[T]
 *
 *    }
 *  }}}
 *
 *   [[scalqa.Idx Indexed Collection]]
 *  {{{
 *    trait Idx[+T] extends Any.Collection[T]{
 *
 *     def apply(i: Int): T
 *
 *    }
 *  }}}
 *
 *   [[scalqa.Lookup Lookup Collection]]
 *  {{{
 *    trait Lookup[K,+T] extends Any.Collection[T] {
 *
 *     def getOpt(k: K): Opt[T]
 *
 *     def allPairs    : ~[(K,T)]
 *
 *    }
 * }}}
 *
 *  Method [[scalqa.Idx._Trait!.all `all`]] returns [[scalqa.Stream.Interface Stream.Interface]], which is essentially a [[scalqa.Stream Stream]] of all elements
 *
 *  [[scalqa.Stream Stream]] is the ONLY class responsible for functional processing of all collections, therefore its [[Stream_Performance performance is paramount]]
 *
 *  Collection interfaces also have [[Mutable mutable]] and [[Mutable immutable]] extensions
 */
package object Quick_Collections { val sort_20 = () }
