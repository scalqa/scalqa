package scalqa; package Pipe; package Flow; package _pump

trait _evaluate[A] extends __[A] {

  def findOpt(f: A ⇒ Boolean): Opt[A] = Z.evaluate.find.opt(This, f)

  def find(f: A ⇒ Boolean): A = Z.evaluate.find.opt(This, f).value

  def isAny(f: A ⇒ Boolean): Boolean = Z.evaluate.find.opt(This, f)

  def isEvery(f: A ⇒ Boolean): Boolean = Z.evaluate.find.opt(This, (v: A) => !f(v)).isEmpty

  def size: Int = metadata.sizeOpt or count()

  def contains[B >: A](value: B): Boolean = Z.evaluate.find.opt(This, value == _)

  def count(f: A => Boolean = EVERY): Int = { var i = 0; synchronize.apply(v => if (f(v)) i += 1); i }
  def countFew(f: A => Boolean*): Index[Int] = Z.evaluate.count.few(This, f: _*)
  def countAndTime: (Int, Time.Length) = (Time.get, This.synchronize.count()) to ((t, c) => (c, t.age))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _evaluate -> '''Evaluate Interface'''
 *
 *    @define always This method always fully pumps all pipeline elements
 *
 * @def size -> Elements count
 *
 *   Returns all elements count
 *
 *   Unlike 'count', 'size' may be retrieved from [[Metadata]], without pumping the pipeline
 *
 *   {{{
 *       def all = (1 <> 5).all
 *
 *       all.peek(_.lp("Pumping 1 Ints: ")).size.lp            // size is known from Metadata
 *
 *       all.peek(_.lp("Pumping 2 Ints: ")).let(_ > 0).size.lp // size is not known from Metadata
 *                                                             // because of indeterminate 'let'
 *       // Output
 *       5
 *       Pumping 2 Ints: 1
 *       Pumping 2 Ints: 2
 *       Pumping 2 Ints: 3
 *       Pumping 2 Ints: 4
 *       Pumping 2 Ints: 5
 *       5
 *   }}}
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
 *     {{{ (1 <> 1000).all.findOpt(_ > 100).lp  // Prints: 101 }}}
 *
 * @def isAny -> Any check
 *
 *     Returns ''true'' if there is an element satisfying the filter function
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
 *     Returns ''true'' if every element is satisfying the filter function
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
 *     Returns ''true'' if there is element equal to the given ''value''
 *     {{{
 *       def all = ('a' <> 'f').all
 *
 *       all.contains('c').lp       // Prints: true
 *
 *       all.contains('y').lp       // Prints: false
 *     }}}
 *
 * @def count( -> Element count
 *
 *    Returns count of elements satisfying the filter function
 *
 *    Default filter counts every element
 *
 *    {{{ ('a' <> 'z').all.count().lp  // Prints: 26 }}}
 *
 *    @note $always
 *
 * @def countAndTime -> Element count and time
 *
 *    Returns count of all elements and the [[Time.Length]] it took to pump the pipeline
 *    {{{
 *      (1 <> 1000).all.trigger(Pause(1.Millis)).countAndTime.lp // Prints: (1000,1.004 sec)
 *    }}}
 *    @note $always
 *
 * @def countFew ->  Element multi count
 *
 *     Counts elements for several filter functions at once
 *
 *     Returns [[Index Index[Int]]], where each [[Int]] corresponds to the given filter function count
 *
 *     If the pipeline is empty, the resulting Index will still hold 0 in each position, but will test isVoid positive
 *
 *     @param  f  several filter functions
 *
 *     @example
 *     {{{
 *       val (all, odd, even) = (1 <> 50).all.countFew(EVERY, _ % 2 == 1, _ % 2 == 0).to3
 *
 *       all  lp "all="   // Prints: all=50
 *       odd  lp "odd="   // odd=25
 *       even lp "even="  // even=25
 *
 *        // ----------------------------------------------------------------------------------
 *
 *       def count(pipe: ~[Int]): Index[Int] = pipe.countFew(_ < 10, _ > 20, 30 <> 60)
 *
 *       count(1 <> 50).all lp  // Prints: ~(9, 30, 21)
 *
 *       count(\/).all lp       // Prints: ~(0, 0, 0)
 *
 *       count(\/).Opt lp       // Prints: Opt.Void
 *     }}}
 *     @note $always
 */
