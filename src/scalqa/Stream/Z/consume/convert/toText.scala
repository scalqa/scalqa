package scalqa; package Stream; package Z; package consume; package convert

private[scalqa] object toText {

  def apply[A](stream: Flow[A], asInfo: Boolean): String = new Custom.String.Z.Table().I(tbl => {
    var first = true
    stream.foreach(o => {
      val head = ~[Any] +~ asInfo.toOpt(o.I.id)
      o match {
        case ta: Any.Able.ToInfo if !o.isInstanceOf[~[_]] =>
          val info = ta.toInfo
          if (first) tbl.header.fill(~[Any] +~ asInfo.toOpt("Class@HashIndex") +~ info.customIdOpt.swap("id") +~ info.all.map(_._1))
          tbl.newRow.fill(head +~ info.customIdOpt +~ info.all.map(_._2))
        case s: Product if !s.isInstanceOf[collection.LinearSeq[_]]=>
          if (first) tbl.header.fill(~[Any] +~ asInfo.toOpt("Class@HashIndex"))
          tbl.newRow.fill(head +~ s.productIterator)
        case _ =>
          tbl.newRow.fill(head + o.I.toString)
      }
      first = false
    })
  }).toString.I.Opt or "ALL_EMPTY"
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
