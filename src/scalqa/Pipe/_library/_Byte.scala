package scalqa; package Pipe; package _library

class _Byte private[scalqa] (protected val This: Pipe[Byte]) extends AnyVal {

  def toBytes = This.to[Array].Bytes

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Byte ->
 *
 *     This library is only available for [[Pipe]] of [[Byte]]s ( Pipe[Byte] ) and is invisible for other Pipes
 *
 * @def toBytes -> Conversion to Bytes
 *
 *     Converts this [[Pipe]] to [[Array.View.Bytes]]
 *
 *     [[Bytes]] can be treated as immutable, because base array reference is discarded
 */
