package scalqa; package Index; package W; package Z; package As

private[Index] class Synchronized[A](protected override val real: W[A], val lockOpt: Opt[AnyRef]) extends Synchronized.Like[A]

private[Index] object Synchronized {

  trait Like[A] extends Index.Z.As.Synchronized.Like[A] with W[A] {

    protected def real: W[A]

    def addAt(i: Int, e: A): Unit = lock.synchronized { real.addAt(i, e) }

    def replaceAt(i: Int, e: A): Unit = lock.synchronized { real.replaceAt(i, e) }

    def removeAt(r: Int.Range): Unit = lock.synchronized { real.removeAt(r) }

    override def order(o: Sorting[A]): Unit = lock.synchronized { real.order(o) }

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/