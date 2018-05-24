package scalqa; package Pipe; package Z; package convert

private[Pipe] class map[A, B](val real: Pipe[A], f: A ⇒ B) extends The.Build.Map[A, B] {

  def pumpOpt(lf: B => Boolean): Opt[B] = {
    var o: Opt[B] = \/
    real.pumpOpt(a => { val v = f(a); if (lf(v)) o = v; o })
    o
  }
}

private[Pipe] object map {

  // *********************************************************************************************************
  def idx[A, B](src: Pipe[A], f: (Int, A) => B, start: Int = 0): Pipe[B] = { var i = start - 1; new map[A, B](src, f({ i += 1; i }, _)) }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/