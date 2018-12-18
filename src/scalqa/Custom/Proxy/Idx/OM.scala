package scalqa; package Custom; package Proxy; package Idx

trait OM[A] extends scalqa.Idx.OM[A] with M.Like[A] with O.Like[A] with Any.Wrap[scalqa.Idx.OM[A]] {

  def refreshAt(i: scalqa.Idx.Range) = real.refreshAt(i)

  def multiChange(ch: scalqa.Idx.M[A] => Any) = real.multiChange(ch)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
