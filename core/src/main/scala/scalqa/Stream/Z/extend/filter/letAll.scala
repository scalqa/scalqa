package scalqa; package Stream; package Z; package extend; package filter

private[Stream] object letAll {

  def apply[@specialized(DATA) A: Ordering](src: Stream[A], fltrStream: Stream[A]): Stream[A] = applyBy[A, A](src, src.sortedOpt, a => a, fltrStream)

  def By[@specialized(DATA) A, B: Ordering](src: Stream[A], map: Mapping[A, B], fltrStream: Stream[B]): Stream[A] = applyBy[A, B](src, src.sortedByOpt[B].map(_._1), map, fltrStream)

  private def applyBy[@specialized(DATA) A, B](src: Stream[A], sso: Opt[Ordering[B]], fun: Mapping[A, B], fltrStream: Stream[B])(implicit o: Ordering[B]): Stream[A] = {

    // ****************************************************************************
    class SortedMerge(o: Ordering[B]) extends Stream[A] with A.Extended.Ilk[A] {
      var c = 1
      var a: A = _
      var f: B = fltrStream.pump
      def prime: Boolean = {
        while (c > 0) {
          if (!src.prime) { c = -1; return false }
          a = src.pump
          val v = fun(a)
          c = o.compare(f, v)
          while (c < 0) {
            if (!fltrStream.prime) return false
            f = fltrStream.pump
            c = o.compare(f, v)
          }
        }
        c == 0
      }
      @inline def pump = { c = 1; a }
      @inline def foreach(c: Consumer[A]) = while (prime) c.accept(pump)
      override def sortedOpt = src.sortedOpt
      @inline def real = src
    }
    // *******************************************************************************

    if (!fltrStream.prime)
      \/
    else
      sso.let(v => fltrStream.sortedOpt.let(_ == v)).map(o => new SortedMerge(o)) orElse {
        val a = fltrStream.to[Idx.Array]
        if (a.size < 10 || o.isVoid) {
          let.apply[A](src, v => a.contains(fun(v)))
        } else {
          a.sort(o);
          let.apply[A](src, v => a.searchOrdered(fun(v))(o).size > 0)
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
