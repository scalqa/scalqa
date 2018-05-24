package scalqa; package Pipe; package From

import scala.language.higherKinds

class AllMethod[CONTAINER[A], A] private[scalqa] (private[scalqa] val This: CONTAINER[A]) extends AnyVal {

  def all(implicit v: Pipe.From[CONTAINER]): Pipe[A] = v(This)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class AllMethod ->
 *
 * @def all -> All elements as Pipe
 *
 *     If this is an aggregation type, its all elements will be provided as [[Pipe]]
 *
 *     The implicit parameter [[Pipe.From]] by default supports following
 *     types and their children:
 *
 *       - scala.TraversableOnce
 *       - scala.Array
 *       - java.lang.Iterable
 *       - java.util.Iterator
 *       - java.util.Spliterator
 *       - java.util.stream.Stream
 *
 *     {{{
 *         scala.List('q','w','e','r','t','y').all.lp
 *
 *         // Output
 *         ~(q, w, e, r, t, y)
 *     }}}
 */
