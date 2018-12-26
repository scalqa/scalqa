package scalqa; package Stream; package Flow; package _extend

trait _map[A] extends Z.Shared[A] { self: Flow[A] =>

  def map[B: Ilk](f: Mapping[A, B]): Flow[B]

  def mapType[B]: Flow[B] = asInstanceOf[Flow[B]]

  def flatMap[B: Ilk](f: Mapping[A, ~[B]]): Flow[B]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _map -> `Stream Conversion Interface`
 *
 *     Conversion changes elements type, but element count always stays the same
 *
 * @def map[ -> Element conversion
 *
 *   Converts every element in the pipeline with given function
 *
 *   {{{
 *       (1 <> 5).all.map( _ / 2.0).lp
 *
 *       // Output
 *       ~(0.5, 1.0, 1.5, 2.0, 2.5)
 *   }}}
 *
 * @def mapType[ -> Element cast
 *
 *   Casts the pipeline elements into the type specified
 *
 *   {{{
 *      def all: ~[Any] = 1 ~+ 2 + 3
 *
 *      all.mapType[Int].lp // Prints: ~(1, 2, 3)
 *   }}}
 *
 *   @note If there is a problem for element casting, it will come up later during pumping action
 *
 * @def flatMap -> Map multiplier
 *
 *   For every existing element, a mapped stream of elements is inserted into the pipeline
 *
 *   Note. The mapping can return an empty stream, in which case total number of elements might even be reduced
 *
 *   @param f function to provide a stream of elements for each existing element
 *
 *   @example
 *   {{{
 *      ~.*(1, 2, 3).flatMap(i => ~.*(i * 10, i * 100, i * 1000)).lp
 *
 *      // Output
 *      ~(10, 100, 1000, 20, 200, 2000, 30, 300, 3000)
 *   }}}
 */
