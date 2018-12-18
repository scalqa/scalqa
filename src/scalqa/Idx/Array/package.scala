package scalqa; package Idx

package object Array {
  type Buffer[A] = Buffer._Class[A]

  def fromClass[A](c: Any.Class[A], len: Int) = new Array[A](c.ilk.mkArray(len))

  def make[A](sz: Int)(implicit i: Ilk[A]) = new Array[A](i.mkArray(sz))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
