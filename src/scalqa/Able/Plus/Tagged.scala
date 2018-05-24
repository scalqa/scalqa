package scalqa; package Able; package Plus

trait Tagged[A] extends Any with Target {

  def +(v: A)(implicit t: Tag[A] = \/): TARGET = _plus(v, t ? v.Class.tag): @inline

  def +~(a: ~[A])(implicit t: Tag[A] = \/): TARGET = if (a.isVoid) _target else a.yieldSizeAndTag.to((all, sz, tag) => sz match {
    case 0 => _target
    case 1 => all.firstOpt.map(v => _plus(v, v.Class.tag)).value
    case _ => _plusAll(all, sz, tag)
  })

  protected def _plus(v: A, t: Tag[A]): TARGET
  protected def _plusAll(a: ~[A], size: Int, t: Tag[A]): TARGET
  protected def _target: TARGET
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Tagged -> '''Generic Plus Tagged'''
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
 * @def +~ -> Add pipe
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
