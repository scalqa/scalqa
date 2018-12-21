package scalqa; package Idx; package O; package Change

trait Remove[A] extends Any.Collection.Remove[A] with Change[A] {

  def items: Idx[A]

}

object Remove {

  def make[A](r: Idx.Range, items: Idx[A]): Remove[A] = new Z.Remove[A](r, items)

  def make[A](i: Int, item: A): Remove[A] = new Z.Single.Remove[A](i, item)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 */
