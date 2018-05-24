package scalqa; package Long; package _library

trait _use extends Any with __ {

  def allUp: ~[Long] = new Z.all.Up(This)

  def allDown: ~[Long] = new Z.all.Down(This)

  def compare(n: Long): Int = Sorting.Position.get(This, n).signum

  def brief: String =
    if (This >= OneTrillion) (This * 10 / OneTrillion / 10D) + "t"
    else if (This >= OneBillion) (This * 10 / OneBillion / 10D) + "g"
    else if (This >= OneMillion) (This * 10 / OneMillion / 10D) + "m"
    else if (This >= OneThousand) (This * 10 / OneThousand / 10D) + "k"
    else "" + This
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def allUp -> Up pipe
 *
 *   Creates a pipe of elements from ''this'' to [[Long.Max]]
 *
 *   Note. The pipe usually is huge, so it should be extended with some restriction.
 *
 *   {{{
 *     10L.allUp.letFirst(5).lp
 *     // Output
 *     ~(10, 11, 12, 13, 14)
 *   }}}
 *
 * @def allDown -> Down pipe
 *
 *   Creates a pipe of elements from ''this'' to [[Long.Min]]
 *
 *   Note. The pipe usually is huge, so it should be extended with some restriction.
 *
 *   {{{
 *     0L.allDown.letFirst(5).lp
 *     // Output
 *     ~(0, -1, -2, -3, -4)
 *   }}}
 */
