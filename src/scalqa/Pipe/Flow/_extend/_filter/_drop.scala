package scalqa; package Pipe; package Flow; package _extend; package _filter

trait _drop[A] {

  def drop(f: A ⇒ Boolean): Flow[A] = let(!f(_))

  def dropIf(f: ⇒ Boolean): Flow[A] = drop(_ => f)

  def dropOnly(value: A): Flow[A] = drop(_ == value)

  def dropVoid: Flow[A] = drop(_.isVoid)

  // --------------------------------------------------
  private[Flow] def map[B](f: A => B): Flow[B]
  private[Pipe] def let(f: A ⇒ Boolean): Flow[A]
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
 * @def drop( ->  Reversed filter
 *
 *    Discards all the objects satisfying the filtering function from the pipeline
 *
 *    {{{ (1 <> 10).all.drop(_ % 2 == 0).lp // Prints: ~(1, 3, 5, 7, 9) }}}
 *
 * @def dropIf -> Valueless reversed filter
 *
 *    Discards objects when filtering function tests positive
 *
 *    The filtering function does not take the objects themselves, instead it is just invoked for each passing element
 *
 *    This is useful when there is a need to stop pipeline processing based on external conditions
 *
 * @def dropOnly -> Reversed filter for constant
 *
 *    Discards all the objects which test 'equal' to the specified constant
 *
 *    {{{ (1 ~ 2 ~ 3 ~ 1 ~ 2 ~ 3).dropOnly(2).lp // Prints: ~(1, 3, 1, 3) }}}
 *
 * @def dropVoid -> Reversed filter for void
 *
 *    Discards all the objects which test [[Any.isVoid]] positive from the pipeline
 *    {{{
 *       ("A" ~ null ~ "B" ~ "" ~ "C").lp          // Prints: ~(A, null, B, void, C)
 *
 *       ("A" ~ null ~ "B" ~ "" ~ "C").dropVoid.lp // Prints: ~(A, B, C)
 *    }}}
 */
