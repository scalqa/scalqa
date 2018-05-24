package scalqa; package Pipe; package Z; package zip

private[Pipe] class Next[A](val real: Pipe[A]) extends The.Build.Map[A, (A, Opt[A])] {
  var co: Opt[A] = \/

  def pumpOpt(lf: ((A, Opt[A])) => Boolean) = {
    var o: Opt[(A, Opt[A])] = \/
    if (!co) co = real.pumpOpt(EVERY)
    real.pumpOpt(v => (co.value, { co = v; co }).I.to(t => { if (lf(t)) o = t; o }));
    if (!o && co) (co.value, Opt.Void).I.to(t => { if (lf(t)) o = t; co = \/ })
    o
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/