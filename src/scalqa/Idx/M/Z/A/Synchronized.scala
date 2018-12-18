package scalqa; package Idx; package M; package Z; package A

private[Idx] class Synchronized[A](protected override val real: M[A], val lockOpt: Opt[AnyRef]) extends Synchronized.Like[A]

private[Idx] object Synchronized {

  trait Like[A] extends Idx.Z.A.Synchronized.Like[A] with M[A] {

    protected def real: M[A]

    def addAt(i: Int, e: A): Unit = lock.synchronized { real.addAt(i, e) }

    def update(i: Int, e: A): Unit = lock.synchronized { real.update(i, e) }

    def removeAt(r: Idx.Range): Unit = lock.synchronized { real.removeAt(r) }

    override def order(o: Ordering[A]): Unit = lock.synchronized { real.order(o) }

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
