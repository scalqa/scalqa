package scalqa; package Any; package Collection; package O; package Change

trait Add[A] extends Change[A] {

  final def name = "Add"

  def items: Any.Collection[A]

  override def toInfo = super.toInfo += ((if (items.size == 1) "item" else "items", items.all.format(",")))

}

object Add {

  def make[A](c: Any.Collection[A]): Add[A] = new Z.Add(c)

  def make[A](a: A): Add[A] = new Z.Single.Add(a)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def items -> Added items
 *
 *     Items added to the collection
 *
 *
 */
