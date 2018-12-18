package scalqa; package Idx; package OM; package Z; package A

private[Idx] class BiMappedView[A, B](protected override val real: OM[A], bm: BiMap[A, B]) extends Idx.M.Z.A.BiMappedView[A, B](real, bm) with OM[B] {

  def refreshAt(r: Idx.Range) { real.refreshAt(r) }

  def multiChange(ch: M[B] => Any): Unit = real.multiChange(l => ch(l.asBiMappedView(bm)))

  def onChange(f: Idx[O.Change[B]] => Any): App.Event = real.onChange(App.Event.moveId1(f, _.asMappedView(_.asMappedView(bm))))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
