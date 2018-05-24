package scalqa; package Range

trait _all[A] extends Any with __[A] {

  def allStep(step: A => A): ~[A] = Z.allStep[A](This, step)

  def allStep(step: Int)(implicit seq: Int.Step[A]): ~[A] = Z.allStep[A](This, step, seq)

  def all(implicit is: Int.Step[A]): ~[A] = allStep(1)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def allStep(step: A => A) -> Pipe of elements with step
 *
 *   Elements are produced from ''start'' to ''end'' using specified ''step'' function
 *
 *   {{{
 *     val dt = DayTime.get(9, 30)
 *     (dt <>> dt + 2.Hours).allStep(_ + 10.Minutes).lp
 *
 *     // Output
 *     ~(9:30, 9:40, 9:50, 10:00, 10:10, 10:20, 10:30, 10:40, 10:50, 11:00, 11:10, 11:20)
 *   }}}
 *   Note: The result depends on implicit [[Sorting]]
 *
 * @def allStep(step: Int) -> Pipe of elements with step
 *
 *   Elements are produced from ''start'' to ''end'' using implicit [[Int.Step]] with provided ''step'' value
 *
 *   If ''step'' is negative, elements piped from ''end'' to ''start''
 *
 *     [[Int.Step]] is universally available for:
 *       - [[Able.Sequence]]
 *       - [[Byte]], [[Char]], [[Long]], [[Int]], [[Short]], [[Float]],[[Double]]
 *       - [[Byte.Like]], [[Char.Like]], [[Long.Like]], [[Int.Like]], [[Short.Like]], [[Float.Like]],[[Double.Like]]
 *
 *    {{{
 *       ('A' <> 'Z').allStep(4).lp  // Prints: ~(A, E, I, M, Q, U, Y)
 *
 *       (1 <> 20).allStep(-3).lp    // Prints: ~(20, 17, 14, 11, 8, 5, 2)
 *   }}}
 *
 * @def all( -> Pipe of elements
 *
 *   Elements are produced from ''start'' to ''end'' using implicit [[Int.Step]] with value 1
 *
 *     [[Int.Step]] is universally available for:
 *       - [[Able.Sequence]]
 *       - [[Byte]], [[Char]], [[Long]], [[Int]], [[Short]], [[Float]],[[Double]]
 *       - [[Byte.Like]], [[Char.Like]], [[Long.Like]], [[Int.Like]], [[Short.Like]], [[Float.Like]],[[Double.Like]]
 *
 *    {{{
 *      ('A' <> 'K').all.lp
 *       (2018.Year.start.day <>+ 5).all.tp
 *
 *       // Output
 *       ~(A, B, C, D, E, F, G, H, I, J, K)
 *       ----------
 *       ?
 *       ----------
 *       2018-01-01
 *       2018-01-02
 *       2018-01-03
 *       2018-01-04
 *       2018-01-05
 *       2018-01-06
 *       ----------
 *     }}}
 */
