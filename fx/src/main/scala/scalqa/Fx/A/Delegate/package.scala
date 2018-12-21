package scalqa; package Fx; package A

package object Delegate {
  type Gui = Gui._Trait
  type Data[A <: Data[A, B], B <: AnyRef] = Data._Trait[A, B]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
