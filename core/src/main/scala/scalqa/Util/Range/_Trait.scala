package scalqa; package Util; package Range

trait _Trait[A] extends Any with Z.Base[A] {

  def start: A
  def startExclusive: Boolean
  def end: A
  def endExclusive: Boolean
  def ordering: Ordering[A]

  def all(implicit n: Numeric[A]): ~[A] = allStep(n.one)
  def allStep(step: A => A): ~[A] = Z.allStep[A](this, step)
  def allStep(step: A)(implicit n: Numeric[A]): ~[A] = Z.allStep[A](this, step, n)

  // Checking endContains first for the benefit of (A <>>!) ranges
  def contains(that: Range[A]): Boolean = endContains(that.end, that.endExclusive) && startContains(that.start, that.startExclusive)
  def contains(a: A): Boolean = startContains(a) && endContains(a)

  def overlapOpt(that: Range[A]) = Z.overlapOpt(this, that).asInstanceOf[Opt[this_type]]
  def join(that: Range[A]) = Z.join(this, that).asInstanceOf[this_type]
  def extendTo(a: A) = Z.extendTo(this, a).asInstanceOf[this_type]

  def map[B](m: A => B)(implicit s: Ordering[B]) = Range.general[B](m(start), startExclusive, m(end), endExclusive)

  override def toString = start.I.toString + (if (startExclusive) " <<" else " <") + (if (endExclusive) ">> " else "> ") + end
}

object _Trait extends {

  implicit def zzFilterMonadic[A](r: Range[A]) = new Z.FilterMonadic[A](r)

  implicit def zzMake[A](v: \/)(implicit s: Ordering[A]): Range[A] = new Z.A.Void(s)

  implicit def zzStream[A](v: Range[A])(implicit n: Numeric[A]): ~[A] = v.all

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> `Generic Range`
 *
 *    [[Range]] is defined with the following defs:
 *
 *        - `start`,`startExclusive`
 *        - `end`, `endExclusive`
 *        - and `ordering`, which makes the above meaningful
 *
 *    [[Range]] has a notion that an element can be within the range, i.e. between start and end, or outside
 *
 *    [[Range]] can be created with special built-in constructors attached to every type, see [[Any._library]]
 *
 *    {{{
 *       'A' <> 'D'   // Range[Char] from 'A' to 'D'
 *
 *       "X" <>> "Z"  // Range[String] from "X" to "Z" exclusive
 *
 *       1.0 <<> 5.0  // Range[Double] from exclusive 1.0 to 5.0
 *
 *       1  <<>> 5    // Range[Int] from exclusive 1 to 5 exclusive
 *
 *       5L <>+ 3     // Range[Long] from 5 to 8
 *
 *       5D <>>+ 3    // Range[Double] from 5.0 to 8.0 exclusive
 *
 *       "abc" <>!    // Range[String] from "abc" to "abc"
 *
 *       "abc" <>>!   // Range[String] from "abc" to "abc" exclusive
 *    }}}
 *
 *    Note. [[Range]] is implicitly converted to a filter function, returning `true` if an element is within [[Range]] and `false` otherwise
 *
 *
 * @def ordering -> Ordering
 *
 *    Ordering defining range
 *
 *    Without Ordering cannot be defined
 *
 * @def start: -> From value
 *
 *    Start value of the range
 *
 * @def startExclusive -> Exclusive check
 *
 *    If true, the `start` value is exclusive
 *    {{{
 *      10 <<> 15 contains 10 lp  // Prints: false
 *
 *      // Exclusive 10 does not contain 10
 *    }}}
 *
 * @def end: -> To value
 *
 *    End value of the range
 *
 * @def endExclusive -> Exclusive check
 *
 *    If true, the `end` value is exclusive
 *    {{{
 *      10 <>> 15 contains 15 lp  // Prints: false
 *
 *      // Exclusive 15 does not contain 15
 *    }}}
 *
 *         * @def allStep(step: A => A) -> Stream of elements with step
 *
 *   Elements are produced from `start` to `end` using specified `step` function
 *
 *   {{{
 *     val dt = DayTime.make(9, 30)
 *     (dt <>> dt + 2.Hours).allStep(_ + 10.Minutes).lp
 *
 *     // Output
 *     ~(9:30, 9:40, 9:50, 10:00, 10:10, 10:20, 10:30, 10:40, 10:50, 11:00, 11:10, 11:20)
 *   }}}
 *   Note: The result depends on implicit Ordering
 *
 * @def allStep(step: A) -> Stream of elements with step
 *
 *   Elements are produced from `start` to `end` using implicit math.Numeric with provided `step` value
 *
 *   If `step` is negative, elements piped from `end` to `start`
 *
 *     math.Numeric is universally available for:
 *       - Byte, Char, Long, Int, Short, Float,Double
 *       - [[Any.Datum.Byte]], [[Any.Datum.Long]], [[Any.Datum.Int]], [[Any.Datum.Short]], [[Any.Datum.Float]],[[Any.Datum.Double]]
 *
 *    {{{
 *       ('A' <> 'Z').allStep(4).lp  // Prints: ~(A, E, I, M, Q, U, Y)
 *
 *       (1 <> 20).allStep(-3).lp    // Prints: ~(20, 17, 14, 11, 8, 5, 2)
 *   }}}
 *
 * @def all( -> Stream of elements
 *
 *   Elements are produced from `start` to `end` using implicit math.Numeric with value 1
 *
 *     math.Numeric is universally available for:
 *       - Byte, Char, Long, Int, Short, Float,Double
 *       - [[Any.Datum.Byte]], [[Any.Datum.Long]], [[Any.Datum.Int]], [[Any.Datum.Short]], [[Any.Datum.Float]],[[Any.Datum.Double]]
 *
 *    {{{
 *      ('A' <> 'K').all.lp
 *       (2018.Year.start.day <>+ 5).all.tp
 *
 *       // Output
 *       ~(A, B, C, D, E, F, G, H, I, J, K)
 *       ----------
 *       ?
 *       ----------
 *       2018-01-01
 *       2018-01-02
 *       2018-01-03
 *       2018-01-04
 *       2018-01-05
 *       2018-01-06
 *       ----------
 *     }}}
 * @def map -> Mapped Range
 *
 *   Creates range with mapped values
 *   {{{
 *     (1 <>> 5) map (_ * 100) lp  // Prints: 100 <>> 500
 *   }}}
 *
 * @def contains(a -> Check if within
 *
 *   Returns true if `this` range contains specified value
 *   {{{
 *     1 <> 9 contains 3 lp // Prints: true
 *   }}}
 *
 * @def contains(that -> Check if within
 *
 *   Returns true if `this` range contains `that` range
 *   {{{
 *     1 <> 9 contains 3 <> 7 lp // Prints: true
 *
 *     1 <> 5 contains 3 <> 7 lp // Prints: false
 *   }}}
 *
 * @def overlapOpt -> Optional intersection
 *
 *   Optionally returns common intersection of `this` and `that`
 *   {{{
 *     1 <> 6 overlapOpt 3 <> 9 lp  // Prints: Opt(3 <>> 7)
 *
 *     1 <> 3 overlapOpt 6 <> 9 lp  // Prints: Opt.Void
 *   }}}
 *
 * @def join -> Union
 *
 *   Returns range with out-most reaches of `this` and `that`
 *   {{{
 *     'A' <> 'C' join 'X' <> 'Z'.lp  // Prints: A <> Z
 *   }}}
 *
 * @def extendTo -> Expand
 *
 *   `This` range is extended to contain the specified value
 *   {{{
 *     'A' <> 'C' extendTo 'G' lp // Prints: A <> G
 *
 *     'A' <> 'C' extendTo 'B' lp // Prints: A <> C
 *   }}}
 *
 * @def toString -> String presentation
 *
 *     {{{
 *         ("AA" <> "BB").toString.lp  // Prints AA <> BB
 *     }}}
 */
