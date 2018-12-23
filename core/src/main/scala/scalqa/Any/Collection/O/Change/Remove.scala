package scalqa; package Any; package Collection; package O; package Change

trait Remove[A] extends Change[A] {

  final def name = "Remove"

  def items: Any.Collection[A]

  override def toInfo = super.toInfo += ((if (items.size == 1) "item" else "items", items.all.format(",")))

}

object Remove {

  def make[A](c: Any.Collection[A]): Remove[A] = new Z.Remove(c)

  def make[A](a: A): Remove[A] = new Z.Single.Remove(a)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *  @def items -> Removed items
 *
 *     Items removed from the collection
 *
 */
