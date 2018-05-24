package scalqa; package Coll

package object W {
  type The[A] = W.The._Class[A]

  def get[A]: W[A] = new The

  def get[A](vs: A*)(implicit t: Tag[A]): W[A] = get[A].I(_ =+~ vs.all)

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
 *    Creates [[Coll.W]]
 *
 *    {{{   val x = Coll.W.get[Int] // Creates Writable Coll of Ints  }}}
 *
 * @def get[A]( -> With values
 *
 *    Creates [[Coll.W]] with specified values
 *
 *    Note. Coll elements order should be considered indeterminate
 *    {{{
 *       val c = Coll.W.get(3, 6, 9) // Creates Writable Coll of Ints
 *       c.all.lp                    // Prints: ~(9, 6, 3)
 *    }}}
 */
