package scalqa; package `val`; package idx; package z; import language.implicitConversions

private[scalqa] object Ordered:

  def contains[A](l: Idx[A], v: A)(using o: Ordering[A]): Boolean =
    def fun(start: Int, to: Int): Boolean = if (to == start) false else
      val i = start + (to - start - 1) / 2
      val c = o.compare(v, l(i))
      if (c < 0) fun(start, i) else if (c > 0) fun(i + 1, to) else true
    fun(0, l.size)

  def search[A](l: Idx[A], v: A, trgtSize: Int)(using o: Ordering[A]): Int.<> =
    def bs(start: Int, to: Int): Int.<> =
      if (to == start) start <>> start else
        val i = start + (to - start - 1) / 2
        val c = o.compare(v, l(i))
        if (c < 0) bs(start, i) else if (c > 0) bs(i + 1, to) else i <> i
    if (l.isEmpty) \/ else
      val r = bs(0, l.size)
      if (r.size == 0) r else
        var i = r.start
        while (i > 0 && o.compare(v, l(i - 1)) == 0) i -= 1
        var j = r.start + 1
        while (j - i < trgtSize && j < l.size && o.compare(v, l(j)) == 0) j += 1
        i <>= ((j - i) min trgtSize)

  def searchBy[A,B](l: Idx[A], v: B, mp: A => B, trgtSize: Int = 1, extraFilter: A => Boolean)(using o: Ordering[B]): Int.<> =
    val r = search(l.map_^(mp), v, 1)
    if (r.size == 0) r else
      var i = r.start
      var ok = true
      while (ok && extraFilter(l(i))) { i += 1; ok = i < l.size && o.compare(v, mp(l(i))) == 0 }
      if (!ok) return r.start <>> r.start
      var j = i + 1
      while (j - i < trgtSize && j < l.size && o.compare(v, mp(l(j))) == 0 && extraFilter(l(j))) j += 1
      i <>= ((j - i) min trgtSize)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
