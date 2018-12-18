package scalqa; package Pro; package O

trait _library[A] extends Any with Pro._library[A] with Any.Wrap[O[A]] {

  def onChangeRun(f: => Any): App.Event = real.onChange(() => f)

  def onValueChange(f: A => Any): App.Event = real.onChange(App.Event.moveId0(f, () => f(real())))

  def onValueChangeWithOld(f: (A, A) => Any): App.Event = { var old = real.apply; real.onChange(App.Event.moveId0(f, () => real().I(v => { f(v, old); old = v }))) }

  override def asMappedView[B](f: A => B): O[B] = new Z.A.Mapped(real, f)

  def asMappedView[B](f: A => B, s: ~[Any.O]): O[B] = new Z.A.Multi.Mapped[A, B](real, f, s)

}

object _library {
  class _Class[A] private[Pro] (protected val real: O[A]) extends AnyVal with _library[A]
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
