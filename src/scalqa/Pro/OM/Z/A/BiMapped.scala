package scalqa; package Pro; package OM; package Z; package A

private[Pro] class BiMapped[A, B](protected override val real: OM[A], bm: BiMap[A, B]) extends O.Z.A.Mapped[A, B](real, bm) with OM[B] {

  def update(v: B) = real.update(bm.undo(v))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
