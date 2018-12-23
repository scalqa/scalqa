package scalqa; package Any; package Collection; package O

trait _Trait[A] extends Any.Collection[A] with Any.O {
  protected type CHANGE <: Change[A]

  def onChange(f: Idx[CHANGE] => Any): EventControl

  protected def onObservableChange(f: () => Any) = onChange(_ => f())

}

object _Trait {

  implicit def zzMake[A](v: \/): O[A] = Idx.Void.asInstanceOf[O[A]]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> `Observable Collection`
 *
 *     Observable collection allows to track all the changes by subscribing for `onChange` event
 *
 * @def onChange -> Change Event
 *
 *     Subscribes listener to be notified of all changes
 *
 *     {{{
 *       val c = Any.Collection.OM.make[Int]
 *
 *       c.onChange(_.all tp "Event: ")
 *
 *       c add 99
 *       c +~= 0 <> 5
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
