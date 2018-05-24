package scalqa; package Coll; package W

trait _Trait[A] extends Coll[A] {

  def add(a: A): Unit

  def remove(a: A): Unit

  def clear: Unit

}

object _Trait extends Able.Void.Companion.Typed[_Trait](Index.WO.Z.The.Void) {

  import scala.language.implicitConversions

  implicit def zzLibrary[A](c: W[A]) = new _library[A, c.type](c)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> '''Writable Collection'''
 *
 *    Writable collection provides methods to modify its content
 *
 * @def add -> Add element
 *
 *    Adds an element to ''this'' collection
 *    {{{
 *       val c: Coll.W[Char] = ('A' <> 'C').all.to[Coll.W]
 *
 *       c add 'X'
 *       c add 'Y'
 *       c =+ 'Z' // Library shortcut
 *
 *       c.all.lp // Prints: ~(Z, Y, X, C, B, A)
 *    }}}
 *
 * @def remove -> Remove element
 *
 *     Removes every element, which is equal to the specified
 *
 *    {{{
 *       val c: Coll.W[Char] = ('A' <> 'C').all.repeat(3).to[Coll.W]
 *
 *       c.all.lp // Prints: ~(C, C, C, B, B, B, A, A, A)
 *
 *       c remove 'B'
 *
 *       c.all.lp // Prints: ~(C, C, C, A, A, A)
 *    }}}
 *
 * @def clear -> Remove all
 *
 *    Removes all elements
 *    {{{
 *      val c: Coll.W[Char] = ('A' <> 'C').all.to[Coll.W]
 *
 *      c.all.lp // Prints: ~(C, B, A)
 *
 *      c.clear
 *
 *      c.all.lp // Prints: void *
 *    }}}
 */
