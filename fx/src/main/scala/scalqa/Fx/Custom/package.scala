package scalqa; package Fx

package object Custom {
  type IdxO[A] = IdxO._Class[A]
  type IdxOM[A] = IdxOM._Class[A]

  def wrapFxThreadEvents[A](v: Idx.O[A]): Idx.O[A] = new ObservableList.O.Z.FxThreadEvents(v)
  def wrapFxThreadEvents[A](v: Idx.OM[A]): Idx.OM[A] = new ObservableList.OM.Z.FxThreadEvents(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
