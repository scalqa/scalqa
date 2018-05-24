package scalqa; package Any; package O

class _library[A <: O] protected[O] (protected val _target: A) extends AnyVal {

  def onObservableChange(f: () => Any): Concurrent.Control = _Trait.onObservableChange(_target, f)

  def onObservableChangeRun(f: => Any): Concurrent.Control = _target.onObservableChange(() => f)

  def onObservableChangeSelf(f: A => Any): Concurrent.Control = _target.onObservableChange(() => f(_target))

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
