package scalqa; package Pipe; package From

import scala.language.higherKinds

abstract class _Class[-CONTAINER[Any]] protected {

  def apply[A](c: CONTAINER[A]): Pipe[A]

}

object _Class {

  implicit val ScalaArray: From[scala.Array] = Z.ScalaArray

  implicit val TraversableOnce: From[scala.TraversableOnce] = Z.TraversableOnce

  implicit val JavaSpliterator: From[java.util.Spliterator] = Z.JavaSpliterator

  implicit val JavaIterator: From[java.util.Iterator] = Z.JavaIterator

  implicit val JavaIterable: From[java.lang.Iterable] = Z.JavaIterable

  implicit val JavaStream: From[java.util.stream.Stream] = Z.JavaStream

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class ->
 *
 *     [[Pipe.From]] is a standard converter interface from arbitrary type and it's children to [[Pipe]]
 *
 *     Once there is an implicit converter instance available in scope, the type can be converted to [[Pipe]] with '<instance>.all' syntax
 *
 *     There are default converters [[Pipe.From$ available]] for major Java and Scala containers
 *
 *     {{{
 *       scala.List(1, 2, 3, 4, 5).all lp   // Prints: ~(1, 2, 3, 4, 5)
 *     }}}
 *
 *     Creating new converter is easy
 *
 *     {{{
 *       class MyType[A](val x: A, val y: A, val z: A)
 *
 *       implicit object MyTypeToPipe extends Pipe.From[MyType] {
 *
 *         def apply[A](v: MyType[A]) = v.x ~ v.y ~ v.z
 *       }
 *
 *       new MyType('a', 'b', 'c').all lp // Prints: ~(a, b, c)
 *     }}}
 *
 * @val ScalaArray -> Array converter
 *
 *    Converter for Java-Scala Array to [[Pipe]]
 *
 *    Note. scalqa.Array has 'all' method built-in
 *
 * @val TraversableOnce -> All Scala containers converter
 *
 *    Every container in Scala implements TraversableOnce and is covered by this converter
 *
 * @val JavaIterable -> All Java containers converter
 *
 *    All containers in Java like Collection, List implement Iterable and are covered by this converter
 *
 * @val JavaIterator -> Java Iterator converter
 *
 *    Iterator is a natural [[Pipe]] source
 *
 * @val JavaSpliterator -> Java Spliterator converter
 *
 *    Spliterator is iterated with simple 'tryAdvance' method
 *
 * @val JavaStream -> Java Stream converter
 *
 *    Stream provides 'iterator' conversion, and iterator is converted to [[Pipe]]
 */
