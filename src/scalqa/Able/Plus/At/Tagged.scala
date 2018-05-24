package scalqa; package Able; package Plus; package At

trait Tagged[A] extends Any with Plus.Tagged[A] {

  def +@(position: Int, value: A)(implicit t: Tag[A] = \/): TARGET = _plusAt(Assert.idxSized(position, size + 1), value, t)

  def +~@(position: Int, a: ~[A])(implicit t: Tag[A] = \/): TARGET = if (a.isVoid) _target else {
    Assert.idxSized(position, size + 1)
    a.yieldSizeAndTag.to((all, sz, tag) => sz match {
      case 0 => _target
      case 1 => all.pumpOpt(EVERY).map(value => _plusAt(position, value, value.Class.tag)).value
      case _ => _plusAllAt(position, all, sz, tag)
    })
  }

  protected def size: Int

  @inline protected override def _plus(v: A, t: Tag[A]) = _plusAt(size, v, Tag.Void)
  @inline protected override def _plusAll(a: ~[A], sz: Int, t: Tag[A]) = _plusAllAt(size, a, sz, Tag.Void)

  protected def _plusAt(i: Int, v: A, t: Tag[A]): TARGET
  protected def _plusAllAt(i: Int, a: ~[A], size: Int, t: Tag[A]): TARGET

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Tagged -> '''Generic Positional Plus Tagged'''
 *
 * @def +@ -> Add at position
 *
 *   Creates a new instance with specified ''value'' added at specified ''position''
 *
 *   {{{
 *     val a1: Array[Char] = Array.get('a', 'b', 'c')
 *     val a2: Array[Char] = a1 +@ (3, 'Z') +@ (1, 'X')
 *
 *     a1.all.lp // Prints: ~(a, b, c)
 *     a2.all.lp // Prints: ~(a, X, b, c, Z)
 *   }}}
 *
 * @def +~@ -> Add pipe at position
 *
 *   Creates a new instance with all pipe values added at specified ''position''
 *
 *   {{{
 *     val a1: Array[Char] = Array.get('a', 'b', 'c')
 *     val a2: Array[Char] = a1 +~@ (3, 'X' <> 'Z') +~@ (0, 'W' ~ 'W' ~ 'W')
 *
 *     a1.all.lp // Prints: ~(a, b, c)
 *     a2.all.lp // Prints: ~(W, W, W, a, b, c, X, Y, Z)
 *   }}}
 */
