package scalqa; package Any; package BiMap

trait _Trait[A, B] /*extends (A => B)*/ {

  def apply(a: A): B

  def undo(b: B): A

}

object _Trait {

  import scala.language.implicitConversions

  implicit def zzGet[A, B](v: \/.type): BiMap[A, B] = Void.cast;
  implicit def zzLibrary[A, B](v: BiMap[A, B]) = new _library(v)
  implicit def zzFunction[A, B](v: BiMap[A, B]): A => B = v(_)
}

private object Void extends BiMap[Any, Any] with Void { def apply(v: Any) = v; def undo(v: Any) = v }

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> '''Bi Directional Mapping'''
 *
 *   [[BiMap]] allows to convert value to some type and then restore it back.
 *
 *   It is used in bi-directional views like:
 *
 *  {{{
 *     val intCharMap: BiMap[Int, Char] = BiMap.get(i => ('A' + i).toChar, _ - 'A')
 *
 *     val x : Index.W[Int]  = Index.W.get(0, 2, 4)
 *     val v : Index.W[Char] = x.asBiMap(intCharMap)
 *
 *     x.all.lp   // Prints: ~(0, 2, 4)
 *     v.all.lp   // Prints: ~(A, C, E)
 *
 *     v(1) = 'Z' // Note, only second index is updated, but both affected.
 *
 *     x.all.lp   // Prints: ~(0, 25, 4)
 *     v.all.lp   // Prints: ~(A, Z, E)
 *  }}}
 *
 *
 * @def apply(a -> Map
 *
 *     Converts value
 *
 * @def undo(b -> Undo map
 *
 *     Converts conversion result to original value
 *
 */
