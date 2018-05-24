package scalqa; package Int; package Range

class _Class private[Int] (protected val real: Long) extends AnyVal with Any.Value.Long with scalqa.Range[Int] with _this {

  protected def companion = _Class

  override def start: Int = value >>> 32 toInt

  override def startExclusive = false

  override def end = start + size

  override def endExclusive = true

  override def sorting = Sorting.The.Int

  override def all(implicit is: Int.Step[Int]): ~[Int] = new Z.all(this)

  override def allStep(step: Int)(implicit is: Int.Step[Int]): ~[Int] = if (step == 0) Fail("0 step") else new Z.all.Stepped(this, step)

  protected override def startContains(i: Int, x: Boolean = false): Boolean = start <= i
  protected override def endContains(i: Int, x: Boolean = false): Boolean = end > i || x && end == i
  protected override def THIS_CLASS: Class[_] = classOf[Range]
  protected def _get(start: Int, startExcl: Boolean, end: Int, endExcl: Boolean): Range = get(start, startExcl, end, endExcl)

}

object _Class extends Any.Value.Long.Companion[Range] {

  protected def get(v: Long) = new Range(v)

  import scala.language.implicitConversions

  implicit def zzGet(or: scalqa.Range[Int]): Range = Range.get(or)

  implicit def zzFilter(r: Range): Int => Boolean = r.contains
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
 *   [[Int.Range]] is a highly efficient extension of [[scalqa.Range Range[Int]]]
 *
 *   It is a value class built around [[Long]] primitive and in most usage cases the object instance is not even created
 *
 *   [[Int.Range]] has ''start'' and exclusive ''end''
 *
 *   It has ''size'' which is equal to ''end'' minus ''start''
 *
 *   In general programming there are several common ways to specify [[Int]] ranges:
 *
 *       - ''start'' plus ''size''
 *       - ''start'' plus ''end'' position
 *       - ''start'' plus ''end'' position exclusive
 *
 *   All three options are reduced in Scalqa to single unambiguous [[Int.Range]]
 *
 *   {{{
 *       "abcdef".substring(2, 5)  // Java way
 *
 *       "abcdef".copy(2 <>> 5)    // Scalqa way
 *
 *       new StringBuilder("abcdef").delete(2, 4)    // Java way
 *
 *       String.Builder.get("abcdef") =-@ (2 <>> 4)  // Scalqa way
 *   }}}
 */
