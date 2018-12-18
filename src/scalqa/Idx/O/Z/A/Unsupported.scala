package scalqa; package Idx; package O; package Z; package A

private[scalqa] trait Unsupported[A] extends Idx.O[A] {

  def onChange(on: Idx[Change[A]] => Any): App.Event = \/

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
