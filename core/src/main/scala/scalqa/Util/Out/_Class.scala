package scalqa; package Util; package Out

class _Class[+A] private[scalqa] (private val real: Any) extends AnyVal with Any.Able.ToString {
  private def _is = !real.isInstanceOf[Deficiency]
  private def _val: A = real.asInstanceOf[A]

  def isValue = _is
  def value: A = if (_is) _val else App.Fail.state("Called 'value' on failed Outcome")
  def valueOpt: Opt[A] = if (_is) _val else Opt.Void

  def deficiency: Deficiency = real match { case v: Deficiency => v; case _ => App.Fail.state("Called 'deficiency' on value Outcome") }
  def deficiencyOpt: Opt[Deficiency] = real match { case v: Deficiency => v; case _ => Opt.Void }

  // ------------------------------------------------------------------------------------------------------------------------------------
  def map[B](f: A => B): Out[B] = if (_is) new Out(f(real.asInstanceOf[A])) else asInstanceOf[Out[B]]
  def letMap[B](f: A => Out[B]): Out[B] = if (_is) f(_val) else asInstanceOf[Out[B]]

  def apply(f: A => Any, df: Deficiency => Any = \/): Out[A] = { real match { case v: Deficiency => df(v); case v => f(_val) }; this }
  def convert[B](f: A => B, df: Deficiency => B): B = real match { case v: Deficiency => df(v); case v => f(_val) }

  override def toString = "Out(" + (if (_is) real.toString else "deficiency=" + deficiency.message) + ")"
}

object _Class {

  implicit def zzLibrary[A](o: Out[A]) = new _library[A](o.real)

  implicit def zzMake[A](v: A): Out[A] = apply(v)
  implicit def zzMake[A](v: Deficiency): Out[A] = apply(v)
  implicit def zzMake[A](v: Throwable): Out[A] = apply(Deficiency.apply(v))

  implicit def zzFilterMonadic[A](o: Out[A]) = new Z.FilterMonadic[A](o.real)
  implicit def zzStream[A](o: Out[A]): ~[A] = if (o._is) o._val.I.~ else \/

  implicit def zzBoolean[A](v: Out[A]): Boolean = v.isValue
  implicit def zzOpt[A](v: Out[A]): Opt[A] = v.valueOpt

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @class _Class -> `Value Outcome`
 *
 *    [[Out Outcome]] holds either `value` (tested by `isValue`) or [[Deficiency]]
 *
 *    The former can be accessed with  `value` and `valueOpt`, the latter with  `deficiency` and `deficiencyOpt`
 *
 *    [[Out Outcome]] is similar to scala.Try with two notable differences:
 *
 *      - scala.Try captures errors, where [[Out Outcome]] holds [[Deficiency]], which may include not only errors, but also business logic shortcomings
 *      - Unlike scala.Try when mapped, [[Out Outcome]] does not captures exceptions. Exceptions are only captured when directly mapping `Future`
 *
 *
 * @def isValue -> Checks if this [[Out Outcome]] holds value
 *
 *     if isValue is false, this [[Out Outcome]] holds [[Deficiency]]
 *
 * @def value: -> Outcome value
 *
 *     Returns outcome value
 *
 *     Note. Will fail for failed outcome
 *
 * @def valueOpt: ->  Outcome optional value
 *
 *     Optionally returns outcome value or Opt.Void if outcome is failed
 *
 * @def deficiency: -> Failure description
 *
 *     Returns outcome [[Deficiency]]
 *
 *     Note. Will fail for successful outcome
 *
 * @def deficiencyOpt: -> Failure option
 *
 *     Returns outcome [[Deficiency]] or Opt.Void if outcome is a success
 *
 * @def map[ -> Map value
 *
 *     Maps outcome value
 *
 *     Already failed outcomes are returned as is
 *
 * @def letMap -> Map value
 *
 *     Maps outcome value to another value or [[Deficiency]]
 *
 * @def apply -> Process outcome, both: success and failure
 *
 *     Takes two functions, one to process success, another - failure
 *
 * @def convert -> Convert outcome, both: success and failure
 *
 *     Takes two functions, one to convert success, another - failure
 */
