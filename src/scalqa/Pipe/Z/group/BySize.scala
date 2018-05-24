package scalqa; package Pipe; package Z; package group

private[Pipe] class BySize[A](val real: Pipe[A], size: Int) extends The.Build.Map[A, ~[A]] {

  def pumpOpt(lf: ~[A] => Boolean): Opt[~[A]] = {
    var s = new Buffer[A]
    real.pumpOpt(v => { s.add(v); s.size } >= size && lf(s.all).I(v => if (!v) s = new Buffer[A]))
    if (s.size == 0 || s.size < size && !lf(s.all)) \/ else s.all
  }

  override def sizeOpt = \/

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/