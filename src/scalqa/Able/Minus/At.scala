package scalqa; package Able; package Minus

trait At[A] extends Any with Minus[A] {

  def -@(r: Int.Range): TARGET = if (r.size == 0) _target else _minusRange(_target, r)

  def -@(i: Int): TARGET = this -@ i.<>!

  // ------------------------------------------------------------------------------------------------------------------
  protected def size: Int
  protected def all: ~[A]

  protected def _minusRange(t: TARGET, r: Int.Range): TARGET

  protected def _minus(v: A) = rmZipIdx(all.zipIdx.let(v == _._2))

  protected def _minusAll(a: ~[A]) = rmZipIdx(all.zipIdx.letAllBy(_._2, a))

  private def rmZipIdx(a: ~[(Int, A)]): TARGET = a.reverse.map(_._1 <>!).foldAs[TARGET](_target, _minusRange(_, _))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait At -> '''Generic Positional Minus'''
 *
 * @def -@(r -> Subtract range
 *
 *   Creates a new instance without specified range
 *
 *   {{{
 *       // Generic Array example
 *       val a1: Array[Int] = (0 <> 9).all.to[Array]
 *       val a2: Array[Int] = a1 -@ (3 <> 7)
 *
 *       a1.all.lp  // Prints: ~(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
 *       a2.all.lp  // Prints: ~(0, 1, 2, 8, 9)
 *   }}}
 *
 * @def -@(i -> Subtract position
 *
 *   Creates a new instance without specified position
 *   {{{
 *      // Generic Array example
 *      val a1: Array[Int] = (0 <> 5).all.to[Array]
 *      val a2: Array[Int] = a1 -@ 4 -@ 2 -@ 0
 *
 *      a1.all.lp // Prints: ~(0, 1, 2, 3, 4, 5)
 *      a2.all.lp // Prints: ~(1, 3, 5)
 *  }}}
 */
