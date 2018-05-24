package scalqa; package Pipe; package Z; package filter

private[Pipe] class dropLast[A](val real: Pipe[A], cnt: Int) extends The.Build[A] {
  var buf = new Buffer[A]

  def pumpOpt(lf: A => Boolean) = {
    var o: Opt[A] = \/;
    real.pumpOpt(a => {
      buf.add(a)
      if (buf.size > cnt) buf.pop.I.to(v => if (lf(v)) o = v)
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