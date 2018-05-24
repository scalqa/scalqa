package scalqa; package Coll; package O; package Z

private[scalqa] trait Single[A] extends O.Change[A] with Coll[A] {

  def item: A

  def items: this.type = this

  def size = 1

  def all: ~[A] = item.I.~

}

private[scalqa] object Single {

  class Add[A](val item: A) extends O.Add[A] with Single[A]

  class Remove[A](val item: A) extends O.Remove[A] with Single[A]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
