package scalqa; package Stream; package Flow; package _extend

trait _filter[A] extends Z.Shared[A] { self: Flow[A] =>

  def let(f: Filter[A]): Flow[A]

  def letBy[T](property: Mapping[A, T], f: Filter[T]): Flow[A] = let(a => f.allow(property(a)))

  def drop(f: Filter[A]): Flow[A] = let(!f.allow(_))

  def dropVoid: Flow[A] = let(!_.isVoid)

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
 *    Base word `let` means 'allow only' certain elements trough the pipeline
 *
 *    Base word `drop` means 'discard' certain elements from the pipeline
 *
 *
 * @def let( ->  Main filter
 *
 *    Only lets elements satisfying the filter
 *
 *    `let` is the main filtering method. It's equivalent in Java and Scala is called `filter`
 *
 *    {{{  (1 <> 10).all.let(_ % 2 == 0).lp // Prints: ~(2, 4, 6, 8, 10) }}}
 *
 * @def letBy -> Property filter
 *
 *    Only lets elements satisfying the filter on given property
 *
 *    {{{
 *       val filter: Stream.Filter[Int] = _ >= 2
 *
 *       ("ABC" ~+ "D" + "E" + "FG").letBy(_.length, filter).lp // Prints: ~(ABC, FG)
 *    }}}
 *
 *    Note: This might be useful when existing filters are reused
 *
 * @def drop( ->  Reversed filter
 *
 *    Discards all the elements satisfying the filter
 *
 *    {{{ (1 <> 10).all.drop(_ % 2 == 0).lp // Prints: ~(1, 3, 5, 7, 9) }}}
 *
 * @def dropVoid -> Reversed filter for void
 *
 *    Discards all the objects which test [[Any.isVoid]] positive from the pipeline
 *    {{{
 *       def all = ("A" ~+ null + "B" + "" + "C")
 *
 *       all.lp              // Prints: ~(A, null, B, void, C)
 *
 *       all.dropVoid.lp     // Prints: ~(A, B, C)
 *    }}}
 */
