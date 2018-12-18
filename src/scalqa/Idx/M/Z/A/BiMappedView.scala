package scalqa; package Idx; package M; package Z; package A

private[Idx] class BiMappedView[A, B](protected override val real: M[A], mpr: BiMap[A, B]) extends Idx.Z.A.MappedView[A, B](real, mpr.apply) with M[B] {

  def addAt(i: Int, e: B): Unit = real.addAt(i, mpr.undo(e))

  def update(i: Int, e: B): Unit = real.update(i, mpr.undo(e))

  def removeAt(r: Idx.Range): Unit = real.removeAt(r)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
