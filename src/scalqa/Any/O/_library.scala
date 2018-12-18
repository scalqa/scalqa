package scalqa; package Any; package O

class _library[A <: O] protected[O] (protected val _this: A) extends AnyVal {

  def onObservableChange(f: () => Any): App.Event = _Trait.onObservableChange(_this, f)

  def onObservableChangeRun(f: => Any): App.Event = _this.onObservableChange(() => f)

  def onObservableChangeSelf(f: A => Any): App.Event = _this.onObservableChange(() => f(_this))

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
