package scalqa; package Idx; package Array

class _Class[A](val real: scala.Array[_ >: A]) extends AnyVal with Idx[A] with Custom.Array.Like[A] {
  protected type TYPE = Idx[A]
  @inline protected def make = new Array[A](_)
  @inline protected def base = real.asInstanceOf[scala.Array[A]]

  @inline final def apply(i: Int): A = base(i)
  @inline final def update(i: Int, v: A): Unit = base(i) = v
  @inline final def size: Int = base.length
  @inline final def length: Int = base.length
  override def contains(v: A): Boolean = Custom.Array.Z.contains(base, v)

}

object _Class {

  implicit def zzMake[A](v: \/)(implicit i: Ilk[A]) = new Array[A](i.mkArray(0))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class -> `Indexed Array Collection`
 *
 *     [[Idx.Array]] has two major functions:
 *
 *     First, it efficiently wraps any Array as [[Idx]] implementation
 *
 *     Second, unlike regular arrays it can be genetically created and can be an Array substitute when ClassTag is not available
 *
 *     {{{
 *       def streamToArray[A](s : ~[A]) : Idx.Array[A] = s.to[Idx.Array]
 *
 *       // This generic method will compile and work with any data type and no ClassTag
 *     }}}
 *
 * @def length -> Number of elements
 *
 *     Same as `size`
 *
 */
