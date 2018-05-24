package scalqa; package Pipe; package _extend; package _filter

trait _drop[A] extends Flow._extend._filter._drop[A] with __[A] {

  override def drop(f: A ⇒ Boolean): Pipe[A] = new Z.filter.drop(This, f)

  override def dropVoid: Pipe[A] = new Z.filter.drop.void(This)

  override def dropOnly(value: A): Pipe[A] = new Z.filter.drop.only(This, value)

  override def dropIf(f: ⇒ Boolean): Pipe[A] = new Z.filter.drop.If(This, f)

  def dropAll(a: ~[A])(implicit o: Sorting[A] = \/): Pipe[A] = Z.filter.dropAll[A](This, a)

  def dropAllBy[B](f: A => B, a: ~[B])(implicit o: Sorting[B] = \/): Pipe[A] = Z.filter.dropAll.by[A, B](This, f, a)

  def dropAllIf(b: Boolean): Pipe[A] = if (b) \/ else This

  def dropFirst(number: Int): Pipe[A] = new Z.filter.dropFirst(This, number)

  def dropLast(number: Int): Pipe[A] = new Z.filter.dropLast[A](This, number)

  def dropAt(r: Int.Range): Pipe[A] = if (r.size == 0) \/ else new Z.filter.dropAt(This, r)

  def dropWhile(f: A => Boolean): Pipe[A] = new Z.filter.dropWhile(This, f)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _drop -> '''Reversed Filter Interface'''
 *
 *    Base word '''drop''' means 'discard' certain objects from the pipeline
 *
 * @def dropFirst -> Sequence head reversed filter
 *
 *    Discards the first consecutive `number` of elements in the sequence
 *    {{{
 *       (1 <> 10).all.dropFirst(3).lp
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
 *      (1 <> 10).all ~~ (1 <> 10) dropWhile (_ <= 5) lp
 *
 *      // Output
 *      ~(6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
 *    }}}
 *
 * @def dropAll( -> Group reversed filter
 *
 *    Discards all elements equal to the found in ''that'' pipe
 *
 *    {{{
 *      (1 <> 10).all.repeat(3).dropAll(3 <> 7).lp
 *
 *      // Output
 *      ~(1, 1, 1, 2, 2, 2, 8, 8, 8, 9, 9, 9, 10, 10, 10)
 *    }}}
 *
 *    @note  The operation is very efficient if pipes are sorted
 *
 * @def dropAllBy -> Property group reversed filter
 *
 *    Discards elements, which produce property value equal to the found in ''that'' pipe
 *
 *    {{{
 *      ("abc" ~ "d" ~ "e" ~ "" ~ "fg" ~ "hijk").dropAllBy(_.length, 0 ~ 3).lp
 *
 *      // Output
 *      ~(d, e, fg, hijk)
 *    }}}
 *
 *    @note  The operation is very efficient if pipes are sorted
 *
 * @def dropAllIf( -> Everything reversed filter
 *
 *    With a single test lets or drops all the elements in the pipeline
 *
 *    @note  This action is better performed with simple 'if-else' outside the pipeline, however it proved to be useful with really long pipeline statements
 *
 *    @example
 *    {{{
 *      (1 <> 10).all.dropAllIf(true).lp
 *
 *      // Output
 *      void
 *    }}}
 */
