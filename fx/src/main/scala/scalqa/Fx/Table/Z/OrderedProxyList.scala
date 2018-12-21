package scalqa; package Fx; package Table; package Z

private[Table] class OrderedProxyList[A](l: Idx.OM[A]) extends Idx.OM.Z.A.OrderedProxy[A](l)(\/) {

  override def fireChange(c: Idx[Idx.Change[A]]): Unit = super.fireChange(c)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
