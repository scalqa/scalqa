package scalqa; package Pipe; package _extend

trait _reproduce[A] extends Flow._extend._reproduce[A] with __[A] {

  override def flatMap[B](f: A => ~[B]): Pipe[B] = new Z.reproduce.flatMap(This, f)

  def repeat(number: Int): Pipe[A] = new Z.reproduce.repeat(This, number)

  def separate(separator: A): Pipe[A] = new Z.reproduce.separate(This, separator)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _reproduce -> '''Reproduce Interface'''
 *
 *     Usually increases number of elements in the pipeline, where for each existing element 0 to many provided
 *
 * @def separate -> Separate
 *
 *     Inserts given element between all existing
 *
 *     @example
 *     {{{
 *       ('a' <> 'z').all.separate('|').format().lp
 *
 *       // Output
 *       a|b|c|d|e|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|w|x|y|z
 *     }}}
 *
 * @def repeat -> Multiply
 *
 *    Repeats each existing element ''number'' of times
 *
 *    @example
 *    {{{
 *       ('a' ~ 'b' ~ 'c').repeat(5).lp
 *       // Output
 *       ~(a, a, a, a, a, b, b, b, b, b, c, c, c, c, c)
 *    }}}
 */
