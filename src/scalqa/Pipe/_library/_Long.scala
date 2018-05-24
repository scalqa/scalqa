package scalqa; package Pipe; package _library

class _Long private[scalqa] (protected val This: Pipe[Long]) extends AnyVal {

  def toLongs = This.to[Array].Longs

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Long ->
 *
 *     This library is only available for [[Pipe]] of [[Long]]s ( Pipe[Long] ) and is invisible for other Pipes
 *
 * @def toLongs -> Conversion to Longs
 *
 *     Converts this [[Pipe]] to [[Array.View.Longs]]
 *
 *     [[Longs]] can be treated as immutable, because base array reference is discarded
 */
