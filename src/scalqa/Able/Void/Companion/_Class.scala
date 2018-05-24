package scalqa; package Able; package Void; package Companion

class _Class[T](v: T) extends Like(v) {

  import scala.language.implicitConversions

  implicit def zzGet(v: \/.type): T = Void

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
