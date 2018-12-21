package scalqa; package Lookup; package I

trait _Trait[A, B] extends Lookup[A, B] {

  def +(v: (A, B)): I[A, B]
  def +~(v: ~[(A, B)]): I[A, B]

  def -(v: A): I[A, B]
  def -~(v: ~[A]): I[A, B]

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> `Immutable LookupCollection`
 *
 */
