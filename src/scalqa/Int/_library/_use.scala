package scalqa; package Int; package _library

trait _use extends Any with __ {

  def all: ~[Int] = This.Range.all

  def allUp: ~[Int] = Z.all.up(This)

  def allDown: ~[Int] = Z.all.down(This)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def all: -> All in range
 *
 *   Creates a pipe of Ints from 0 to ''this'' exclusive
 *
 *   {{{
 *     12.all lp // Prints:  ~(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
 *   }}}
 *
 * @def allUp -> Up pipe
 *
 *   Creates a pipe of elements from ''this'' to [[Int.Max]]
 *
 *   Note. The pipe usually is very large, so it should be extended with some restriction
 *
 *   {{{
 *     10.allUp.letFirst(5) lp  // Prints: ~(10, 11, 12, 13, 14)
 *   }}}
 *
 * @def allDown -> Down pipe
 *
 *   Creates a pipe of elements from ''this'' to [[Int.Min]]
 *
 *   Note. The pipe usually is very large, so it should be extended with some restriction
 *
 *   {{{
 *     0.allDown.letFirst(5) lp // Prints: ~(0, -1, -2, -3, -4)
 *   }}}
 */
