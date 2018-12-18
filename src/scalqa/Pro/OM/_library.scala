package scalqa; package Pro; package OM

trait _library[A] extends Any with M._library[A] with O._library[A] with Any.Wrap[OM[A]] {

  override def asBiMappedView[B](bm: BiMap[A, B]): OM[B] = new Z.A.BiMapped[A, B](real, bm)

  def asBiMappedView[B](bm: BiMap[A, B], s: ~[Any.O]): OM[B] = s.I.let(_.prime).map(a => new Z.A.MultiBiMapped[A, B](real, bm, a)) orElse asBiMappedView(bm)

}

object _library {
  class _Class[A] private[Pro] (protected val real: OM[A]) extends AnyVal with _library[A]
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
