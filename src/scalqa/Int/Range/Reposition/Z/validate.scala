package scalqa; package Int; package Range; package Reposition; package Z

private[Reposition] object validate {

  def apply(r: Range.Reposition): Unit = r.indexes.I.to(ti => {
    if (r.range.size != ti.size) Fail.validate("size" + 's' + ':' + r.range.size + '<' + '>' + ti.size)
    Array.get[Boolean](ti.size).I(a => ti.all(i => { if (a(i)) Fail.validate("Index map is inconsistent ", ti.all.zipIdx.toString); a(i) = true }))
  })

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/