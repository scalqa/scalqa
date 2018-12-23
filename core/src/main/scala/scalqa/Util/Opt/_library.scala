package scalqa; package Util; package Opt

class _library[A] private[Opt] (protected[Opt] val real: Any) extends AnyVal with Any.Able.Stream[A] {
  @inline private[Opt] def _empty = real.isInstanceOf[Z.VoidValue]
  @inline private def _val: A = real.asInstanceOf[A]

  def or(default: => A): A = if (_empty) default else _val

  def orOpt(that: => Opt[A]): Opt[A] = if (_empty) that else new Opt(real)

  def default(v: => A): Opt[A] = if (_empty) new Opt(v) else new Opt(real)

  def asOption: Option[A] = if (_empty) scala.None else scala.Some(_val)

  def asOptional: java.util.Optional[A] = if (_empty) java.util.Optional.empty() else java.util.Optional.of(_val)

  def all: Stream[A] = if (_empty) \/ else _val.I.~

  def size: scala.Int = if (_empty) 0 else 1

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _library ->
 *
 *     `Use Library` extends '_use' interface with strictly typed methods
 *
 *     [[Opt]] is co-variant and methods accepting precise types are not allowed
 *
 *     Nevertheless, attaching invariantly typed library solves the problem
 *
 * @def all ->  As Stream
 *
 *    If no value, void stream is returned
 *
 *    Otherwise the stream with a single value element is returned
 *
 *    {{{
 *       Opt.Void.all.lp     // Prints: void
 *
 *       12.Opt.all.lp       // Prints: ~(12)
 *
 *       "abc".Opt.all.lp    // Prints: ~(abc)
 *    }}}
 *
 * @def or( ->  Value or default
 *
 *     Returns value, or if none, then given default
 *
 *     Note. [[Opt._Class.orElse Opt.orElse]] is implicitly typed equivalent, which should be used when this fails
 *
 *     {{{
 *         "abc".Opt or "xyz".lp  // Prints: abc
 *
 *         Opt.Void  or "xyz".lp  // Prints: xyz
 *     }}}
 *
 * @def orOpt -> Default option
 *
 *     Returns `this` [[Opt]], or if it is void, then given default
 *
 *     Note. [[Opt._Class.orElseOpt Opt.orElseOpt]] is implicitly typed equivalent, which should be used when this fails
 *     {{{
 *         "abc".Opt orOpt "xyz".Opt lp;  // Prints: Opt(abc)
 *
 *         Opt.Void  orOpt "xyz".Opt lp;  // Prints: Opt(xyz)
 *     }}}
 *
 * @def default -> Default value
 *
 *   Only if there is no value, creates new option with `default` value
 *   {{{
 *       12.Opt.default(24) lp            // Prints: Opt(12)
 *
 *       12.Opt.let(NONE).default(24) lp  // Prints: Opt(24)
 *   }}}
 */
