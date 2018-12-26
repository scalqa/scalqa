package scalqa; package Stream; package Flow; package _extend; package Z

private[Stream] trait Shared[A] { self: Flow[A] =>

  def letType[B](implicit t: ClassTag[B]): Flow[B] = let(v => !t.unapply(v).isEmpty).asInstanceOf[Flow[B]]

  def letMap[B: Ilk](f: Mapping[A, Opt[B]]): Flow[B] = map(f).dropVoid.map(_.value)

  def letLookup[B: Ilk](f: PartialFunction[A, B]): Flow[B] = let(f.isDefinedAt).map(f.apply)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def letType -> Filter and type converter
 *
 *    Only lets elements, which are instances of the given type
 *
 *    Note, the result is mapped to the specified type
 *    {{{
 *       def all = ~[Any] + "1" + 2 + 3.0 + 4l + "5"
 *
 *       all.lp                  // Prints ~(1, 2, 3.0, 4, 5)
 *
 *       all.letType[String].lp  // Prints ~(1, 5)
 *    }}}
 *
 * @def letMap -> Filter and converter
 *
 *     Only lets elements for which given function returns non empty [[Opt]]
 *
 *     The elements are converted to the new type
 *
 *     {{{
 *         def all = "ABC" ~+ "1" + "22" + "D" + "333" + "E"
 *
 *         all.letMap(v => if (v.length < 2) \/ else v).lp // Prints: ~(ABC, 22, 333)
 *
 *         all.letMap({
 *           case s if (s.length >= 2) => s
 *           case _                    => \/
 *         }).lp                                           // Prints: ~(ABC, 22, 333)
 *
 *         all.letMap(_.toIntOut.valueOpt).lp              // Prints: ~(1, 22, 333)
 *     }}}
 *
 *     Note: 'letMap' is a better alternative to letLookup with PartialFunction, because it is evaluated just once for each element
 *
 * @def letLookup -> Filter and converter
 *
 *     Only lets elements for which given PartialFinction is defined
 *
 *     The elements are converted to the new type
 *
 *     {{{
 *        def all = ~[Any] + "ABC" + 1 + 22.0 + "DE" + 333F + "F"
 *
 *        all.letLookup({ case s: String if (s.length > 1) => s }).lp
 *
 *        // Output
 *        ~(ABC, DE)
 *     }}}
 *
 *     @note 'letLookup' always requires double evaluation for each element, so 'letMap' is preferred in many cases
 *
 */
