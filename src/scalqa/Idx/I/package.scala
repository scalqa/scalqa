package scalqa; package Idx

package object I {

  def make[A](vs: A*)(implicit i: Ilk[A]): I[A] = vs match {
    case a: scala.collection.mutable.WrappedArray[A] => i.mkValue(a.array)
    case _ => i.mkValue(vs.all)
  }

  def make[A](v: scala.Array[A])(implicit i: Ilk[A]): I[A] = i.mkValue(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 *
 */
