package scalqa; package Pipe; package Z; package filter

private[Pipe] class letWhile[A](val real: Pipe[A], f: A => Boolean) extends The.Build[A] {
  var done = false

  def pumpOpt(lf: A => Boolean) =
    if (done) \/
    else real.pumpOpt(v => if (f(v)) lf(v) else { done = true; true }).dropIf(done)

  override def sizeOpt = \/

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
