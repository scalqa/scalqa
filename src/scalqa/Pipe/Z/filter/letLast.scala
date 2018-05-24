package scalqa; package Pipe; package Z; package filter

private sealed class letLast[A](val real: Pipe[A], cnt: Int) extends The.Build[A] {
  var o: Opt[~[A]] = \/

  def pumpOpt(lf: A => Boolean) = o.or {
    new Buffer[A].I(b => real(v => { b.add(v); if (b.size > cnt) b.pop })).all.I(o = _)
  }.pumpOpt(lf)

  override def sizeOpt = \/

}

private[Pipe] object letLast {

  def apply[A](src: Pipe[A], cnt: Int): Pipe[A] = src.sizeOpt.map(s => if (s > cnt) src.dropFirst(s - cnt) else src) or new letLast(src, cnt)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/