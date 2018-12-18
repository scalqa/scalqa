package scalqa; package Idx; package OM

trait _library[A, IdxWO <: OM[A]] extends Any with M._library[A, IdxWO] with O._library[A] with Any.Wrap[IdxWO] {

  override def asBiMappedView[B](bm: BiMap[A, B]): OM[B] = new Z.A.BiMappedView(real, bm)

  override def asBiMappedView[B](m: A => B, u: B => A): OM[B] = asBiMappedView(BiMap(m, u))

  override def asSynchronizedView(lockOpt: Opt[AnyRef] = \/): OM[A] = new Z.A.SynchronizedView(real, lockOpt)

}

private object _library {

  class _Class[A, IndexWO <: OM[A]] private[OM] (protected val real: IndexWO) extends AnyVal with _library[A, IndexWO]

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
