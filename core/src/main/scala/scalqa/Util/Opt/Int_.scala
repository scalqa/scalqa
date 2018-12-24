package scalqa; package Util; package Opt

class Int_ private[Opt] (private[Opt] val real: scala.Int) extends AnyVal with Any.Able.Void {
  private def This = this.asInstanceOf[Opt.Int]
  private def _is = real != Opt.Int.VoidVal

  override def isVoid = real == Opt.Int.VoidVal
  def isValue: Boolean = _is
  def value: scala.Int = if (_is) real else throw new IllegalStateException("called 'value' for Empty Opt")

  def let(f: scala.Int => Boolean): Opt.Int = if (_is && f(real)) This else Opt.Int.Void
  def letLookup[B](f: PartialFunction[scala.Int, B]): Opt[B] = if (_is && f.isDefinedAt(real)) f(real) else Opt.Void
  def letMap[B](f: scala.Int => Opt[B]): Opt[B] = if (_is) f(real) else Opt.Void
  def letMix[B, C](that: Opt[B])(mix: (scala.Int, B) => C): Opt[C] = if (_is && that.isValue) mix(real, that.value) else Opt.Void

  def drop(f: scala.Int => Boolean): Opt.Int = if (_is && !f(real)) This else Opt.Int.Void

  def map[B](f: scala.Int => B): Opt[B] = if (_is) f(real) else Opt.Void
  def swap[B](newValue: => B): Opt[B] = if (_is) newValue else Opt.Void

  def contains(parameter: scala.Int): Boolean = parameter == real
  def orElseOpt(that: => Opt.Int): Opt.Int = if (_is) This else that
  def apply(f: scala.Int => Any, p: => Any = \/): Opt.Int = { if (_is) f(real) else p; This }
  def orElse(default: => scala.Int): scala.Int = if (_is) real else default
  def or(default: => scala.Int): scala.Int = if (_is) real else default
  def orVal(default: scala.Int): scala.Int = if (_is) real else default
  def all: ~[scala.Int] = if (_is) real.I.~ else \/

  override def toString = if (isVoid) "Opt.Void" else "Opt(" + real + ")"
}

object Int_ {
  private[Opt] val VoidVal = scala.Int.MinValue + 1

  val Void = new Opt.Int(VoidVal)

  def make(v: scala.Int) = new Opt.Int(v)

  implicit def zzBoolean(o: Opt.Int): Boolean = o.isValue

  implicit def zzFilterMonadic(o: Opt.Int) = new Z.FilterMonadic[scala.Int](o.real)

  implicit def zzStream(o: Opt.Int): ~[scala.Int] = o.all

  implicit def zzMakeValue(v: scala.Int): Opt.Int = if (v == VoidVal) Void else new Opt.Int(v)

  implicit def zzMake[A](v: \/): Opt.Int = Void

  implicit def zzMake(v: Opt[scala.Int]): Opt.Int = if (v.isValue) new Opt.Int(v.value) else Void

  implicit def zzOpt(v: Opt.Int): Opt[scala.Int] = if (v.real == VoidVal) Opt.Void else v.real
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Int_ -> `Int Value Option`
 *
 *   [[Opt.Int]] is functionally equivalent to [[scalqa.Opt Opt[Int]]]
 *
 *   The method sets are identical, so please refer to [[Opt]] for details
 *
 *   [[Opt.Int]] is specialized for Int primitive and provides performance boost where it is critical
 *
 *   Generally [[Opt]] is very fast, except for primitives, which are auto-boxed
 */
