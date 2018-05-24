package scalqa; package Pipe; package Z; package filter

private[Pipe] class dropWhile[A](val real: Pipe[A], f: A => Boolean) extends The.Build[A] {
  var done = false

  def pumpOpt(lf: A => Boolean) = real.pumpOpt(v => { if (done) lf(v) else if (f(v)) false else { done = true; lf(v) } })

    override def sizeOpt = \/

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/