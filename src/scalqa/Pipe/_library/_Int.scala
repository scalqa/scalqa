package scalqa; package Pipe; package _library

class _Int private[scalqa] (protected val This: Pipe[Int]) extends AnyVal {

  def toInts = This.to[Array].Ints

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Int ->
 *
 *     This library is only available for [[Pipe]] of [[Int]]s ( Pipe[Int] ) and is invisible for other Pipes
 *
 * @def toInts -> Conversion to Ints
 *
 *     Converts this [[Pipe]] to [[Array.View.Ints]]
 *
 *     [[Ints]] can be treated as immutable, because base array reference is discarded
 */
