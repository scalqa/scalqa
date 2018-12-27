package POP.Package_Type

/**
 *  'Companion objects' is a Scala language are designed to keep:
 *
 *      - type static definitions
 *      - implicit conversions within type's scope
 *
 *  Within [[Package_Type package type]] these roles are split:
 *
 *      - `package object` logically becomes type companion with all static definitions
 *      - implicit conversions will remain in the real companion object with unusable name `_Class` or `_Trait`
 *
 *  Here are code fragments of how [[scalqa.Pro Pro]] (property) is defined
 *
 *  {{{
 *    package scalqa {
 *
 *      package object scalqa {
 *
 *        type Pro[+A] = Pro._Trait[A]           // The name to be used
 *
 *      }
 *
 *      package Pro {
 *
 *        trait _Trait[@specialized(DATA) +A] {  // Type definition
 *
 *          def apply(): A
 *
 *        }
 *
 *        object _Trait {                        // Implicit definitions
 *
 *          implicit def zzFunction0[A](v: Pro[A]): () => A = () => v()
 *
 *          implicit def zzLibrary[A](v: Pro[A]) = new _library._Class(v)
 *
 *        }
 *      }
 *      package object Pro {                     // Static definitions
 *
 *        def make[A](source: => A): Pro[A] = new Z.A.Sourced(source)
 *
 *      }
 *    }
 *  }}}
 */
class Type_Companion { val sort_3 = () }
