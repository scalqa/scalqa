package scalqa; package Opt; package orError

class _Class[+A] private[orError] (protected[Opt] val _target: Any) extends AnyVal with _convert[A] with _use[A] with _collection[A] with _validate[A] {

  override def toString: String = if (_isVal) "Opt(" + _target.I.toString + ")" else "Opt.Error(" + errorOpt.value + ")"

}

object _Class {

  import scala.language.implicitConversions

  implicit def zzGet[A](v: \/.type): orError[A] = Void
  implicit def zzGet[A](a: A): orError[A] = if (a == null) Fail("null") else get(a)
  implicit def zzGet[T](t: Throwable): orError[T] = getError(t)
  implicit def zzGet[A](v: scala.util.Try[A]): orError[A] = get(v)

  implicit def zzUseLibrary[A](o: orError[A]) = new _use_library[A](o._target)

  implicit def zzBoolean(o: orError[_]): Boolean = o.valueOpt
  implicit def zzAll[T](o: orError[T]): ~[T] = o.all
  implicit def zzOpt[T](o: orError[T]): Opt[T] = o.valueOpt

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @class _Class -> '''Opt or Error'''
 *
 * This class is very similar to the Opt with most matching functionality.
 *
 * Like Opt it may or may not hold value.
 *
 * Unlike Opt, Opt.orError cannot be empty, so, whenever there is no 'value', there is 'error' explaining why the value is not available.
 *
 * Opt.orError type cannot be assigned generalized '*'. If there is no value to assign, special error instance must be created.
 *
 */
