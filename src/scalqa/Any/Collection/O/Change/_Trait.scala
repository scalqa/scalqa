package scalqa; package Any; package Collection; package O; package Change

trait _Trait[A] extends Any.Able.ToInfo {

  def name: String

  def toInfo = new Pro.Info(this, name)

}

object _Trait {

  implicit def zzLibrary[A](v: Change[A]) = new _library(v)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *  @trait _Trait -> `Collection Change`
 *
 *  [[Change]] represents a manipulation with one or many elements of the collection
 *
 *  There are two types of Collecton [[Change]]: [[Add]] and [[Remove]]
 *
 * @def name -> Change name
 *
 *     Can be "Add", "Remove", "Refresh", or "Reposition"
 *
 */
