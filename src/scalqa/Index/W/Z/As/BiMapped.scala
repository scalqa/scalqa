package scalqa; package Index; package W; package Z; package As

private[Index] class BiMapped[A, B](protected override val real: W[A], mpr: BiMap[A, B]) extends Index.Z.As.Mapped[A, B](real, mpr.apply) with W[B] {

  def addAt(i: Int, e: B): Unit = real.addAt(i, mpr.undo(e))

  def replaceAt(i: Int, e: B): Unit = real.replaceAt(i, mpr.undo(e))

  def removeAt(r: Int.Range): Unit = real.removeAt(r)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/