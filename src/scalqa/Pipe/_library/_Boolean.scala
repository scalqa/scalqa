package scalqa; package Pipe; package _library

class _Boolean private[scalqa] (protected val This: Pipe[Boolean]) extends AnyVal {

  def toBooleans = This.to[Array].Booleans

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Boolean ->
 *
 *     This library is only available for [[Pipe]] of [[Boolean]]s ( Pipe[Boolean] ) and is invisible for other Pipes
 *
 * @def toBooleans -> Conversion to Booleans
 *
 *     Converts this [[Pipe]] to [[Array.View.Booleans]]
 *
 *     [[Booleans]] can be treated as immutable, because base array reference is discarded
 */
