package scalqa; package Index; package O; package Z; package As

private[scalqa] class UnsupportedWO[A](l: Index.O[A]) extends O.The.Proxy[A](l) with Index.W.Z.The.Unsupported[A] with WO[A] {

  def multiChange(ch: W[A] => Any) = Fail.unsupported()

  def refreshAt(i: Int.Range): Unit = Fail.unsupported()

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/