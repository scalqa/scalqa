package scalqa; package Pipe; package Z; package transform

private class nonEmptyOpt[A] private (val real: Pipe[A], private var o: Opt[A]) extends Pipe.The.Base[A] {

  def pumpOpt(lf: A => Boolean): Opt[A] = o.run(o = \/).let(lf).orOpt(real.pumpOpt(lf))

  override def sizeOpt = real.sizeOpt.map(_ + o.size)

}

private[Pipe] object nonEmptyOpt {

  def apply[A](all: Pipe[A]): Opt[~[A]] = all.sizeOpt.let(_ > 0).swap(all) orOpt all.pumpOpt(EVERY).map(new nonEmptyOpt(all, _))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/