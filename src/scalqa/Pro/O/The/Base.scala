package scalqa; package Pro; package O; package The

trait Base[A] extends O[A] with Any.O.Source {

  def onChange(f: () => Any) = onObservableChange(f)

  override def onObservableChange(f: () => Any) = super[Source].onObservableChange(f)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
