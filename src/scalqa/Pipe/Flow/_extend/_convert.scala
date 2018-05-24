package scalqa; package Pipe; package Flow; package _extend

trait _convert[A] {

  def map[B](f: A => B): Flow[B]

  def mapCast[B]: Flow[B] = this.cast[Flow[B]]

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
 *     Conversion changes elements type, but element count always stays the same
 *
 * @def map[ -> Element conversion
 *
 *   Converts every element in the pipeline with given function
 *
 *   @example
 *   {{{
 *       (1 <> 5).all.map( _ / 2.0).lp
 *
 *       // Output
 *       ~(0.5, 1.0, 1.5, 2.0, 2.5)
 *   }}}
 *
 * @def mapCast[ -> Element cast
 *
 *   Casts the pipeline elements into the type specified
 *
 *   {{{
 *      def all: ~[Any] = 1 ~ 2 ~ 3
 *
 *      all.mapCast[Int].lp // Prints: ~(1, 2, 3)
 *   }}}
 *
 *   @note If there is a problem for element casting, it will come up later during pumping action
 */
