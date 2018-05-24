package scalqa; package Index; package O; package Change

trait Remove[A] extends Coll.O.Remove[A] {

  def range: Int.Range

  def items: Index[A]

}

object Remove {

  def get[A](r: Int.Range, items: Index[A]): Remove[A] = new Z.Remove[A](r, items)

  def get[A](i: Int, item: A): Remove[A] = new Z.Single.Remove[A](i, item)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def range -> Affected range
 *
 *     Range of items affected
 *
 */
