package scalqa; package Stream; package _extend

trait _map[A] extends Flow._extend._map[A] { self: Stream[A] =>

  override def map[B](f: Mapping[A, B])(implicit i: Ilk[B]): Stream[B] = Z.extend.map.map.refRef[A, B](this, f, i)

  override def mapType[B]: Stream[B] = this.asInstanceOf[Stream[B]]

  def mapRef[B](f: Mapping[A, B])(implicit i: Ilk[B]): ~[B] = Z.extend.map.map.refRef[A, B](this, f, i)

  def mapIdx[B](f: Mapping.Idx[A, B], start: Int = 0)(implicit i: Ilk[B]): ~[B] = { var j = start - 1; map[B](f({ j += 1; j }, _)) }

  override def letMap[B](f: Mapping[A, Opt[B]])(implicit i: Ilk[B]): Stream[B] = Z.extend.filter.letMap.refRef[A, B](this, f, i)

  override def letLookup[B: Ilk](f: PartialFunction[A, B]): Stream[B] = let(f.isDefinedAt).map(f.apply)

  override def letType[B](implicit t: ClassTag[B]): Stream[B] = Z.extend.filter.letType(this, t)

  override def flatMap[B](f: Mapping[A, ~[B]])(implicit i: Ilk[B]): Stream[B] = Z.extend.map.flatMap.refRef[A, B](this, f, i)

  def flatten[B](implicit f: Mapping[A, ~[B]], i: Ilk[B]): Stream[B] = flatMap(f)

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
 *   Stream map changes elements type
 *
 * @def flatten -> Converts a stream of streams into a flat stream
 *
 *   {{{
 *     val stream: ~[~[Char]] = *(
 *       'a' <> 'd',
 *       List('x', 'y', 'z'),
 *       Vector('v', 'e', 'c', 't', 'o', 'r'))
 *
 *     stream.flatten.lp // Prints: ~(a, b, c, d, x, y, z, v, e, c, t, o, r)
 *   }}}
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
 *
 *  @def mapRef -> Non - specialized mapping
 *
 *    Logically same as `map`, `mapRef` will box primitives if they are involved
 *
 *    Should be rarely used for testing and special cases
 */
