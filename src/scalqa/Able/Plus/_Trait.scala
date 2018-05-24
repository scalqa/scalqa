package scalqa; package Able; package Plus

trait _Trait[A] extends Any with Target {

  def +(value: A): TARGET = _plus(value)

  def +~(values: ~[A]): TARGET = if (values.isVoid) _target else values.yieldSize.to((all, sz) => sz match {
    case 0 => _target
    case 1 => _plus(all.first)
    case _ => _plusAll(all, sz)
  })

  protected def _plus(v: A): TARGET
  protected def _plusAll(a: ~[A], size: Int): TARGET
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> '''Generic Plus'''
 *
 * @def +( -> Add
 *
 *   Creates a new instance with specified value added
 *
 *   {{{
 *     // Generic Array example
 *     val a1: Array[Char] = Array.get('a', 'b', 'c')
 *     val a2: Array[Char] = a1 + 'x' + 'y' + 'z'
 *
 *     a1.all.lp // Prints: ~(a, b, c)
 *     a2.all.lp // Prints: ~(a, b, c, x, y, z)
 *   }}}
 *
 * @def +~ -> Add all
 *
 *   Creates a new instance with added pipe values
 *
 *   {{{
 *     val a1: Array[Char] = Array.get('a', 'b', 'c')
 *     val a2: Array[Char] = a1 +~ *('x', 'y', 'z') +~ ('x' <> 'z')
 *
 *     a1.all.lp // Prints: ~(a, b, c)
 *     a2.all.lp // Prints: ~(a, b, c, x, y, z, x, y, z)
 *   }}}
 */
