package scalqa; package Pipe; package Z; package convert

private[Pipe] class swap[A, B](val real: Pipe[A], f: ⇒ B) extends The.Build.Map[A, B] {

  def pumpOpt(lf: B => Boolean): Opt[B] = {
    var o: Opt[B] = \/
    real.pumpOpt(a => { o = f.I.let(lf); o })
    o
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/