package scalqa; package Pipe; package Z; package flow

private[Pipe] class synchronize[A](src: Flow[A]) extends synchronize.like[A] {

  def apply(f: A => Any): Unit = src(v => this.synchronized { f(v) })

  override def sizeOpt = src.sizeOpt
}

private[Pipe] object synchronize {

  def apply[A](src: Flow[A]): Flow[A] = src match { case a: Pipe[A] => a; case s: like[A] => s; case _ => new synchronize(src) }

  // ***************************************************************************************
  abstract class like[A] extends Flow[A] with Z.FlowWithMetadata[A] {

    def let(f: A ⇒ Boolean): Flow[A] = new let(this, f)

    def flatMap[B](f: A ⇒ ~[B]): Flow[B] = new flatMap(this, f)

    def map[B](f: A ⇒ B): Flow[B] = new map(this, f)

    def peek(f: A => Any): Flow[A] = new peek(this, f)

    def foldOpt(op: (A, A) ⇒ A): Opt[A] = Z.reduce.fold.opt(synchronize, op)

    def foldAsOpt[B](start: B, op: (B, A) ⇒ B, f: (B, B) => B): Opt[B] = Z.reduce.fold.asOpt(synchronize, start, op)

  }

  // ***************************************************************************************
  class let[A](src: like[A], fltr: A ⇒ Boolean) extends like[A] { def apply(f: A => Any) = src(a => if (fltr(a)) f(a)) }

  // ***************************************************************************************
  class flatMap[A, B](src: like[A], m: A ⇒ ~[B]) extends like[B] { def apply(f: B => Any) = src(a => m(a).apply(f)) }

  // ***************************************************************************************
  class map[A, B](src: like[A], m: A ⇒ B) extends like[B] { def apply(f: B => Any) = src(a => f(m(a))); override def sizeOpt = src.sizeOpt }

  // ***************************************************************************************
  class peek[A](src: like[A], p: A => Any) extends like[A] { def apply(f: A => Any) = src(v => { p(v); f(v) }); override def sizeOpt = src.sizeOpt }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/