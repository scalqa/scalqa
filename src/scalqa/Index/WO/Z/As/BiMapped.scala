package scalqa; package Index; package WO; package Z; package As

private[Index] class BiMapped[A, B](protected override val real: WO[A], bm: BiMap[A, B]) extends Index.W.Z.As.BiMapped[A, B](real, bm) with WO[B] {

  def refreshAt(r: Int.Range) { real.refreshAt(r) }

  def multiChange(ch: W[B] => Any): Unit = real.multiChange(l => ch(l.asBiMap(bm)))

  def onChange(f: Coll[O.Change[B]] => Any): Concurrent.Control = real.onChange(Any.Event.moveId1(f, c => f(c.asMap(_.asMap(bm)))))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/