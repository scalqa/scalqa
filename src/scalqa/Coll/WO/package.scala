package scalqa; package Coll

package object WO {
  type The[A] = The._Class[A]

  def get[A]: WO[A] = new The

  def get[A](vs: A*): WO[A] = get[A].I(_ =+~ vs.all)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def get[A]: -> Default
 *
 *    Creates [[Coll.WO]]
 *
 *    {{{   val x = Coll.WO.get[Int] // Creates Writable Observable Coll of Ints  }}}
 *
 * @def get[A]( -> With values
 *
 *    Creates [[Coll.WO]] with specified values
 *
 *    Note. Coll elements order should be considered indeterminate
 *    {{{
 *       val c = Coll.WO.get(3, 6, 9) // Creates Writable Observable Coll of Ints
 *       c.all.lp                     // Prints: ~(9, 6, 3)
 *    }}}
 */
