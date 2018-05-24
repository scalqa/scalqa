package scalqa; package Index; package WO; package Z

private[scalqa] trait LibraryBase[A, IndexWO <: WO[A]] extends Any with W.Z.LibraryBase[A, IndexWO] with O.Z.LibraryBase[A] with Coll.WO.Z.LibraryBase[A, IndexWO] {

  override def asBiMap[B](bm: BiMap[A, B]): WO[B] = new Z.As.BiMapped(This, bm)

  override def asBiMap[B](m: A => B, u: B => A): WO[B] = asBiMap(BiMap.get(m, u))

  override def asSynchronized(lockOpt: Opt[AnyRef] = \/): WO[A] = new Z.As.Synchronized(This, lockOpt)

  protected def This: IndexWO
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
