package scalqa; package Pipe; package Z; package process

private[Pipe] class shuffle[A](val real: Pipe[A]) extends The.Build[A] {
  private var ao: Opt[Pipe[A]] = \/

  def pumpOpt(f: A => Boolean): Opt[A] = _all.pumpOpt(f)

  override def sizeOpt = ao.letMap(_.sizeOpt) orOpt real.sizeOpt orOpt _all.sizeOpt

  private def _all = {
    def load = {
      val a = real.as[Array]
      a.size.all.swap(Random.intBelow(a.size)).applyIdx((i, j) => a(i).I.to(v => { a(i) = a(j); a(j) = v }))
      a.all.pipe
    }
    ao.orOpt { ao = load; ao }.value
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
