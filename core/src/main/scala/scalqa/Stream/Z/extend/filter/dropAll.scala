package scalqa; package Stream; package Z; package extend; package filter

private[Stream] object dropAll {

  def apply[@specialized(DATA) A: Ordering](src: Stream[A], fltrStream: Stream[A]): Stream[A] = applyBy[A, A](src, src.sortedOpt, a => a, fltrStream)

  def By[@specialized(DATA) A, B: Ordering](src: Stream[A], map: Mapping[A, B], fltrStream: Stream[B]): Stream[A] = applyBy[A, B](src, src.sortedByOpt[B].map(_._1), map, fltrStream)

  private def applyBy[@specialized(DATA) A, B](src: Stream[A], sso: Opt[Ordering[B]], fun: Mapping[A, B], fltrStream: Stream[B])(implicit o: Ordering[B]): Stream[A] = {

    // ****************************************************************************
    class SortedMerge(o: Ordering[B]) extends Stream[A] with A.Extended.Ilk[A] {
      var c = 0
      var a: A = _
      var f: B = fltrStream.pump
      var done = false
      def prime: Boolean = if (done) src.prime else {
        while (c == 0) {
          if (!src.prime) { done = true; return false }
          a = src.pump
          val v = fun(a)
          c = o.compare(f, v)
          while (c < 0) {
            if (!fltrStream.prime) return true
            f = fltrStream.pump
            c = o.compare(f, v)
          }
        }
        c > 0
      }
      @inline final def pump = if (done) src.pump else { if (c < 0) done = true else c = 0; a }
      @inline final def foreach(c: Consumer[A]) = while (prime) c.accept(pump)
      override def sortedOpt = src.sortedOpt
      @inline final def real = src
    }
    // *******************************************************************************

    if (!fltrStream.prime)
      src
    else
      sso.let(v => fltrStream.sortedOpt.let(_ == v)).map(o => new SortedMerge(o)) orElse {
        val a = fltrStream.to[Idx.Array]
        if (a.size < 10 || o.isVoid) {
          drop.apply[A](src, v => a.contains(fun(v)))
        } else {
          a.sort(o);
          drop.apply[A](src, v => a.searchOrdered(fun(v))(o).size > 0)
        }
      }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
