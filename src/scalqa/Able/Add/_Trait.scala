package scalqa; package Able; package Add

trait _Trait[A] extends Any with Target {

  def =+(element: A): TARGET = { _add(element); _target }

  def =+~(pipe: ~[A]): TARGET = { if (!pipe.isVoid) _addAll(pipe); _target }

  protected def _add(v: A): Unit
  protected def _addAll(a: ~[A]): Unit = a(_add)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> '''Generic Add'''
 * 
 * 		Defines operations to add value to some target container
 *
 * @def =+( -> Add
 *
 *    Adds given ''element'' to target container
 *    {{{
 *      // Generic example
 *      val x = Index.W.get(1, 2, 3)
 *
 *       x =+ 4 =+ 5 =+ 6
 *
 *       x.all.lp // Prints: ~(1, 2, 3, 4, 5, 6)
 *    }}}
 * @def =+~ -> Add all
 *
 *    Adds given ''pipe'' elements to target container
 *    {{{
 *      // Generic example
 *      val x = Index.W.get(1, 2, 3)
 *
 *       x =+~ (4 <> 6) =+~ (7 ~ 8 ~ 9)
 *
 *       x.all.lp // ~(1, 2, 3, 4, 5, 6, 7, 8, 9)
 *    }}}
 */
