package scalqa; package Coll

trait _Trait[+A] extends Any {

  def all: ~[A]

  def size: Int

}

object _Trait extends Able.Void.Companion.Typed[Coll](new Coll[Nothing] with Void { def size = 0; def all = \/ }) {

  import scala.language.implicitConversions

  implicit def zzAll[A](c: Coll[A]) = c.all

  implicit def zzLibrary[A](v: Coll[A]) = new _library(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait ->
 *     '''Collection'''
 *
 *    "Collection" is the root of  [[Features.Observable_Collections Scalqa Collections Framework]]
 *
 *    It is a rough equivalent of Java Collection and Scala Traversable.
 *
 *    The notable difference is how the size is treated.
 *    A good [[Coll]] implementation must have a readily available size, where as in Java and Scala size can be calculated each time.
 *
 * @def size: -> Number of elements
 *
 *    Readily available, not calculated element count
 *
 *    {{{
 *      *(1,3,5,7).to[Coll].size.lp  // Prints: 4
 *    }}}
 *
 *
 * @def all: -> Returns a Pipe of all elements
 *
 *    Unless specifically defined, the order must be assumed as random.
 *
 *    {{{
 *      val coll = Coll.get(1,3,5,7)
 *      coll.all.lp
 *
 *      // Output
 *      ~(1, 3, 5, 7)
 *    }}}
 */
