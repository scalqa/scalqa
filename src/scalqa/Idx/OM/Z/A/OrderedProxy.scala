package scalqa; package Idx; package OM; package Z; package A

private[scalqa] class OrderedProxy[A](t: OM[A] = \/)(implicit o: Ordering[A]) extends Idx.O.Z.A.OrderedProxy[A](t)(o) with OrderedProxy.EntryIndexBase[A] with OM[A] {

  override def target: OM[A] = super.target.asInstanceOf[OM[A]]

  def target_=(t: OM[A]): Unit = super.target_=(t); override def target_=(t: O[A]): Unit = target_=(t.asObservableMutableView)

  override def order(o: Ordering[A]): Unit = ordering = o

  def multiChange(ch: Idx.M[A] => Any): Unit = target.multiChange(tl => ch(new OrderedProxy.EntryIndexBase[A] {
    def entryIndex = OrderedProxy.this.entryIndex
    def target = tl
    def multiChange(ch: Idx.M[A] => Any): Unit = ch(this)
  }))
}

private[scalqa] object OrderedProxy {

  trait EntryIndexBase[A] extends M[A] with Idx.O.Z.A.OrderedProxy.Entry.IndexBase[A] {
    protected def target: M[A]

    def addAt(i: Int, a: A): Unit = target.synchronized(target.add(a))

    def removeAt(r: Idx.Range): Unit = target.synchronized(entryIndex.all.letAt(r).map(_.index).sort.reverse.foreach(target removeAt _))

    def update(i: Int, e: A): Unit = target.synchronized(target.update(entryIndex(i).index, e))

    def refreshAt(r: Idx.Range): Unit = target.synchronized(entryIndex.all.letAt(r).map[A](_.value).letType[Any.Able.Refresh].foreach(_.refresh))

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
