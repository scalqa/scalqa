package scalqa; package Custom; package Array; package Z

import System.arraycopy

private[scalqa] object minus {

  def apply[@specialized(DATA) A](a: Array[A], v: A): Array[A] = if (!contains(a, v)) a else {
    val ab = a.all.drop(_ == v).to[scalqa.Idx.Array.Buffer]
    val na = emptyAs(a, ab.size)
    ab.copyTo(na)
    na
  }

  def stream[@specialized(DATA) A](a: Array[A], v: ~[A]): Array[A] = {
    val ab = a.all.dropAll(v).to[scalqa.Idx.Array.Buffer]
    val na = emptyAs(a, ab.size)
    ab.copyTo(na)
    na
  }

  def At[@specialized(DATA) A](a: Array[A], r: Idx.Range): Array[A] = {
    val s = r.start
    val e = r.end
    if (s < 0 || e > a.length)
      a.length.Range.overlapOpt(r).map(At(a, _)) or emptyAs(a, 0)
    else {
      val ra = emptyAs(a, a.length - r.size)
      if (s > 0) arraycopy(a, 0, ra, 0, s)
      val rest = a.length - e
      if (rest > 0) arraycopy(a, e, ra, s, rest)
      ra
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
