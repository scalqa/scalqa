package scalqa; package Pipe; package _library

class _Double private[scalqa] (protected val This: Pipe[Double]) extends AnyVal {

  def toDoubles = This.to[Array].Doubles

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Double ->
 *
 *     This library is only available for [[Pipe]] of [[Double]]s ( Pipe[Double] ) and is invisible for other Pipes
 *
 * @def toDoubles -> Conversion to Doubles
 *
 *     Converts this [[Pipe]] to [[Array.View.Doubles]]
 *
 *     [[Doubles]] can be treated as immutable, because base array reference is discarded
 */
