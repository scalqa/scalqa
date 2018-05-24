package scalqa; package Int; package Range; package Reposition; package Z

private[Reposition] object extend {

  def apply(rep: Range.Reposition, r: Range): Range.Reposition = rep.range.I.to(rr =>
    if (rr.contains(r))
      rep
    else
      (rr join r).I.to(r => get(r, r.size.Range.toArray.I(a => { val i = rr.start - r.start; a.loadAt(i, rep.indexes.asMap(_ + i)) }))))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/