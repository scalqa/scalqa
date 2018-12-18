package scalqa; package Util; package Void; package Setup

class Typed[T[Any]](v: T[Any]) extends Like[T[Any]](v) {

  @inline implicit def zzMake[A](v: \/): T[A] = Void.asInstanceOf[T[A]]

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def zzMake -> Get void
 *
 *     Converts Unit to void instance of `this` type
 *
 *     {{{
 *         // Generic examples
 *
 *         val c : Any.Collection[String] = \/
 *
 *         val p: Percent       = \/
 *
 *         val a: Refs[Int]    = \/
 *     }}}
 */
