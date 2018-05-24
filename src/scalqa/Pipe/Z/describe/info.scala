package scalqa; package Pipe; package Z; package describe

private[scalqa] object info {

  def text[A](stream: Flow[A], asInfo: Boolean): String.Text = new String.Z.Table().I(tbl => {
    stream.synchronize.applyIdx((i, o) => {
      val head = ~[Any] ~~ asInfo.opt(o.I.id)
      o match {
        case ta: Able.Info if (!o.isInstanceOf[~[_]]) =>
          if (i == 0) tbl.header.fill(~[Any] ~~ asInfo.opt("Class@HashIndex") ~~ ta.I.info.all.map(_._1))
          tbl.newRow.fill(head ~~ ta.I.info.all.map(_._2))
        case p: Product =>
          if (i == 0) tbl.header.fill(~[Any] ~~ asInfo.opt("Class@HashIndex"))
          tbl.newRow.fill(head ~~ p.productIterator.all)
        case _ =>
          tbl.newRow.fill(head ~ o.I.toString)
      }
    })
  }).toString.Opt or "ALL_EMPTY"
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/