package scalqa; package Index; package O; package Change; package Z

private[O] trait Single[A] extends Coll.O.Z.Single[A] with Index[A] {

  def index: Int

  def range: Int.Range = index <>!

  def apply(i: Int) = item

}

private[O] object Single {

  class Add[A](val index: Int, val item: A) extends O.Add[A] with Single[A]

  class Remove[A](val index: Int, val item: A) extends O.Remove[A] with Single[A]

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
