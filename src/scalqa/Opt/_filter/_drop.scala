package scalqa; package Opt; package _filter

trait _drop[+A] extends Any with __[A] {

  def drop(f: A => Boolean): Opt[A] = if (_isVal && !f(_val)) This else Void

  def dropOnly[B >: A](v: B): Opt[A] = if (_isVal && v != _val) This else Void

  def dropIf(test: => Boolean): Opt[A] = if (_isVal && !test) This else Void

  def dropVoid: Opt[A] = drop(_.isVoid)

  def dropAll[B >: A](a: ~[B]): Opt[A] = if (_isVal && !a.findOpt(_ == _val)) This else Void

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _drop -> $drop
 *
 *    @define drop '''Reversed Filter Interface'''
 *
 *        Base word '''drop''' means 'discard' certain values
 *
 *        When value is discarded, [[Opt.Void]] is returned
 *
 * @def drop( ->  Reversed filter
 *
 *     Discards value if it passes given filtering function
 *
 *     {{{
 *       "Abc".Opt.drop(_.length > 2).lp  // Prints: Opt.Void
 *
 *       "Abc".Opt.drop(_.length > 3).lp  // Prints: Opt(Abc)
 *     }}}
 *     @note Nothing is done if ''this'' is void
 *
 * @def dropOnly -> Reversed filter for constant
 *
 *     Discards value if it is equal to the given value
 *
 *     {{{
 *       "Abc".Opt.dropOnly("Abc").lp  // Prints: Opt.Void
 *
 *       "Abc".Opt.dropOnly("Xyz").lp  // Prints: Opt(Abc)
 *     }}}
 *     @note Nothing is done if ''this'' is void
 *
 * @def dropIf -> Valueless reversed filter
 *
 *     Discards value if filter ''test'' is positive
 *
 *     {{{
 *       "Abc".Opt.dropIf(true) .lp  // Prints: Opt.Void
 *
 *       "Abc".Opt.dropIf(false).lp  // Prints: Opt(Abc)
 *     }}}
 *     @note Nothing is done if ''this'' is void
 *
 * @def dropVoid -> Reversed Filter for void
 *
 *     Discards value if it tests [[Any.isVoid]]
 *
 *     {{{
 *       "".Opt.dropVoid   .lp  // Prints: Opt.Void
 *
 *       "Abc".Opt.dropVoid.lp  // Prints: Opt(Abc)
 *     }}}
 *     @note Nothing is done if ''this'' is void
 *
 * @def dropAll[ -> Group reversed filter
 *
 *     Discards value if it belongs to the given group
 *
 *     {{{
 *       3.Opt.dropAll(1 <> 10)      .lp  // Prints: Opt.Void
 *
 *       3.Opt.dropAll(0 ~ 2 ~ 4 ~ 6).lp  // Prints: Opt(3)
 *     }}}
 *     @note Nothing is done if ''this'' is void
 */
