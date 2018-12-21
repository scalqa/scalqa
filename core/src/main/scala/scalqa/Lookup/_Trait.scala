package scalqa; package Lookup

trait _Trait[A, +B] extends Any with Any.Collection[B] {

  def getOpt(key: A): Opt[B]

  def all: ~[B] = allPairs.map(_._2)

  def allPairs: ~[(A, B)]
}

object _Trait {

  implicit def zzMake[A, B](v: \/): Lookup[A, B] = Z.A.Void.asInstanceOf[Lookup[A, B]]

  implicit def zzLibrary[A, B](v: Lookup[A, B]) = new _library._Class[A, B](v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> `Lookup Collection`
 *
 *    In [[Lookup]] every element is stored with a 'key' and can be accessed (looked up) with this key
 *
 *    It is a greatly simplified equivalent of scala.Map
 *
 *
 * @def getOpt( -> Element by key
 *
 *    Optionally returns element associated with the given `key`
 *
 * @def allPairs: -> All key/value pairs
 *
 *    Returns a [[Stream]] of all key/value pairs for this [[Lookup]]
 */
