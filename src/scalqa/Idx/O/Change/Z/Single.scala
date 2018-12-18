package scalqa; package Idx; package O; package Change; package Z

private[O] trait Single[A] extends Change[A] with Idx[A] {

  def index: Int

  def item: A

  def range: Idx.Range = index <>!

  def apply(i: Int) = item

  def size = 1

  def items: Idx[A] = item.I.to[Idx]

}

private[O] object Single {

  class Add[A](val index: Int, val item: A) extends Change.Add[A] with Single[A]

  class Remove[A](val index: Int, val item: A) extends Change.Remove[A] with Single[A]

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
