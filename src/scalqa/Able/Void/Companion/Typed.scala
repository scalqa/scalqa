package scalqa; package Able; package Void; package Companion

import scala.language.higherKinds
import scala.language.implicitConversions

class Typed[T[Nothing] <: Any](v: T[Nothing]) extends Like[T[Nothing]](v) {

  implicit def zzGet[A](v: \/.type): T[A] = Void.cast

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def zzGet -> Get void
 *
 *     Converts Unit to void instance of ''this'' type
 *
 *     {{{
 *         // Generic examples
 *
 *         val c : Coll[String] = \/
 *
 *         val p: Percent       = \/
 *
 *         val a: Array[Int]    = \/
 *     }}}
 */
