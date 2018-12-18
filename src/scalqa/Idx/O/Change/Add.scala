package scalqa; package Idx; package O; package Change

trait Add[A] extends Any.Collection.Add[A] with Change[A] {

  def items: Idx[A]

}

object Add {

  def make[A](r: Idx.Range, items: Idx[A]): Add[A] = new Z.Add[A](r, items)

  def make[A](i: Int, item: A): Add[A] = new Z.Single.Add[A](i, item)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
