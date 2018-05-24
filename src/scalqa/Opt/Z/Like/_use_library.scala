package scalqa; package Opt; package Z; package Like

private[Opt] trait _use_library[A] extends Any with __[A] {

  def or(default: => A): A = if (_isVal) _val else default

  def orOpt(that: => Opt[A]): Opt[A] = if (_isVal) new Opt(_val) else that

  def default(v: => A): Opt[A] = if (_isVal) new Opt(_val) else new Opt(v)

  def asOption: Option[A] = if (_isVal) scala.Some(_val) else scala.None

  def asOptional[B >: A]: java.util.Optional[B] = if (_isVal) java.util.Optional.of(_val) else java.util.Optional.empty()

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def or( ->  Value or default
 *
 *     Returns value, or if none, then given default
 *
 *     Note. [[Opt._use.orElse Opt.orElse]] is implicitly typed equivalent, which should be used when this fails
 *
 *     {{{
 *         "Abc".Opt or "Xyz".lp  // Prints: Abc
 *
 *         Opt.Void  or "Xyz".lp  // Prints: Xyz
 *     }}}
 *
 * @def orOpt -> Default option
 *
 *     Returns ''this'' [[Opt]], or if it is void, then given default
 *
 *     Note. [[Opt._use.orElseOpt Opt.orElseOpt]] is implicitly typed equivalent, which should be used when this fails
 *     {{{
 *         "Abc".Opt orOpt "Xyz".Opt.lp  // Prints: Opt(Abc)
 *
 *         Opt.Void  orOpt "Xyz".Opt.lp  // Prints: Opt(Xyz)
 *     }}}
 *
 * @def default -> Default value
 *
 *   Only if there is no value, creates new option with ''default'' value
 *   {{{
 *       12.Opt.default(24) lp            // Prints: Opt(12)
 *
 *       12.Opt.let(NONE).default(24) lp  // Prints: Opt(24)
 *   }}}
 */
