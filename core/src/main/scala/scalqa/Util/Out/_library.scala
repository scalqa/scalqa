package scalqa; package Util; package Out

class _library[A] private[Out] (protected[Out] val real: Any) extends AnyVal {
  private def _is = !real.isInstanceOf[Deficiency]
  private def _val: A = real.asInstanceOf[A]

  def or(default: => A): A = if (_is) _val else default

  def orElse[B >: A](default: => B): B = if (_is) _val else default

  def recover(f: Deficiency => Opt[A]): Out[A] = new Out(if (_is) real else f(real.asInstanceOf[Deficiency]) orElse real)

  def toOption: Option[A] = if (_is) scala.Some(_val) else scala.None

  def toOptional: java.util.Optional[A] = if (_is) java.util.Optional.of(_val) else java.util.Optional.empty()

  import scala.util.{ Try, Success, Failure }
  def toTry: Try[A] = real match {
    case d: Deficiency => d.errorOpt.map(new Failure(_)) or new Failure(new Exception(d.message))
    case _             => new Success(_val)
  }
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
 *     `Library` extends Outcome with strictly typed methods
 *
 *     [[Out]] is co-variant and methods accepting precise types are not allowed
 *
 *     Nevertheless, attaching invariantly typed library solves the problem
 *
 * @def or( ->  Value or default
 *
 *     Returns value, or if none, then given default
 *
 *     Note. [[orElse]] is implicitly typed equivalent, which should be used when this fails
 *
 *     {{{
 *         "abc".Opt or "xyz".lp  // Prints: abc
 *
 *         Opt.Void  or "xyz".lp  // Prints: xyz
 *     }}}
 *
 * @def recover -> Recover value
 *
 *   If Outcome is failed, tries to recover value with the given function
 *
 */
