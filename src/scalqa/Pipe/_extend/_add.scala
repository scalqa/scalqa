package scalqa; package Pipe; package _extend

trait _add[A] extends __[A] with Any._library._pipe.Like[A] {

  override def ~(element: A): ~[A] = new Z.append.tilde(This, element)

  override def ~~(that: ~[A]): ~[A] = if (that.isVoid) This else new Z.append.tilde.all(This, that)

  def ~@(index: Int, element: A): ~[A] = if (index < 0) this.~(element) else new Z.append.tilde.allAt(This, index, element.I.~)

  def ~~@(index: Int, that: ~[A]): ~[A] = if (index < 0) this.~~(that) else new Z.append.tilde.allAt(This, index, that)

  def default(element: => A): ~[A] = This.nonEmptyOpt or element.I.~

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _add -> '''Data Extension Interface'''
 *
 * @def ~( -> Append
 *
 *    Creates a new [[Pipe]] with given ''element'' appended to ''this'' [[Pipe]]
 *
 *    {{{
 *       (1 <> 5).all ~ 99 ~ 100.lp
 *
 *       // Output
 *       ~(1, 2, 3, 4, 5, 99, 100)
 *    }}}
 *
 * @def ~~( -> Append pipe
 *
 *    Creates a new [[Pipe]] with ''that'' [[Pipe]] appended to ''this'' [[Pipe]]
 *
 *    {{{
 *       ('1' <> '9').all ~~ ('a' <> 'd')  ~~ ('A' <> 'D').lp
 *
 *       // Output
 *       ~(1, 2, 3, 4, 5, 6, 7, 8, 9, a, b, c, d, A, B, C, D)
 *    }}}
 *
 * @def ~@ -> Insert at
 *
 *    Creates a new [[Pipe]] with given ''element'' inserted into ''this'' [[Pipe]]
 *
 *    @param index position in the current pipe to insert element at. If index is out of range (including -1), the element is appended
 *
 *    {{{
 *      ('a' <> 'd').all ~@ (2, 'X').lp
 *
 *       // Output
 *       ~(a, b, X, c, d)
 *    }}}
 *
 * @def ~~@ -> Insert pipe at
 *
 *    Creates a new [[Pipe]] with ''that'' [[Pipe]] inserted into ''this'' [[Pipe]]
 *
 *    @param index position in the current pipe to insert elements at. If index is out of range (including -1), the elements are appended
 *
 *   @example
 *   {{{
 *       ('a' <> 'f').all ~~@ (3, 'X' <> 'Z').lp
 *
 *       // Output
 *       ~(a, b, c, X, Y, Z, d, e, f)
 *   }}}
 *
 * @def default -> Default element
 *
 *     If ''this'' [[Pipe]] is empty, the given ''element'' will be appended
 *
 *     Otherwise ''this'' [[Pipe]] elements will not change
 *     {{{
 *       (1 <>> 1).all.default(99).lp // Prints: ~(99)
 *
 *       (1 <>> 5).all.default(99).lp // Prints: ~(1, 2, 3, 4)
 *     }}}
 */
