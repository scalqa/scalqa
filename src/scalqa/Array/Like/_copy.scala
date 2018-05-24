package scalqa; package Array; package Like

import scala.language.higherKinds

trait _copy[A, ARRAY[A]] extends Any with Able.Copy.Range.Tagged[A, ARRAY[A]] with Able.Copy.ToArray[A] with __[A, ARRAY] {

  def copyResize(newSize: Int)(implicit t: Tag[A] = \/): Array[A] = { val a = createArray(newSize)(t); copyToArray(a, 0, (_raw.length min newSize).Range); a }

  def copyAppend(that: Like[A, _])(implicit t: Tag[A] = \/): Array[A] = { val a = copyResize(size + that.size)(t); that.copyToArray(a, size); a }

  def copyToArray[B >: A](dest: Array[B], destPos: Int = 0, srcRangeOpt: Opt[Int.Range] = \/): Unit = {
    val r = srcRangeOpt or (0 <>> (dest.size - destPos min size))
    try {
      if (r.size > 0) System.arraycopy(_raw, r.start, dest._raw, destPos, r.size)
    } catch {
      case e: Throwable => {
        Print.Error.ls("Array.copy", "\n\tfrom:", _raw, " fromPos", r.start, "\n\tdest:", dest, " destPos", destPos, "\n\tlen:", r.size)
        throw e
      }
    }
  }

  def createArray(size: Int)(implicit t: Tag[A] = \/): Array[A] =
    if (t.isVoid) java.lang.reflect.Array.newInstance(_raw.getClass.getComponentType, size).cast[Array.Raw[A]]
    else t.newArray(size)

  protected def _copy(r: Int.Range, t: Tag[A]): ARRAY[A] = { val a = createArray(r.size)(t); copyToArray(a, 0, r); a.cast }

  protected def _copyDrop(r: Int.Range, t: Tag[A]): ARRAY[A] = {
    val a = createArray(size - r.size)(t)
    if (r.start > 0) copyToArray(a, 0, r.start.Range);
    if (r.end < size) copyToArray(a, r.start, r.end <>> size)
    a.cast
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def createArray -> Create array
 *
 *     Creates new [[Array]] with the same data type as ''this''
 *
 * @def copyResize -> Resize
 *
 *     Creates new [[Array]] with specified size and copies all data into it
 *
 *     Note: If new size is smaller, important data loss may happen
 *     {{{
 *       val array: Array[Int] = (0 <> 15).all.to[Array]
 *
 *       array.copyResize(5).all.lp
 *
 *       // Output
 *       ~(0, 1, 2, 3, 4)
 *     }}}
 *
 * @def copyAppend -> Append
 *
 *     Creates new [[Array]], which holds all data from ''this'' following by ''that''
 *     {{{
 *       val array1: Array[Int] = (1 <> 5).all.to[Array]
 *       val array2: Array[Int] = (10 <> 15).all.to[Array]
 *
 *       array1.copyAppend(array2).all.lp
 *
 *       // Output
 *        ~(1, 2, 3, 4, 5, 10, 11, 12, 13, 14, 15)
 *     }}}
 *
 * @def copyToArray -> Bulk copy
 *
 *     Uses JVM efficient bulk copy method to transfer ''this'' data to the specified [[Array]]
 *
 *     Java ''System.arraycopy'' is used
 *
 *     @param dest destination [[Array]]
 *     @param destPos destination [[Array]] position to copy to
 *     @param srcRangeOpt  optional ''this'' range to copy. If void, full range of ''this'' is copied.
 *     @example
 *     {{{
 *       val src:  Array[Char] = ('A' <> 'Z').all.to[Array]
 *       val dest: Array[Char] = Array.get(26)
 *
 *       src.copyToArray(dest, 20, 0 <>> 6)
 *       src.copyToArray(dest, 0, 20 <>> 26)
 *
 *       dest.all.lp
 *       // Output
 *       ~(U, V, W, X, Y, Z,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  , A, B, C, D, E, F)
 *     }}}
 */
