package scalqa; package Able; package Remove

trait At[CONTAINER] extends Any {

  def =-@(position: Int): CONTAINER = { _removeRange(position <>!); _target }

  def =-@(range: Int.Range): CONTAINER = { _removeRange(range); _target }

  protected def _removeRange(r: Int.Range): Unit
  protected def _target: CONTAINER

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait At -> '''Generic Positional Remove'''
 *
 * @def =-@(p -> Remove at position
 *
 *    Removes element at given position
 *    {{{
 *      // Generic example
 *      val x = ('A' <> 'D').all.to[Index.W]
 *
 *      x =-@ 2 =-@ 1
 *
 *      x.all.lp // Prints: ~(A, D)
 *    }}}
 * @def =-@(r -> Remove range
 *
 *    Removes elements at given range
 *    {{{
 *      // Generic example
 *      val x = (0 <> 10).all.to[Index.W]
 *
 *      x =-@ (7 <> 8) =-@ (2 <> 4)
 *
 *      x.all.lp // Prints: ~(0, 1, 5, 6, 9, 10)
 *    }}}
 */
