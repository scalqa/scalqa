package scalqa; package Opt

class _Class[+A] private[Opt] (protected[Opt] val _target: Any) extends AnyVal with _use[A] with _convert[A] with _filter._Trait[A] with _collection[A] {

  override def toString: String = if (isVoid) "Opt.Void" else "Opt(" + _target.I.toString + ")"

}

object _Class {

  import scala.language.implicitConversions

  implicit def zzUseLibrary[A](o: Opt[A]) = new _use_library[A](o._target)

  implicit def zzBoolean[A](o: Opt[A]): Boolean = !o.isVoid

  @inline implicit def zzGetByValue[A](a: A): Opt[A] = if (a == null) Void else new Opt[A](a)

  implicit def zzGet[A](v: \/.type): Opt[A] = Void

  implicit def zzGet[A](v: NONE.type): Opt[A] = Void

  implicit def zzGet[A](v: scala.Option[A]): Opt[A] = Opt.getByOption(v)

  implicit def zzGet[A](v: java.util.Optional[A]): Opt[A] = Opt.getByOptional(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class -> '''Value Option'''
 *
 *    [[Opt]] is a container, which can hold a single value or be void
 *
 *    [[Opt]] is readily convertible to [[Boolean]], where [[Opt]] with value is 'true' and void is 'false'
 *
 *    [[Opt]] and [[Pipe]] are the only two [[https://en.wikipedia.org/wiki/Monad_(functional_programming) ''monadic'']] types with rich libraries for functional processing
 */
