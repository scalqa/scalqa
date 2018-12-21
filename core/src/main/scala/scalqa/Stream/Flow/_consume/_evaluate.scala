package scalqa; package Stream; package Flow; package _consume

trait _evaluate[A] { self: Flow[A] =>

  def lookupOpt[B](f: PartialFunction[A, B]): Opt[B] = findOpt(f.isDefinedAt).map(f)

  protected def findAnyOpt: Opt[A]

  def findOpt(f: Filter[A]): Opt[A] = let(f).findAnyOpt

  def find(f: Filter[A]): A = findOpt(f).value

  def isAny(f: Filter[A]): Boolean = findOpt(f)

  def isEvery(f: Filter[A]): Boolean = let(!f.allow(_)).findAnyOpt.isVoid

  def contains[B >: A](value: B): Boolean = findOpt(value == _)

  def count: Int

  def count(f: Filter[A]): Int = { var i = 0; foreach(v => if (f.allow(v)) self.synchronized { i += 1 }); i }

  def countFew(f: Filter[A]*): Idx[Int] = Z.consume.evaluate.count.few(this, f.toArray)

  def countAndTime: (Int, Duration) = { val t = Time.now; (count, t.age) }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _evaluate -> `Evaluate Interface`
 *
 * @def lookupOpt -> Find first matching option
 *
 *     The found element may be converted as well
 *
 *     {{{
 *       def stream = ~[Any] + "ABC" + 1 + 22.0 + "DE" + 333F + "F"
 *
 *       // Find length of the first matching string
 *       stream.lookupOpt{ case s: String if (s.length > 1) => s.length }.lp // Prints: Opt(3)
 *     }}}
 *
 * @def count: -> All elements count
 *
 *    Returns count of all elements
 *
 *    {{{ ('a' <> 'z').all.count.lp  // Prints: 26 }}}
 *
 * @def count( -> Element conditional count
 *
 *    Returns count of elements satisfying the filter function
 *
 * @def findOpt -> Find
 *
 *     Optionally returns the first element satisfying the given filter function
 *
 *     {{{ (1 <> 1000).all.findOpt(_ > 100).lp  // Prints: Opt(101) }}}
 *
 * @def find( -> Find
 *
 *     Returns the first element satisfying the given filter function
 *
 *     Fails if none found
 *
 *     {{{ (1 <> 1000).all.find(_ > 100).lp  // Prints: 101 }}}
 *
 * @def isAny -> Any check
 *
 *     Returns `true` if there is an element satisfying the filter function
 *
 *     {{{
 *         def all = (1 <> 100).all
 *
 *         all.isAny(_ > 10).lp   // Prints: true
 *
 *         all.isAny(_ > 100).lp  // Prints: false
 *     }}}
 *
 * @def isEvery ->  Every check
 *
 *     Returns `true` if every element is satisfying the filter function
 *
 *     {{{
 *         def all = (1 <> 100).all
 *
 *         all.isEvery(_ > 10).lp   // Prints: false
 *
 *         all.isEvery(_ > 0).lp    // Prints: true
 *     }}}
 *
 * @def contains -> Includes check
 *
 *     Returns `true` if there is element equal to the given `value`
 *     {{{
 *       def all = ('a' <> 'f').all
 *
 *       all.contains('c').lp       // Prints: true
 *
 *       all.contains('y').lp       // Prints: false
 *     }}}
 *
 * @def countAndTime -> Element count and time
 *
 *    Returns count of all elements and the [[Duration]] it took to pump the pipeline
 *    {{{
 *      (1 <> 1000).all.peek(_ => App.pause(1.Millis)).countAndTime.lp // Prints: (1000,1.004 sec)
 *    }}}
 *
 * @def countFew ->  Element multi count
 *
 *     Counts elements for several filter functions at once
 *
 *     Returns [[Idx Idx[Int]]], where each Int corresponds to the given filter function count
 *
 *     If the pipeline is empty, the resulting Idx will still hold 0 in each position, but will test isVoid positive
 *
 *     @param  f  several filter functions
 *
 *     @example
 *     {{{
 *       val (all, odd, even) = (1 <> 50).all.countFew(ANY, _ % 2 == 1, _ % 2 == 0).toTuple3
 *
 *       "all=" + all lp;    // Prints: all=50
 *       "odd=" + odd lp;    // Prints: odd=25
 *       "even=" + even lp;  // Prints: even=25
 *
 *        // ----------------------------------------------------------------------------------
 *
 *       def count(stream: ~[Int]): Idx[Int] = stream.countFew(_ < 10, _ > 20, 30 <> 60)
 *
 *       count(1 <> 50).all lp  // Prints: ~(9, 30, 21)
 *
 *       count(\/).all lp       // Prints: ~(0, 0, 0)
 *
 *       count(\/).Opt lp       // Prints: Opt.Void
 *     }}}
 */
