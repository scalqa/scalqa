package scalqa; package Int; package Range; package Reposition; package Z

private[scalqa] object getBySorting {

  def apply[A](l: Index[A], fullRange: Boolean = false, o: Sorting[A]): Int.Range.Reposition = Array.get[(Int, A)](l.size).I.to(ar => {

    ar.load(l.all.zipIdx)

    ar.sort(o.asMap(_._2))

    val ro: Opt[Int.Range] = if (fullRange) ar.size.Range.Opt else ar.all.zipIdx.pumpOpt(_.to(_ != _._1)).map(_._1 <> ar.size.all.reverse.pumpOpt(i => i != ar(i)._1).value)

    ro.map(r => {
      get(
        r,
        Array.get[Int](r.size).I(ra => ar.all.letAt(r).map(_._1 - r.start).applyIdx((i, v) => ra(v) = i, r.start)))
    }) or \/
  })
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
