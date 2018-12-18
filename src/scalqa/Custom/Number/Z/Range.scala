package scalqa; package Custom; package Number; package Z

private[scalqa] abstract class Range[@specialized(DATA) A] extends Util.Range[A] {

  protected def step(start: A, steps: Int): A

  override def all(implicit n: math.Numeric[A]): Stream[A] = allStep(n.one)

  def ilk: Any.Class.Ilk

  override def allStep(iStep: A)(implicit n: math.Numeric[A]): Stream[A] = new Stream[A] with Stream.A.Specialized.Indexed[A] {
    private def _first = if (startExclusive) n.plus(start, n.one) else start
    private def _last = if (endExclusive) n.minus(end, n.one) else end
    val neg = n.signum(iStep) == -1
    val from = if (neg) _last else _first
    val to = if (neg) _first else _last
    def _apply(i: Int): A = n.plus(from, n.fromInt(i))
    val _size: Int = {
      val rng = n.minus(_last, _first)
      var v = n.toInt(n.divByInt(rng, n.toInt(iStep)))
      while (Range.this.contains(_apply(v))) v += 1
      v
    }
    def pump = _pumpIndexed
    def foreach(f: Stream.Consumer[A]) = _consumeIndexed(f)
    override def ilkOpt = Range.this.ilk
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
