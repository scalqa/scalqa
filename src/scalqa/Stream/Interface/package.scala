package scalqa; package Stream

package object Interface {
  private[scalqa] def This = this

  def apply[A]: Stream[A] = Z.A.Void.asInstanceOf[Stream[A]]

  def *[@specialized(DATA) A](v: A*): Stream[A] = v match { case w: collection.mutable.WrappedArray[A] => Custom.Array.Z.stream(w.array); case _ => v.all }

  implicit def zzMake[A](v: \/): ~[A] = Z.A.Void.asInstanceOf[~[A]]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def *[ -> Varagr Constructor
 *
 *     Creates stream with specified values
 *
 * @def apply[A] -> Get Void [[Stream]]
 *
 *     Returns a strongly typed void Stream
 *
 *     This is convenient way to get a void instance or to start a pipeline chain
 *
 *     {{{
 *        val p1: ~[Int] = ~.apply[Int]  // gets a Void Int Stream
 *        val p2: ~[Int] = ~[Int]        // equivalent to the above
 *        val p3 = ~[Int]                // equivalent to the above
 *
 *        // Starting a pipeline chain with void Double forces subsequent elements to Double too
 *        val s: ~[Double] = ~[Double] + 1 + 2L + 3.0F + 4.0
 *     }}}
 */
