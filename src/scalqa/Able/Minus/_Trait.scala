package scalqa; package Able; package Minus

trait _Trait[A] extends Any with Target {

  def -(value: A): TARGET = _minus(value)

  def -~(values: ~[A]): TARGET = _minusAll(values)

  protected def _minus(value: A): TARGET
  protected def _minusAll(values: ~[A]): TARGET
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> '''Generic Minus Interface''
 *
 * @def -( -> Subtract ''value''
 *
 *   Creates a new instance with specified value removed
 *
 *   {{{
 *       // Generic Array example
 *       val a1: Array[Char] = ('a' <> 'g').all.to[Array]
 *       val a2: Array[Char] = a1 - 'b' - 'd' - 'f'
 *
 *       a1.all.lp // Prints: ~(a, b, c, d, e, f, g)
 *       a2.all.lp // Prints: ~(a, c, e, g)
 *   }}}
 *
 * @def -~ -> Subtract all values
 *
 *   Creates a new instance with all pipe values removed
 *
 *   {{{
 *       // Generic Array example
 *       val a1: Array[Char] = ('a' <> 'g').all.to[Array]
 *       val a2: Array[Char] = a1 -~ ('c' <> 'e')
 *
 *       a1.all.lp // Prints: ~(a, b, c, d, e, f, g)
 *       a2.all.lp // Prints: ~(a, b, f, g)
 *   }}}
 *
 */
