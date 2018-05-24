package scalqa; package Index; package Z

import Sorting.Position._

private[Index] object BinarySearch {

  def apply[A](l: Index[A], v: A, trgtSize: Int)(implicit srt: Sorting[A]): Int.Range = {
    def bs(start: Int, to: Int): Int.Range = {
      if (to == start) start <>>!
      else (start + (to - start - 1) / 2).I.to(i => srt(v, l(i)) match { case AsIs => bs(start, i); case Inverse => bs(i + 1, to); case _ => i <>! })
    }
    if (l.isEmpty) 0 <>>!
    else bs(0, l.size) ? (_.size > 0, r => {
      var i = r.start
      while (i > 0 && srt(v, l(i - 1)).isEither) i -= 1
      var j = r.start + 1
      while (j - i < trgtSize && j < l.size && srt(v, l(j)).isEither) j += 1
      i <>>+ ((j - i) min trgtSize)
    })
  }

  def apply[A, B](l: Index[A], v: B, mp: A => B, trgtSize: Int = 1, extraFilter: A => Boolean)(implicit srt: Sorting[B]): Int.Range = apply(l.asMap(mp), v, 1)(srt)
    .?(_.size > 0 && (trgtSize > 1 || extraFilter != EVERY), r => {
      var i = r.start
      var ok = true
      while (ok && !extraFilter(l(i))) { i += 1; ok = i < l.size && srt(v, mp(l(i))).isEither }
      if (!ok) return r.start <>>!
      var j = i + 1
      while (j - i < trgtSize && j < l.size && srt(v, mp(l(j))).isEither && extraFilter(l(j))) j += 1
      i <>>+ ((j - i) min trgtSize)
    })

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/