package scalqa; package Lookup

trait _Trait[A, +B] extends Any with Coll[B] {

  def apply(key: A): B = opt(key) or Fail("There is no value for key: '" + key + "'")

  def opt(key: A): Opt[B]

  def all: ~[B] = allPairs.map(_._2)

  def allPairs: ~[(A, B)]

}

object _Trait {

  import scala.language.implicitConversions

  implicit def zzGet[A, B](v: \/.type): Lookup[A, B] = Z.The.Void.cast

  implicit def zzLibrary[A, B](v: Lookup[A, B]) = new _library[A, B](v)

  implicit def zzPartialFunction[A, B](l: Lookup[A, B]): PartialFunction[A, B] = l.asPartialFunction

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> '''Lookup Collection'''
 *
 *    In "Lookup Collection" every element is stored with a 'key' and can be accessed (looked up) with this key
 *
 *    It is a rough equivalent of java.util.Map and scala.Map
 *
 *    The notable difference is that [[Lookup]] extends collection, while Java Map does not
 *
 * @def apply -> Element by key
 *
 *    Returns element associated with the given ''key''
 *
 *    Fails, if none is found
 *
 * @def opt( -> Element by key
 *
 *    Optionally returns element associated with the given ''key''
 *
 * @def allPairs: -> All key/value pairs
 *
 *    Returns a [[Pipe]] of all key/value pairs for this [[Lookup]]
 */
