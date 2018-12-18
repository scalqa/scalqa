package scalqa; package Idx; package Range; package Reposition; package Z

private[Reposition] object validate {

  def apply(r: Reposition): Unit = {
    val ti = r.indexes
    if (r.range.size != ti.size)
      App.Fail.validate("size" + 's' + ':' + r.range.size + '<' + '>' + ti.size)
    val a = new scala.Array[Boolean](ti.size)
    ti.all.foreach(i => {
      if (a(i)) App.Fail.validate("Idx map is inconsistent ", ti.all.zipIdx);
      a(i) = true
    })
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
