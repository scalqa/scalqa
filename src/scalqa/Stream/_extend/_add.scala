package scalqa; package Stream; package _extend

trait _add[A] { self: Stream[A] =>

  def +(element: A): ~[A] = Z.extend.add.append(this, element)

  def +~(that: ~[A]): ~[A] = Z.extend.add.appendAll(this, that)

  def append(element: A): ~[A] = Z.extend.add.append(this, element)

  def appendAll(that: ~[A]): ~[A] = Z.extend.add.appendAll(this, that)

  def insertAt(index: Int, element: A): ~[A] = Z.extend.add.insertAt(this, index, element)

  def insertAllAt(index: Int, that: ~[A]): ~[A] = Z.extend.add.insertAt.all(this, index, that)

  def default(element: => A): ~[A] = if (prime) this else Z.A.One(element)

  def unfold(f: Mapping[~[A], A]): ~[A] = Z.extend.flow.unfold(this, f)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _add -> `Stream Extension Interface`
 *
 * @def append( -> Append
 *
 *    Creates a new [[Stream]] with given `element` appended to `this` [[Stream]]
 *
 *    {{{
 *       (1 <> 5).all + 99 + 100.lp
 *
 *       // Output
 *       ~(1, 2, 3, 4, 5, 99, 100)
 *    }}}
 *
 * @def +( -> Append
 *
 *     Same as `append`
 *
 *    Creates a new [[Stream]] with given `element` appended to `this` [[Stream]]
 *
 *    {{{
 *       (1 <> 5).all + 99 + 100.lp
 *
 *       // Output
 *       ~(1, 2, 3, 4, 5, 99, 100)
 *    }}}
 *
 * @def appendAll -> Append all
 *
 *    Creates a new [[Stream]] with `that` [[Stream]] appended to `this` [[Stream]]
 *
 *    {{{
 *       ('1' <> '9').all +~ ('a' <> 'd')  +~ ('A' <> 'D').lp
 *
 *       // Output
 *       ~(1, 2, 3, 4, 5, 6, 7, 8, 9, a, b, c, d, A, B, C, D)
 *    }}}
 *
 * @def +~( -> Append all
 *
 *    Same as `appendAll`
 *
 *    Creates a new [[Stream]] with `that` [[Stream]] appended to `this` [[Stream]]
 *
 *    {{{
 *       ('1' <> '9').all +~ ('a' <> 'd') +~ ('A' <> 'D').lp
 *
 *       // Output
 *       ~(1, 2, 3, 4, 5, 6, 7, 8, 9, a, b, c, d, A, B, C, D)
 *    }}}
 *
 * @def insertAt -> Insert at
 *
 *    Creates a new [[Stream]] with given `element` inserted into `this` [[Stream]]
 *
 *    @param index position in the current stream to insert element at. If index is out of range (including -1), the element is appended
 *
 *    {{{
 *      ('a' <> 'd').all insertAt (2, 'X').lp
 *
 *       // Output
 *       ~(a, b, X, c, d)
 *    }}}
 *
 * @def insertAllAt -> Insert stream at
 *
 *   Creates a new [[Stream]] with `that` [[Stream]] inserted into `this` [[Stream]]
 *
 *   @param index position in the current stream to insert elements at. If index is out of range (including -1), the elements are appended
 *
 *   @example
 *   {{{
 *       ('a' <> 'f').all insertAllAt (3, 'X' <> 'Z').lp
 *
 *       // Output
 *       ~(a, b, c, X, Y, Z, d, e, f)
 *   }}}
 *
 * @def default -> Default element
 *
 *     If `this` [[Stream]] is empty, the given `element` will be appended
 *
 *     Otherwise `this` [[Stream]] elements will not change
 *     {{{
 *       (1 <>> 1).all.default(99).lp // Prints: ~(99)
 *
 *       (1 <>> 5).all.default(99).lp // Prints: ~(1, 2, 3, 4)
 *     }}}
 *
 * @def unfold -> Lazy infinite stream
 *
 *    Lazily unfolds next value with a function taking all prior values
 *
 *    {{{
 *
 *      // Unfoldifg Fibonacci Sequence
 *
 *     (0 ~+ 1).unfold(_.letLast(2).sum).letNext(20).lp
 *
 *      // Output
 *      ~(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181)
 *
 *    }}}
 */
