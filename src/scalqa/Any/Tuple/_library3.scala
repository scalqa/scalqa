package scalqa; package Any; package Tuple

class _library3[A, B, C] private[scalqa] (private val t: (A, B, C)) extends AnyVal {

  def apply(f: (A, B, C) => Any): (A, B, C) = { f(t._1, t._2, t._3); t }

  def to[T](f: (A, B, C) => T): T = f(t._1, t._2, t._3)

  def map1[T](f: A => T): (T, B, C) = (f(t._1), t._2, t._3)

  def map2[T](f: B => T): (A, T, C) = (t._1, f(t._2), t._3)

  def map3[T](f: C => T): (A, B, T) = (t._1, t._2, f(t._3))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _library3 -> '''Tuple3 Library'''
 *
 * @def apply -> Process by function
 *
 *     Processes tuple elements in functional manner
 *
 *     Returns original tuple
 *
 *     {{{
 *       (2, 4, 6) apply (_ + _ + _ lp)                                  // Prints: 12
 *
 *       (4, 4, 6)((first, second, third) => first + second + third lp)  // Prints: 14
 *     }}}
 *
 * @def to -> Convert by function
 *
 *     Converts tuple elements in functional manner
 *
 *     {{{
 *       (2, 4, 6).to(_ + _ + _).lp                                        // Prints: 12
 *
 *       (4, 4, 6).to((first, second, third) => first + second + third).lp // Prints: 14
 *     }}}
 *
 * @def map1 -> Map first
 *
 *     Creates new tuple with first element mapped
 *
 *     {{{
 *       (1, 2, 3).map1(_ * 10).lp   // Prints: (10,2,3)
 *     }}}
 *
 * @def map2 -> Map second
 *
 *     Creates new tuple with second element mapped
 *
 *     {{{
 *       (1, 2, 3).map2(_ * 10).lp   // Prints: (1,20,3)
 *     }}}
 *
 * @def map3 -> Map third
 *
 *     Creates new tuple with third element mapped
 *
 *     {{{
 *       (1, 2, 3).map3(_ * 10).lp   // Prints: (1,2,30)
 *     }}}
 */
