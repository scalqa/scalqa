package scalqa; package Pro; package M

trait _library[A] extends Any with Pro._library[A] with Any.Wrap[M[A]] {

  def updateIfVoid(v: A) = if (real().isVoid) real() = v

  def asBiMappedView[B](bm: BiMap[A, B]): M[B] = new Z.A.AsBiMap(real, bm)

  def bindTo(z: O[_ <: A]): App.Event = z.onChange(() => real() = z())

  def bindTo[B <: A](z: Idx.Selection.O[B], dflt: A): App.Event = z.onChange(real() = z.positions.getOpt(0).map(z(_)) orElse dflt)

}

object _library {

  class _Class[A] private[Pro] (protected val real: M[A]) extends AnyVal with _library[A]
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
