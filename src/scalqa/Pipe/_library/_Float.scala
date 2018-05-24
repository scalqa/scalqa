package scalqa; package Pipe; package _library

class _Float private[scalqa] (protected val This: Pipe[Float]) extends AnyVal {

  def toFloats = This.to[Array].Floats

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Float ->
 *
 *     This library is only available for [[Pipe]] of [[Float]]s ( Pipe[Float] ) and is invisible for other Pipes
 *
 * @def toFloats -> Conversion to Floats
 *
 *     Converts this [[Pipe]] to [[Array.View.Floats]]
 *
 *     [[Floats]] can be treated as immutable, because base array reference is discarded
 */
