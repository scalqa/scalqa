package scalqa; package Idx; package O; package Z; package A; package OrderedProxy

private[scalqa] class Entry[A](var index: Int, val value: A) extends Any.Able.ToInfo {

  override def equals(a: Any): Boolean = a.I.letType[Entry[A]].let(_.index == index).let(_.value == value)

  def toInfo = new Pro.Info(this) += (("index", index)) += (("value", value))
}

private[scalqa] object Entry {

  def indexSorting[A]: Ordering[Entry[A]] = IndexOrdering.asInstanceOf[Ordering[Entry[A]]]; private val IndexOrdering = Ordering.Int.on[Entry[Any]](_.index)

  // **********************************************
  trait IndexBase[A] {

    protected def entryIndex: Idx.M[Entry[A]]

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
