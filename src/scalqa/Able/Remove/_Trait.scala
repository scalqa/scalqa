package scalqa; package Able; package Remove

trait _Trait[A] extends Any with Target {

  def =-(element: A): TARGET = { _remove(element); _target }

  def =-~(pipe: ~[A]): TARGET = { _removeAll(pipe); _target }

  protected def _remove(v: A): Unit
  protected def _removeAll(a: ~[A]): Unit = a(_remove)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> '''Generic Remove'''
 *
 * @def =-( -> Remove
 *
 *    Removes all elements equal to provided
 *    {{{
 *      // Generic example
 *      val x = Index.W.get(1, 2, 3, 4, 5)
 *
 *      x =- 2 =- 3 =- 4
 *
 *      x.all.lp // Prints: ~(1, 5)
 *    }}}
 * @def =-~ -> Remove all
 *
 *    Removes all elements equal to pipe provided
 *    {{{
 *      // Generic example
 *      val x = Index.W.get(1, 2, 3, 4, 5)
 *
 *      x =-~ (2 <> 4) =-~ (2 ~ 3 ~ 4)
 *
 *      x.all.lp // Prints: ~(1, 5)
 *    }}}
 */
