package scalqa; package Idx; package M; package Z; package A

private[Idx] class Sealable[A](list: M[A]) extends Custom.Proxy.Idx.M.Like[A] with Any.Able.Seal {

  override def size = list.size

  override def apply(i: Int) = list(i)

  override def all = list.all

  protected def real = { _failIfSealed; list }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
