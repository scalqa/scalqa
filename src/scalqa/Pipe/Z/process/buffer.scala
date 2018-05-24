package scalqa; package Pipe; package Z; package process

private[Pipe] class buffer[A](val real: Pipe[A]) extends The.Build[A] {
  private var ao: Opt[Pipe[A]] = \/

  def pumpOpt(f: A => Boolean): Opt[A] = _all.pumpOpt(f)

  override def sizeOpt = ao.letMap(_.sizeOpt) orOpt real.sizeOpt orOpt _all.sizeOpt

  private def _all = ao.orOpt { ao = new Buffer(real).all; ao }.value

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/