package scalqa; package Array; package Like

import scala.language.higherKinds

private[Array] trait __[A, ARRAY[A]] extends Any {

  protected def raw: Array.Raw[_ >: A]

  @inline private[Array] def _raw = raw

  protected[Array] def value = raw

  private[Array] def This: Like[A, ARRAY[A]] = this.cast

  protected def size: Int

  protected def copyResize(newSize: Int)(implicit t: Tag[A] = \/): Array[A]

  protected def copyToArray[B >: A](dest: Array[B], destPos: Int = 0, srcRangeOpt: Opt[Int.Range] = \/): Unit

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def raw -> Raw base
 *
 *    The scala.Array ''this'' is based on
 *
 *    ''This'' is a thing AnyVal wrapper around ''raw''
 *
 *
 */
