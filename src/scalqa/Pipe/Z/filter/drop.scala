package scalqa; package Pipe; package Z; package filter

private[Pipe] class drop[A](val real: Pipe[A], f: A ⇒ Boolean) extends The.Build[A] {

  def pumpOpt(lf: A => Boolean): Opt[A] = real.pumpOpt(v => !f(v) && lf(v))

  override def sizeOpt = \/

}

private[Pipe] object drop {

  class If[A](a: Pipe[A], f: ⇒ Boolean) extends drop[A](a, _ => f)

  class only[A](a: Pipe[A], v: A) extends drop[A](a, _ == v)

  class void[A](a: Pipe[A]) extends drop[A](a, _.isVoid)

  def range[A](a: Pipe[A], r: Int.Range): Pipe[A] = if (r.size == 0) a else { val s = r.start; val e = r.end; var i = -1; new let[A](a, _ => { i += 1; i < s || i >= e }) { /*new type*/ } }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/