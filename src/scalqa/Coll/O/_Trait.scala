package scalqa; package Coll; package O

trait _Trait[A] extends Coll[A] with Any.O {

  def onChange(f: Coll[Change[A]] => Any): Concurrent.Control

  protected def onObservableChange(f: () => Any) = onChange(_ => f())

}

object _Trait {

  import scala.language.implicitConversions

  implicit def zzLibrary[A](c: O[A]) = new _library(c)

  implicit def zzGet[A](v: \/.type): O[A] = Index.Void.cast

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> '''Observable Collection'''
 *
 *     Observable collection allows to track all the changes by subscribing for ''onChange'' event
 *
 * @def onChange -> Change Event
 *
 *     Subscribes listener to be notified of all changes
 *
 *     {{{
 *       val c = Coll.WO.get[Int]
 *
 *       c.onChange(_.all tp "Event: ")
 *
 *       c add 99
 *       c =+~ 0 <> 5
 *       c =-~ 3 <> 5
 *
 *       c.all.lp
 *
 *       // Output
 *       Event: ---- ----
 *              name item
 *              ---- ----
 *              Add  99
 *              ---- ----
 *       Event: ---- ----
 *              name item
 *              ---- ----
 *              Add  0
 *              Add  1
 *              Add  2
 *              Add  3
 *              Add  4
 *              Add  5
 *              ---- ----
 *       Event: ------ ----
 *              name   item
 *              ------ ----
 *              Remove 3
 *              Remove 4
 *              Remove 5
 *              ------ ----
 *       ~(2, 1, 0, 99)
 *     }}}
 */
