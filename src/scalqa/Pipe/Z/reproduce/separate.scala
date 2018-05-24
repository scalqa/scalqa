package scalqa; package Pipe; package Z; package reproduce

private[Pipe] class separate[A](val real: Pipe[A], sep: A) extends The.Build[A] {
  var notFirst = false
  var vo: Opt[A] = \/

  def pumpOpt(f: A => Boolean): Opt[A] = {
    if (vo) { val o = vo; vo = \/; if (o.let(f)) return o }
    var o: Opt[A] = \/
    real.pumpOpt(v => {
      if (notFirst && f(sep)) {
        vo = v
        o = sep
      } else if (f(v)) {
        o = v
      }
      notFirst = true
      o
    })
    o
  }

  override def sizeOpt = real.sizeOpt.map(_ + vo.size).map(i => if (i == 0) 0 else (i - 1) * 2 + 1)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/