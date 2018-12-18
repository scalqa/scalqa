package scalqa; package Idx; package Range

class _Class private[Idx] (protected val value: Long) extends AnyVal with scalqa.Range[Int] {
  protected override type this_type = Range

  def size: Int = value << 32 >>> 32 toInt

  def toArray: scala.Array[Int] = Z.array(this)

  def toInts: Ints = scalqa.Ints.make(this)

  // -------------------------------------------------------------------------------------------
  def move(positions: Int): Range = (start + positions) <>>+ size

  def resizeBy(change: Int): Range = start <>> this.end + change

  protected def ilk = Ilk.Ints

  override def start: Int = value >>> 32 toInt

  override def startExclusive = false

  override def end = start + size

  override def endExclusive = true

  override def ordering = Ordering.Int

  override def all(implicit is: Numeric[Int]): ~[Int] = Z.stream(start,size)

  override def allStep(step: Int)(implicit is: Numeric[Int]): ~[Int] = if (step == 0) App.Fail("0 step") else Z.stream.step(this, step)

  // -------------------------------------------------------------------------------------------
  protected override def startContains(i: Int, x: Boolean = false): Boolean = start <= i
  protected override def endContains(i: Int, x: Boolean = false): Boolean = end > i || x && end == i
  protected override def thisClass: Class[_] = classOf[Range]
  protected def make(start: Int, startExcl: Boolean, end: Int, endExcl: Boolean): Range = make(start, startExcl, end, endExcl)
}

object _Class {

  implicit def zzMake(or: scalqa.Range[Int]): Range = Range.make(or)

  implicit def zzFilter(r: Range): Stream.Filter[Int] = r.contains
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class ->
 *
 *   [[Idx.Range]] is a highly efficient extension of [[scalqa.Range Range[Int]]]
 *
 *   It is a value class built around Long primitive and in most usage cases the object instance is not even created
 *
 *   [[Idx.Range]] has `start` and exclusive `end`
 *
 *   It has `size` which is equal to `end` minus `start`
 *
 *   In general programming there are several common ways to specify Int ranges:
 *
 *       - `start` plus `size`
 *       - `start` plus `end` position
 *       - `start` plus `end` position exclusive
 *
 *   All three options are reduced in Scalqa to single unambiguous [[Idx.Range]]
 *
 *   {{{
 *       "abcdef".substring(2, 5)  // Java way
 *
 *       "abcdef".copy(2 <>> 5)    // Scalqa way
 *
 *       new StringBuilder("abcdef").delete(2, 4)    // Java way
 *
 *       Util.StringBuilder.make("abcdef") -=@ (2 <>> 4)  // Scalqa way
 *   }}}
 *
 * @def toArray -> Idx collection
 *
 *     Returns all indexes belonging to the range as Int Array
 *     {{{
 *       (3 <>> 9).toArray.all lp // Prints: ~(3, 4, 5, 6, 7, 8)
 *     }}}
 *
 * @def toInts -> Convert to Ints
 *
 *     Returns all indexes belonging to the range as [[Ints]]
 *     {{{
 *       (3 <>> 9).toInts.all lp // Prints: ~(3, 4, 5, 6, 7, 8)
 *     }}}
 *
 * @def size -> Size
 *
 *     Returns range size, which is equal to `end` - `start`
 *     {{{
 *       (2 <>> 5).size lp  // Prints: 3
 *     }}}
 *
 * @def resizeBy -> Resize
 *
 *    Creates a new [[Range]] with changed size
 *    {{{
 *      (0 <> 1) resizeBy 2 lp  // Prints: 0 <>> 4
 *
 *      (1 <> 7) resizeBy -2 lp // Prints: 1 <>> 6
 *   }}}
 *
 * @def move -> Range move
 *
 *    Creates a new [[Range]], where elements of `this` are shifted by `positions`
 *    {{{
 *       (0 <> 1) move 2 lp  // Prints: 2 <>> 4
 *
 *       (5 <> 7) move -1 lp // Prints: 3 <>> 6
 *    }}}
 *
 * @def toArray -> Array of indexes
 *
 *    Returns all indexes belonging to the range as [[Array  scala.Array[Int]]]
 *    {{{
 *      (5 <> 10).toArray.all lp // Prints: ~(5, 6, 7, 8, 9, 10)
 *    }}}
 *
 */
