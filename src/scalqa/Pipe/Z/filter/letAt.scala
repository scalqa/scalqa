package scalqa; package Pipe; package Z; package filter

private[Pipe] class letAt[A](val real: Pipe[A], from: Int, til: Int) extends The.Build[A] {
  def this(p: Pipe[A], r: Int.Range) = this(p, r.start, r.end)
  var i = -1

  def pumpOpt(lf: A => Boolean) = {
    var o: Opt[A] = \/
    real.pumpOpt(v => {
      i += 1
      if (i < from) false
      else if (i >= til) true
      else if (lf(v)) o = v
      o
    })
    o
  }

  override def sizeOpt = \/

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/