package scalqa; package Idx; package OM; package Z; package A

private[Idx] class SynchronizedView[A](protected override val real: OM[A], val lockOpt: Opt[AnyRef]) extends SynchronizedView.Like[A]

private[Idx] object SynchronizedView {

  trait Like[A] extends OM[A] with Idx.M.Z.A.Synchronized.Like[A] with Idx.O.Z.A.SynchronizedView.Like[A] {

    protected def real: OM[A]

    def refreshAt(r: Idx.Range): Unit = lock.synchronized { real.refreshAt(r) }

    def multiChange(ch: M[A] => Any): Unit = lock.synchronized { real.multiChange(ch) }

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
