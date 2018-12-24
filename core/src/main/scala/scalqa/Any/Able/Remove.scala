package scalqa; package Any; package Able

trait Remove[A] {

  def remove(v: A): Unit

  def removeAll(s: ~[A]): Unit = s(remove)

  def clear: Unit

  def -=(element: A): this.type = { remove(element); this }

  def -~=(stream: ~[A]): this.type = { removeAll(stream); this }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Remove -> `Generic Remove`
 *
 * @def clear: -> Remove everything
 *
 *    Clears container of all elements
 *
 * @def remove( -> Remove
 *
 *    Removes all elements equal to provided
 *    {{{
 *      // Generic example
 *      val x = Idx.M.make(1, 2, 3, 4, 5)
 *
 *      x.remove(2)
 *      x.remove(3)
 *      x.remove(4)
 *
 *      x.all.lp // Prints: ~(1, 5)
 *    }}}
 * @def removeAll -> Remove all
 *
 *    Removes all elements equal to any in provided stream
 *    {{{
 *      // Generic example
 *      val x = Idx.M.make(1, 2, 3, 4, 5)
 *
 *      x.removeAll(2 <> 4)
 *      x.removeAll(2 ~+ 3 + 4)
 *
 *      x.all.lp // Prints: ~(1, 5)
 *    }}}
 *
 * @def -= -> Remove operator
 *
 *    Removes all elements equal to provided
 *    {{{
 *      // Generic example
 *      val x = Idx.M.make(1, 2, 3, 4, 5)
 *
 *      x =- 2 =- 3 =- 4
 *
 *      x.all.lp // Prints: ~(1, 5)
 *    }}}
 * @def -~= -> Remove all operator
 *
 *    Removes all elements equal to any in provided stream
 *    {{{
 *      // Generic example
 *      val x = Idx.M.make(1, 2, 3, 4, 5)
 *
 *      x =-~ (2 <> 4) =-~ (2 ~+ 3 + 4)
 *
 *      x.all.lp // Prints: ~(1, 5)
 *    }}}
 */
