package scalqa; package Pipe; package _extend

trait _convert[A] extends Flow._extend._convert[A] with __[A] {

  override def map[B](f: A => B): Pipe[B] = new Z.convert.map(This, f)

  override def mapCast[B]: Pipe[B] = This.cast[~[B]]

  def mapIdx[B](f: (Int, A) => B, start: Int = 0): Pipe[B] = Z.convert.map.idx(This, f, start)

  def mapFor(filter: A => Boolean, convert: A => A): Pipe[A] = map(v => if (filter(v)) convert(v) else v)

  def swap[B](f: => B): Pipe[B] = new Z.convert.swap(This, f)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _convert -> '''Data Conversion Interface'''
 *
 *   Data conversion changes elements type, but element count always stays the same
 *
 * @def mapIdx -> Indexed element conversion
 *
 *   Converts every element in the pipeline with given function
 *
 *   @param f the conversion function which also accepts element index in the sequence
 *   @param start the starting value of indexing
 *   @example
 *   {{{
 *     ('A' <> 'G').all.mapIdx(_ + "=" + _, 1).lp
 *
 *     // Output
 *     ~(1=A, 2=B, 3=C, 4=D, 5=E, 6=F, 7=G)
 *   }}}
 *
 * @def mapFor -> Conditional conversion
 *
 *   Converts elements selected by filter function
 *
 *   The rest of elements are passed as is
 *
 *   Note: This method does not change type
 *
 *   @param filter selecting conversion elements.
 *   @param convert conversion function.
 *
 *   {{{
 *     ("abc" ~ "d" ~ "e" ~ "" ~ "fg").mapFor(_.length < 2, _.padEndTo(3, "x")).lp
 *
 *     // Output
 *     ~(abc, dxx, exx, xxx, fg)
 *   }}}
 *
 * @def swap -> Valueless conversion
 *
 *   Swaps each element with the one provided by the function
 *
 *   Note. The function does not even consider original elements
 *
 *   @example
 *   {{{
 *       // Create a Pipe of 10 random Ints
 *       (1 <> 10).all.swap(Random.intBelow(100)).lp
 *
 *       // Possible Output
 *       ~(12, 71, 7, 30, 79, 38, 44, 28, 39, 45)
 *   }}}
 */
