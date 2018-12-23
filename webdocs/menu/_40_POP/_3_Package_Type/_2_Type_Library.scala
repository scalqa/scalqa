package POP.Package_Type

/**
 *  [[Type_Library Type library]] extends a [[Package_Type package type]] with methods, which are virtually attached and can be called directly on every instance of the type
 *  {{{
 *    12.allUp  // Creates a Stream of Ints from 12 to Max
 *
 *    // 'allUp' is not an Int method, but available thanks to Custom.Int._library
 *  }}}
 *
 *  Note. This feature is widely spread in Scala, Scalqa just formalizes its usage
 *
 *  Type library must be defined under the name '_library'
 *
 *  `Example`
 *
 *   [[scalqa.Idx]] has just 3 core methods, but there is another 20 methods available to developers through the [[scalqa.Idx._library library]]
 *
 *  There are 2 advantages:
 *
 *    - [[scalqa.Idx Idx]] can be implemented by application classes and this will not clog their name space
 *    - [[scalqa.Idx._library Library]] can afford to have much more methods, than the host type could ever justify to hold directly
 *
 *
 *  Here are code fragments of how [[scalqa.Idx._library Idx library]] is defined
 *
 *  {{{
 *    package scalqa {
 *
 *       package object scalqa {
 *         type Idx[+A] = Idx._Trait[A]                             // The name to be used
 *       }
 *
 *      package Idx {
 *
 *        trait _Trait[+A] extends Any with Any.Collection[A] {     // Type definition
 *            // Methods
 *        }
 *
 *        object _Trait {
 *
 *           implicit def zzLibrary[A](v: Idx[A]) = new _library(v) // Attaching library
 *        }
 *
 *        class _library[A] (val This: Idx[A]) extends AnyVal{      // Library definition
 *           // Methods
 *        }
 *      }
 *  }}}
 */
class Type_Library { val sort_2 = () }
