package scalqa; package Pipe; package Z; package zip

private[Pipe] class Map[A, B](val real: Pipe[A], f: A => B) extends The.Build.Map[A, (A, B)] {

  def pumpOpt(lf: ((A, B)) => Boolean) = {
    var o: Opt[(A, B)] = \/
    real.pumpOpt(a => {
      val t = (a, f(a))
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