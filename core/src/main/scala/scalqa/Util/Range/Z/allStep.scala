package scalqa; package Util; package Range; package Z

private class allStep[A](up: Boolean, r: Range[A], private var cur: A, step: A => A) extends Stream.A.Base[A] {

  var has = true

  override def prime = has

  override def pump = {
    val v = cur;
    cur = step(v)
    has = (if (up) Range.endContains(r, cur) else Range.startContains(r, cur))
    v
  }
}
private[Range] object allStep {

  def apply[A](r: Range[A], step: A => A): ~[A] = {
    val next = step(r.start)
    val i = r.ordering.compare(r.start, next)
    if (i < 0) new allStep[A](true, r, if (r.startExclusive) next else r.start, step)
    else if (i > 0) new allStep[A](false, r, if (r.endExclusive) step(r.end) else r.end, step)
    else App.Fail("Invalid step")
  }

  def apply[A](r: Range[A], step: A, n: Numeric[A]): ~[A] = {
    n.signum(step) match {
      case 1  => new allStep[A](true, r, if (r.startExclusive) n.plus(r.start, n.one) else r.start, n.plus(_, step))
      case -1 => new allStep[A](false, r, if (r.endExclusive) n.minus(r.end, n.one) else r.end, n.plus(_, step))
      case _  => App.Fail("Invalid step: " + step)
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
