package scalqa; package Any; package Datum

package object Double {
  type Ordered[A <: Ordered[A]] = Ordered._Trait[A]
  type Computable[A <: Computable[A]] = Computable._Trait[A]
  type Number[A <: Number[A]] = Number._Trait[A]

  def undo(v: Double[_]) = _Trait.real(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
