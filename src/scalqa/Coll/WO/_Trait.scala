package scalqa; package Coll; package WO

trait _Trait[A] extends W[A] with O[A] {
  protected type COLL_W <: W[A]

  def replaceAll(p: ~[A]) { multiChange(c => { c.clear; p(c.add) }) }

  def multiChange(changeInterface: COLL_W => Any)

}

object _Trait {

  import scala.language.implicitConversions

  implicit def zzLibrary[A](c: WO[A]) = new _library[A, c.type](c);

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> '''Writable Observable Collection'''
 *
 * @def replaceAll -> Replaces all elements
 *
 *    Removes all elements and inserts new ones creating just one change event
 *    {{{
 *      val c: Coll.WO[Int] = (1 <> 3).all.to[Coll.WO]
 *      c.onChange(_.all.tp("Event: "))
 *
 *      c.all.lp.lp
 *      c.replaceAll(10 <> 12)
 *      c.all.lp
 *
 *      // Output
 *      ~(3, 2, 1)
 *
 *      Event: ------ -----
 *             name   item
 *             ------ -----
 *             Remove 3,2,1
 *             Add    10
 *             Add    11
 *             Add    12
 *              ------ -----
 *      ~(12, 11, 10)
 *    }}}
 *
 * @def multiChange -> Transactional change
 *
 *    Allows to do many changes to the collection, while only one change event will be created and propagated
 *    {{{
 *      val c = Coll.WO.get[Int]
 *
 *      c.onChange(_.all.tp("Event: "))
 *
 *      c.multiChange(ch => {
 *         ch add 99
 *         ch =+~ 0 <> 5
 *         ch =-~ 3 <> 4
 *         ch =+ 100
 *      })
 *
 *      c.all.lp
 *
 *      // Output
 *      Event: ------ ----
 *             name   item
 *             ------ ----
 *             Add    99
 *             Add    0
 *             Add    1
 *             Add    2
 *             Add    3
 *             Add    4
 *             Add    5
 *             Remove 3
 *             Remove 4
 *             Add    100
 *             ------ ----
 *      ~(100, 5, 2, 1, 0, 99)
 *    }}}
 */
