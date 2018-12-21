package scalqa; package Pro

trait _library[A] extends Any with Any.Wrap[Pro[A]] {

  def asMappedView[B](f: A => B): Pro[B] = new Z.A.Mapped(real, f)

}

object _library {

  class _Class[A] private[Pro] (protected val real: Pro[A]) extends AnyVal with _library[A] {

    def asObservableView(s: ~[Any.O]): O[A] = s.I.let(_.prime).map(all => new O.Z.A.Multi.Dependent(real, s)) orElse asObservableView

    def asObservableView: O[A] = new O.Z.A.NoEventsWrap[A](real())

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
