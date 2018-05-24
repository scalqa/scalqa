package scalqa; package Any; package Itself

trait _opt[A] extends Any with __[A] {

  def let(f: A => Boolean): Opt[A] = if (f(This)) This else \/

  def letOnly(that: A): Opt[A] = if (that == This) This else \/

  def letIf(condition: Boolean): Opt[A] = if (condition) This else \/

  def letAs[B](c: java.lang.Class[B]): Opt[B] = if (c.isInstance(This)) This.cast[B] else \/

  def drop(f: A => Boolean): Opt[A] = if (f(This)) \/ else This

  def dropOnly(v: A): Opt[A] = if (v != This) This else \/

  def dropIf(v: Boolean): Opt[A] = if (v) \/ else This

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _opt ->
 *
 *     These methods provide option filtering functions, which are performed on value
 *
 *     Basically, an extra step of creating an Opt is saved
 *
 *  {{{
 *        val ch : Char = 'A'
 *        Opt.get(ch).let(_.isDigit)
 *            // vs. //
 *        ch.I.let(_.isDigit)
 *  }}}
 *
 * @def let( -> Filtered value option
 *
 *     If ''this'' passes filter function, ''this'' is returned as [[Opt]]
 *
 *     Otherwise empty Opt.Void is returned
 *     {{{
 *         5.I.let(_ < 10).lp // Prints: Opt(5)
 *         5.I.let(_ > 10).lp // Prints: Opt.Void
 *     }}}
 *
 * @def drop( -> Filtered out value option
 *
 *     If ''this'' does not pass filter function, ''this'' is returned as [[Opt]]
 *
 *     Otherwise empty Opt.Void is returned
 *     {{{
 *         5.I.drop(_ < 10).lp // Prints: Opt.Void
 *         5.I.drop(_ > 10).lp // Prints: Opt(5)
 *     }}}
 *
 * @def letOnly( -> Equal value option
 *
 *     If ''this'' == ''that'' , ''this'' is returned as [[Opt]]
 *
 *     Otherwise empty Opt.Void is returned.
 *     {{{
 *         5.I.letOnly(5).lp // Prints: Opt(5)
 *         5.I.letOnly(6).lp // Prints: Opt.Void
 *     }}}
 *
 * @def dropOnly( -> Not equal value option
 *
 *     If ''this'' != ''that'' , ''this'' is returned as [[Opt]]
 *
 *     Otherwise empty Opt.Void is returned
 *     {{{
 *         5.I.dropOnly(5).lp // Prints: Opt.Void
 *         5.I.dropOnly(6).lp // Prints: Opt(5)
 *     }}}
 *
 * @def letIf( -> Conditional option
 *
 *     If ''condition'' == ''true'' , ''this'' is returned as [[Opt]]
 *
 *     Otherwise empty Opt.Void is returned.
 *     {{{
 *         5.I.letIf(true)  lp  // Prints: Opt(5)
 *
 *         5.I.letIf(false) lp  // Prints: Opt.Void
 *     }}}
 *
 * @def dropIf( -> Condition NOT option
 *
 *     If ''condition'' == ''false'' , ''this'' is returned as [[Opt]]
 *
 *     Otherwise empty Opt.Void is returned.
 *     {{{
 *         5.I.dropIf(true)  lp  // Prints: Opt.Void
 *         5.I.dropIf(false) lp  // Prints: Opt(5)
 *     }}}
 *
 * @def letAs -> Typed option
 *
 *     If ''this'' is an instance of provided type, ''this'' is returned as [[Opt]] value of new type
 *
 *     Otherwise empty Opt.Void is returned.
 *     {{{
 *        val a : Any = "abc"
 *        a.I.letAs(classOf[String]).lp  // Prints: Opt(abc)
 *        a.I.letAs(classOf[Double]).lp  // Prints: Opt.Void
 *     }}}
 */
