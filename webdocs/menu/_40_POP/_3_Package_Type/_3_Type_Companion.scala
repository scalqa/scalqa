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
 *  Here are code fragments of how Ordering is defined
 *
 *  {{{
 *    package scalqa {
 *
 *       package object scalqa {
 *         type Ordering[-A] = Ordering._Trait[A]  // The name to be used
 *       }
 *
 *       package Ordering {
 *
 *         trait _Trait[-A] {                    // Type definition
 *           // Methods
 *         }
 *
 *         object _Trait {                       // Implicit definitions
 *
 *
 *           implicit def zzLibrary[A](v: Ordering[A]) = new _library[A](v)
 *           implicit def zzMake[A](v: \/) = A.Void.asInstanceOf[Ordering[A]]
 *           implicit def zzMake[A](v: java.util.Comparator[A]): Ordering[A] = make(v)
 *           // More methods
 *         }
 *
 *         package object Ordering {              // Static definitions
 *
 *           def make[A](implicit o: Ordering[A]): Ordering[A] = o
 *           def from[A, B](f: A => B)(implicit o: Ordering[B]): Ordering[A] = o.asMappedView(f)
 *         }
 *       }
 *     }
 *  }}}
 */
class Type_Companion { val sort_3 = () }
