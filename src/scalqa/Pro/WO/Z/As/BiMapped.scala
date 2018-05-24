package scalqa; package Pro; package WO; package Z; package As

private[Pro] class BiMapped[A, B](protected override val real: WO[A], bm: BiMap[A, B]) extends O.Z.As.Mapped[A, B](real, bm) with WO[B] {

  def update(v: B) = real.update(bm.undo(v))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/