package scalqa; package Idx; package Selection; package O

trait _Trait[A] extends Selection[A] with Any.O {

  def onChange(f: this.type => Any): EventControl

  def onChangeRun(f: => Any): EventControl = onChange(_ => f)

  protected def onObservableChange(on: () => Any) = onChange(_ => on())
}

object _Trait {

  implicit def zzLibrary[A](v: O[A]) = new _library._Class[A](v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
