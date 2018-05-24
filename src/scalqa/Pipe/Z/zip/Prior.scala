package scalqa; package Pipe; package Z; package zip

private[Pipe] class Prior[A](val real: Pipe[A]) extends The.Build.Map[A, (Opt[A], A)] {
  var po: Opt[A] = \/

  def pumpOpt(lf: ((Opt[A], A)) => Boolean) = {
    var o: Opt[(Opt[A], A)] = \/
    real.pumpOpt(v => (po, { po = v; v }).I.to(t => { if (lf(t)) o = t; o }));
    o
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/