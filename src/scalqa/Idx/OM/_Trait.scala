package scalqa; package Idx; package OM

trait _Trait[A] extends M[A] with O[A] {

  def refreshAt(r: Idx.Range)

  def multiChange(changeInterface: M[A] => Any)

  def replaceAll(s: ~[A]) { multiChange(c => { c.clear; s(c.add) }) }

}

private object _Trait extends Util.Void.Setup.Typed[OM](Z.A.Void) {

  implicit def zzMake[A: Ilk](v: NEW.type): OM[A] = make[A]

  implicit def zzLibrary[A](c: OM[A]) = new _library._Class[A, c.type](c);

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> `Observable Mutable Idx Collection`
 *
 * @def refreshAt(r: Idx.Range) -> Refresh range
 *
 *     Two things happen:
 *
 *       - If any element at the specified range implements [[Any.Able.Refresh]], its `refresh` method is executed
 *       - An event containing [[Idx.Refresh]] is propagated to `this` Idx listeners.
 *
 *     {{{
 *      val c: Idx.OM[Int] = (1 <> 20).all.to[Idx.OM]
 *
 *      c.onChange(_.all.tp)
 *
 *      c.refreshAt(10 <> 15)
 *
 *      // Output
 *
 *      ------- ---------
 *      name    range
 *      ------- ---------
 *      Refresh 10 <>> 16
 *      ------- ---------
 *   }}}
 *
 * @def replaceAll -> Replaces all elements
 *
 *    Removes all elements and inserts new ones creating just one change event
 *    {{{
 *      val c: Any.Collection.OM[Int] = (1 <> 3).all.to[Any.Collection.OM]
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
 *      val c = Any.Collection.OM.make[Int]
 *
 *      c.onChange(_.all.tp("Event: "))
 *
 *      c.multiChange(ch => {
 *         ch add 99
 *         ch +~= 0 <> 5
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
 *
 */
