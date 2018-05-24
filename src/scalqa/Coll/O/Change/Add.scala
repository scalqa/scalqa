package scalqa; package Coll; package O; package Change

trait Add[A] extends Change[A] {

  final def name = "Add"

  def items: Coll[A]

}

object Add {

  def getOpt[A](a: ~[A]): Opt[Change[A]] = a.nonEmptyOpt.map(get)

  def get[A](a: ~[A]): Change[A] = new Z.Add(a.to[Coll])

  def getSingle[A](a: A): Change[A] = new Z.Single.Add(a)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def name -> "Add"
 *
 *     Returns "Add"
 *
 * @def items -> Affected items
 *
 *     Items affected by the change
 */
