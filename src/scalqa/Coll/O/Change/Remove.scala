package scalqa; package Coll; package O; package Change

trait Remove[A] extends Change[A] {

  final def name = "Remove"

  def items: Coll[A]

}

object Remove {

  def getOpt[A](a: ~[A]): Opt[Change[A]] = a.nonEmptyOpt.map(get)

  def get[A](a: ~[A]): Change[A] = new Z.Remove(a.to[Coll])

  def getSingle[A](a: A): Change[A] = new Z.Single.Remove(a)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def name -> "Remove"
 *
 *     Returns "Remove"
 *
 * @def items -> Affected items
 *
 *     Items affected by the change
 */
