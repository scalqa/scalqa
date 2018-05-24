package scalqa; package Index; package Selection; package O

trait _Trait[A] extends Selection[A] with Any.O {

  def onChange(f: this.type => Any): Concurrent.Control

  protected def onObservableChange(on: () => Any) = onChange(_ => on())
}

object _Trait {

  import scala.language.implicitConversions

  implicit def zzLibrary[A](v: O[A]) = new _library[A](v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
