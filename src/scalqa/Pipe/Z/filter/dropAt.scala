package scalqa; package Pipe; package Z; package filter

private[Pipe] class dropAt[A](val real: Pipe[A], r: Int.Range) extends The.Build[A] {
  var i = -1

  def pumpOpt(lf: A => Boolean) = real.pumpOpt(v => { i += 1; if (r.contains(i)) false else lf(v) })

  override def sizeOpt = \/

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/