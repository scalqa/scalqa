package scalqa; package Idx; package Array

package object Buffer {

  def make[A](implicit i: Ilk[A]): Buffer[A] = i.mkBuffer(\/)

  def makeSized[A](initSize: Int)(implicit i: Ilk[A]): Buffer[A] = i.mkBuffer(initSize)

  def loaded[@specialized(DATA) A](array: scala.Array[_ >: A], currentSize: Opt.Int = \/): Buffer[A] = {
    class Loaded(var _array: scala.Array[A]) extends Buffer[A] {
      _size = currentSize or _array.length
      def apply(i: Int) = _array(i).asInstanceOf[A]
      def update(i: Int, v: A) = _array(i) = v
      def _arrayResize(sz: Int) = _array = _array.copyResize(sz)
    }
    new Loaded(array.asInstanceOf[scala.Array[A]])
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Buffer ->
 *
 *   Canonical way to create a default [[Idx.Array.Buffer]] is to use universal value [[NEW]]
 *
 *   {{{
 *       val l : Idx.Array.Buffer[Long]   = NEW
 *
 *       val s : Idx.Array.Buffer[String] = NEW
 *   }}}
 */
