package scalqa; package Index; package WO; package Z; package The

private[scalqa] class OrderedProxy[A](t: WO[A] = \/)(implicit o: Sorting[A]) extends Index.O.Z.The.OrderedProxy[A](t)(o) with OrderedProxy.EntryIndexBase[A] with WO[A] {

  override def target: WO[A] = super.target.cast

  def target_=(t: WO[A]): Unit = super.target_=(t); override def target_=(t: O[A]): Unit = target_=(t.asWO)

  override def order(o: Sorting[A]): Unit = sorting = o

  def multiChange(ch: Index.W[A] => Any): Unit = target.multiChange(tl => ch(new OrderedProxy.EntryIndexBase[A] {
    def entryIndex = OrderedProxy.this.entryIndex
    def target = tl
    def multiChange(ch: Index.W[A] => Any): Unit = ch(this)
  }))
}

private[scalqa] object OrderedProxy {

  trait EntryIndexBase[A] extends W[A] with Index.O.Z.The.OrderedProxy.Entry.IndexBase[A] {
    protected def target: W[A]

    def addAt(i: Int, a: A): Unit = target.synchronized(target.add(a))

    def removeAt(r: Int.Range): Unit = target.synchronized(entryIndex.all.letAt(r).map(_.index).sort.reverse.foreach(target =-@ _))

    def replaceAt(i: Int, e: A): Unit = target.synchronized(target.replaceAt(entryIndex(i).index, e))

    def refreshAt(r: Int.Range): Unit = target.synchronized(entryIndex.all.letAt(r).map[A](_.value).apply(Able.Refresh.apply))

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/