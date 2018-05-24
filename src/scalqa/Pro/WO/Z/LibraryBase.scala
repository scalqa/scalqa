package scalqa; package Pro; package WO; package Z

private[scalqa] trait LibraryBase[A] extends Any with W.Z.LibraryBase[A] with O.Z.LibraryBase[A] {

  override def asBiMap[B](bm: BiMap[A, B]): WO[B] = new Z.As.BiMapped[A, B](This, bm)

  def asBiMap[B](bm: BiMap[A, B], p: ~[Any.O]): WO[B] = p.nonEmptyOpt.map(a => new Z.The.MultiBiMapped[A, B](This, bm, a)) orElse asBiMap(bm)

  protected def This: WO[A]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
