package scalqa; package Index; package O

trait _Trait[A] extends Index[A] with Coll.O[A] {

  def onChange(f: Coll[Change[A]] => Any): Concurrent.Control

}

object _Trait {

  import scala.language.implicitConversions

  implicit def zzGet[A](v: \/.type): O[A] = Void.cast

  implicit def zzLibrary[A](v: O[A]) = new _library(v)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> '''Observable Index Collection'''
 *
 *     Observable Index collection allows to track all the changes by subscribing to ''onChange'' event
 */
