package scalqa; package Able; package Add

trait At[A] extends Any with Add[A] {

  def =+@(position: Int, element: A): TARGET = { _addAt(position, element); _target }

  def =+~@(position: Int, a: ~[A]): TARGET = { if (!a.isVoid) _addAllAt(position, a); _target }

  @inline protected override def _add(v: A) = _addAt(size, v)
  @inline protected override def _addAll(a: ~[A]) = _addAllAt(size, a)

  protected def size: Int
  protected def _addAt(i: Int, v: A): Unit
  protected def _addAllAt(i: Int, a: ~[A]): Unit = a.applyIdx(_addAt, i)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait At -> '''Generic Positional Add'''
 *
 *    Defines operations to add value to some target container at particular position
 *
 * @def =+@ -> Add at position
 *
 *    Adds ''element'' at given ''position''
 *    {{{
 *       // Generic example
 *       val x = ('A' <> 'F').all.to[Index.W]
 *
 *       x =+@ (3, 'd') =+@ (2, 'c') =+@ (1, 'b') =+@ (0, 'a')
 *
 *       x.all.lp // Prints: ~(a, A, b, B, c, C, d, D, E, F)
 *    }}}
 *
 * @def =+~@ -> Add all at position
 *
 *    Adds pipe ''elements'' at given ''position''
 *    {{{
 *       // Generic example
 *       val x = ('A' <> 'F').all.to[Index.W]
 *
 *       x =+~@ (4, 'e' <> 'g') =+~@ (1, 'b' ~ 'c' ~ 'd')
 *
 *       x.all.lp // Prints: ~(A, b, c, d, B, C, D, e, f, g, E, F)
 *    }}}
 */
