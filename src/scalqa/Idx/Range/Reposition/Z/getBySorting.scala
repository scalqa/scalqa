package scalqa; package Idx; package Range; package Reposition; package Z

private[scalqa] object fromOrdering {

  def apply[A](l: Idx[A], fullRange: Boolean = false, o: Ordering[A]): Reposition = {
    val ar = new scala.Array[(Int, A)](l.size)

    ar.updateAll(l.all.zipIdx)

    ar.sort(o.on(_._2))

    val ro: Opt[Range] = if (fullRange) ar.size.Range.Opt else ar.all.zipIdx.findOpt(_.to(_ != _._1)).map(_._1 <> ar.size.all.reverse.findOpt(i => i != ar(i)._1).value)

    ro.map(r => {
      make(
        r,
        Ints.fromArray { val ra = new scala.Array[Int](r.size); ar.all.letAt(r).map(_._1 - r.start).foreachIdx((i, v) => ra(v) = i, r.start); ra })
    }) or \/
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
