package scalqa; package Custom; package Tuple

class _library2[A, B] private[scalqa] (private val t: (A, B)) extends AnyVal {

  def apply[T](f: (A, B) => Any): (A, B) = { f(t._1, t._2); t }

  def to[T](f: (A, B) => T): T = f(t._1, t._2)

  def map1[T](f: A => T): (T, B) = (f(t._1), t._2)

  def map2[T](f: B => T): (A, T) = (t._1, f(t._2))

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _library2 -> `Tuple2 Library`
 *
 * @def apply -> Process with function
 *
 *     Processes tuple elements in functional manner
 *
 *      Returns original tuple
 *
 *     {{{
 *       (2, 4)(_ * _ lp)                                // Prints: 8
 *
 *       (3, 4).to((first, second) => first * second lp) // Prints: 12
 *     }}}
 * @def to -> Convert by function
 *
 *     Converts tuple elements in functional manner
 *
 *     {{{
 *       (2, 4).to(_ * _).lp                             // Prints: 8
 *
 *       (3, 4).to((first, second) => first * second).lp // Prints: 12
 *
 *       (0 <> 4).all.zipIdx.map(_.to(_ * _)).lp         //  Prints: ~(0, 1, 4, 9, 16)
 *     }}}
 * @def map1 -> Map first
 *
 *     Creates new tuple with first element mapped
 *
 *     {{{
 *       (1, 2).map1(_ * 10) .lp   // Prints: (10,2)
 *     }}}
 *
 * @def map2 -> Map second
 *
 *     Creates new tuple with second element mapped
 *
 *     {{{
 *       (1, 2).map2(_ * 10) .lp   // Prints: (1,20)
 *     }}}
 */
