package scalqa; package Pro; package W; package The; package Z

private[Pro] class AsBiMap[A, B](protected override val real: W[A], bm: BiMap[A, B]) extends Pro.Z.As.Mapped[A, B](real, bm) with W[B] {

  def update(v: B) = real.update(bm.undo(v))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/