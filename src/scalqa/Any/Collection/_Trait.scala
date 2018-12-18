package scalqa; package Any; package Collection

trait _Trait[@specialized(DATA) +A] extends Any {

  def all: ~[A]

  def size: Int

}

object _Trait extends Util.Void.Setup.Typed[Any.Collection](new Any.Collection[Nothing] with Void { def size = 0; def all = \/ }) {

  implicit def zzStream[A](c: Any.Collection[A]) = c.all

  implicit class _library[A](val real: Any.Collection[A]) extends AnyVal with Any.Collection._library[A]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait ->
 *     `Collection`
 *
 *    "Collection" is the root of  [[Features.Simple_Collections Scalqa Collections Framework]]
 *
 *    It is a rough equivalent of Java Collection and Scala Traversable.
 *
 *    The notable difference is how the size is treated.
 *    A good [[Any.Collection]] implementation must have a readily available size, where as in Java and Scala size can be calculated each time.
 *
 * @def size: -> Number of elements
 *
 *    Readily available, not calculated element count
 *
 *    {{{
 *      *(1,3,5,7).to[Idx].size.lp  // Prints: 4
 *    }}}
 *
 *
 * @def all: -> Returns a Stream of all elements
 *
 *    Unless specifically defined, the order must be assumed as random.
 *
 *    {{{
 *      val coll = Any.Collection.make(1,3,5,7)
 *      coll.all.lp
 *
 *      // Output
 *      ~(1, 3, 5, 7)
 *    }}}
 */
