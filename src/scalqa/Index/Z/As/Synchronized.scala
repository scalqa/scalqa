package scalqa; package Index; package Z; package As

private[scalqa] class Synchronized[A](protected val real: Index[A], val lockOpt: Opt[AnyRef]) extends Synchronized.Like[A]

private[scalqa] object Synchronized {

  trait Like[A] extends Index[A] {

    protected def real: Index[A]

    protected def lockOpt: Opt[AnyRef]

    protected val lock: AnyRef = lockOpt or this

    def apply(i: Int) = lock.synchronized(real(i))

    def size = lock.synchronized(real.size)

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/