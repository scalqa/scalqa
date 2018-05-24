package scalqa; package Pipe; package _extend; package _filter

trait _let[A] extends Flow._extend._filter._let[A] with __[A] {

  override def let(f: A ⇒ Boolean): Pipe[A] = new Z.filter.let(This, f)

  override def letOnly(v: A): Pipe[A] = new Z.filter.let.only(This, v)

  override def letMap[B](f: A => Opt[B]): Pipe[B] = This.map(f).dropVoid.map(_.value)

  override def letPartialMap[B](f: PartialFunction[A, B]): Pipe[B] = This.let(f.isDefinedAt).map(f)

  override def letAs[T](c: Class[T]): Pipe[T] = new Z.filter.let.as(This, c).cast

  override def letBy[T](as: A => T, f: T => Boolean): Pipe[A] = new Z.filter.let.by(This, as, f)

  override def letIf(f: ⇒ Boolean): Pipe[A] = new Z.filter.let.If(This, f)

  def letSwap[B](f: => Opt[B]): Pipe[B] = letMap(_ => f)

  def letIdx(f: (Int, A) ⇒ Boolean, start: Int = 0): Pipe[A] = Z.filter.let.idx(This, f, start)

  def letFirst(number: Int): Pipe[A] = new Z.filter.letFirst(This, number)

  def letAt(r: Int.Range): Pipe[A] = if (r.size == 0) \/ else new Z.filter.letAt(This, r)

  def letLast(number: Int): Pipe[A] = Z.filter.letLast[A](This, number)

  def letWhile(f: A => Boolean): Pipe[A] = new Z.filter.letWhile(This, f)

  // ----------------------------------------------------------------------------------------------
  def letAll(that: ~[A])(implicit o: Sorting[A] = \/): Pipe[A] = Z.filter.letAll[A](This, that)

  def letAllBy[B](f: A => B, that: ~[B])(implicit o: Sorting[B] = \/): Pipe[A] = Z.filter.letAll.by[A, B](This, f, that)

  def letAllIf(b: Boolean): Pipe[A] = if (b) This else \/

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _let -> '''Filter Interface'''
 *
 *    Base word '''let''' means 'allow only' certain objects trough the pipeline
 *
 * @def letIdx -> Indexed filter
 *
 *    Only lets elements satisfying the filtering function
 *
 *    @param f filtering function, which also takes element index in the sequence
 *    @param start the starting index value
 *
 *     {{{
 *       (1 <> 10).all.letIdx((i, v) => i > 2 && i < 7).lp
 *
 *       // Output
 *       ~(4, 5, 6, 7)
 *    }}}
 *
 * @def letSwap -> Valueless filter and converter
 *
 *    Only lets elements for which given function returns non empty [[Opt]]
 *
 *    The elements are converted to the new type
 *
 *    Note, the conversion function does not take the elements themselves, instead it is just invoked for each element in the pipeline
 *
 *    {{{
 *       val src = ('A' <> 'G').all.iterator
 *
 *       (1 <> 1000).all.letSwap(src.nextOpt).lp
 *
 *       // Output
 *       ~(A, B, C, D, E, F, G)
 *    }}}
 *
 * @def letFirst -> Sequence head filter
 *
 *    Only lets first ''number'' of elements
 *    {{{
 *       (1 <> 10).all.letFirst(3).lp
 *
 *       // Output
 *       ~(1, 2, 3)
 *    }}}
 *
 * @def letLast -> Sequence tail filter
 *
 *    Only lets last ''number'' of elements
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
 *       (1 <> 10).all.letAt(3 <> 7).lp
 *
 *       // Output
 *       ~(4, 5, 6, 7, 8)
 *    }}}
 *
 * @def letWhile -> Sequence head filter.
 *
 *    Only lets first consecutive elements satisfying the filtering function
 *
 *    Note, everything starting from the first non compliant element will be discarded (including later compliant elements)
 *
 *    {{{
 *      (1 <> 10).all ~~ (1 <> 10) letWhile (_ <= 5).lp
 *
 *      // Output
 *      ~(1, 2, 3, 4, 5)
 *    }}}
 *
 *
 * @def letAll( -> Group filter
 *
 *    Only lets elements equal to the found in ''that'' pipe
 *
 *    {{{
 *      (1 <> 10).all.repeat(3).letAll(3 <> 7).lp
 *
 *      // Output
 *      ~(3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7)
 *    }}}
 *
 *    @note  The operation is very efficient if pipes are sorted
 *
 * @def letAllBy -> Property group filter.
 *
 *    Only lets elements, which produce property value equal to the found in ''that'' pipe
 *
 *    {{{
 *      ("abc" ~ "d" ~ "e" ~ "" ~ "fg" ~ "hijk").letAllBy(_.length, 0 ~ 1 ~ 2).lp
 *
 *      // Output
 *      ~(d, e, void, fg)
 *    }}}
 *
 *    @note  The operation is very efficient if pipes are sorted
 *
 * @def letAllIf( -> Everything filter.
 *
 *    With a single test lets or drops all the elements in the pipeline
 *
 *    @note  This action is better performed with simple 'if-else' outside the pipeline, however it proved to be useful with really long pipeline statements
 *
 *    @example
 *    {{{
 *      (1 <> 10).all.letAllIf(false).lp
 *
 *      // Output
 *      void
 *    }}}
 */
