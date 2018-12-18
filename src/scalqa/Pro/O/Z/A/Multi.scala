package scalqa; package Pro; package O; package Z; package A

private[Pro] abstract class Multi[A](arrayVal: Refs[Any.O]) extends O[A] {
  def this(multi: ~[Any.O]) = this(multi.to[Refs])

  def onChange(j: () => Any): App.Event = new App.Event.A.Base {
    val controls = arrayVal.all.map(_.onObservableChange(j)).to[Refs]
    onCancelRun(controls.all.foreach(_.cancel))
  }

}

private[Pro] object Multi {

  class Mapped[A, B](protected val real: O[A], map: A => B, dependencies: ~[Any.O]) extends Multi[B](dependencies + real) {

    val v: Any.O = real

    def apply = map(real())

  }

  // **********************************************************************************************************************************************************************
  class Dependent[A](protected val real: Pro[A], s: ~[Any.O]) extends Multi[A](real.I.letType[O[A]].map[~[Any.O]](s + _).or(s)) {

    def apply = real()

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
