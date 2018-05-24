package scalqa; package Pipe; package Flow; package _extend; package _filter

trait _let[A] {

  def let(f: A ⇒ Boolean): Flow[A]

  def letOnly(v: A): Flow[A] = let(_ == v)

  def letIf(f: ⇒ Boolean): Flow[A] = let(_ => f)

  def letBy[T](pc: A => T, f: T => Boolean): Flow[A] = let(a => f(pc(a)))

  def letAs[T](c: Class[T]): Flow[T] = let(c.isInstance).cast

  def letMap[B](f: A => Opt[B]): Flow[B] = map(f).dropVoid.map(_.value)

  def letPartialMap[B](f: PartialFunction[A, B]): Flow[B] = let(f.isDefinedAt).map(f)

  // --------------------------------------------------
  private[Flow] def map[B](f: A => B): Flow[B]
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
 * @def let( ->  Main filter
 *
 *    Only lets elements satisfying the filtering function
 *
 *    'let' is the main filtering method. It's equivalent in Java and Scala is called 'filter'
 *
 *    {{{  (1 <> 10).all.let(_ % 2 == 0).lp // Prints: ~(2, 4, 6, 8, 10) }}}
 *
 * @def letIf -> Valueless filter
 *
 *    Only lets elements for which filtering function tests positive
 *
 *    Note, the filtering function does not take the elements themselves, instead it is just invoked for each pipeline passing element
 *
 *    This is useful when there is a need to stop pipeline processing based on external conditions
 *
 * @def letOnly -> Constant filter
 *
 *    Only lets elements 'equal' to the specified
 *
 *    {{{ (1 ~ 2 ~ 3 ~ 1 ~ 2 ~ 3).letOnly(2).lp // Prints: ~(2, 2) }}}
 *
 * @def letBy -> Property filter
 *
 *    Only lets elements satisfying the filtering function
 *
 *    @param pc the property conversion function
 *    @param f the property filtering function to be invoked for each element in the pipeline
 *    @example
 *    {{{
 *        ("ABC" ~ "D" ~ "E" ~ "FG").letBy[Int](_.length, _ >= 2).lp // Prints: ~(ABC, FG)
 *    }}}
 *
 *    @note This might not be useful in simple cases, but is very expressive when standard filters are reused
 *
 * @def letAs -> Filter and type converter
 *
 *    Only lets elements, which are instances of the given type
 *
 *    Note, the result is mapped to the specified type
 *    @example
 *    {{{
 *       def all:  ~[Any]    = "1" ~ 2 ~ 3.0 ~ 4l ~ "5"
 *
 *       def allS: ~[String] = all.letAs(classOf[String])
 *
 *       allS.lp // prints '~(1, 5)'
 *    }}}
 *
 * @def letMap -> Filter and converter
 *
 *     Only lets elements for which given function returns non empty [[Opt]]
 *
 *     The elements are converted to the new type
 *
 *     {{{
 *         def all = "ABC" ~ "1" ~ "22" ~ "D" ~ "333" ~ "E"
 *
 *         all.letMap(v => if (v.length < 2) \/ else v).lp // Prints: ~(ABC, 22, 333)
 *
 *         all.letMap({
 *           case s if (s.length >= 2) => s
 *           case _                    => ()
 *         }).lp                                           // Prints: ~(ABC, 22, 333)
 *
 *         all.letMap(_.toIntOpt).lp                       // Prints: ~(1, 22, 333)
 *     }}}
 *
 *     @note 'letMap' is a better alternative to PartialFunction, because it is evaluated just once for each element
 *
 * @def letPartialMap -> Filter and converter
 *
 *     Only lets elements for which given PartialFinction is defined
 *
 *     The elements are converted to the new type
 *
 *     @example
 *     {{{
 *        def all = ~[Any] ~ "ABC" ~ 1 ~ 22.0 ~ "DE" ~ 333F ~ "F"
 *
 *        all.letPartialMap({ case s: String if (s.length > 1) => s }).lp
 *
 *        // Output
 *        ~(ABC, DE)
 *     }}}
 *
 *     @note 'letPartialMap' always requires double evaluation for each element, so 'letMap' is preferred in most cases
 */
