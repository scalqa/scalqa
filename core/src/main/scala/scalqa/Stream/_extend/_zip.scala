package scalqa; package Stream; package _extend

trait _zip[A] { self: Stream[A] =>

  def zip[B](that: ~[B]): ~[(A, B)] = new Z.extend.zip.zip[A, B](this, that)

  def zipAll[B](that: ~[B], thisDflt: Opt[A], thatDflt: Opt[B]): ~[(A, B)] = Z.extend.zip.zipAll(this, that, thisDflt, thatDflt)

  def zipIdx: ~[(Int, A)] = new Z.extend.zip.zipIdx(this, 0)

  def zipIdx(start: Int): ~[(Int, A)] = new Z.extend.zip.zipIdx(this, start)

  def zipMap[B](f: Mapping[A, B]): ~[(A, B)] = new Z.extend.zip.zipMap[A, B](this, f)

  def zipNext: ~[(A, Opt[A])] = new Z.extend.zip.zipNext(this)

  def zipPrior: ~[(Opt[A], A)] = new Z.extend.zip.zipPrior(this)

  def zipFoldAs[B](start: B)(f: Folding.As[B, A]): Stream[(A, B)] = new Z.extend.zip.zipFoldAs(this, start, f)

  def unzip[B, C](implicit f: A => (B, C)): (Stream[B], Stream[C]) = Z.extend.zip.unzip(this, f)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _zip -> `Merge Interface`
 *
 *  @def zipFoldAs -> Merges current folding value
 *
 *    {{{
 *     (1 <> 7).all.zipFoldAs(0L)(_ + _).tp
 *
 *     // "Running Total" Output
 *     -- --
 *     ?  ?
 *     -- --
 *     1  1
 *     2  3
 *     3  6
 *     4  10
 *     5  15
 *     6  21
 *     7  28
 *    }}}
 *
 *  @def unzip -> Unzips stream in two
 *
 *   {{{
 *     val pairs = ('a' <> 'g').all.zipMap(_.upper).to[Idx]
 *
 *     pairs.all.lp  // Prints ~((a,A), (b,B), (c,C), (d,D), (e,E), (f,F), (g,G))
 *
 *     val (left, right) = pairs.all.unzip
 *
 *     left.all.lp   // Prints ~(a, b, c, d, e, f, g)
 *
 *     right.all.lp  // Prints ~(G, F, E, D, C, B, A)
 *   }}}
 *
 * @def zipAll[ -> Merge stream
 *
 *   Merges `this` and `that` streams, creating `Tuples` for corresponding elements
 *
 *   @param  that the stream to merge with `this`
 *   @param  thisDflt if `this` [[Stream]] has fewer elements,  `thisDflt` will be used to fill the voids. Fails if `thisDflt` is required, but not available
 *   @param  thatDflt if `that` [[Stream]] has fewer elements,  `thatDflt` will be used to fill the voids. Fails if `thatDflt` is required, but not available
 *
 *   @example
 *   {{{
 *      ('a' <> 'f').all.zip('A' <> 'H', '?', '?').lp
 *
 *      // Output
 *      ~((a,A), (b,B), (c,C), (d,D), (e,E), (f,F), (?,G), (?,H))
 *   }}}
 *
 * @def zipIdx: -> Merge index
 *
 *   Creates a new [[Stream]] with elements paired with their sequential index, starting at 0
 *
 *   Note:  Idx is the first element in the resulting tuples
 *
 *   {{{
 *      ('A' <> 'F').all.zipIdx.lp
 *
 *      // Output
 *      ~((0,A), (1,B), (2,C), (3,D), (4,E), (5,F))
 *   }}}
 *
 * @def zipIdx( -> Merge index
 *
 *   Creates a new [[Stream]] with elements paired with their sequential index
 *
 *   Note:  Idx is the first element in the resulting tuples.
 *
 *   @param start index initial value
 *   @example
 *   {{{
 *       ('A' <> 'F').all.zipIdx('A'.toInt) lp
 *
 *      // Output
 *      ~((65,A), (66,B), (67,C), (68,D), (69,E), (70,F))
 *   }}}
 *
 *
 * @def zip[ -> Zip that
 *
 *   Merges `this` and `that` streams, creating `Tuples` for corresponding elements
 *
 *   If `that` stream runs out of elements to merge, the rest of `this` stream will be discarded too
 *
 *   {{{
 *      (1 <> 100).all.zip('A' <> 'D').lp
 *
 *      // Output
 *      ~((1,A), (2,B), (3,C), (4,D))
 *   }}}
 *
 * @def zipMap -> Merge property
 *
 *   Creates a new [[Stream]] with elements paired with their property, defined by given function
 *
 *   {{{
 *      ('A' <> 'F').all.zipMap(_.toInt).lp
 *
 *      // Output
 *      ~((A,65), (B,66), (C,67), (D,68), (E,69), (F,70))
 *   }}}
 *
 *
 * @def zipPrior -> Merge with prior
 *
 *   Creates new [[Stream]] with elements paired with the optional prior element
 *
 *   {{{
 *      (1 <> 5).all.zipPrior.lp
 *
 *      // Output
 *      ~((Void,1), (Opt(1),2), (Opt(2),3), (Opt(3),4), (Opt(4),5))
 *   }}}
 *
 * @def zipNext -> Merge with next
 *
 *   Creates new [[Stream]] with elements paired with the optional next element
 *
 *   {{{
 *      (1 <> 5).all.zipNext.lp
 *
 *      // Output
 *      ~((1,Opt(2)), (2,Opt(3)), (3,Opt(4)), (4,Opt(5)), (5,Void))
 *   }}}
 */
