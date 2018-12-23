package POP

/**
 *  Package type is a class or a trait developed within a specially designated package of the same name
 *
 *  It is defined as class '_Class' or trait '_Trait' within the package and then aliased to the real name in the parent package
 *
 *  Here is an example how [[scalqa.Idx]] is defined
 *
 *  {{{
 *    package scalqa {
 *
 *       package object scalqa {
 *         type Idx[+A] = Idx._Trait[A]                          // The name to be used
 *       }
 *
 *       package Idx {
 *
 *         trait _Trait[+A] extends Any with Any.Collection[A] { // Type definition
 *
 *            def apply(i: Int): A
 *
 *            def all: ~[A] = Z.stream(this)
 *         }
 *      }
 *  }}}
 *
 *
 *  Complex package type can be assembled from many [[Type_Trait type traits]], nevertheless from usage prospective it is still a single integral object
 *
 *  A package type can also have a [[Type_Library Type Library]] attached
 *
 *  Naturally, `package object` becomes a [[Type_Companion companion]] for [[Package_Type package type]]
 *
 */
package object Package_Type { val sort_3 = () }
