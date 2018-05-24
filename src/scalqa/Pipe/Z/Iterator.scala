package scalqa; package Pipe; package Z

private[Pipe] class Iterator[A](protected val real: Pipe[A]) extends The.Build[A] with Pipe.Iterator[A] {
  private var o: Opt[A] = \/

  override def iterator = this

  def all = this

  override def nextOpt = previewOpt.run(o = \/)

  def nextFindOpt(f: A => Boolean) = pumpOpt(f)

  def previewOpt: Opt[A] = o orOpt real.pumpOpt(EVERY).I(o = _)

  def pumpOpt(f: A => Boolean) = o.run(o = \/).let(f) orOpt real.pumpOpt(f)

  override def sizeOpt = real.sizeOpt.map(_ + o.size)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
