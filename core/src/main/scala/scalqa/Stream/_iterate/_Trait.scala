package scalqa; package Stream; package _iterate

trait _Trait[A] { self: Stream[A] =>

  def prime: Boolean

  def pump: A

  def next: A = if (prime) pump else Stream.failEmpty

  def nextOpt: Opt[A] = if (prime) pump else Opt.Void

  def findNextOpt(f: Filter[A]): Opt[A] = { while (prime) { var v = pump; if (f.allow(v)) return v }; Opt.Void }

  def take(cnt: Int): ~[A] = Z.iterate.take(this, cnt)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> `Iteration Interface`
 *
 * @def prime -> Get next element ready
 *
 *     Prepares next element to be pumped. If required, the element might be requested from the source and saved locally
 *
 *     Returns true if there is element waiting to be pumped or false if [[Stream]] is empty
 *
 *     `prime` can be called multiple times without pumping the element, in this case it must consistently return the same value
 *
 *     `prime` can be used similarly to Iterator.hasNext
 *
 * @def pump: -> Pump next element
 *
 *     `pump` is a faster `next`
 *
 *     The Stream MUST be successfully 'primed' before `pump` is called
 *
 *     {{{
 *         val s : ~[Int] = 1 <> 3
 *
 *         while(s.prime) s.pump.lp
 *
 *         // Prints
 *         1
 *         2
 *         3
 *     }}}
 *
 * @def findNextOpt -> Find next element
 *
 *     Iterates elements until the first satisfying the filter is found
 *
 * @def nextOpt -> Next element
 *
 *     Optionally returns next element or Opt.Void
 *
 * @def next: -> Next element
 *
 *     Delivers next element
 *
 *     Fails if no elements
 *
 *     Implemented as:
 *     {{{
 *         def next: A = if (prime) pump else Stream.failEmpty
 *     }}}
 *
 * @def take -> Group iterate
 *
 *   Iterates through several elements at once and returns them as different [[Stream]]
 *
 *   {{{
 *
 *     val s : ~[Int] = 1 <> 30
 *
 *     s.take(5).lp  // Prints ~(1, 2, 3, 4, 5)
 *
 *     s.take(12).lp // Prints ~(6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17)
 *
 *     s.take(7).lp  // Prints ~(18, 19, 20, 21, 22, 23, 24)
 *
 *     // Print leftovers
 *     s.lp          // Prints ~(25, 26, 27, 28, 29, 30)
 *   }}}
 */
