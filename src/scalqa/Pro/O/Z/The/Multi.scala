package scalqa; package Pro; package O; package Z; package The

private[Pro] class Multi(list: Refs[Any.O]) extends Any.O {
  def this(multi: ~[Any.O]) = this(multi.to[Refs])

  protected def onObservableChange(j: () => Any): Concurrent.Control = new Concurrent.Control.The.Base {}.I(task =>
    list.all.map(_.onObservableChange(j)).to[Refs].I.to(controls => task.onCancelRun(controls.all(_.cancel))))

}

private[Pro] object Multi {

  class Mapped[A, B](protected val real: O[A], map: A => B, dependencies: ~[Any.O]) extends Multi(dependencies ~ real) with O.The.Base[B] {

    val v: Any.O = real

    def apply = map(real())

  }

  // **********************************************************************************************************************************************************************
  class Dependent[A](protected val real: Pro[A], p: ~[Any.O]) extends Multi(real.I.letAs(classOf[O[A]]).map[~[Any.O]](p ~ _).or(p)) with O.The.Base[A] {

    def apply = real()

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
