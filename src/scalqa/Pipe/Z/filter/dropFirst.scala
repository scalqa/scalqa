package scalqa; package Pipe; package Z; package filter

private[Pipe] class dropFirst[A](val real: Pipe[A], cnt: Int) extends The.Build[A] {
  var i = 0

  def pumpOpt(lf: A => Boolean) = real.pumpOpt(v => if (i < cnt) { i += 1; false } else lf(v))

  override def sizeOpt = \/

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/