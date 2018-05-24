package scalqa; package Able; package Plus; package At

trait _Trait[A] extends Any with Plus[A] {

  def +@(i: Int, v: A): TARGET = _plusAt(Assert.idxSized(i, size + 1), v)

  def +~@(i: Int, a: ~[A]): TARGET = if (a.isVoid) _target else {
    Assert.idxSized(i, size + 1);
    a.yieldSize.to((all, sz) => sz match {
      case 0 => _target
      case 1 => _plusAt(i, all.first)
      case _ => _plusAllAt(i, all, sz)
    })
  }

  //  ---------------------------------------------------------------------------------------------------------------------
  protected def size: Int

  @inline protected def _plus(v: A) = _plusAt(size, v)
  @inline protected def _plusAll(a: ~[A], sz: Int) = _plusAllAt(size, a, sz)

  protected def _plusAt(i: Int, v: A): TARGET
  protected def _plusAllAt(index: Int, all: ~[A], size: Int): TARGET

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> '''Generic Positional Plus'''
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
 *   Creates a new instance with pipe values added at specified ''position''
 *
 *   {{{
 *     val a1: Array[Char] = Array.get('a', 'b', 'c')
 *     val a2: Array[Char] = a1 +~@ (3, 'X' <> 'Z') +~@ (0, 'W' ~ 'W' ~ 'W')
 *
 *     a1.all.lp // Prints: ~(a, b, c)
 *     a2.all.lp // Prints: ~(W, W, W, a, b, c, X, Y, Z)
 *   }}}
 */
