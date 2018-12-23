package scalqa; package Stream

package object A {
  type Specialized[A] = Specialized._Trait[A]

  def assertIlk[@specialized(DATA) A](s: Stream[A], ilk: Any.Ilk): Stream[A] = new Stream[A] with Stream.Z.A.Extended.All[A] {
    @inline final def prime = real.prime
    @inline final def pump = real.pump
    @inline final def foreach(f: Consumer[A]) = real.foreach(f)
    @inline final override def ilkOpt = ilk
    @inline final override def real = s
  }

  def assertSize[@specialized(DATA) A](s: Stream[A], sz: Int): Stream[A] = new Stream[A] with Stream.Z.A.Extended.All[A] {
    @inline final def prime = real.prime
    @inline final def pump = real.pump
    @inline final def foreach(f: Consumer[A]) = real.foreach(f)
    @inline final override def sizeOpt = sz
    @inline final override def real = s
  }

  def assertSorted[@specialized(DATA) A](s: Stream[A], o: Ordering[A]): Stream[A] = new Stream[A] with Stream.Z.A.Extended.All[A] {
    @inline final def prime = real.prime
    @inline final def pump = real.pump
    @inline final def foreach(f: Consumer[A]) = real.foreach(f)
    @inline final override def sortedOpt = o
    @inline final override def real = s
  }

  def assertSortedBy[@specialized(DATA) A, B](s: Stream[A], o: Ordering[B], f: A => B): Stream[A] = new Stream[A] with Stream.Z.A.Extended.All[A] {
    @inline final def prime = real.prime
    @inline final def pump = real.pump
    @inline final def foreach(f: Consumer[A]) = real.foreach(f)
    @inline final override val sortedOpt = o.on(f)
    @inline final override def sortedByOpt[C] = (o, f).Opt.I.asInstanceOfTarget
    @inline final override def real = s
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object A -> `Abstract Stream bases`
 *
 *     Generally a [[Stream]] can be defined with just two methods: `prime` and `pump` and fully pumped with a loop:
 *
 *     {{{
 *       class TenIntsStream extends Stream.A.Base[Int] {
 *         var i = 0
 *
 *         def prime = i < 10
 *
 *         def pump = { i += 1; i }
 *       }
 *
 *       val s = new TenIntsStream
 *
 *       while (s.prime) print(s.pump + " ") // Prints 1 2 3 4 5 6 7 8 9 10
 *     }}}
 *
 *     This resembles Iterator with 'hasNext' and 'next' methods.
 *
 *     The difference is: `pump` MUST NEVER be called without preceding successful `prime`. This rule adds about 10% speed increase
 */
