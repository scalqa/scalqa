package scalqa; package Index; package WO; package Z; package As

private[Index] class Synchronized[A](protected override val real: WO[A], val lockOpt: Opt[AnyRef]) extends Synchronized.Like[A]

private[Index] object Synchronized {

  trait Like[A] extends WO[A] with Index.W.Z.As.Synchronized.Like[A] with Index.O.Z.As.Synchronized.Like[A] {

    protected def real: WO[A]

    def refreshAt(r: Int.Range): Unit = lock.synchronized { real.refreshAt(r) }

    def multiChange(ch: W[A] => Any): Unit = lock.synchronized { real.multiChange(ch) }

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/