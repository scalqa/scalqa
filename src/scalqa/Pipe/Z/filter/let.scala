package scalqa; package Pipe; package Z; package filter

private[Pipe] class let[A](val real: Pipe[A], f: A ⇒ Boolean) extends The.Build[A] {

  def pumpOpt(lf: A => Boolean): Opt[A] = real.pumpOpt(v => f(v) && lf(v))

  override def sizeOpt = \/

}

private[Pipe] object let {

  class If[A](a: Pipe[A], f: ⇒ Boolean) extends let[A](a, _ => f)

  class only[A](a: Pipe[A], v: A) extends let[A](a, _ == v)

  class as[A, T](a: Pipe[A], c: Class[T]) extends let[A](a, c.isInstance)

  def idx[A](a: Pipe[A], f: (Int, A) ⇒ Boolean, start: Int): Pipe[A] = { var i = start - 1; new let[A](a, v => { i += 1; f(i, v) }) { /*new type*/ } }

  class by[A, T](a: Pipe[A], as: A => T, f: T => Boolean) extends let[A](a, v => f(as(v)))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/