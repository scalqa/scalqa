package scalqa; package Opt

import java.lang.ref.WeakReference

class Weak[A <: AnyRef] private (private val real: WeakReference[A]) extends AnyVal {

  def valueOpt: Opt[A] = real.get

  override def toString = "Weak" + valueOpt.toString

  protected[Opt] def _target = valueOpt._target
}

object Weak {

  def get[A <: AnyRef](t: A): Weak[A] = new Weak(new WeakReference[A](t))

  import scala.language.implicitConversions

  implicit def zzGet[A <: AnyRef](a: A): Weak[A] = get(a)

  implicit def zzGet[A <: AnyRef](v: \/.type): Weak[A] = Void.cast; private val Void = new Weak(new WeakReference(null))

  implicit def zzOpt[A <: AnyRef](o: Weak[A]): Opt[A] = o.valueOpt

  implicit def zzBoolean(o: Weak[_]): Boolean = o.real.get != null

  implicit def zzAll[A <: AnyRef](o: Weak[A]): ~[A] = o.valueOpt.all
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Weak -> '''Weakly Referenced Optional Value'''
 *
 *     [[Opt.Weak]] value will be garbage collected in case there is no other reference to it
 *
 *     It is implicitly converted to [[Opt]], so it can be used just like regular [[Opt]]
 *
 *     The same instance of [[Opt.Weak]], which is not void, will become void when reference is lost
 *
 *     {{{
 *         class MyClass
 *
 *         var mc = new MyClass
 *
 *         val o: Opt.Weak[MyClass] = mc
 *
 *         o.swap("Ref OK") or "Ref Lost" lp // Prints:  Ref OK
 *
 *         mc = null                         // Clearing hard refference
 *         App.Memory.gc                     // Run garbage collection
 *
 *         o.swap("Ref OK") or "Ref Lost" lp // Prints:  Ref Lost
 *     }}}
 *
 * @def get -> By value
 *
 *     Creates [[Opt.Weak]] with given value
 *
 * @def toString -> String description
 *
 *     Returns: "Weak" + valueOpt.toString
 *
 * @def valueOpt -> Explicit Opt
 *
 *     [[Opt.Weak]] is implicitly converted to Opt, so there is no need to call this method in most cases, but rather call Opt methods directly
 *
 *     {{{
 *         Opt.Weak.get("ABC").let(_.startsWith("A")).apply(_ lp)  // Prints: ABC
 *     }}}
 */
