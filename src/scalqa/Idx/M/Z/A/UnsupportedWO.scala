package scalqa; package Idx; package M; package Z; package A

private[Idx] class UnsupportedWO[A](l: Idx.M[A]) extends Custom.Proxy.Idx.M[A](l) with Idx.O.Z.A.Unsupported[A] with OM[A] {

  def multiChange(ch: M[A] => Any) = App.Fail.unsupported()

  def refreshAt(i: Idx.Range): Unit = App.Fail.unsupported()

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
