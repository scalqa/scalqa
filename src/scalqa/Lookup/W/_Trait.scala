package scalqa; package Lookup; package W

trait _Trait[A, B] extends Lookup[A, B] {

  def put(key: A, value: B)

  def remove(key: A): Boolean

  def clear: Boolean

}

object _Trait {

  import scala.language.implicitConversions

  implicit def zzLibrary[A, B](c: W[A, B]) = new _library[A, B, c.type](c)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
