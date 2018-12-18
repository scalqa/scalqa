package scalqa; package Stream; package _consume

trait _evaluate[A] extends Flow._consume._evaluate[A] { self: Stream[A] =>

  def findIdxOpt(f: Filter[A]): Opt.Int = Z.consume.evaluate.find.indexOpt(this, f)

  def unequalOpt(that: ~[A], check: (A, A) => Boolean = _ == _): Opt[String] = Z.consume.evaluate.unequalOpt(this, that, check)

  override def find(f: Filter[A]): A = findOpt(f).value
  override def findOpt(f: Filter[A]): Opt[A] = findNextOpt(f)
  protected def findAnyOpt: Opt[A] = nextOpt

  override def lookupOpt[B](f: PartialFunction[A, B]): Opt[B] = findNextOpt(f.isDefinedAt).map(f)

  override def isAny(f: Filter[A]): Boolean = findNextOpt(f)

  override def isEvery(f: Filter[A]): Boolean = drop(f).findNextOpt(ANY).isVoid

  override def contains[B >: A](value: B): Boolean = findNextOpt(_ == value)

  override def count: Int = Z.consume.evaluate.count(this)

  override def count(f: Filter[A]): Int = Z.consume.evaluate.count(this, f)

  override def countFew(f: Filter[A]*): Idx[Int] = Z.consume.evaluate.count.few(this, f.toArray)

  override def countAndTime: (Int, Duration) = Z.consume.evaluate.count.andTime(this)

  def last: A = lastOpt.value
  def lastOpt: Opt[A] = if (!prime) Opt.Void else { var v = pump; while (prime) v = pump; v }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *  @trait _evaluate -> `Evaluate Interface`
 *
 *      Most methods search for certain data and stop once found
 *
 *      The pipeline, in most cases, is discarded not fully pumped
 *
 * @def lastOpt -> Last element
 *
 *     Optionally returns the last element or Opt.Void
 *
 * @def last: ->  Last element
 *
 *     Returns the last data element
 *
 *     Fails if no data
 *
 * @def findIdxOpt(f: Filter[A]) -> Find index
 *
 *     Optionally returns index for the first element satisfying the filter function or Opt.Void if none found
 *
 *     {{{ (50 <> 500).all.findIdxOpt(_ == 400).lp // Prints: Opt(350) }}}
 *
 * @def unequalOpt -> Unequal check
 *
 *     Pumps both streams and compares all corresponding elements
 *
 *     When first not equal pair is found, message is returned
 *
 *     If all are equal, Opt.Void is returned
 *
 *     {{{
 *       (0 <> 10).all unequalOpt (0 <> 10) lp        // Prints: Opt.Void
 *
 *       (0 <> 10).all unequalOpt (0 <>> 10) lp       // Prints: Opt(First has more elements)
 *
 *       (0 <> 5).all + 7 + 8 unequalOpt (0 <> 10) lp // Prints: Opt(Fail at index 6: 7 != 6)
 *     }}}
 *
 *     @param check is the function to compare two elements
 */
