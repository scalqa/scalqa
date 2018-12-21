package scalqa; package Idx; package O

trait _library[A] extends Any with Idx._library[A] with Any.Wrap[O[A]] {

  override def asMappedView[B](f: A => B): O[B] = new Z.A.MappedView(real, f)

  def asStatefullMapView[B](f: A => B): O[B] = new Z.A.StatefullMap(real, f)

  override def asSynchronizedView(lockOpt: Opt[AnyRef] = \/): O[A] = new Z.A.SynchronizedView(real, lockOpt)

  override def asReversedView: O[A] = new Z.A.ReversedView(real)

  override def asTailView(from: Int): O[A] = if (from <= 0) real else new Z.A.Tail(real, from)

}

object _library {
  class _Class[A] private[O] (protected val real: O[A]) extends AnyVal with _library[A]
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
