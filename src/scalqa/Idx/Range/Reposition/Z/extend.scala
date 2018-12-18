package scalqa; package Idx; package Range; package Reposition; package Z

private[Reposition] object extend {

  def apply(rep: Reposition, r: Range): Reposition = {
    val rr = rep.range
    if (rr.contains(r))
      rep
    else {
      val nr = rr join r
      make(nr, Ints.fromArray({
        val a = new scala.Array[Int](nr.size)
        val from = rr.start - nr.start;
        rep.indexes.all.foreachIdx((i, v) => a(i) = v + from, from)
        a
      }))
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
