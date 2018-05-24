package scalqa; package Pro; package W; package Z

private[scalqa] trait LibraryBase[A] extends Any with Pro.Z.LibraryBase[A] {

  def updateIfVoid(v: A) = if (This().isVoid) This() = v

  def asBiMap[B](bm: BiMap[A, B]): W[B] = new The.Z.AsBiMap(This, bm)

  def bindTo(z: O[_ <: A]): Concurrent.Control = z.onChange(() => This() = z())

  def bindTo[B <: A](z: Index.Selection.O[B], dflt: A): Concurrent.Control = z.onChange(This() = z.positions.opt(0).map(z(_)) orElse dflt)

  protected def This: W[A]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
