package scalqa; package Range; package Z

private[Range] class allStep[A](ot: Sorting.Type, r: Range[A], var next: A, step: A => A) extends ~[A] {

  def supplyOpt: Opt[A] = next.Opt.let(a => if (ot.isUp) r._endContains(a) else r._startContains(a)).run(next = step(next))

}

private[Range] object allStep {

  def apply[A](r: Range[A], step: A => A): ~[A] = {
    step(r.start).I.to(next => r.sorting(r.start, next) match {
      case p if (p.isAsIs)    => new allStep[A](Sorting.Type.Ascending, r, if (r.startExclusive) next else r.start, step)
      case p if (p.isInverse) => new allStep[A](Sorting.Type.Descending, r, if (r.endExclusive) step(r.end) else r.end, step)
      case _                  => Fail("Invalid step")
    })
  }

  def apply[A](r: Range[A], step: Int, is: Int.Step[A]): ~[A] = {
    step match {
      case i if (i > 0) => new allStep[A](Sorting.Type.Ascending, r, if (r.startExclusive) is[A](1, r.start) else r.start, is[A](step, _))
      case i if (i < 0) => new allStep[A](Sorting.Type.Descending, r, if (r.endExclusive) is[A](-1, r.end) else r.end, is[A](step, _))
      case i            => Fail("Invalid step: " + i)
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/