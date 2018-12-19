package scalqa; package Idx; package O; package Z; package A

private[scalqa] class MappedView[A, B](protected override val real: O[A], map: A => B) extends Idx.Z.A.MappedView[A, B](real, map) with O[B] {

  def onChange(f: Idx[Change[B]] => Any): EventControl = real.onChange(EventControl.moveId1(f, _.asMappedView(_.asMappedView(map))))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
