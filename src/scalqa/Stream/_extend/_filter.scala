package scalqa; package Stream; package _extend

trait _filter[A] extends Flow._extend._filter[A] { self: Stream[A] =>

  override def let(f: Filter[A]): Stream[A] = Z.extend.filter.let(this, f)

  override def letMap[B](f: Mapping[A, Opt[B]])(implicit i: Ilk[B]): Stream[B] = Z.extend.filter.letMap.refRef[A, B](this, f, i)

  override def letLookup[B: Ilk](f: PartialFunction[A, B]): Stream[B] = let(f.isDefinedAt).map(f.apply)

  override def letType[B](implicit t: ClassTag[B]): Stream[B] = Z.extend.filter.letType(this, t)

  override def letBy[T](as: Mapping[A, T], f: Filter[T]): Stream[A] = Z.extend.filter.letBy(this, as, f)

  def letIdx(f: Filter.Idx[A], start: Int = 0): ~[A] = Z.extend.filter.letIdx(this, f, start)

  def letNext(number: Int): ~[A] = Z.extend.filter.letAt(this, 0 <>> number)

  def letAt(r: Idx.Range): ~[A] = Z.extend.filter.letAt(this, r)

  def letLast(number: Int): ~[A] = Z.extend.filter.letLast(this, number)

  def letWhile(f: Filter[A]): ~[A] = Z.extend.filter.letWhile(this, f)

  def letAll(that: ~[A])(implicit o: Ordering[A] = \/): ~[A] = Z.extend.filter.letAll[A](this, that)

  def letAllBy[B](f: Mapping[A, B], that: ~[B])(implicit o: Ordering[B] = \/): ~[A] = Z.extend.filter.letAll.By[A, B](this, f, that)

  override def drop(f: Filter[A]): Stream[A] = Z.extend.filter.drop(this, f)

  override def dropVoid: Stream[A] = Z.extend.filter.dropVoid(this)

  def dropAll(a: ~[A])(implicit o: Ordering[A] = \/): ~[A] = Z.extend.filter.dropAll[A](this, a)

  def dropAllBy[B](f: Mapping[A, B], a: ~[B])(implicit o: Ordering[B] = \/): ~[A] = Z.extend.filter.dropAll.By[A, B](this, f, a)

  def dropNext(number: Int): ~[A] = Z.extend.filter.dropNext(this, number)

  def dropLast(number: Int): ~[A] = Z.extend.filter.dropLast(this, number)

  def dropAt(r: Idx.Range): ~[A] = Z.extend.filter.dropAt(this, r)

  def dropWhile(f: Filter[A]): ~[A] = Z.extend.filter.dropWhile(this, f)

  def dropEverythingIf(b: Boolean): ~[A] = if (b) \/ else this
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _filter -> `Filter Interface`
 *
 *    Base word `let` means 'allow only' certain objects trough the pipeline
 *
 *    Base word `drop` means 'discard' certain objects from the pipeline
 *
 *
 * @def letIdx -> Indexed filter
 *
 *    Only lets elements satisfying the filtering function
 *
 *    @param f filtering function, which also takes element index in the sequence
 *    @param start the starting index value
 *
 *     {{{
 *       ('a' <> 'z').all.letIdx((i, v) => i >= 2 && i <= 7, 1).lp
 *
 *       // Output
 *       ~(b, c, d, e, f, g)
 *    }}}
 *
 * @def letNext -> Sequence head filter
 *
 *    Only lets first `number` of elements
 *    {{{
 *       (1 <> 10).all.letNext(3).lp
 *
 *       // Output
 *       ~(1, 2, 3)
 *    }}}
 *
 * @def letLast -> Sequence tail filter
 *
 *    Only lets last `number` of elements
 *    {{{
 *       (1 <> 10).all.letLast(3).lp
 *
 *       // Output
 *       ~(8, 9, 10)
 *    }}}
 *
 * @def letAt -> Sequence range filter
 *
 *    Only lets elements within given sequence range
 *
 *    {{{
 *       ('a' <> 'z').all.letAt(1 <> 7).lp
 *
 *       // Output
 *       ~(b, c, d, e, f, g, h)
 *    }}}
 *
 * @def letWhile -> Sequence head filter.
 *
 *    Only lets first consecutive elements satisfying the filtering function
 *
 *    Note, everything starting from the first non compliant element will be discarded (including later compliant elements)
 *
 *    {{{
 *      (1 <> 10).all +~ (1 <> 10) letWhile (_ <= 5) lp
 *
 *      // Output
 *      ~(1, 2, 3, 4, 5)
 *    }}}
 *
 *
 * @def letAll( -> Group filter
 *
 *    Only lets elements equal to the found in `that` stream
 *
 *    {{{
 *       val idx = (1 <> 5).all.flatMap(_.I repeat 3).to[Idx]
 *
 *       idx.all.lp                    // Prints: ~(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5)
 *
 *       idx.all.letAll(3 <> 7).lp     // Prints: ~(3, 3, 3, 4, 4, 4, 5, 5, 5)
 *
 *       idx.all.letAll(2 ~+ 5 + 11).lp // Prints: ~(2, 2, 2, 5, 5, 5)
 *    }}}
 *
 *    @note  The operation is very efficient if streams are sorted
 *
 * @def letAllBy -> Property group filter.
 *
 *    Only lets elements, which produce property value equal to the found in `that` stream
 *
 *    {{{
 *      ("abc" ~+ "d" + "e" + "" + "fg" + "hijk").letAllBy(_.length, 0 ~+ 1 + 2).lp
 *
 *      // Output
 *      ~(d, e, void, fg)
 *    }}}
 *
 *    @note  The operation is very efficient if streams are sorted
 *
 * @def dropNext -> Sequence head reversed filter
 *
 *    Discards the first consecutive `number` of elements in the sequence
 *    {{{
 *       (1 <> 10).all.dropNext(3).lp
 *
 *       // Output
 *       ~(4, 5, 6, 7, 8, 9, 10)
 *    }}}
 *
 * @def dropLast -> Sequence tail reversed filter
 *
 *    Discards the last consecutive `number` of elements in the sequence
 *    {{{
 *       (1 <> 10).all.dropLast(3).lp
 *
 *       // Output
 *       ~(1, 2, 3, 4, 5, 6, 7)
 *    }}}
 *
 * @def dropAt -> Sequence range reversed filter
 *
 *    Discards sequence elements, which fall within the specified range
 *
 *    {{{
 *       (1 <> 10).all.dropAt(3 <> 7).lp
 *
 *       // Output
 *       ~(1, 2, 3, 9, 10)
 *    }}}
 *
 *
 * @def dropWhile -> Sequence head reversed filter
 *
 *    Discards first consecutive elements satisfying the filtering function
 *
 *    Note, everything starting from the first non compliant element will be allowed (including later compliant elements)
 *
 *    {{{
 *      (1 <> 10).all +~ (1 <> 10) dropWhile (_ <= 5) lp
 *
 *      // Output
 *      ~(6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
 *    }}}
 *
 * @def dropAll( -> Group reversed filter
 *
 *    Discards all elements equal to the found in `that` stream
 *
 *    {{{
 *       val idx = (1 <> 5).all.flatMap(_.I repeat 3).to[Idx]
 *
 *       idx.all.lp                     // Prints: ~(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5)
 *
 *       idx.all.dropAll(3 <> 7).lp     // Prints: ~(1, 1, 1, 2, 2, 2)
 *
 *       idx.all.dropAll(2 ~+ 5 + 11).lp // Prints: ~(1, 1, 1, 3, 3, 3, 4, 4, 4)
 *    }}}
 *
 *    @note  The operation is very efficient if streams are sorted
 *
 * @def dropAllBy -> Property group reversed filter
 *
 *    Discards elements, which produce property value equal to the found in `that` stream
 *
 *    {{{
 *      ("abc" ~+ "d" + "e" + "" + "fg" + "hijk").dropAllBy(_.length, 0 ~+ 3).lp
 *
 *      // Output
 *      ~(d, e, fg, hijk)
 *    }}}
 *
 *    @note  The operation is very efficient if streams are sorted
 *
 * @def dropEverythingIf( -> Discarding everything
 *
 *    With a single test lets to drop the entire pipeline in favor of void instance
 *
 *    Note: This can also be done with 'if-else' outside the pipeline, however it proved to be useful with really long pipeline statements
 *
 *    {{{
 *      (1 <> 10).all.dropEverythingIf(true).lp
 *
 *      // Output
 *      void
 *    }}}
 */
