package scalqa; package Pipe; package _library

class _Short private[scalqa] (protected val This: Pipe[Short]) extends AnyVal {

  def toShorts = This.to[Array].Shorts

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Short ->
 *
 *     This library is only available for [[Pipe]] of [[Short]]s ( Pipe[Short] ) and is invisible for other Pipes
 *
 * @def toShorts -> Conversion to Shorts
 *
 *     Converts this [[Pipe]] to [[Array.View.Shorts]]
 *
 *     [[Shorts]] can be treated as immutable, because base array reference is discarded
 */
