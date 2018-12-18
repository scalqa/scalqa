package scalqa; package Custom; package Proxy; package Idx

trait Like[A] extends scalqa.Idx[A] with Any.Wrap[scalqa.Idx[A]] {

  override def apply(i: Int) = real.apply(i)

  override def size = real.size

  override def all = real.all
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
