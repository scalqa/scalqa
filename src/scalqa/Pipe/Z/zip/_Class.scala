package scalqa; package Pipe; package Z; package zip

private[Pipe] class _Class[A, B](a: Pipe[A], b: Pipe[B], ao: Opt[A], bo: Opt[B]) extends The.Build.Pair[A, B, (A, B)](a, b) {

  def pumpOpt(lf: ((A, B)) => Boolean) = {
    def fail(s: String) = Fail("Pipe.zip '" + s + "' default Opt is not provided, but is required to match other Pipe's length")
    var o: Opt[(A, B)] = \/;
    one.pumpOpt(a => { o = two.pumpOpt(EVERY).default(bo or fail("second")).map((a, _)).let(lf); o });
    if (!o) two.pumpOpt(b => { val c = (ao or fail("first"), b); if (lf(c)) o = c; o })
    o
  }
  override def sizeOpt = one.sizeOpt.letMap(s => two.sizeOpt.map(_ max s))
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/