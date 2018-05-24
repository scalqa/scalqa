package scalqa; package Pipe; package Z; package reproduce

private[Pipe] class flatMap[A, B](val real: Pipe[A], f: A => ~[B]) extends The.Build.Map[A, B] {
  var in: Pipe[B] = \/

  def pumpOpt(lf: B => Boolean): Opt[B] = in.pumpOpt(lf) orOpt {
    var o: Opt[B] = \/
    real.pumpOpt(a => { in = f(a); o = in.pumpOpt(lf); o })
    o
  }

  override def sizeOpt = \/

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/