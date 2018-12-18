package scalqa; package Idx; package O; package Z; package A

private[scalqa] class SynchronizedView[A](protected override val real: O[A], val lockOpt: Opt[AnyRef]) extends SynchronizedView.Like[A]

private[scalqa] object SynchronizedView {

  trait Like[A] extends Idx.Z.A.Synchronized.Like[A] with O[A] {

    protected def real: O[A]

    def onChange(f: Idx[Change[A]] => Any) = real.onChange(App.Event.moveId1(f, c => lock.synchronized { f(c) }))

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
