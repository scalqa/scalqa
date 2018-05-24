package scalqa; package Sorting; package Z; package The

private[Sorting] class Mapped[A, B](o: Sorting[A], f: B => A) extends Sorting[B] {

  def position(x: B, y: B) = o(f(x), f(y));

  override val voidPosition = o.voidPosition

  Assert(o.voidPosition != null)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/