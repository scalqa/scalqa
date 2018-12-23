package scalqa

package object Stream {
  type Interface[+A] = Interface._Class[A]
  type Flow[A] = Flow._Trait[A]

  // Function -------------------------------------------------------------------------------
  type Consumer[-A] = Stream.Interface.Function.Consumer[A]; val Consumer = Stream.Interface.Function.Consumer
  type Filter[-A] = Stream.Interface.Function.Filter[A]; val Filter = Stream.Interface.Function.Filter
  type Mapping[-A, +B] = Stream.Interface.Function.Mapping[A, B]; val Mapping = Stream.Interface.Function.Mapping
  type Folding[A] = Stream.Interface.Function.Folding[A]; val Folding = Stream.Interface.Function.Folding

  def *[@specialized(DATA) A](v: A*): Stream[A] = v match { case w: collection.mutable.WrappedArray[A] => Custom.Array.Z.stream(w.array); case _ => v.all }

  def make[@specialized(DATA) A](v: Idx[A]): Stream[A] = Idx.Z.stream(v)

  def make[@specialized(DATA) A: Ilk](v: java.lang.Iterable[A]): ~[A] = Z.A.Java.Iterable.toStream[A](v)

  def make[@specialized(DATA) A: Ilk](v: java.util.Iterator[A]): ~[A] = Z.A.Java.Iterator.toStream[A](v)

  def make[@specialized(DATA) A](v: Array[A]): ~[A] = Custom.Array.Z.stream(v)

  def make[@specialized(DATA) A: Ilk](v: collection.GenTraversableOnce[A]): ~[A] = Z.A.Scala.GenTraversableOnce.toStream[A](v)

  def make(v: scala.Range): ~[Int] = Idx.Range.Z.stream(v.start, v.size)

  private[scalqa] def failEmpty = App.Fail.state("Stream is empty")
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Stream ->
 *
 *    There are many ways to create [[Stream]] besides `make` constructors
 *
 *     {{{
 *      val sf: ~[Float] = ~.*(1, 2, 3)      // Vararg constructor '*'
 *      sf lp                                // Prints: ~(1.0, 2.0, 3.0)
 *
 *      val si: ~[Int] = 4 ~+ 5 + 6 + 7 + 8  // Create with '~+' operator and append
 *      si lp                                // Prints: ~(4, 5, 6, 7, 8)
 *
 *      val sd = ~[Double] + 12 + 10L + 1D   // Void stream and append
 *      sd lp                                // Prints: ~(12.0, 10.0, 1.0)
 *
 *      val sc: ~[Char] = 'A' <> 'D'         // From Range, which can implicitly convert to Stream
 *      sc lp                                // Prints: ~(A, B, C, D)
 *
 *      val v1 = ~[Int]                      // Void stream with explicit type
 *      v1 lp                                // Prints: ~()
 *
 *      val v2: ~[Int] = \/                  // Void stream with context type
 *      v2 lp                                // Prints: ~()
 *    }}}
 *
 * @def *[ -> Varagr Constructor
 *
 *     Creates stream with specified values
 *
 * @type Consumer -> Function alias
 *
 *   Alias to type and object [[Stream.Interface.Function.Consumer]]
 *
 * @type Folding -> Function alias
 *
 *   Alias to type and object [[Stream.Interface.Function.Folding]]
 *
 * @type Filter -> Function alias
 *
 *   Alias to type and object [[Stream.Interface.Function.Filter]]
 *
 * @type Mapping -> Function alias
 *
 *   Alias to type and object [[Stream.Interface.Function.Mapping]]
 */
