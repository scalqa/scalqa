package scalqa; package Custom; package Tuple

class _library4[A, B, C, D] private[scalqa] (private val t: (A, B, C, D)) extends AnyVal {

  def apply(f: (A, B, C, D) => Any): (A, B, C, D) = { f(t._1, t._2, t._3, t._4); t }

  def to[T](f: (A, B, C, D) => T): T = f(t._1, t._2, t._3, t._4)

  def map1[T](f: A => T): (T, B, C, D) = (f(t._1), t._2, t._3, t._4)

  def map2[T](f: B => T): (A, T, C, D) = (t._1, f(t._2), t._3, t._4)

  def map3[T](f: C => T): (A, B, T, D) = (t._1, t._2, f(t._3), t._4)

  def map4[T](f: D => T): (A, B, C, T) = (t._1, t._2, t._3, f(t._4))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _library4 -> `Tuple4 Library`
 *
 * @def apply -> Process by function
 *
 *     Processes tuple elements in functional manner
 *
 *     Returns original tuple
 *
 *     {{{
 *       (2, 4, 6, 8) apply (_ + _ + _ + _ lp)                                              // Prints: 20
 *
 *       (4, 4, 6, 8)((first, second, third, fourth) => first + second + third + fourth lp) // Prints: 22
 *     }}}
 *
 * @def to -> Convert by function
 *
 *     Converts tuple elements in functional manner
 *
 *     {{{
 *       (2, 4, 6, 8).to(_ + _ + _ + _) lp                                                  // Prints: 20
 *
 *       (4, 4, 6).to((first, second, third, fourth) => first + second + third + fourth) lp // Prints: 22
 *     }}}
 *
 * @def map1 -> Map first
 *
 *     Creates new tuple with first element mapped
 *
 *     {{{
 *       (1, 2, 3, 4).map1(_ * 10) lp   // Prints: (10,2,3,4)
 *     }}}
 *
 * @def map2 -> Map second
 *
 *     Creates new tuple with second element mapped
 *
 *     {{{
 *       (1, 2, 3, 4).map2(_ * 10) lp   // Prints: (1,20,3,4)
 *     }}}
 *
 * @def map3 -> Map third
 *
 *     Creates new tuple with third element mapped
 *
 *     {{{
 *       (1, 2, 3, 4).map3(_ * 10).lp   // Prints: (1,2,30,4)
 *     }}}
 *
 * @def map4 -> Map fourth
 *
 *     Creates new tuple with fourth element mapped
 *
 *     {{{
 *       (1, 2, 3, 4).map4(_ * 10) lp   // Prints: (1,2,3,40)
 *     }}}
 */
