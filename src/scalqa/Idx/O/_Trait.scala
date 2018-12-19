package scalqa; package Idx; package O

trait _Trait[A] extends Idx[A] with Any.Collection.O[A] {
  protected type CHANGE[A] = Change[A]

  def onChange(f: Idx[Change[A]] => Any): EventControl

}

object _Trait {

  implicit def zzMake[A](v: \/): O[A] = Void.asInstanceOf[O[A]]

  implicit def zzLibrary[A](v: O[A]) = new _library._Class(v)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> `Observable Idx Collection`
 *
 *     Observable Idx collection allows to track all the changes by subscribing to `onChange` event
 */
