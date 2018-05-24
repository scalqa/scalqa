package scalqa; package Coll; package WO; package Z

private[scalqa] trait LibraryBase[A, CollWO <: WO[A]] extends Any with O.Z.LibraryBase[A] with W.Z.LibraryBase[A, CollWO] {

  protected override def _removeAll(p: ~[A]): Unit = This.multiChange(c => p(c.=-))
  protected override def _addAll(p: ~[A]): Unit = This.multiChange(c => p(c.=+))
  protected def This: CollWO

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
