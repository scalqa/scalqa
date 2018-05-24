package scalqa; package Pipe; package Z; package group

private[Pipe] class _Class[A](val real: Pipe[A], group: (A, A) => Boolean, peek: (A, Boolean) => Any) extends The.Build.Map[A, ~[A]] {
  var buf: Buffer[A] = null

  def pumpOpt(lf: ~[A] => Boolean): Opt[~[A]] = {
    var o: Opt[~[A]] = \/
    if (buf != null || real.pumpOpt(EVERY).apply(v => { buf = new Buffer(); buf.add(v); peek(v, true) })) {
      real.pumpOpt(v => {
        val split = !group(buf.last, v)
        if (split) {
          if (lf(buf.all)) o = buf.all
          buf = new Buffer
        }
        buf.add(v)
        peek(v, split)
        o
      })
      if (!o && buf.size > 0) { if (lf(buf.all)) o = buf.all; buf = null }
    }
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