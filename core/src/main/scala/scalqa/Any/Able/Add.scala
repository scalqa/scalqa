package scalqa; package Any; package Able

trait Add[@specialized(DATA) A] {

  def add(v: A): Unit

  def addAll(stream: ~[A]): Unit = stream(add)

  def +=(v: A): this.type = { add(v); this }

  def +~=(stream: ~[A]): this.type = { addAll(stream); this }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Add -> `Generic Add`
 *
 *     Adding elements to some target container
 *
 * @def add( -> Add
 *
 *    Adds given `v` to target container
 *    {{{
 *      // Generic example
 *      val x = Idx.M.make(1, 2, 3)
 *
 *       x add 4
 *       x add 5
 *       x add 6
 *
 *       x.all.lp // Prints: ~(1, 2, 3, 4, 5, 6)
 *    }}}
 *
 * @def += -> Add operator
 *
 *    Calls add and returns container
 *    {{{
 *      // Generic example
 *      val x = Idx.M.make(1, 2, 3)
 *
 *       x += 4 += 5 += 6
 *
 *       x.all.lp // Prints: ~(1, 2, 3, 4, 5, 6)
 *    }}}
 *
 * @def addAll -> Add Stream
 *
 *    Adds given `stream` elements to target container
 *    {{{
 *      // Generic example
 *      val x = Idx.M.make(1, 2, 3)
 *
 *       x addAll 4 <> 6
 *       x addAll 7 ~+ 8 + 9
 *
 *       x.all.lp // ~(1, 2, 3, 4, 5, 6, 7, 8, 9)
 *    }}}
 *
 * @def +~= -> Add Stream operator
 *
 *    Calls addAll and returns container
 *    {{{
 *      // Generic example
 *      val x = Idx.M.make(1, 2, 3)
 *
 *      x +~= (4 <> 6) +~= (7 ~+ 8 + 9)
 *
 *      x.all.lp // ~(1, 2, 3, 4, 5, 6, 7, 8, 9)
 *    }}}
 */
