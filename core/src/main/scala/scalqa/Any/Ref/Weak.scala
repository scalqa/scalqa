package scalqa; package Any; package Ref

import java.lang.ref.WeakReference

class Weak[A <: AnyRef] private (private val real: WeakReference[A]) extends AnyVal {

  def opt: Opt[A] = { val v = real.get; if (v == null) Opt.Void else v }

  override def toString = "AnyRefWeak=" + opt.map(_.toString).or("empty")

}

object Weak {

  def apply[A <: AnyRef](v: A): Weak[A] = new Weak(new WeakReference[A](v))

  implicit def zzBoolean(o: Weak[_]): Boolean = o.real.get != null

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Weak -> `Weakly Referenced Value`
 *
 *     [[Ref.Weak]] value will be garbage collected in case there is no other reference to it
 *
 *     Note. The returned [[Opt]] should be used for basic checks only.
 *           It should not be subjected to chain transformations, as this creates more references to the weak value
 *
 *     {{{
 *       var hr = new Object        // hard reference
 *
 *       val wr = Any.Ref.Weak(hr)  // weak reference
 *
 *       wr.opt.isValue.lp          // Prints: true
 *
 *       hr = null                  // Clearing hard refference
 *       App.Memory.gc              // Run garbage collection
 *
 *       wr.opt.isValue.lp          // Prints: false
 *     }}}
 *
 * @def opt -> Value Opt
 *
 *     Returns value option
 *
 */
