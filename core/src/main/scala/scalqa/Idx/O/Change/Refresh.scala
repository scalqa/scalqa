package scalqa; package Idx; package O; package Change

trait Refresh[A] extends Change[A] {

  final def name = "Refresh"

}

object Refresh {

  def make[A](r: Idx.Range): Refresh[A] = new Z.Refresh[A](r)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def name -> "Refresh"
 *
 *     Returns "Refresh"
 *
 */
