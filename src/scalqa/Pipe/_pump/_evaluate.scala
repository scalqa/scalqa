package scalqa; package Pipe; package _pump

trait _evaluate[A] extends Flow._pump._evaluate[A] with __[A] {

  def firstOpt: Opt[A] = This.pumpOpt(EVERY)

  def first: A = firstOpt.value

  def lastOpt: Opt[A] = Z.filter.letLast[A](This, 1).firstOpt

  def last: A = lastOpt.value

  def findIdxOpt(f: A ⇒ Boolean): Opt[Int] = This.zipIdx.dropWhile(t => !f(t._2)).firstOpt.map(_._1)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *  @trait _evaluate -> '''Evaluate Interface'''
 *
 *      Most methods search for certain data and stop once found
 *
 *      The pipeline, in most cases, is discarded not fully pumped
 *
 * @def firstOpt -> First element
 *
 *     Optionally returns the first data element or Opt.Void
 *
 * @def first: -> First element
 *
 *     Returns the first data element
 *
 *     Fails if no data
 *
 * @def lastOpt -> Last element
 *
 *     Optionally returns the last element or Opt.Void
 *
 * @def last: ->  Last element
 *
 *     Returns the last data element
 *
 *     Fails if no data
 *
 * @def findIdxOpt(f: A ⇒ Boolean) -> Find index
 *
 *     Optionally returns index for the first element satisfying the filter function or Opt.Void if none found
 *
 */
