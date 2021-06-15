package scalqa; package `val`; package stream; package z; package use; import language.implicitConversions

import lang.string.z.Table

object print:
  private def EMPTY  = "EMPTY_STREAM"

  def apply[A](v: ~[A], id: Boolean, num: Boolean)(using t: Given.DocTag[A]): Unit =
    val ps      = v.map(toProduct)
    val tbl     = Table()
    val TAKE_SZ = 10
    fillRows(tbl,ps.read_~(TAKE_SZ), id, num)
    if (tbl.Rows.size != 0)
      var i = 0
      println(tbl.Header)
      while(tbl.Rows.size > 0)
        i += tbl.Rows.size
        tbl.Rows.~.foreach(println)
        tbl.Rows.clear
        fillRows(tbl, ps.read_~(TAKE_SZ), id, num, i)
      println(tbl.separator)
    else
      println(EMPTY)

  def toText[A](v: ~[A], id: Boolean)(using t: Given.DocTag[A]): String = Table().^(fillRows(_,v.map(toProduct),id)).^.as(t => if (t.Rows.size == 0) EMPTY else t.toString)

  // ------------------------------------------------------------------------------------------------------------
  private def toProduct[A](v: A)(using t: Given.DocTag[A]): Product =
    import gen.`given`.z.ProductTag
    v match
      case v : Stream[Any]                               => Tuple1(t.tag(v))
      case v : Product if(t.isInstanceOf[ProductTag[_]]) => t.doc(v)
      case v : Product                                   => v
      case v                                             => Able.Doc.doc_?(v) or Tuple1(t.tag(v))

  private def fillRows(tbl: Table, s: ~[Product], id: Boolean, num : Boolean = false, from: Int=0) =
    s.foreachIndexed((i,v) => {
        if(i==0) tbl.Header.fill((num ? "# ").~ ++ (id ? "Id") ++ v.productElementNames)
        tbl.newRow.fill((num ? i.toString).~ ++ (id ? v.productPrefix ) ++ v.productIterator)
    }, from)
/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
