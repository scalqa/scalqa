package scalqa; package Pipe; package Z; package zip

private[Pipe] class Idx[A](val real: Pipe[A], var i: Int) extends The.Build.Map[A, (Int, A)] {

  def pumpOpt(lf: ((Int, A)) => Boolean) = {
    var o: Opt[(Int, A)] = \/
    real.pumpOpt(a => {
      val t = (i, a)
      i += 1
      if (lf(t)) o = t
      o
    })
    o
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/