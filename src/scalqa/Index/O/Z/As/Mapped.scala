package scalqa; package Index; package O; package Z; package As

private[scalqa] class Mapped[A, B](protected override val real: O[A], map: A => B) extends Index.Z.As.Mapped[A, B](real, map) with O[B] {

  def onChange(f: Coll[O.Change[B]] => Any): Concurrent.Control = { val m = map; real.onChange(Any.Event.moveId1(f, c => f(c.asMap(_.asMap(m))))) }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/