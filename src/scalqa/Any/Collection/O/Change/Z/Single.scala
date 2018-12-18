package scalqa; package Any; package Collection; package O; package Change; package Z

private[scalqa] trait Single[A] extends Change[A] with Any.Collection[A] {

  def item: A

  def items: this.type = this

  def size = 1

  def all: ~[A] = item.I.~

}

private[scalqa] object Single {

  class Add[A](val item: A) extends Change.Add[A] with Single[A]

  class Remove[A](val item: A) extends Change.Remove[A] with Single[A]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
