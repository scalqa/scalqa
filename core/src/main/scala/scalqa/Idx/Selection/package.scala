package scalqa; package Idx

package object Selection {
  type O[A] = O._Trait[A]

  def make[A](targetIndex: Idx[A], idx: Idx[Int]) = new Selection[A] { def target = targetIndex; def positions = idx }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/