package scalqa; package Index; package O; package Z; package As

private[scalqa] class Synchronized[A](protected override val real: O[A], val lockOpt: Opt[AnyRef]) extends Synchronized.Like[A]

private[scalqa] object Synchronized {

  trait Like[A] extends Index.Z.As.Synchronized.Like[A] with O[A] {

    protected def real: O[A]

    def onChange(f: Coll[Index.O.Change[A]] => Any) = real.onChange(Any.Event.moveId1(f, c => lock.synchronized { f(c) }))

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/