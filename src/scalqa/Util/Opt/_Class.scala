package scalqa; package Util; package Opt

final class _Class[+A] private[Opt] (protected[scalqa] val real: Any) extends AnyVal with Any.Able.Void {
  @inline private def _is = !real.isInstanceOf[VoidValue]
  @inline private def _val: A = real.asInstanceOf[A]

  override def isVoid = !_is
  def isValue: Boolean = _is
  def value: A = if (_is) _val else throw new IllegalStateException("called 'value' for Empty Opt")

  def let(f: A => Boolean): Opt[A] = if (_is && f(_val)) this else Void
  def letType[B](implicit t: ClassTag[B]): Opt[B] = if (_is && !t.unapply(_val).isEmpty) asInstanceOf[Opt[B]] else Void
  def letLookup[B](f: PartialFunction[A, B]): Opt[B] = if (_is && f.isDefinedAt(_val)) new Opt(f(_val)) else Void
  def letMap[B](f: A => Opt[B]): Opt[B] = if (_is) f(_val) else Void
  def letMix[B, C](that: Opt[B])(mix: (A, B) => C): Opt[C] = if (_is && that._is) new Opt(mix(_val, that._val)) else Void
  def drop(f: A => Boolean): Opt[A] = if (_is && !f(_val)) this else Void

  def map[B](f: A => B): Opt[B] = if (_is) new Opt[B](f(_val)) else Void
  def swap[B](newValue: => B): Opt[B] = if (_is) new Opt[B](newValue) else Void

  def contains(parameter: Any): Boolean = parameter == real
  def orElseOpt[B >: A](that: => Opt[B]): Opt[B] = if (_is) this else that
  def apply(f: A => Any, p: => Any = \/): Opt[A] = { if (_is) f(_val) else p; this }

  def orElse[B >: A](default: => B): B = if (_is) _val else default

  def toOut(d: => Deficiency = "Value is not available"): Out[A] = if (isVoid) d else _val

  override def toString = if (isVoid) "Opt.Void" else "Opt(" + real + ")"

}

object _Class {

  @inline implicit def zzLibrary[A](o: Opt[A]) = new _library[A](o.real)

  @inline implicit def zzBoolean[A](o: Opt[A]): Boolean = o.isValue

  @inline implicit def zzFilterMonadic[A](o: Opt[A]) = new Z.FilterMonadic[A](o.real)

  @inline implicit def zzStream[A](o: Opt[A]): ~[A] = if (o._is) o._val.I.~ else \/

  @inline implicit def zzMakeValue[A](a: A): Opt[A] = if (a == null) Void else new Opt[A](a)

  @inline implicit def zzMake[A](v: \/): Opt[A] = Void

  implicit def zzMake[A](v: scala.Option[A]): Opt[A] = Opt.fromOption(v)

  implicit def zzMake[A](v: java.util.Optional[A]): Opt[A] = Opt.fromOptional(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class -> `Value Option`
 *
 *    [[Opt]] is a container, which can hold a single value or be void
 *
 *    [[Opt]] is readily convertible to Boolean, where [[Opt]] with value is 'true' and void is 'false'
 *
 * @def let( ->  Main filter
 *
 *    Discards value if it does not pass given filtering function
 *    {{{
 *       "foo".Opt.let(_.length > 2).lp  // Prints: Opt(foo)
 *
 *       "foo".Opt.let(_.length > 3).lp  // Prints: Opt.Void
 *    }}}
 *    Note: Opt.Void stays Opt.Void without evaluation
 *
 * @def drop( ->  Reversed filter
 *
 *     Discards value if it passes given filtering function
 *
 *     {{{
 *       "foo".Opt.drop(_.length > 2).lp  // Prints: Opt.Void
 *
 *       "foo".Opt.drop(_.length > 3).lp  // Prints: Opt(foo)
 *     }}}
 *     @note Nothing is done if `this` is void
 *
 * @def map[ ->  Convert value
 *
 *    Creates new option with value converted by the given function
 *
 *    If there is no value, `this` is returned as is
 *
 *    {{{
 *       2.Opt.map(_ * 10) lp   // Prints: Opt(20)
 *    }}}
 *
 * @def swap ->  Replace value
 *
 *    Creates new option with value replaced with newValue
 *
 *    Opt.Void stays Opt.Void
 *
 *    {{{
 *       "foo".Opt.swap("bar") lp // Prints: Opt(bar)
 *
 *       Opt.Void.swap("bar")  lp // Prints: Opt.Void
 *    }}}
 * @def letType -> Filter and type converter
 *
 *    Discards value if it does not belong to the given type
 *
 *    Note, the result is mapped to the given type
 *    {{{
 *       def o: Opt[Any] = "1"
 *
 *       o.letAs[String].lp // Prints: Opt(1)
 *
 *       o.letAs[Int].lp    // Prints: Opt.Void
 *    }}}
 *    Note: Opt.Void stays Opt.Void without evaluation
 *
 * @def letMap -> Filter and converter
 *
 *    Discards value if given function returns [[Opt.Void]]
 *
 *    Otherwise value is converted to the function result
 *
 *    {{{
 *       "abc".Opt.letMap(v => if(v.startsWith("a")) \/ else v).lp  // Prints: Opt.Void
 *
 *       "xyz".Opt.letMap(v => if(v.startsWith("x")) \/ else v).lp  // Prints: Opt(xyz)
 *
 *       "Cbs".Opt.letMap({
 *           case s if(s.startsWith("A")) => \/
 *           case s => s
 *        }).lp                                                     // Prints: Opt(Cbs)
 *    }}}
 *    Note: Opt.Void stays Opt.Void without evaluation
 *
 * @def letLookup -> Filter and converter
 *
 *    Discards value if given partial function is not defined
 *
 *    {{{
 *         2.Opt.letLookup({case v if(v < 5) => v * 10}) .lp   // Prints: Opt(20)
 *
 *         7.Opt.letLookup({case v if(v < 5) => v * 10}) .lp   // Prints: Opt.Void
 *    }}}
 *    Note: Opt.Void stays Opt.Void without evaluation
 *
 * @def letMix -> Mix filter
 *
 *    If either [[Opt]] is void, Opt.Void is returned
 *
 *    Otherwise, mixed value is returned
 *
 *    {{{
 *       val o5: Opt[Int] = 5
 *       val ov: Opt[Int] = \/
 *
 *
 *       o5.letMix(ov)(_ * _) lp // Prints: Opt.Void
 *
 *       ov.letMix(o5)(_ * _) lp // Prints: Opt.Void
 *
 *       o5.letMix(o5)(_ * _) lp // Prints: Opt(25)
 *
 *       // same as
 *
 *       {for(x <- o5; y <- o5) yeild x * y}.lp
 *
 *    }}}
 *
 * @def orElseOpt -> Default option
 *
 *     Returns `this` [[Opt]], or if it is void, then given default
 *
 *     Note. [[Opt._library.orOpt Opt.orOpt]] is strictly typed equivalent, which should be used in most cases
 *
 *     {{{
 *         "abc".Opt orOpt "xyz".Opt lp;  // Prints: Opt(abc)
 *
 *         Opt.Void  orOpt "xyz".Opt lp;  // Prints: Opt(xyz)
 *     }}}
 *
 * @def orElse[ ->  Value or default
 *
 *     Returns value, or if none, then given default
 *
 *     Note. [[Opt._library.or Opt.or]] is strictly typed equivalent, which should be used in most cases
 *
 *     {{{
 *         "abc".Opt or "xyz".lp  // Prints: abc
 *
 *         Opt.Void  or "xyz".lp  // Prints: xyz
 *     }}}
 *
 * @def isValue -> Check for value
 *
 *   Returns `true` if `this` option holds value, 'false' - otherwise
 *   {{{
 *       12.Opt.isValue.lp            // Prints: true
 *
 *       12.Opt.let(NONE).isValue.lp  // Prints: false
 *   }}}
 *
 * @def value -> Value
 *
 *   Returns value, or if void - fails
 *   {{{
 *       12.Opt.value.lp            // Prints: 12
 *
 *       12.Opt.let(NONE).value.lp  // Fails on execution
 *   }}}
 *
 * @def contains -> Check contains
 *
 *   Returns 'true' only if there is value and it is equal to the given `parameter`
 *
 *   'false' - otherwise
 *
 *   {{{
 *       12.Opt.contains(12).lp            // Prints: true
 *
 *       12.Opt.let(NONE).contains(12).lp  // Prints: false
 *   }}}
 *
 * @def apply -> Process option, both: value or no value
 *
 *     Takes two functions, one to process value, another - no value
 *
 *   {{{
 *       12.Opt.apply(_ * 2 lp) // Prints: 24
 *
 *       12.Opt(_ * 4 lp)       // Prints: 48
 *   }}}
 *
 * @def toOut -> Convert to outcome
 *
 *    Convert this [[Opt]] to outcome, optionally providing custom [[Deficiency]] for void case
 *
 * @def toString -> Convert to String
 *
 *    Returns "Opt.Void" or "Opt(" + value + ")" String
 */
