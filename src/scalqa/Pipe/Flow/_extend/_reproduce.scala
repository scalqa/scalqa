package scalqa; package Pipe; package Flow; package _extend

trait _reproduce[A] {

  def flatMap[B](f: A => ~[B]): Flow[B]

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
 *    Usually extends number of elements in the pipeline
 *
 *    For each existing element 0 to many are inserted
 *
 * @def flatMap -> Map multiplier
 *
 *   For every existing element, a mapped group of elements is inserted into the pipeline
 *
 *   Note. The function can return an empty group, in which case total number of elements might even be reduced
 *
 *   @param f function to provide a group of elements for each existing element
 *
 *   @example
 *   {{{
 *      (1 ~ 2 ~ 3).flatMap(i => (i * 10) ~ (i * 100) ~ (i * 1000)).lp
 *
 *      // Output
 *      ~(10, 100, 1000, 20, 200, 2000, 30, 300, 3000)
 *   }}}
 *
 */
