package scalqa; package Pipe; package Z; package zip

private[Pipe] class Only[A, B](f: Pipe[A], l: Pipe[B]) extends The.Build.Pair[A, B, (A, B)](f, l) {

  def pumpOpt(lf: ((A, B)) => Boolean) = {
    var o: Opt[(A, B)] = \/
    one.pumpOpt(a => {
      o = two.pumpOpt(EVERY).map((a, _)).let(lf); o
    })
    o
  }

  override def sizeOpt = one.sizeOpt.letMap(s => two.sizeOpt.map(_ min s))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/