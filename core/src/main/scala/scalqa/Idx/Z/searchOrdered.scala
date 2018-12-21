package scalqa; package Idx; package Z

private[Idx] object searchOrdered {

  def apply[A](l: Idx[A], v: A, trgtSize: Int)(implicit o: Ordering[A]): Idx.Range = {
    def bs(start: Int, to: Int): Idx.Range = {
      if (to == start) start <>>!
      else {
        val i = start + (to - start - 1) / 2
        val c = o.compare(v, l(i))
        if (c < 0) bs(start, i) else if (c > 0) bs(i + 1, to) else i <>!
      }
    }
    if (l.isEmpty) 0 <>>!
    else {
      val r = bs(0, l.size)
      if (r.size == 0) r else {
        var i = r.start
        while (i > 0 && o.compare(v, l(i - 1)) == 0) i -= 1
        var j = r.start + 1
        while (j - i < trgtSize && j < l.size && o.compare(v, l(j)) == 0) j += 1
        i <>>+ ((j - i) min trgtSize)
      }
    }
  }

  def By[A, B](l: Idx[A], v: B, mp: A => B, trgtSize: Int = 1, extraFilter: Opt[A => Boolean])(implicit o: Ordering[B]): Idx.Range = {
    val r = apply(l.asMappedView(mp), v, 1)
    if (r.size == 0) r else {
      var i = r.start
      var ok = true
      while (ok && extraFilter.map(_(l(i))).or(true)) { i += 1; ok = i < l.size && o.compare(v, mp(l(i))) == 0 }
      if (!ok) return r.start <>>!
      var j = i + 1
      while (j - i < trgtSize && j < l.size && o.compare(v, mp(l(j))) == 0 && extraFilter.map(_(l(j))).or(true)) j += 1
      i <>>+ ((j - i) min trgtSize)
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
