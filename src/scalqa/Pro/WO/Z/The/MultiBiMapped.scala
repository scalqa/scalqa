package scalqa; package Pro; package WO; package Z; package The

private[Pro] class MultiBiMapped[A, B](protected override val real: WO[A], bm: BiMap[A, B], dependencies: ~[Any.O]) extends O.Z.The.Multi.Mapped[A, B](real, bm, dependencies) with WO[B] {

  def update(v: B) = real() = bm.undo(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/