package scalqa; package Custom; package Proxy

private[scalqa] trait List[A] extends java.util.AbstractList[A] with Any.Wrap[java.util.List[A]] {

  def make(i: Int) = real.get(i)

  def size = real.size

  override def add(i: Int, v: A) = { real.add(i, v) }

  override def add(v: A): Boolean = real.add(v)

  override def addAll(i: Int, v: java.util.Collection[_ <: A]): Boolean = real.addAll(i, v)

  override def addAll(v: java.util.Collection[_ <: A]): Boolean = real.addAll(v)

  override def clear = real.clear 

  override def remove(i: Int): A = real.remove(i)

  override def remove(v: Any): Boolean = real.remove(v)

  override def removeAll(v: java.util.Collection[_]): Boolean = real.removeAll(v)

  override def retainAll(v: java.util.Collection[_]): Boolean = real.retainAll(v)

  override def set(i: Int, v: A): A = real.set(i, v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
