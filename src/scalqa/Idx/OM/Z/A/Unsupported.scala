package scalqa; package Idx; package OM; package Z; package A

private[Idx] trait Unsupported[A] extends OM[A] with M.Z.A.Unsupported[A] with O.Z.A.Unsupported[A] {

  def refreshAt(i: Idx.Range): Unit = App.Fail.unsupported()

  def multiChange(ch: M[A] => Any): Unit = App.Fail.unsupported()

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
