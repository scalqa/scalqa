package scalqa; package Pipe; package Z; package reproduce

private[Pipe] class repeat[A](val real: Pipe[A], size: Int) extends The.Build[A] {
  var o: Opt[A] = \/
  var i = size

  def pumpOpt(f: A => Boolean): Opt[A] = {
    while (i < size && o) {
      i += 1
      if (o.let(f)) return o
    }
    o = \/
    real.pumpOpt(v => {
      i = 0
      while (i < size && o.isVoid) {
        i += 1
        if (f(v)) o = v
      }
      o
    })
    o
  }

  override def sizeOpt = real.sizeOpt.map(_ * size + o.swap(size - i).or(0))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
