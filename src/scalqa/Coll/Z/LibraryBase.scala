package scalqa; package Coll; package Z

private[scalqa] trait LibraryBase[A] extends Any {

  @inline def isEmpty = This.size == 0

  def asMap[B](f: A => B): Coll[B] = new Z.As.Mapped[A, B](This, f)

  // --------------------------------------------------------
  protected def This: Coll[A]
  protected def size = This.size
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def isEmpty -> Empty check
 *
 *     This is a semantic shortcut for 'size==0'
 *
 *     No efficiencies will be realized
 *
 * @def asMap -> Mapped view
 *
 *   Creates a type mapped view of ''this'' collection
 *   {{{
 *       val coll: Coll.W[Int] = (0 <>> 5).all.to[Coll.W]
 *
 *       val view: Coll[Char] = coll.asMap(i => ('a' + i).toChar)
 *
 *       view.all.lp
 *
 *       coll.clear
 *       coll =+~ (5 <>> 10)
 *
 *       view.all.lp
 *
 *       // Output
 *       ~(e, d, c, b, a)
 *       ~(j, i, h, g, f)
 *   }}}
 */
