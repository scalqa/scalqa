package scalqa; package Idx; package Array

class _Class[A](val real: scala.Array[_ >: A]) extends AnyVal with Idx[A] with Custom.Array.Like[A] {
  protected type TYPE = Idx[A]
  @inline protected def make = new Array[A](_)
  @inline protected def base = real.asInstanceOf[scala.Array[A]]

  @inline def apply(i: Int): A = base(i)
  @inline def update(i: Int, v: A): Unit = base(i) = v
  @inline def size: Int = base.length
  @inline def length: Int = base.length
  override def contains(v: A): Boolean = Custom.Array.Z.contains(base, v)

}

object _Class {

  def fromClass[A](c: Any.Class[A], len: Int) = new Array[A](c.ilk.mkArray(len))

  def make[A](sz: Int)(implicit i: Ilk[A]) = new Array[A](i.mkArray(sz))

  implicit def zzMake[A](v: \/)(implicit i: Ilk[A]) = new Array[A](i.mkArray(0))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
