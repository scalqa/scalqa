package scalqa; package Util; package Void; package Setup

class _Class[T](v: T) extends Like(v) {

  implicit def zzMake(v: \/): T = Void

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
 *     }}}
 */
