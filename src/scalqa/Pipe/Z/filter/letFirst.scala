package scalqa; package Pipe; package Z; package filter

private[Pipe] class letFirst[A](val real: Pipe[A], cnt: Int) extends The.Build[A] {
  private var i = 0

  def pumpOpt(lf: A => Boolean): Opt[A] = if (i >= cnt) \/ else {
    var o: Opt[A] = \/
    real.pumpOpt(v => {
      i += 1;
      if (lf(v)) o = v
      i >= cnt || o
    })
    o
  }

  override def sizeOpt: Opt[Int] = real.sizeOpt.map(cnt - i max 0 min _)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
