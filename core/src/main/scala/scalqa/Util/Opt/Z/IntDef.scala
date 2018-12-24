package scalqa; package Util; package Opt.Z

import scalqa.{ Opt => Opt }

private[Opt] trait IntDef extends Any with Any.Able.Void {
  private def This = this.asInstanceOf[Opt.Int]
  private[Opt] def real: Int

  private def _is = real != Opt.Int.VoidVal

  override def isVoid = real == Opt.Int.VoidVal
  def isValue: Boolean = _is
  def value: Int = if (_is) real else throw new IllegalStateException("called 'value' for Empty Opt")

  def let(f: Int => Boolean): Opt.Int = if (_is && f(real)) This else Opt.Int.Void
  def letLookup[B](f: PartialFunction[Int, B]): Opt[B] = if (_is && f.isDefinedAt(real)) f(real) else Opt.Void
  def letMap[B](f: Int => Opt[B]): Opt[B] = if (_is) f(real) else Opt.Void
  def letMix[B, C](that: Opt[B])(mix: (Int, B) => C): Opt[C] = if (_is && that.isValue) mix(real, that.value) else Opt.Void

  def drop(f: Int => Boolean): Opt.Int = if (_is && !f(real)) This else Opt.Int.Void

  def map[B](f: Int => B): Opt[B] = if (_is) f(real) else Opt.Void
  def swap[B](newValue: => B): Opt[B] = if (_is) newValue else Opt.Void

  def contains(parameter: Int): Boolean = parameter == real
  def orElseOpt(that: => Opt.Int): Opt.Int = if (_is) This else that
  def apply(f: Int => Any, p: => Any = \/): Opt.Int = { if (_is) f(real) else p; This }
  def orElse(default: => Int): Int = if (_is) real else default
  def or(default: => Int): Int = if (_is) real else default
  def orVal(default: Int): Int = if (_is) real else default
  def all: ~[Int] = if (_is) real.I.~ else \/

  override def toString = if (isVoid) "Opt.Void" else "Opt(" + real + ")"
}

private[Opt] object IntDef {

  class Setup {
    private[Opt] val VoidVal = Int.MinValue + 1

    val Void = new Opt.Int(VoidVal)

    def make(v: Int) = new Opt.Int(v)

    implicit def zzBoolean(o: Opt.Int): Boolean = o.isValue

    implicit def zzFilterMonadic(o: Opt.Int) = new FilterMonadic[Int](o.real)

    implicit def zzStream(o: Opt.Int): ~[Int] = o.all

    implicit def zzMakeValue(v: Int): Opt.Int = if (v == VoidVal) Void else new Opt.Int(v)

    implicit def zzMake[A](v: \/): Opt.Int = Void

    implicit def zzMake(v: Opt[Int]): Opt.Int = if (v.isValue) new Opt.Int(v.value) else Void

    implicit def zzOpt(v: Opt.Int): Opt[Int] = if (v.real == VoidVal) Opt.Void else v.real
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
