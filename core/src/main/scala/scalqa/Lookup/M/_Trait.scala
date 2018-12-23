package scalqa; package Lookup; package M

trait _Trait[A, B] extends Lookup[A, B] {

  def put(key: A, value: B): Unit

  def putAll(s: ~[(A, B)]) = s(t => put(t._1, t._2))

  def remove(key: A): Boolean

  def clear: Boolean

  def apply(key: A, b: ⇒ B): B = getOpt(key) or b.I(put(key, _))

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
