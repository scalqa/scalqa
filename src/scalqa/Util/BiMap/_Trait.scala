package scalqa; package Util; package BiMap

trait _Trait[@specialized(DATA) A, B] {

  def apply(v: A): B

  def undo(v: B): A

}

object _Trait {

  implicit def zzMake[A, B](v: \/): BiMap[A, B] = Void.asInstanceOf[BiMap[A, B]]
  implicit def zzLibrary[A, B](v: BiMap[A, B]) = new _library(v)
  implicit def zzMapping[A, B](v: BiMap[A, B]): Stream.Mapping[A, B] = v(_)
  implicit def zzFubction[A, B](v: BiMap[A, B]): A => B = v(_)

  implicit def zzMake[A](v: AS_IS.type): BiMap[A, A] = Void.asInstanceOf[BiMap[A, A]]

}

private object Void extends BiMap[Any, Any] with Void { def apply(x: Any) = x; def undo(x: Any) = x }

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> `Two Directional Mapping`
 *
 *   [[BiMap]] allows to convert value to some type and back
 *
 *   It is used in two way binded collections
 *  {{{
 *     val intToChar: BiMap[Int, Char] = BiMap(i => ('A' + i).toChar, _ - 'A')
 *
 *     val coll: Idx.M[Int] = *(0, 2, 4).to[Idx.M]
 *     val view: Idx.M[Char] = x.asBiMappedView(intToChar)
 *
 *     coll.all.lp   // Prints: ~(0, 2, 4)
 *     view.all.lp   // Prints: ~(A, C, E)
 *
 *     view(1) = 'Z' // Note, only second collection is updated, but both are changed
 *
 *     coll.all.lp   // Prints: ~(0, 25, 4)
 *     view.all.lp   // Prints: ~(A, Z, E)
 *   }}}
 *
 * @def apply(v -> Map
 *
 *     Converts value
 *
 * @def undo(v -> Undo map
 *
 *     Restores conversion result to original value
 */
