package scalqa; package Coll; package W; package Z; package As

private[Coll] class Mapped[A, B](real: Coll.W[A], bm: BiMap[A, B]) extends Coll.Z.As.Mapped(real, bm) with W[B] {

  def add(a: B) = real.add(bm.undo(a))

  def remove(a: B) = real.remove(bm.undo(a))

  def clear = real.clear

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/