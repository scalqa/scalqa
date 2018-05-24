package scalqa; package Index; package O; package Z; package The; package OrderedProxy

private[scalqa] class Entry[A](var index: Int, val value: A) extends Able.Info {

  override def equals(a: Any): Boolean = a.I.letAs(classOf[Entry[A]]).let(_.index == index).let(_.value == value)

  protected def info = \/.info ~ ("index", index) ~ ("value", value)
}

private[scalqa] object Entry {

  def indexSorting[A]: Sorting[Entry[A]] = IndexOrdering.cast; private val IndexOrdering = Sorting.The.Int.asMap[Entry[Any]](_.index)

  // **********************************************
  trait IndexBase[A] {

    protected def entryIndex: Index.W[Entry[A]]

    def apply(i: Int): A = entryIndex(i).value

    def size = entryIndex.size

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/