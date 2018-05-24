package scalqa; package Pipe; package Z; package append

private[Pipe] class tilde[A](val real: Pipe[A], var that: Opt[A]) extends The.Build[A] {

  def pumpOpt(lf: A => Boolean): Opt[A] = real.pumpOpt(lf) orOpt that.run(that = \/).let(lf)

  override def sizeOpt = real.sizeOpt.map(_ + that.size)

}

private[Pipe] object tilde {

  abstract class two[A](f: Pipe[A], l: Pipe[A]) extends The.Build.Pair[A, A, A](f, l) {

    override def tagOpt = one.tagOpt.let(t => two.tagOpt.letOnly(t))

  }

  // **************************************************************************************************************************************
  class all[A](f: Pipe[A], l: Pipe[A]) extends two[A](f, l) {
    var cur: Pipe[A] = one

    def pumpOpt(lf: A => Boolean): Opt[A] = cur.pumpOpt(lf) orOpt (if (cur == two) \/ else { cur = two; cur.pumpOpt(lf) })

    override def sizeOpt = cur.sizeOpt.letMap(s => two.sizeOpt.map(ls => s + (cur == two) ? (0, ls)))
  }

  // **************************************************************************************************************************************
  class allAt[A](f: Pipe[A], idx: Int, l: Pipe[A]) extends two[A](f, l) {
    var i = 0;

    def pumpOpt(lf: A => Boolean): Opt[A] = {
      var o: Opt[A] = \/
      if (i < idx) one.pumpOpt(v => { i += 1; if (lf(v)) o = v; o || i >= idx })
      o orOpt two.pumpOpt(lf) orOpt one.pumpOpt(lf)
    }

    override def sizeOpt = one.sizeOpt.letMap(s => two.sizeOpt.map(_ + s))
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
